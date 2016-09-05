package com.vathsav.flick.model;

/**
 * Created by vathsav on 03/09/16.
 * POJO for MessageItems - for fetching from Firebase
 */
public class MessageItemGetter {
    private final String message_id;
    private final String sender_name;
    private final String message_body;
    private final String message_timestamp;

    public MessageItemGetter(String message_id, String sender_name, String message_body, String message_timestamp) {
        this.message_id = message_id;
        this.sender_name = sender_name;
        this.message_body = message_body;
        this.message_timestamp = message_timestamp;
    }

    public String getMessageId() {
        return message_id;
    }

    public String getSenderName() {
        return sender_name;
    }

    public String getMessageBody() {
        return message_body;
    }

    public String getMessageTimestamp() {
        return message_timestamp;
    }
}
