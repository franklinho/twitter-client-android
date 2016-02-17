package com.codepath.apps.mysimpletweets.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.codepath.apps.mysimpletweets.R;
import com.codepath.apps.mysimpletweets.TwitterApplication;
import com.codepath.apps.mysimpletweets.adapters.StatusesArrayAdapter;
import com.codepath.apps.mysimpletweets.models.Status;
import com.codepath.apps.mysimpletweets.networking.TwitterClient;
import com.codepath.apps.mysimpletweets.utilities.EndlessRecyclerViewScrollListener;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class TimelineActivity extends AppCompatActivity {

    private TwitterClient client;
    List<Status> statuses;
    StatusesArrayAdapter aStatuses;
    @Bind(R.id.rvTweets) RecyclerView rvTweets;
    long maxId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);
        ButterKnife.bind(this);

        //Create arraylist datasource
        statuses = new ArrayList<>();
        //Construct the adapter
        aStatuses = new StatusesArrayAdapter(statuses);

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


        client = TwitterApplication.getRestClient();
        populateTimeline(true);

    }



    // Send api request to get timeline json and fills listview with tweet objects
    private void populateTimeline(final boolean newTimeline) {
        if (newTimeline == true) {
            maxId = 0L;
            statuses.clear();
            aStatuses.notifyDataSetChanged();
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
                Toast.makeText(getBaseContext(), "SuccessArray", Toast.LENGTH_SHORT).show();


                int curSize = statuses.size();
                //Add them to the adapter
                statuses.addAll(Status.fromJSONArray(json));
                if (newTimeline == false) {
                    aStatuses.notifyItemRangeInserted(curSize, statuses.size()-1);
                } else {
                    aStatuses.notifyDataSetChanged();
                }

                maxId = statuses.get(statuses.size()-1).getId() - 1;
                Log.d("DEBUG", "Status Array: " + statuses.toString());
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                Log.d("DEBUG", errorResponse.toString());
                Toast.makeText(getBaseContext(), "FailureObject", Toast.LENGTH_SHORT).show();
            }


        }, maxId);

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


}
