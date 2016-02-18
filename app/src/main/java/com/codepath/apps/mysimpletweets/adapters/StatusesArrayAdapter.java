package com.codepath.apps.mysimpletweets.adapters;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.codepath.apps.mysimpletweets.R;
import com.codepath.apps.mysimpletweets.TwitterApplication;
import com.codepath.apps.mysimpletweets.activities.TimelineActivity;
import com.codepath.apps.mysimpletweets.fragments.ComposeDialog;
import com.codepath.apps.mysimpletweets.models.Status;
import com.codepath.apps.mysimpletweets.networking.TwitterClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by franklinho on 2/16/16.
 */
public class StatusesArrayAdapter extends RecyclerView.Adapter<StatusesArrayAdapter.ViewHolder> {
    private List<Status> mStatuses;
    private Context context;
    private TwitterClient client;


    public StatusesArrayAdapter(List<Status> statuses, Context context) {
        mStatuses = statuses;
        this.context = context;
    }

    public static class ViewHolder extends  RecyclerView.ViewHolder {

        @Bind(R.id.tvName) TextView tvName;
        @Bind(R.id.tvRelativeTimeStamp) TextView tvRelativeTimeStamp;
        @Bind(R.id.tvBody) TextView tvBody;
        @Bind(R.id.tvScreenName) TextView tvScreenName;
        @Bind(R.id.ivProfileImage) ImageView ivProfileImage;
        @Bind(R.id.tvRetweetCount) TextView tvRetweetCount;
        @Bind(R.id.ibtnFavorite) ImageButton ibtnFavorite;
        @Bind(R.id.ibtnRetweet) ImageButton ibtnRetweet;
        @Bind(R.id.ibtnReply) ImageButton ibtnReply;


//        TextView tvUsername;
//        TextView tvRelativeTimeStamp;
//        TextView tvBody;
//        ImageView ivProfileImage;

        private Context context;


        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
//            tvUsername = (TextView) itemView.findViewById(R.id.tvUsername);
//            tvRelativeTimeStamp = (TextView) itemView.findViewById(R.id.tvRelativeTimeStamp);
//            tvBody = (TextView) itemView.findViewById(R.id.tvBody);
//            ivProfileImage = (ImageView) itemView.findViewById(R.id.ivProfileImage);

            context=itemView.getContext();
        }
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View statusView = inflater.inflate(R.layout.item_status, parent, false);
        ViewHolder viewHolder = new ViewHolder(statusView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final com.codepath.apps.mysimpletweets.models.Status status = mStatuses.get(position);

        ImageView ivProfileImage = holder.ivProfileImage;
        TextView tvName = holder.tvName;
        TextView tvBody = holder.tvBody;
        TextView tvRelativeTimeStamp = holder.tvRelativeTimeStamp;
        TextView tvScreenName = holder.tvScreenName;
        final TextView tvRetweetCount = holder.tvRetweetCount;
        final ImageButton ibtnFavorite = holder.ibtnFavorite;
        final ImageButton ibtnRetweet = holder.ibtnRetweet;
        ImageButton ibtnReply = holder.ibtnReply;



        tvName.setText(status.getUser().getName());
        tvBody.setText(status.getText());
        tvRelativeTimeStamp.setText(status.getRelativeTimeAgo());
        tvScreenName.setText(status.getUser().getScreenName());

        ivProfileImage.setImageResource(android.R.color.transparent); // Clear imageview
//            Picasso.with(holder.context).load(status.getUser().getProfileImageUrl()).into(ivProfileImage);
        Glide.with(holder.context).load(status.getUser().getProfileImageUrl()).into(ivProfileImage);

        tvRetweetCount.setText(Integer.toString(status.getRetweetCount()));
        if (status.getFavorited() == true) {
            ibtnFavorite.setImageResource(R.drawable.heart_icon_red);
        } else {
            ibtnFavorite.setImageResource(R.drawable.heart_icon);
        }

        if (status.getRetweeted() == true) {
            ibtnRetweet.setImageResource(R.drawable.retweet_icon_green);
        } else {
            ibtnRetweet.setImageResource(R.drawable.retweet_icon);
        }

        ibtnReply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                android.support.v4.app.FragmentManager fm = ((TimelineActivity) context).getSupportFragmentManager();
                ComposeDialog composeDialog = ComposeDialog.newInstance();
                Bundle bundle = new Bundle();
                bundle.putParcelable("status", status);
                composeDialog.setArguments(bundle);
                composeDialog.show(fm, "fragment_compose");
            }
        });

        ibtnRetweet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                client = TwitterApplication.getRestClient();
                if (status.getRetweeted()) {
                    client.postUnRetweet(status.getId(), new JsonHttpResponseHandler());
                    status.setRetweeted(false);
                    status.setRetweetCount(status.getRetweetCount() - 1);
                    tvRetweetCount.setText(Integer.toString(status.getRetweetCount()));
                    ibtnRetweet.setImageResource(R.drawable.retweet_icon);
                } else {
                    client.postRetweet(status.getId(), new JsonHttpResponseHandler());
                    status.setRetweeted(true);
                    status.setRetweetCount(status.getRetweetCount() + 1);
                    tvRetweetCount.setText(Integer.toString(status.getRetweetCount()));
                    ibtnRetweet.setImageResource(R.drawable.retweet_icon_green);
                }

            }
        });

        ibtnFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                client = TwitterApplication.getRestClient();
                if (status.getFavorited()) {
                    client.postUnlike(status.getId(), new JsonHttpResponseHandler());
                    status.setFavorited(false);
                    ibtnFavorite.setImageResource(R.drawable.heart_icon);
                } else {
                    client.postLike(status.getId(), new JsonHttpResponseHandler());
                    status.setFavorited(true);
                    ibtnFavorite.setImageResource(R.drawable.heart_icon_red);
                }

            }
        });



    }

    @Override
    public int getItemCount() {
        return mStatuses.size();
    }


    public void clear() {
        mStatuses.clear();
        notifyDataSetChanged();
    }

    public void addAll(List<Status> statuses) {
        mStatuses.addAll(statuses);
        notifyDataSetChanged();
    }


}
