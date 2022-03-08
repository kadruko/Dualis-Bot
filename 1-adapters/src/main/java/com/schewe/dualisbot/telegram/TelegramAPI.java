package com.schewe.dualisbot.telegram;

import com.schewe.dualisbot.domain.telegram.entities.Message;

import java.io.IOException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class TelegramAPI {

    public static String API_BASE_URL = "https://api.telegram.org/";
    public static String API_TOKEN = "1337691387:AAG4VYOic14uiajYYs0x5nzKQw1NzMNjcoI";
    public static String API_URL = API_BASE_URL + "bot" + API_TOKEN;

    public static String ENDPOINT_MESSAGE = "/sendMessage";

    public static String PARAMETER_CHAT_ID = "chat_id";
    public static String PARAMETER_MESSAGE = "text";

    public static void sendMessage(Message message) throws IOException {
        String parameterChatroomId = "?" + PARAMETER_CHAT_ID + "=" + message.getChatroom().getChatroomId();
        String parameterMessage = "&" + PARAMETER_MESSAGE + "=" + message.getText();
        String parameters = parameterChatroomId + parameterMessage;

        String urlEncoded = API_URL + ENDPOINT_MESSAGE + URLEncoder.encode(parameters, StandardCharsets.UTF_8);
        URL url = new URL(urlEncoded);
        url.openConnection();

        System.out.println();
        System.out.println("--- Message sent to Telegram ---");
        System.out.println(urlEncoded);
        System.out.println(message.getText());
    }

}
