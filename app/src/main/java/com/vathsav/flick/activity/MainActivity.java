package com.vathsav.flick.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.vathsav.flick.R;
import com.vathsav.flick.model.ConversationAdapter;
import com.vathsav.flick.model.ConversationItem;
import com.vathsav.flick.utils.Constants;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RecyclerView conversationsList = (RecyclerView) findViewById(R.id.recycler_view_main);

        // TODO: 20/10/16 Query available users
        // TODO: 03/09/16 Enable users to create their own conversation threads by searching for an existing Flick user and sending an invite.

        Constants.firebaseReferenceUsers.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                ArrayList<ConversationItem> listOfConversations = new ArrayList<>();

                for (DataSnapshot userSnapshot : dataSnapshot.getChildren()) {
                    listOfConversations.add(new ConversationItem(0, userSnapshot.getKey(), "last_message"));
                }

                conversationsList.setLayoutManager(new StaggeredGridLayoutManager(1, 1));
                conversationsList.setAdapter(new ConversationAdapter(listOfConversations, getApplicationContext()));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_logout:
//                FirebaseAuth.getInstance().signOut();
                return true;
            case R.id.action_new_conversation:
                Intent newConversation = Constants.intentNewConveration;
                startActivity(newConversation);
        }
        return false;
    }
}
