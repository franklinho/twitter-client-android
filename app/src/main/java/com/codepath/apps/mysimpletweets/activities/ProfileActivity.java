package com.codepath.apps.mysimpletweets.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.codepath.apps.mysimpletweets.R;
import com.codepath.apps.mysimpletweets.TwitterApplication;
import com.codepath.apps.mysimpletweets.fragments.HeaderFragment;
import com.codepath.apps.mysimpletweets.fragments.ProfileTimeLineFragment;
import com.codepath.apps.mysimpletweets.models.User;
import com.codepath.apps.mysimpletweets.networking.TwitterClient;

import butterknife.ButterKnife;

public class ProfileActivity extends AppCompatActivity {

//    @Bind(R.id.toolbar)
//    Toolbar toolbar;


//    User user;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ButterKnife.bind(this);

//        setSupportActionBar(toolbar);
//        ActionBar actionBar = getSupportActionBar();
//
//        actionBar.setLogo(R.drawable.space_between_icon);
//        actionBar.setDisplayUseLogoEnabled(true);
//        actionBar.setDisplayShowHomeEnabled(true);
////        actionBar.setDefaultDisplayHomeAsUpEnabled(false);
////        actionBar.setHomeAsUpIndicator(actionBar.DISPLAY_HOME_AS_UP);
//        actionBar.setDisplayHomeAsUpEnabled(true);
//
//        actionBar.setDisplayShowTitleEnabled(true);

        TwitterClient client;
        client = TwitterApplication.getRestClient();


        User user = getIntent().getParcelableExtra("user");
        if (user == null) {
            user = TwitterClient.currentUser;
        }

//        actionBar.setTitle("@" + user.getScreenName());


        android.support.v4.app.FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        // Create header fragment

        HeaderFragment headerFragment = HeaderFragment.newInstance(user);
        ft.replace(R.id.flHeader, headerFragment);


        //Create user timeline fragment

        ProfileTimeLineFragment profileTimeLineFragment = ProfileTimeLineFragment.newInstance(user.getId());
        //Display user fragment (dynamically)

        ft.replace(R.id.flContainer, profileTimeLineFragment);
        ft.commit();


    }


}
