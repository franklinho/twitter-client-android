package com.codepath.apps.mysimpletweets.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.codepath.apps.mysimpletweets.R;
import com.codepath.apps.mysimpletweets.TwitterApplication;
import com.codepath.apps.mysimpletweets.activities.ProfileActivity;
import com.codepath.apps.mysimpletweets.models.User;
import com.codepath.apps.mysimpletweets.networking.TwitterClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by franklinho on 2/16/16.
 */
public class UsersArrayAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<User> mUsers;
    private Context context;
    private TwitterClient client = TwitterApplication.getRestClient();



    public UsersArrayAdapter(List<User> users, Context context) {
        mUsers = users;
        this.context = context;
    }

    public static class UserViewHolder extends  RecyclerView.ViewHolder implements View.OnClickListener {
        public User user;
        private Context context;
        @Bind(R.id.tvScreenName)
        TextView tvScreenName;
        @Bind(R.id.ivProfileImage)
        ImageView ivProfileImage;
        @Bind(R.id.tvName)
        TextView tvName;
        @Bind(R.id.btnFollow)
        Button btnFollow;


        public UserViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            context=itemView.getContext();
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getLayoutPosition();
            Intent i = new Intent(context, ProfileActivity.class);
            i.putExtra("user", user );
            context.startActivity(i);
        }
    }




    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        RecyclerView.ViewHolder viewHolder;

        View v = inflater.inflate(R.layout.item_user, parent, false);
        viewHolder = new UserViewHolder(v);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        final UserViewHolder holder = (UserViewHolder) viewHolder;
        final com.codepath.apps.mysimpletweets.models.User user = mUsers.get(position);
        holder.user = user;

        ImageView ivProfileImage = holder.ivProfileImage;
        TextView tvName = holder.tvName;
        TextView tvScreenName = holder.tvScreenName;
        final Button btnFollow = holder.btnFollow;

        tvName.setText(user.getName());
        tvScreenName.setText("@" + user.getScreenName());

        ivProfileImage.setImageResource(android.R.color.transparent); // Clear imageview
        Glide.with(holder.context).load(user.getProfileImageUrl()).into(ivProfileImage);


        if (user.getFollowing()) {
            client.postFollow(user.getId(), new JsonHttpResponseHandler());
            user.setFollowing(true);
            btnFollow.setBackground(holder.context.getResources().getDrawable(R.drawable.followed_button_border));
            btnFollow.setTextColor(Color.parseColor("#FFFFFF"));
            btnFollow.setText("Unfollow");
        } else {
            client.postUnfollow(user.getId(), new JsonHttpResponseHandler());
            user.setFollowing(false);
            btnFollow.setBackground(holder.context.getResources().getDrawable(R.drawable.unfollowed_button_border));
            btnFollow.setTextColor(Color.parseColor("#55acee"));
            btnFollow.setText("Follow");
        }

        btnFollow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (user.getFollowing()) {
                    client.postUnfollow(user.getId(), new JsonHttpResponseHandler());
                    user.setFollowing(false);
                    btnFollow.setBackground(holder.context.getResources().getDrawable(R.drawable.unfollowed_button_border));
                    btnFollow.setTextColor(Color.parseColor("#55acee"));
                    btnFollow.setText("Follow");
//                    v.startAnimation(animScale);
                } else {
                    client.postFollow(user.getId(), new JsonHttpResponseHandler());
                    user.setFollowing(true);
                    btnFollow.setBackground(holder.context.getResources().getDrawable(R.drawable.followed_button_border));
                    btnFollow.setTextColor(Color.parseColor("#FFFFFF"));
                    btnFollow.setText("Unfollow");
//                    v.startAnimation(animScale);
                }

            }
        });






    }

    @Override
    public int getItemCount() {
        return mUsers.size();
    }




}
