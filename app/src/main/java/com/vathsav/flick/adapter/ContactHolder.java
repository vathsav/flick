package com.vathsav.flick.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.vathsav.flick.R;
import com.vathsav.flick.utils.Constants;

/**
 * Created by vathsav on 21/09/16.
 * ViewHolder for contacts screen
 */
public class ContactHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    final Context context;
    final ImageView imageViewPicture;
    final TextView textViewContactName;
    final TextView textViewContactNumber;

    public ContactHolder(View itemView, Context context) {
        super(itemView);
        this.context = context;
        imageViewPicture = itemView.findViewById(R.id.image_view_contact_display_picture);
        textViewContactName = itemView.findViewById(R.id.text_view_contact_name);
        textViewContactNumber = itemView.findViewById(R.id.text_view_contact_number);
    }

    @Override
    public void onClick(View view) {
        // TODO: 21/09/16 Open conversation thread! :D
        context.startActivity(Constants.intentThread);
    }
}
