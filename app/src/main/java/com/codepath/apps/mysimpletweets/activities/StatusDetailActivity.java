package com.codepath.apps.mysimpletweets.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.codepath.apps.mysimpletweets.R;
import com.codepath.apps.mysimpletweets.TwitterApplication;
import com.codepath.apps.mysimpletweets.fragments.ComposeDialog;
import com.codepath.apps.mysimpletweets.models.Status;
import com.codepath.apps.mysimpletweets.networking.TwitterClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import java.lang.reflect.Field;

import butterknife.Bind;
import butterknife.ButterKnife;

public class StatusDetailActivity extends AppCompatActivity implements ComposeDialog.InsertNewStatus {
    Status status;
    @Bind(R.id.ivProfileImage) ImageView ivProfileImage;
    @Bind(R.id.tvName) TextView tvName;
    @Bind(R.id.tvScreenName) TextView tvScreenName;
    @Bind(R.id.tvBody) TextView tvBody;
    @Bind(R.id.tvRetweetCount) TextView tvRetweetCount;
    @Bind(R.id.tvTimestamp) TextView tvTimestamp;
    @Bind(R.id.ibtnReply) ImageButton ibtnReply;
    @Bind(R.id.ibtnRetweet) ImageButton ibtnRetweet;
    @Bind(R.id.ibtnFavorite) ImageButton ibtnFavorite;
    private TwitterClient client;
    @Bind(R.id.toolbar)
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status_detail);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();

        actionBar.setLogo(R.drawable.space_between_icon);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
//        actionBar.setDefaultDisplayHomeAsUpEnabled(false);
//        actionBar.setHomeAsUpIndicator(actionBar.DISPLAY_HOME_AS_UP);
        actionBar.setDisplayHomeAsUpEnabled(true);

        actionBar.setDisplayShowTitleEnabled(false);

        client = TwitterApplication.getRestClient();
        status = getIntent().getParcelableExtra("status");

        tvBody.setMaxLines(Integer.MAX_VALUE);
        if (status != null) {
            tvName.setText(status.getUser().getName());
            tvScreenName.setText(status.getUser().getScreenName());
            Glide.with(this).load(status.getUser().getProfileImageUrl()).into(ivProfileImage);
            tvRetweetCount.setText(status.getRetweetCount().toString());
            tvBody.setText(status.getText());
            tvTimestamp.setText(status.getFormattedTimeStamp());
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

                    android.support.v4.app.FragmentManager fm = getSupportFragmentManager();
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

            ivProfileImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(StatusDetailActivity.this, ProfileActivity.class);
                    i.putExtra("user", status.getUser());
                    startActivity(i);
                }
            });

        }
    }

    @Override
    public void insertNewStatus(Status status) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);


        AutoCompleteTextView searchTextView = (AutoCompleteTextView) searchView.findViewById(android.support.v7.appcompat.R.id.search_src_text);

        try {
            Field mCursorDrawableRes = TextView.class.getDeclaredField("mCursorDrawableRes");
            mCursorDrawableRes.setAccessible(true);
            mCursorDrawableRes.set(searchTextView, R.drawable.cursor); //This sets the cursor resource ID to 0 or @null which will make it visible on white background
        } catch (Exception e) {
        }
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Intent i = new Intent(getBaseContext(), SearchResultsActivity.class);
                i.putExtra("query", query);
                searchView.clearFocus();
                startActivity(i);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return true;
    }

    public void onProfileView(MenuItem item) {
        Intent i = new Intent(this, ProfileActivity.class);
//        i.putExtra("userId",client.getCurrentUser().getId());
        startActivity(i);
    }

    public void onCompose(MenuItem item) {
        FragmentManager fm = getSupportFragmentManager();
        ComposeDialog composeDialog = ComposeDialog.newInstance();
        composeDialog.show(fm, "fragment_compose");
    }
}
