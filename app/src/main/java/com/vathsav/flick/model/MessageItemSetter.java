package com.vathsav.flick.model;

/**
 * Created by vathsav on 31/05/16.
 * POJO for Message Bubbles
 */
public class MessageItemSetter {
    public String message_id;
    public String sender_name;
    public String message_body;
    public String message_timestamp;

    public MessageItemSetter(String message_id, String sender_name, String message_body, String message_timestamp) {
        this.message_id = message_id;
        this.sender_name = sender_name;
        this.message_body = message_body;
        this.message_timestamp = message_timestamp;
    }
}
