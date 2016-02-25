package com.codepath.apps.mysimpletweets.activities;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.codepath.apps.mysimpletweets.R;
import com.codepath.apps.mysimpletweets.adapters.UsersArrayAdapter;
import com.codepath.apps.mysimpletweets.models.statuses.User;

import java.io.IOException;
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

    @Bind(R.id.pbProgressAction)
    View pbProgessAction;
    @Bind(R.id.btnNetwork)
    Button btnNetwork;

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


        if (!isConnected()) {
            btnNetwork.setVisibility(View.VISIBLE);
        } else {
            btnNetwork.setVisibility(View.GONE);
        }




    }

    public void showProgressBar() {
        // Show progress item
        pbProgessAction.setVisibility(View.VISIBLE);
    }

    public void hideProgressBar() {
        // Hide progress item
        pbProgessAction.setVisibility(View.GONE);
    }

    public boolean isConnected() {
        if (isNetworkAvailable() && isOnline()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

    public boolean isOnline() {
        Runtime runtime = Runtime.getRuntime();
        try {
            Process ipProcess = runtime.exec("/system/bin/ping -c 1 8.8.8.8");
            int     exitValue = ipProcess.waitFor();
            return (exitValue == 0);
        } catch (IOException e)          { e.printStackTrace(); }
        catch (InterruptedException e) { e.printStackTrace(); }
        return false;
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (!isConnected()) {
            btnNetwork.setVisibility(View.VISIBLE);
        } else {
            btnNetwork.setVisibility(View.GONE);
        }

    }
}
