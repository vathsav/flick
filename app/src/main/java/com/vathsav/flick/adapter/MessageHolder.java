package com.vathsav.flick.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.vathsav.flick.R;

/**
 * Created by vathsav on 31/05/16.
 * MessageHolder for handling MessageItem
 */

public class MessageHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    final TextView chatBubbleLeft;
    final TextView chatBubbleRight;
    private final Context context;

    public MessageHolder(View itemView, Context context) {
        super(itemView);
        this.context = context;
        itemView.setOnClickListener(this);

        // User's bubble is on the right, the other person's is on the right
        chatBubbleLeft = itemView.findViewById(R.id.text_view_chat_bubble_left);
        chatBubbleRight = itemView.findViewById(R.id.text_view_chat_bubble_right);
    }

    @Override
    public void onClick(View v) {

    }
}
