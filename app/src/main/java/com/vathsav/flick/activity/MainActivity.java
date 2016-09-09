package com.vathsav.flick.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;

import com.google.firebase.auth.FirebaseAuth;
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

        RecyclerView conversationsList = (RecyclerView) findViewById(R.id.recycler_view_main);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(1, 1);


        ConversationAdapter conversationAdapter = new ConversationAdapter(generateDummyConversations(),
                getApplicationContext());

        if (conversationsList != null) {
            conversationsList.setLayoutManager(staggeredGridLayoutManager);
            conversationsList.setAdapter(conversationAdapter);
        }
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
                FirebaseAuth.getInstance().signOut();
                return true;
            case R.id.action_new_conversation:
                Intent newConversation = new Intent(Constants.intentNewConversation);
                startActivity(newConversation);
        }
        return false;
    }

    // TODO: 03/09/16 Enable users to create their own conversation threads by searching for an existing Flick user and sending an invite.
    private ArrayList<ConversationItem> generateDummyConversations() {
        ArrayList<ConversationItem> arrayList = new ArrayList<>();
        arrayList.add(new ConversationItem(0, "Sentinel", "Peace."));
        arrayList.add(new ConversationItem(1, "Crazy Ivan", "#$!@#+&%"));
        arrayList.add(new ConversationItem(2, "Deadshot", "You HEAR ME?!"));
        arrayList.add(new ConversationItem(2, "Autobot", "Don't mess with me."));
        return arrayList;
    }
}
