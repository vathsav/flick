package com.vathsav.flick.model;

/**
 * Created by vathsav on 31/05/16.
 * POJO for Conversation List Item
 */
public class ConversationItem {
    private final int id;
    private final String contact_name;
    private final String last_message;

    public ConversationItem(int id, String contact_name, String last_message) {
        this.id = id;
        this.contact_name = contact_name;
        this.last_message = last_message;
    }

    public int getId() {
        return id;
    }

    public String getContactName() {
        return contact_name;
    }

    public String getLastMessage() {
        return last_message;
    }
}
