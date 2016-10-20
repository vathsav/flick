package com.vathsav.flick.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.vathsav.flick.R;
import com.vathsav.flick.model.ContactAdapter;
import com.vathsav.flick.model.ContactItem;

import java.util.ArrayList;
import java.util.List;

/**
 * An activity for the user to start a new conversation with an existing Flick user.
 */

public class NewConversationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_conversation);

        Toolbar toolbar = (Toolbar) findViewById(R.id.action_new_conversation);
        toolbar.setTitle("New Conversation");
        setSupportActionBar(toolbar);

        // TODO: 21/09/16 Ask the user for permission to access Contacts. Check for flick users in the contacts and display on the RecyclerView.

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view_contacts);

        ContactAdapter contactAdapter = new ContactAdapter(dummyContacts(), getApplicationContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));


        recyclerView.setAdapter(contactAdapter);
    }

    private List<ContactItem> dummyContacts() {
        List<ContactItem> listOfContacts = new ArrayList<>();
        listOfContacts.add(new ContactItem("CONTACT_KEY", "Vathsav Harikrishnan", "12345", "A Million Tomorrows"));
        listOfContacts.add(new ContactItem("CONTACT_KEY", "Vathsav Harikrishnan", "12345", "A Million Tomorrows"));
        listOfContacts.add(new ContactItem("CONTACT_KEY", "Vathsav Harikrishnan", "12345", "A Million Tomorrows"));
        listOfContacts.add(new ContactItem("CONTACT_KEY", "Vathsav Harikrishnan", "12345", "A Million Tomorrows"));
        listOfContacts.add(new ContactItem("CONTACT_KEY", "Vathsav Harikrishnan", "12345", "A Million Tomorrows"));
        return listOfContacts;
    }
}
