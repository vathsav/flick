package com.vathsav.flick.model;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.vathsav.flick.R;

/**
 * Created by vathsav on 31/05/16.
 */
public class ConversationHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    Context context;
    TextView conversationName;
    TextView conversationMessage;

    public ConversationHolder(View itemView, Context context) {
        super(itemView);
        this.context = context;
        itemView.setOnClickListener(this);
        conversationName = (TextView) itemView.findViewById(R.id.card_conversation_item_name);
        conversationMessage = (TextView) itemView.findViewById(R.id.card_conversation_item_name_message);
    }

    @Override
    public void onClick(View v) {
        Intent openThread = new Intent("com.vathsav.flick.THREAD");
        openThread.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(openThread);
    }
}
