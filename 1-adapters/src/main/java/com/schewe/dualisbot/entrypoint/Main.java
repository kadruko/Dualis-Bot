package com.schewe.dualisbot.entrypoint;

import com.schewe.dualisbot.adapters.DualisGateway;
import com.schewe.dualisbot.adapters.DualisWebscraper;
import com.schewe.dualisbot.adapters.telegram.TelegramAPI;
import com.schewe.dualisbot.domain.dualis.entities.Exam;
import com.schewe.dualisbot.domain.telegram.entities.Message;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

        DualisWebscraper.getInstance().run();
        DualisGateway dualisGateway = DualisGateway.getInstance();

        ExamsComparator examsComparator = new ExamsComparator(dualisGateway.getOldExams(), dualisGateway.getNewExams());
        List<Exam> examDifference = examsComparator.getDifference();

        for(Exam exam : examDifference){
            List<Message> messages = MessageFactory.generateMessagesFor(exam);
            for(Message message : messages){
                try {
                    TelegramAPI.sendMessage(message);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        }

    }

}
