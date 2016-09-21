package com.vathsav.flick.model;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vathsav.flick.R;

import java.util.List;

/**
 * Created by vathsav on 21/09/16.
 * Adapter for ContactItems
 */
public class ContactAdapter extends RecyclerView.Adapter<ContactHolder> {
    private final List<ContactItem> listOfContacts;
    private final Context context;

    public ContactAdapter(List<ContactItem> listOfContacts, Context context) {
        this.listOfContacts = listOfContacts;
        this.context = context;
    }

    @Override
    public ContactHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_contact, parent, false);
        return new ContactHolder(view, context);
    }

    @Override
    public void onBindViewHolder(ContactHolder holder, int position) {
//        holder.imageViewPicture.setImageBitmap();
        holder.textViewContactName.setText(listOfContacts.get(position).contact_name);
        holder.textViewContactNumber.setText(listOfContacts.get(position).contact_number);
    }

    @Override
    public int getItemCount() {
        return listOfContacts.size();
    }
}
