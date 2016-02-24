package com.codepath.apps.mysimpletweets.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.codepath.apps.mysimpletweets.R;
import com.codepath.apps.mysimpletweets.TwitterApplication;
import com.codepath.apps.mysimpletweets.models.User;
import com.codepath.apps.mysimpletweets.networking.TwitterClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import butterknife.Bind;
import butterknife.ButterKnife;


public class HeaderFragment extends Fragment {

    @Bind(R.id.ivProfileImage)
    ImageView ivProfileImage;
    @Bind(R.id.tvName)
    TextView tvName;
    @Bind(R.id.tvScreenName)
    TextView tvScreenName;
    @Bind(R.id.tvFollowersCount)
    TextView tvFollowersCount;
    @Bind(R.id.tvFollowingCount)
    TextView tvFollowingCount;
    @Bind(R.id.ivBackground) ImageView ivBackground;
    @Bind(R.id.btnFollow)
    Button btnFollow;

    public HeaderFragment() {
        // Required empty public constructor
    }


    public static HeaderFragment newInstance(User user) {
        HeaderFragment headerFragment = new HeaderFragment();
        Bundle args = new Bundle();
        args.putParcelable("user", user);
        headerFragment.setArguments(args);
        return headerFragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_header, container, false);
        ButterKnife.bind(this, v);

        final User user = getArguments().getParcelable("user");
        tvName.setText(user.getName());
        tvScreenName.setText("@"+user.getScreenName());
        tvFollowersCount.setText(user.getFollowersCount().toString());
        tvFollowingCount.setText(user.getFriendsCount().toString());
        Glide.with(this).load(user.getProfileImageUrl()).into(ivProfileImage);
        Glide.with(this).load(user.getProfileBackgroundImageUrl()).into(ivBackground);

        final TwitterClient client = TwitterApplication.getRestClient();
//        final Animation animScale = AnimationUtils.loadAnimation(getContext(), R.anim.anim_scale);
        if (user.getFollowing()) {
            client.postFollow(user.getId(), new JsonHttpResponseHandler());
            user.setFollowing(true);
            btnFollow.setBackground(getResources().getDrawable(R.drawable.followed_button_border));
            btnFollow.setTextColor(Color.parseColor("#FFFFFF"));
            btnFollow.setText("Unfollow");
        } else {
            client.postUnfollow(user.getId(), new JsonHttpResponseHandler());
            user.setFollowing(false);
            btnFollow.setBackground(getResources().getDrawable(R.drawable.unfollowed_button_border));
            btnFollow.setTextColor(Color.parseColor("#55acee"));
            btnFollow.setText("Follow");
        }

        btnFollow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (user.getFollowing()) {
                    client.postUnfollow(user.getId(), new JsonHttpResponseHandler());
                    user.setFollowing(false);
                    btnFollow.setBackground(getResources().getDrawable(R.drawable.unfollowed_button_border));
                    btnFollow.setTextColor(Color.parseColor("#55acee"));
                    btnFollow.setText("Follow");
//                    v.startAnimation(animScale);
                } else {
                    client.postFollow(user.getId(), new JsonHttpResponseHandler());
                    user.setFollowing(true);
                    btnFollow.setBackground(getResources().getDrawable(R.drawable.followed_button_border));
                    btnFollow.setTextColor(Color.parseColor("#FFFFFF"));
                    btnFollow.setText("Unfollow");
//                    v.startAnimation(animScale);
                }

            }
        });


        return v;
    }


}
