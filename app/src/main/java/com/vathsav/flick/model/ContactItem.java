package com.vathsav.flick.model;

/**
 * POJO for Contact items in the NewConversationActivity activity.
 */

public class ContactItem {
    public final String contact_key;
    public final String contact_name;
    public final String contact_number;
    public final String contact_status;

    public ContactItem(String contact_key, String contact_name, String contact_number, String contact_status) {
        this.contact_key = contact_key;
        this.contact_name = contact_name;
        this.contact_number = contact_number;
        this.contact_status = contact_status;
    }

    public String get_contact_key() {
        return contact_key;
    }

    public String get_contact_name() {
        return contact_name;
    }

    public String get_contact_number() {
        return contact_number;
    }

    public String get_contact_status() {
        return contact_status;
    }
}
