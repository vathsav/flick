package com.vathsav.flick.model;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vathsav.flick.R;
import com.vathsav.flick.utils.Constants;

import java.util.List;

/**
 * Created by vathsav on 31/05/16.
 */
public class MessageAdapter extends RecyclerView.Adapter<MessageHolder> {
    private final List<MessageItem> conversationThread;
    private final Context context;

    public MessageAdapter(List<MessageItem> conversationThread, Context context) {
        this.conversationThread = conversationThread;
        this.context = context;
    }

    @Override
    public MessageHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.card_chat_bubble, null);
        return new MessageHolder(view, context);
    }

    @Override
    public void onBindViewHolder(MessageHolder holder, int position) {
        if (conversationThread != null)
            if (conversationThread.get(position).getSenderName().equals(Constants.userName)) {
                // My own message
                holder.chatBubbleLeft.setVisibility(View.INVISIBLE);
                holder.chatBubbleRight.setVisibility(View.VISIBLE);
                holder.chatBubbleRight.setText(conversationThread.get(position).getMessageBody());
            } else {
                // Friend's message
                holder.chatBubbleRight.setVisibility(View.INVISIBLE);
                holder.chatBubbleLeft.setVisibility(View.VISIBLE);
                holder.chatBubbleLeft.setText(conversationThread.get(position).getMessageBody());
            }
    }

    @Override
    public int getItemCount() {
        return conversationThread.size();
    }
}
