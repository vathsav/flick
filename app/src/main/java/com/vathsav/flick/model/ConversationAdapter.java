package com.vathsav.flick.model;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vathsav.flick.R;

import java.util.List;

/**
 * Created by vathsav on 31/05/16.
 * Adapter for conversation items.
 */
public class ConversationAdapter extends RecyclerView.Adapter<ConversationHolder> {
    private final List<ConversationItem> listOfConversations;
    private final Context context;

    public ConversationAdapter(List<ConversationItem> listOfConversations, Context context) {
        this.listOfConversations = listOfConversations;
        this.context = context;
    }

    @Override
    public ConversationHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.card_conversation_item, null);
        return new ConversationHolder(view, context);
    }

    @Override
    public void onBindViewHolder(ConversationHolder holder, int position) {
        holder.conversationName.setText(listOfConversations.get(position).getContactName());
        holder.conversationMessage.setText(listOfConversations.get(position).getLastMessage());
    }

    @Override
    public int getItemCount() {
        return listOfConversations.size();
    }
}
