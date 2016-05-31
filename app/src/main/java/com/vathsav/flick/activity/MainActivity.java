package com.vathsav.flick.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.vathsav.flick.R;
import com.vathsav.flick.model.ConversationAdapter;
import com.vathsav.flick.model.ConversationItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView conversationsList = (RecyclerView) findViewById(R.id.recycler_view_main);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(1, 1);

        ConversationAdapter conversationAdapter = new ConversationAdapter(getListOfConversations(),
                getApplicationContext());

        if (conversationsList != null) {
            conversationsList.setLayoutManager(staggeredGridLayoutManager);
            conversationsList.setAdapter(conversationAdapter);
        }
    }

    private List<ConversationItem> getListOfConversations() {
        List<ConversationItem> listOfConversations = new ArrayList<>();
        listOfConversations.add(new ConversationItem(1, "Vathsav", "Hello world"));
        listOfConversations.add(new ConversationItem(2, "Ben", "Hello world"));
        listOfConversations.add(new ConversationItem(3, "Dave", "Hello world"));
        listOfConversations.add(new ConversationItem(4, "Harikrishnan", "Hello world"));
        listOfConversations.add(new ConversationItem(5, "Lazy", "Hello world"));
        listOfConversations.add(new ConversationItem(6, "Smosh", "Hello world"));
        listOfConversations.add(new ConversationItem(7, "Flick", "Hello world"));
        listOfConversations.add(new ConversationItem(8, "Kemu", "Hello world"));
        listOfConversations.add(new ConversationItem(9, "Blink", "Hello world"));
        return listOfConversations;
    }
}
