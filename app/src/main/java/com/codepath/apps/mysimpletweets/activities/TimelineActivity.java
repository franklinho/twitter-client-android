package com.codepath.apps.mysimpletweets.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.codepath.apps.mysimpletweets.R;
import com.codepath.apps.mysimpletweets.TwitterApplication;
import com.codepath.apps.mysimpletweets.adapters.StatusesArrayAdapter;
import com.codepath.apps.mysimpletweets.models.Status;
import com.codepath.apps.mysimpletweets.networking.TwitterClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class TimelineActivity extends AppCompatActivity {

    private TwitterClient client;
    List<Status> statuses;
    StatusesArrayAdapter aStatuses;
    @Bind(R.id.lvTweets) ListView lvTweets;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);
        ButterKnife.bind(this);

        //Create arraylist datasource
        statuses = new ArrayList<>();
        //Construct the adapter
        aStatuses = new StatusesArrayAdapter(this, statuses);

        //Connect adapter to listview
        lvTweets.setAdapter(aStatuses);

        client = TwitterApplication.getRestClient();
        populateTimeline();
    }

    // Send api request to get timeline json and fills listview with tweet objects
    private void populateTimeline() {
        client.getHomeTimeline(new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray json) {
                Log.d("DEBUG", json.toString());
                Toast.makeText(getBaseContext(), "SuccessArray", Toast.LENGTH_SHORT).show();


                //Add them to the adapter
                aStatuses.addAll(Status.fromJSONArray(json));
//                statuses = (List<Status>) gson.fromJson(json.toString(), listType);
                Log.d("DEBUG", "Status Array: " + statuses.toString());
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                Log.d("DEBUG", errorResponse.toString());
                Toast.makeText(getBaseContext(), "FailureObject", Toast.LENGTH_SHORT).show();
            }


            @Override
            public void onUserException(Throwable error) {
                Log.d("DEBUG", error.toString());
                Toast.makeText(getBaseContext(), "UserException", Toast.LENGTH_SHORT).show();
            }


        });

    }


}
