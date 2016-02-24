package com.codepath.apps.mysimpletweets.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.codepath.apps.mysimpletweets.R;
import com.codepath.apps.mysimpletweets.TwitterApplication;
import com.codepath.apps.mysimpletweets.models.direct_messages.DirectMessage;
import com.codepath.apps.mysimpletweets.networking.TwitterClient;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by franklinho on 2/16/16.
 */
public class DirectMessagesArrayAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<DirectMessage> mDirectMessages;
    private Context context;
    private TwitterClient client = TwitterApplication.getRestClient();



    public DirectMessagesArrayAdapter(List<DirectMessage> directMessages, Context context) {
        mDirectMessages = directMessages;
        this.context = context;
    }

    public static class DirectMessageViewHolder extends  RecyclerView.ViewHolder implements View.OnClickListener {
        public DirectMessage directMessage;
        private Context context;

        @Bind(R.id.ivProfileImage)
        ImageView ivProfileImage;
        @Bind(R.id.tvName)
        TextView tvName;
        @Bind(R.id.tvBody)
        TextView tvBody;
        @Bind(R.id.tvTimestamp)
        TextView tvTimestamp;


        public DirectMessageViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            context=itemView.getContext();
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
//            int position = getLayoutPosition();
//            Intent i = new Intent(context, ProfileActivity.class);
//            i.putExtra("directMessage", directMessage );
//            context.startActivity(i);
        }
    }




    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        RecyclerView.ViewHolder viewHolder;

        View v = inflater.inflate(R.layout.item_direct_message, parent, false);
        viewHolder = new DirectMessageViewHolder(v);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        final DirectMessageViewHolder holder = (DirectMessageViewHolder) viewHolder;
        final DirectMessage directMessage = mDirectMessages.get(position);
        holder.directMessage = directMessage;

        ImageView ivProfileImage = holder.ivProfileImage;
        TextView tvName = holder.tvName;
        TextView tvBody = holder.tvBody;
        TextView tvTimestamp = holder.tvTimestamp;


        tvName.setText(directMessage.getSender().getName().toString());
        tvBody.setText(directMessage.getText().toString());
        tvTimestamp.setText(directMessage.getRelativeTimeAgo().toString());

        ivProfileImage.setImageResource(android.R.color.transparent); // Clear imageview
        Glide.with(holder.context).load(directMessage.getSender().getProfileImageUrl()).into(ivProfileImage);







    }

    @Override
    public int getItemCount() {
        return mDirectMessages.size();
    }




}
