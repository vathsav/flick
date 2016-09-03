package com.vathsav.flick.model;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.vathsav.flick.R;
import com.vathsav.flick.utils.Constants;

/**
 * Created by vathsav on 31/05/16.
 */
public class ConversationHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    final TextView conversationName;
    final TextView conversationMessage;
    private final Context context;

    public ConversationHolder(View itemView, Context context) {
        super(itemView);
        this.context = context;
        itemView.setOnClickListener(this);
        conversationName = (TextView) itemView.findViewById(R.id.card_conversation_item_name);
        conversationMessage = (TextView) itemView.findViewById(R.id.card_conversation_item_name_message);
    }

    @Override
    public void onClick(View v) {
        Intent openThread = new Intent(Constants.intentThread);
        // TODO: 03/09/16 Send thread ids to ThreadActivity as an intent extra
        openThread.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(openThread);
    }
}
