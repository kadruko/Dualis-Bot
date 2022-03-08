package com.schewe.dualisbot.domain.telegram.entities;

import com.schewe.dualisbot.domain.telegram.enumerations.Chatroom;

public class Message {

    private final String text;
    private final Chatroom chatroom;

    public Message(String text, Chatroom chatroom) {
        this.text = text;
        this.chatroom = chatroom;
    }

    public String getText() {
        return text;
    }

    public Chatroom getChatroom() {
        return chatroom;
    }
}
