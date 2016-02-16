package com.codepath.apps.mysimpletweets.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.codepath.apps.mysimpletweets.R;
import com.codepath.apps.mysimpletweets.models.Status;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by franklinho on 2/16/16.
 */
public class StatusesArrayAdapter extends ArrayAdapter<Status>{
    public StatusesArrayAdapter(Context context, List<Status> statuses) {
        super(context, android.R.layout.simple_list_item_1, statuses);
    }

    // Override custom template

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Get tweet
        Status status = getItem(position);
        // Find or inflate the template
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_status,parent,false);
        }
        // Find the subviews and fill data with the template
        ImageView ivProfileImage = (ImageView) convertView.findViewById(R.id.ivProfileImage);
        TextView tvUsername = (TextView) convertView.findViewById(R.id.tvUsername);
        TextView tvBody = (TextView) convertView.findViewById(R.id.tvBody);
        //Populate data into the subviews

        tvUsername.setText(status.getUser().getName());
        tvBody.setText(status.getText());
        ivProfileImage.setImageResource(android.R.color.transparent); // Clear imageview
        Picasso.with(getContext()).load(status.getUser().getProfileImageUrl()).into(ivProfileImage);
        // Return the view to be inserted into the list

        return convertView;

    }
}
