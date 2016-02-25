package com.codepath.apps.mysimpletweets.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.astuetz.PagerSlidingTabStrip;
import com.codepath.apps.mysimpletweets.R;
import com.codepath.apps.mysimpletweets.fragments.ComposeDirectMessageDialog;
import com.codepath.apps.mysimpletweets.fragments.InboxDirectMessageFragment;
import com.codepath.apps.mysimpletweets.fragments.SentDirectMessageFragment;
import com.codepath.apps.mysimpletweets.models.direct_messages.DirectMessage;

import butterknife.Bind;
import butterknife.ButterKnife;

public class DirectMessagesActivity extends AppCompatActivity implements ComposeDirectMessageDialog.InsertNewDirectMessage {


    @Bind(R.id.toolbar)
    Toolbar toolbar;
    long cursor;
    @Bind(R.id.viewpager)
    ViewPager viewpager;
    @Bind(R.id.tabs)
    PagerSlidingTabStrip tabstrip;
    InboxDirectMessageFragment inboxDirectMessageFragment;
    SentDirectMessageFragment sentDirectMessageFragment;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_direct_messages);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();

        actionBar.setLogo(R.drawable.space_between_icon);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
//        actionBar.setDefaultDisplayHomeAsUpEnabled(false);
//        actionBar.setHomeAsUpIndicator(actionBar.DISPLAY_HOME_AS_UP);
        actionBar.setDisplayHomeAsUpEnabled(true);

//        actionBar.setDisplayShowTitleEnabled(true);


        //Get viewpager

        //Set Viewpager adapter
        viewpager.setAdapter(new DirectMessagesPagerAdapter(getSupportFragmentManager()));



        //Attach the pager tabs to the viewpager
        tabstrip.setViewPager(viewpager);

    }

    public class DirectMessagesPagerAdapter extends FragmentPagerAdapter {

        private String tabTitles[] = { "Inbox", "Sent" };

        public DirectMessagesPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        //Get the fragment for the tab
        @Override
        public Fragment getItem(int position) {
            if (position == 0 ) {
                inboxDirectMessageFragment = new InboxDirectMessageFragment();
                return inboxDirectMessageFragment;
            } else if (position == 1){
                sentDirectMessageFragment = new SentDirectMessageFragment();
                return sentDirectMessageFragment;
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



    public void showNewMessageDialog(View v) {
        showNewMessageDialog();
    }
    public void showNewMessageDialog() {
        FragmentManager fm = getSupportFragmentManager();
        ComposeDirectMessageDialog composeDirectMessageDialog = ComposeDirectMessageDialog.newInstance();
        composeDirectMessageDialog.show(fm, "fragment_new_direct_message");
    }

    @Override
    public void insertNewDirectMessage(DirectMessage directMessage) {
        sentDirectMessageFragment.insertNewDirectMessage(directMessage);
    }
}
