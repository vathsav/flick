package com.vathsav.flick.model;

/**
 * Created by vathsav on 31/05/16.
 */
public class MessageItem {
    private String messageId;
    private String senderName;
    private String messageBody;
    private String messageTimestamp;

    public MessageItem() {
    }

    public MessageItem(String messageId, String senderName, String messageBody, String messageTimestamp) {
        this.messageId = messageId;
        this.senderName = senderName;
        this.messageBody = messageBody;
        this.messageTimestamp = messageTimestamp;
    }

    public String getMessageId() {
        return messageId;
    }

    public String getSenderName() {
        return senderName;
    }

    public String getMessageBody() {
        return messageBody;
    }

    public String getMessageTimestamp() {
        return messageTimestamp;
    }
}
