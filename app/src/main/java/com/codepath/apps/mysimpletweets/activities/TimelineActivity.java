package com.codepath.apps.mysimpletweets.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.astuetz.PagerSlidingTabStrip;
import com.codepath.apps.mysimpletweets.R;
import com.codepath.apps.mysimpletweets.TwitterApplication;
import com.codepath.apps.mysimpletweets.fragments.ComposeDialog;
import com.codepath.apps.mysimpletweets.fragments.HomeTimeLineFragment;
import com.codepath.apps.mysimpletweets.fragments.MentionsTimeLineFragment;
import com.codepath.apps.mysimpletweets.fragments.TweetsListFragment;
import com.codepath.apps.mysimpletweets.models.Status;
import com.codepath.apps.mysimpletweets.networking.TwitterClient;

import butterknife.Bind;
import butterknife.ButterKnife;

public class TimelineActivity extends AppCompatActivity implements ComposeDialog.InsertNewStatus {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.viewpager)
    ViewPager viewpager;
    TweetsListFragment feedFragment;
    private TwitterClient client;
    @Bind(R.id.tabs)
    PagerSlidingTabStrip tabstrip;
    HomeTimeLineFragment homeTimeLineFragment;
    MentionsTimeLineFragment mentionsTimeLineFragment;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();

        actionBar.setLogo(R.drawable.space_between_icon);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDefaultDisplayHomeAsUpEnabled(false);
        actionBar.setHomeAsUpIndicator(0);
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);


        client = TwitterApplication.getRestClient();
        client.getCurrentUser();



        //Get viewpager

        //Set Viewpager adapter
        viewpager.setAdapter(new TweetsPagerAdapter(getSupportFragmentManager()));



        //Attach the pager tabs to the viewpager
        tabstrip.setViewPager(viewpager);
    }



    public void showComposeDialog(View v) {
        FragmentManager fm = getSupportFragmentManager();
        ComposeDialog composeDialog = ComposeDialog.newInstance();
        composeDialog.show(fm, "fragment_compose");
    }

    public void insertNewStatus(Status status) {
       homeTimeLineFragment.insertNewStatus(status);
//        feedFragment.insertNewStatus(status);
    }

    public void onProfileView(MenuItem item) {
        Intent i = new Intent(this, ProfileActivity.class);
//        i.putExtra("userId",client.getCurrentUser().getId());
        startActivity(i);
    }

    // return order of fragments in viewpager
    public class TweetsPagerAdapter extends FragmentPagerAdapter {

        private String tabTitles[] = { "Home", "Mentions" };

        public TweetsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        //Get the fragment for the tab
        @Override
        public Fragment getItem(int position) {
            if (position == 0 ) {
                homeTimeLineFragment = new HomeTimeLineFragment();
                return homeTimeLineFragment;
            } else if (position == 1){
                mentionsTimeLineFragment = new MentionsTimeLineFragment();
                return mentionsTimeLineFragment;
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}
