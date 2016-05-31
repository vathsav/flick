package com.vathsav.flick.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.vathsav.flick.R;
import com.vathsav.flick.model.MessageAdapter;
import com.vathsav.flick.model.MessageItem;
import com.vathsav.flick.utils.Constants;

import java.util.ArrayList;
import java.util.List;

public class ThreadActivity extends AppCompatActivity {

    DatabaseReference reference;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread);

        final String conversationId = "12345";

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final EditText message = (EditText) findViewById(R.id.edit_text_message);

        reference = database.getReference("conversations").child(conversationId);

        Button buttonFlick = (Button) findViewById(R.id.button_flick);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_conversation_thread);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(1, 1);

        final MessageAdapter messageAdapter = new MessageAdapter(createDummyConversationThread(), getApplicationContext());

        if (recyclerView != null) {
            recyclerView.setLayoutManager(staggeredGridLayoutManager);
            recyclerView.setAdapter(messageAdapter);
        }

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<MessageItem> conversation = new ArrayList<>();

                for (DataSnapshot messageSnapshot : dataSnapshot.getChildren()) {
                    conversation.add(
                            new MessageItem(
                                    messageSnapshot.child("messageId").getValue().toString(),
                                    messageSnapshot.child("senderName").getValue().toString(),
                                    messageSnapshot.child("messageBody").getValue().toString(),
                                    messageSnapshot.child("messageTimestamp").getValue().toString()
                            ));
                }

                if (recyclerView != null)
                    recyclerView.setAdapter(new MessageAdapter(conversation, getApplicationContext()));
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
                    reference.push().setValue(new MessageItem(String.valueOf(reference.push().hashCode()),
                            Constants.userName,
                            message.getText().toString(),
                            String.valueOf(System.currentTimeMillis())
                    ));
                }
            });
        }
    }

    private List<MessageItem> createDummyConversationThread() {
        List<MessageItem> conversation = new ArrayList<>();
        conversation.add(new MessageItem("1", "Vathsav", "Loading Conversation", String.valueOf(System.currentTimeMillis())));
        return conversation;
    }
}
