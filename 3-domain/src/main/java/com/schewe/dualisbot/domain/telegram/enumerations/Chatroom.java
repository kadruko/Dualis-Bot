package com.schewe.dualisbot.domain.telegram.enumerations;

public enum Chatroom {

    PRIVATE("-495716641"),
    GROUP("-495716641");

    private final String chatroomId;

    Chatroom(String chatroomId){
        this.chatroomId = chatroomId;
    }

    public String getChatroomId() {
        return chatroomId;
    }
}
