package com.vathsav.flick.model;

/**
 * Created by vathsav on 31/05/16.
 * POJO for Conversation List Item
 */
public class ConversationItem {
    int id;
    String contactName;
    String lastMessage;

    public ConversationItem(int id, String contactName, String lastMessage) {
        this.id = id;
        this.contactName = contactName;
        this.lastMessage = lastMessage;
    }

    public int getId() {
        return id;
    }

    public String getContactName() {
        return contactName;
    }

    public String getLastMessage() {
        return lastMessage;
    }
}
