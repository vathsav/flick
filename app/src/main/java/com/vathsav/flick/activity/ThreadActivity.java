package com.vathsav.flick.activity;

import android.os.Bundle;
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

        final String conversationId = "0";

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final EditText message = (EditText) findViewById(R.id.edit_text_message);

        reference = database.getReference("conversations").child(conversationId);

        Button buttonFlick = (Button) findViewById(R.id.button_flick);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_conversation_thread);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(1, 1);

        MessageAdapter messageAdapter = new
                MessageAdapter(createDummyConversationThread(), getApplicationContext());

        if (recyclerView != null) {
            recyclerView.setLayoutManager(staggeredGridLayoutManager);
            recyclerView.setAdapter(messageAdapter);
        }

        // Code for automatically refreshing a recycler view when the data in the server changes
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<MessageItemGetter> conversation = new ArrayList<>();

                for (DataSnapshot messageSnapshot : dataSnapshot.getChildren()) {
                    conversation.add(
                            new MessageItemGetter(
                                    messageSnapshot.child("message_id").getValue().toString(),
                                    messageSnapshot.child("sender_name").getValue().toString(),
                                    messageSnapshot.child("message_body").getValue().toString(),
                                    messageSnapshot.child("message_timestamp").getValue().toString()
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
                    reference.push().setValue(
                            new MessageItemSetter(String.valueOf(reference.push().hashCode()),
                                    Constants.userName,
                                    message.getText().toString(),
                                    String.valueOf(System.currentTimeMillis())
                            ));
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
