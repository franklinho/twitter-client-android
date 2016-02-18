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
import com.codepath.apps.mysimpletweets.adapters.StatusesArrayAdapter;
import com.codepath.apps.mysimpletweets.fragments.ComposeDialog;
import com.codepath.apps.mysimpletweets.models.Status;
import com.codepath.apps.mysimpletweets.networking.TwitterClient;
import com.codepath.apps.mysimpletweets.utilities.EndlessRecyclerViewScrollListener;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class TimelineActivity extends AppCompatActivity implements ComposeDialog.InsertNewStatus {

    private TwitterClient client;
    List<Status> statuses;
    StatusesArrayAdapter aStatuses;
    @Bind(R.id.rvTweets)
    RecyclerView rvTweets;
    @Bind(R.id.swipeContainer)
    SwipeRefreshLayout swipeContainer;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    long maxId;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);
        ButterKnife.bind(this);



        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();

        actionBar.setLogo(R.drawable.twitter_icon);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDefaultDisplayHomeAsUpEnabled(false);
        actionBar.setHomeAsUpIndicator(0);
        actionBar.setDisplayHomeAsUpEnabled(false);

        actionBar.setDisplayShowTitleEnabled(false);

        //Create arraylist datasource
        statuses = new ArrayList<>();
        //Construct the adapter
        aStatuses = new StatusesArrayAdapter(statuses, this);

        //Connect adapter to listview
        rvTweets.setAdapter(aStatuses);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rvTweets.setLayoutManager(linearLayoutManager);

        rvTweets.addOnScrollListener(new EndlessRecyclerViewScrollListener(linearLayoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount) {
                populateTimeline(false);
            }
        });

        swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                populateTimeline(true);
            }
        });

        swipeContainer.setColorSchemeResources(R.color.twitter_blue);

        client = TwitterApplication.getRestClient();
        client.getCurrentUser();
        populateTimeline(true);


    }


    // Send api request to get timeline json and fills listview with tweet objects
    private void populateTimeline(final boolean newTimeline) {
        if (newTimeline == true) {
            maxId = 0L;
            aStatuses.clear();
        }
//
//        JSONArray jsonArray = null;
//
//        try {
//            jsonArray = new JSONArray(loadJSONFromAsset());
//        } catch (JSONException e) {
//            e.printStackTrace();
//
//        }
//        statuses.addAll(Status.fromJSONArray(jsonArray));
//
//        if (newTimeline == false) {
//            int curSize = statuses.size();
//            aStatuses.notifyItemRangeInserted(curSize, statuses.size()-1);
//        } else {
//            aStatuses.notifyDataSetChanged();
//        }

        client.getHomeTimeline(new JsonHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray json) {
                Log.d("DEBUG", json.toString());
//                Toast.makeText(getBaseContext(), "SuccessArray", Toast.LENGTH_SHORT).show();


                int curSize = statuses.size();
                //Add them to the adapter
                statuses.addAll(Status.fromJSONArray(json));
                if (newTimeline == false) {
                    aStatuses.notifyItemRangeInserted(curSize, statuses.size() - 1);
                } else {
                    aStatuses.notifyDataSetChanged();
                }

                maxId = statuses.get(statuses.size() - 1).getId() - 1;
                Log.d("DEBUG", "Status Array: " + statuses.toString());
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                Log.d("DEBUG", errorResponse.toString());
//                Toast.makeText(getBaseContext(), "FailureObject", Toast.LENGTH_SHORT).show();
            }


        }, maxId);

        swipeContainer.setRefreshing(false);

    }

    public void showComposeDialog(View v) {
        FragmentManager fm = getSupportFragmentManager();
        ComposeDialog composeDialog = ComposeDialog.newInstance();
        composeDialog.show(fm, "fragment_compose");
    }


    public String loadJSONFromAsset() {
        String json = null;
        try {

            InputStream is = getAssets().open("jsonplaceholder.json");

            int size = is.available();

            byte[] buffer = new byte[size];

            is.read(buffer);

            is.close();

            json = new String(buffer, "UTF-8");


        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;

    }

    public void insertNewStatus(Status status) {
        statuses.add(0, status);
        aStatuses.notifyItemInserted(0);
        rvTweets.scrollToPosition(0);
    }


}
