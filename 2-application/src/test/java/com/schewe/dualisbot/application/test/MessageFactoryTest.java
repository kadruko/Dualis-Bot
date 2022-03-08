package com.schewe.dualisbot.application.test;

import com.schewe.dualisbot.abstraction.valueobjects.NaturalNumber;
import com.schewe.dualisbot.abstraction.valueobjects.Percentage;
import com.schewe.dualisbot.application.MessageFactory;
import com.schewe.dualisbot.domain.dualis.entities.Exam;
import com.schewe.dualisbot.domain.dualis.valueobjects.Rating;
import com.schewe.dualisbot.domain.telegram.entities.Message;
import com.schewe.dualisbot.domain.telegram.enumerations.Chatroom;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MessageFactoryTest {

    @Test
    public void generateMessagesForFirstAttempt() throws Exception {
        Exam exam = new Exam("Betriebssysteme", new Percentage(0.5f), new Rating(new Percentage(0.83f)), new NaturalNumber(1),"T3INF2005");
        List<Message> messages = MessageFactory.generateMessagesFor(exam);
        assert messages.size() == 2;
        Message messagePrivate = messages.get(0);
        Message messageGroup = messages.get(1);
        assert messagePrivate.getChatroom() == Chatroom.PRIVATE;
        assert messagePrivate.getText().equals("Neue Note\nKlausur: " + exam.getName() + "\nBewertung: " + exam.getRating().getRating());
        assert messageGroup.getChatroom() == Chatroom.GROUP;
        assert messageGroup.getText().equals("Neue Note\nKlausur: " + exam.getName());
    }

    @Test
    public void generateMessagesForSecondAttempt() throws Exception {
        Exam exam = new Exam("Betriebssysteme", new Percentage(0.5f), new Rating(new Percentage(0.83f)), new NaturalNumber(2),"T3INF2005");
        List<Message> messages = MessageFactory.generateMessagesFor(exam);
        assert messages.size() == 2;
        Message messagePrivate = messages.get(0);
        Message messageGroup = messages.get(1);
        assert messagePrivate.getChatroom() == Chatroom.PRIVATE;
        assert messagePrivate.getText().equals("Neue Note\nKlausur: " + exam.getName() + "\nBewertung: " + exam.getRating().getRating());
        assert messageGroup.getChatroom() == Chatroom.GROUP;
        assert messageGroup.getText().equals("Neue Note\nKlausur: " + exam.getName() + "\nHinweis: Es handelt sich um eine Nachklausur.");
    }

}
