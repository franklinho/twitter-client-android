package com.codepath.apps.mysimpletweets.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.astuetz.PagerSlidingTabStrip;
import com.codepath.apps.mysimpletweets.R;
import com.codepath.apps.mysimpletweets.TwitterApplication;
import com.codepath.apps.mysimpletweets.fragments.HeaderFragment;
import com.codepath.apps.mysimpletweets.fragments.ProfileTimeLineFragment;
import com.codepath.apps.mysimpletweets.fragments.QueryTimeLineFragment;
import com.codepath.apps.mysimpletweets.models.User;
import com.codepath.apps.mysimpletweets.networking.TwitterClient;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ProfileActivity extends AppCompatActivity {

    @Bind(R.id.viewpager)
    ViewPager viewpager;

    private TwitterClient client;
    @Bind(R.id.tabs)
    PagerSlidingTabStrip tabstrip;
    ProfileTimeLineFragment profileTimeLineFragment;
    QueryTimeLineFragment queryTimeLineFragment;
    User user;
//    @Bind(R.id.toolbar)
//    Toolbar toolbar;


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


        user = getIntent().getParcelableExtra("user");
        if (user == null) {
            user = TwitterClient.currentUser;
        }

//        actionBar.setTitle("@" + user.getScreenName());

//
        android.support.v4.app.FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
//        // Create header fragment
//
        HeaderFragment headerFragment = HeaderFragment.newInstance(user);
        ft.replace(R.id.flHeader, headerFragment);
////
//
//        //Create user timeline fragment
//
//        ProfileTimeLineFragment profileTimeLineFragment = ProfileTimeLineFragment.newInstance(user.getId());
//        //Display user fragment (dynamically)
//
//        ft.replace(R.id.flContainer, profileTimeLineFragment);
        ft.commit();


        //Get viewpager

        //Set Viewpager adapter
        viewpager.setAdapter(new TweetsPagerAdapter(getSupportFragmentManager()));



        //Attach the pager tabs to the viewpager
        tabstrip.setViewPager(viewpager);


    }

    // return order of fragments in viewpager
    public class TweetsPagerAdapter extends FragmentPagerAdapter {

        private String tabTitles[] = { "Tweets", "Media" };

        public TweetsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        //Get the fragment for the tab
        @Override
        public Fragment getItem(int position) {
            if (position == 0 ) {
                profileTimeLineFragment = ProfileTimeLineFragment.newInstance(user.getId());
                return profileTimeLineFragment;
            } else if (position == 1){
                queryTimeLineFragment = QueryTimeLineFragment.newInstance("from:"+user.getScreenName().toString()+" AND filter:media");
                return queryTimeLineFragment;
            } else {
                return null;
            }
        }


        //Returns number of tabs
        @Override
        public int getCount() {
            return tabTitles.length;
        }

        //Returns tab titles
        @Override
        public CharSequence getPageTitle(int position) {
            return tabTitles[position];
        }
    }


}
