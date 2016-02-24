package com.codepath.apps.mysimpletweets.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.codepath.apps.mysimpletweets.R;
import com.codepath.apps.mysimpletweets.TwitterApplication;
import com.codepath.apps.mysimpletweets.adapters.DirectMessagesArrayAdapter;
import com.codepath.apps.mysimpletweets.fragments.ComposeDirectMessageDialog;
import com.codepath.apps.mysimpletweets.models.direct_messages.DirectMessage;
import com.codepath.apps.mysimpletweets.networking.TwitterClient;
import com.codepath.apps.mysimpletweets.utilities.EndlessRecyclerViewScrollListener;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class DirectMessagesActivity extends AppCompatActivity {

    List<DirectMessage> directMessages;
    LinearLayoutManager linearLayoutManager;
    @Bind(R.id.rvDirectMessages)
    RecyclerView rvDirectMessages;
    DirectMessagesArrayAdapter aDirectMessages;
    long maxId;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    long cursor;

    @Bind(R.id.swipeContainer)
    SwipeRefreshLayout swipeContainer;
    int currentRequestCount = 0;

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


        directMessages = new ArrayList<>();

        aDirectMessages = new DirectMessagesArrayAdapter(directMessages, this);
        rvDirectMessages.setAdapter(aDirectMessages);
        linearLayoutManager = new LinearLayoutManager(this);
        rvDirectMessages.setLayoutManager(linearLayoutManager);

        rvDirectMessages.addOnScrollListener(new EndlessRecyclerViewScrollListener(linearLayoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount) {
                populateMessages(false);
            }
        });

        swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                populateMessages(true);
            }
        });

        populateMessages(true);



    }


    private void populateMessages(final boolean newTimeline) {
        if (newTimeline == true) {
            maxId = 0L;
            directMessages.clear();
        }


        TwitterClient client = TwitterApplication.getRestClient();
        client.getDirectMessages(maxId, new JsonHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray json) {
                Log.d("DEBUG", json.toString());
//                Toast.makeText(getBaseContext(), "SuccessArray", Toast.LENGTH_SHORT).show();


                int curSize = directMessages.size();
                //Add them to the adapter

                directMessages.addAll(DirectMessage.fromJSONArray(json));
                if (newTimeline == false) {
                    aDirectMessages.notifyItemRangeInserted(curSize, directMessages.size() - 1);
                } else {
                    aDirectMessages.notifyDataSetChanged();
                }

                maxId = directMessages.get(directMessages.size() - 1).getId() - 1 ;

                Log.d("DEBUG", "DirectMessage Array: " + directMessages.toString());

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                Log.d("DEBUG", errorResponse.toString());
//                Toast.makeText(getBaseContext(), "FailureObject", Toast.LENGTH_SHORT).show();
            }



        });

        swipeContainer.setRefreshing(false);

    }

    public void showNewMessageDialog(View v) {
        showNewMessageDialog();
    }
    public void showNewMessageDialog() {
        FragmentManager fm = getSupportFragmentManager();
        ComposeDirectMessageDialog composeDirectMessageDialog = ComposeDirectMessageDialog.newInstance();
        composeDirectMessageDialog.show(fm, "fragment_new_direct_message");
    }
}
