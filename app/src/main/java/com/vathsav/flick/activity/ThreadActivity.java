package com.vathsav.flick.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.vathsav.flick.R;
import com.vathsav.flick.model.MessageAdapter;
import com.vathsav.flick.model.MessageItemGetter;
import com.vathsav.flick.model.MessageItemSetter;
import com.vathsav.flick.utils.Constants;

import java.util.ArrayList;
import java.util.List;

public class ThreadActivity extends BaseActivity {

    private DatabaseReference reference;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_conversation_thread);
        toolbar.setTitle("Flick");
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        final EditText message = (EditText) findViewById(R.id.edit_text_message);
        final Button buttonFlick = (Button) findViewById(R.id.button_flick);
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        final MessageAdapter messageAdapter = new
                MessageAdapter(createDummyConversationThread(), getApplicationContext());

        final String conversationId = "0";

        reference = Constants.firebaseReferenceConversations.child(conversationId);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_conversation_thread);

        if (recyclerView != null) {
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setAdapter(messageAdapter);
        }

        // Code for automatically refreshing a recycler view when the data in the server changes
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<MessageItemGetter> conversation = new ArrayList<>();
                recyclerView.setAdapter(new MessageAdapter(conversation, getApplicationContext()));

                // Reset the messageAdapter. There's a weird margin on top if I don't.
                recyclerView.setAdapter(new MessageAdapter(null, getApplicationContext()));

                for (DataSnapshot messageSnapshot : dataSnapshot.getChildren()) {
                    conversation.add(
                            new MessageItemGetter(
                                    // TODO: 04/09/16 Change sender name to sender id after implementing OAuth.
                                    messageSnapshot.child("message_id").getValue().toString(),
                                    messageSnapshot.child("sender_name").getValue().toString(),
                                    messageSnapshot.child("message_body").getValue().toString(),
                                    messageSnapshot.child("message_timestamp").getValue().toString()
                            ));
                }

                if (recyclerView != null) {
                    recyclerView.setLayoutManager(linearLayoutManager);
                    recyclerView.scrollToPosition(conversation.size() - 1);
                    recyclerView.setAdapter(new MessageAdapter(conversation, getApplicationContext()));
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.v(Constants.LOG_CATCH_EXCEPTION_VERBOSE, databaseError.getMessage());
            }
        });

        // Push new messages to Firebase
        if (buttonFlick != null && message != null) {
            buttonFlick.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!message.getText().toString().equals(""))
                        reference.push().setValue(
                                new MessageItemSetter(String.valueOf(reference.push().hashCode()),
                                        Constants.userName,
                                        message.getText().toString(),
                                        String.valueOf(System.currentTimeMillis())
                                ));
                    message.setText(null);
                }
            });
        }
    }

    private List<MessageItemGetter> createDummyConversationThread() {
        List<MessageItemGetter> conversation = new ArrayList<>();
        conversation.add(
                new MessageItemGetter("1",
                        "Vathsav",
                        "Loading Conversation",
                        String.valueOf(System.currentTimeMillis())
                ));
        return conversation;
    }
}
