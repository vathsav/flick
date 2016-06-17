package com.vathsav.flick.activity;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;

import com.google.firebase.auth.FirebaseAuth;
import com.vathsav.flick.R;
import com.vathsav.flick.model.ConversationAdapter;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView conversationsList = (RecyclerView) findViewById(R.id.recycler_view_main);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(1, 1);

        ConversationAdapter conversationAdapter = new ConversationAdapter(null,
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
        }
        return false;
    }
}
