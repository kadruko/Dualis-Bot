package com.schewe.dualisbot.application;

import com.schewe.dualisbot.domain.dualis.entities.Exam;
import com.schewe.dualisbot.domain.telegram.entities.Message;
import com.schewe.dualisbot.domain.telegram.enumerations.Chatroom;

import java.util.ArrayList;
import java.util.List;

public class MessageFactory {

    public static List<Message> generateMessagesFor(Exam exam){
        List<Message> messages = new ArrayList<>();

        String textPrivate =
                "Neue Note\n" +
                "Klausur: " + exam.getName() + "\n" +
                "Bewertung: " + exam.getRating().getRating();
        Message messagePrivate = new Message(textPrivate, Chatroom.PRIVATE);
        messages.add(messagePrivate);

        String textGroup =
                "Neue Note\n" +
                "Klausur: " + exam.getName();
        if(exam.getAttemptNumber().getNumber() > 1){
            textGroup += "\nHinweis: Es handelt sich um eine Nachklausur.";
        }
        Message messageGroup = new Message(textGroup, Chatroom.GROUP);
        messages.add(messageGroup);

        return messages;
    }

}