package com.codepath.apps.mysimpletweets.activities;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;

import com.codepath.apps.mysimpletweets.TwitterApplication;
import com.codepath.apps.mysimpletweets.models.statuses.User;
import com.codepath.apps.mysimpletweets.networking.TwitterClient;
import com.codepath.apps.mysimpletweets.utilities.EndlessRecyclerViewScrollListener;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FollowersActivity extends UserListActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        rvUsers.addOnScrollListener(new EndlessRecyclerViewScrollListener(linearLayoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount) {
                populateUsers(false);
            }
        });

        swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                populateUsers(true);
            }
        });

        populateUsers(true);

    }

    private void populateUsers(final boolean newTimeline) {
        if (newTimeline == true) {
            cursor = 0L;
            users.clear();
        }


        TwitterClient client = TwitterApplication.getRestClient();
        client.getFollowers(user.getId(), cursor, new JsonHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject json) {
                Log.d("DEBUG", json.toString());
//                Toast.makeText(getBaseContext(), "SuccessArray", Toast.LENGTH_SHORT).show();


                int curSize = users.size();
                //Add them to the adapter



                try {
                    cursor = json.getLong("next_cursor");
                    JSONArray jsonUsers = json.getJSONArray("users");
                    users.addAll(User.fromJSONArray(jsonUsers));
                    if (newTimeline == false) {
                        aUsers.notifyItemRangeInserted(curSize, users.size() - 1);
                    } else {
                        aUsers.notifyDataSetChanged();
                    }

                    maxId = users.get(users.size() - 1).getId() - 1 ;

                    Log.d("DEBUG", "Status Array: " + users.toString());
                } catch (JSONException e) {
                    Log.d("DEBUG", e.toString());
                }

            }



            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                Log.d("DEBUG", errorResponse.toString());
//                Toast.makeText(getBaseContext(), "FailureObject", Toast.LENGTH_SHORT).show();
            }



        });

        swipeContainer.setRefreshing(false);

    }

}
