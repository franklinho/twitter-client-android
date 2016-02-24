package com.codepath.apps.mysimpletweets.activities;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.codepath.apps.mysimpletweets.R;
import com.codepath.apps.mysimpletweets.adapters.UsersArrayAdapter;
import com.codepath.apps.mysimpletweets.models.User;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class UserListActivity extends AppCompatActivity {
    List<Long> idList;
    List<User> users;
    LinearLayoutManager linearLayoutManager;
    @Bind(R.id.rvUsers)
    RecyclerView rvUsers;
    UsersArrayAdapter aUsers;
    long maxId;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    long cursor;

    @Bind(R.id.swipeContainer)
    SwipeRefreshLayout swipeContainer;
    int currentRequestCount = 0;
    User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);
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

        user = getIntent().getParcelableExtra("user");
        users = new ArrayList<>();

        aUsers = new UsersArrayAdapter(users, this);
        rvUsers.setAdapter(aUsers);
        linearLayoutManager = new LinearLayoutManager(this);
        rvUsers.setLayoutManager(linearLayoutManager);
        idList = new ArrayList<>();



    }



}
