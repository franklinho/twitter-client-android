package com.codepath.apps.mysimpletweets.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.codepath.apps.mysimpletweets.R;
import com.codepath.apps.mysimpletweets.models.User;

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

        User user = getArguments().getParcelable("user");
        tvName.setText(user.getName());
        tvScreenName.setText("@"+user.getScreenName());
        tvFollowersCount.setText(user.getFollowersCount().toString());
        tvFollowingCount.setText(user.getFriendsCount().toString());
        Glide.with(this).load(user.getProfileImageUrl()).into(ivProfileImage);
        Glide.with(this).load(user.getProfileBackgroundImageUrl()).into(ivBackground);


        return v;
    }


}
