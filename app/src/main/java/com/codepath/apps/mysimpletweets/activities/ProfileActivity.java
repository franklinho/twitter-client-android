package com.codepath.apps.mysimpletweets.activities;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.codepath.apps.mysimpletweets.R;
import com.codepath.apps.mysimpletweets.TwitterApplication;
import com.codepath.apps.mysimpletweets.fragments.ProfileTimeLineFragment;
import com.codepath.apps.mysimpletweets.models.User;
import com.codepath.apps.mysimpletweets.networking.TwitterClient;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ProfileActivity extends AppCompatActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;

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
//    User user;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();

        actionBar.setLogo(R.drawable.space_between_icon);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
//        actionBar.setDefaultDisplayHomeAsUpEnabled(false);
//        actionBar.setHomeAsUpIndicator(actionBar.DISPLAY_HOME_AS_UP);
        actionBar.setDisplayHomeAsUpEnabled(true);

        actionBar.setDisplayShowTitleEnabled(true);

        TwitterClient client;
        client = TwitterApplication.getRestClient();


        User user = getIntent().getParcelableExtra("user");
        if (user == null) {
            user = TwitterClient.currentUser;
        }
        tvName.setText(user.getName());
        tvScreenName.setText(user.getScreenName());
        tvFollowersCount.setText(user.getFollowersCount().toString());
        tvFollowingCount.setText(user.getFriendsCount().toString());
        Glide.with(this).load(user.getProfileImageUrl()).into(ivProfileImage);
        actionBar.setTitle("@" + user.getScreenName());



        //Create user timeline fragment


            ProfileTimeLineFragment profileTimeLineFragment = ProfileTimeLineFragment.newInstance(user.getId());
            //Display user fragment (dynamically)
            android.support.v4.app.FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

            ft.replace(R.id.flContainer, profileTimeLineFragment);

            ft.commit();



//        long userId =  getIntent().getLongExtra("userId", TwitterClient.currentUser.getId());

//        if (userId == TwitterClient.currentUser.getId()) {
//            user = TwitterClient.currentUser;
//            configureProfileActivity(savedInstanceState);
//        } else {
//            client.getUserProfile(userId, new JsonHttpResponseHandler() {
//                @Override
//                public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
//                    Gson gson = new GsonBuilder().create();
//
//                    user = gson.fromJson(response.toString(), User.class);
//                    configureProfileActivity(savedInstanceState);
//
//                }
//
//                @Override
//                public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
//                    Log.d("DEBUG", "Failed to grab user object");
//                    user = TwitterClient.currentUser;
//                }
//            });
//        }


    }
}
