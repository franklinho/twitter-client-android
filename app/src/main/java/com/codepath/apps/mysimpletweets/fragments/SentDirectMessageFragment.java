package com.codepath.apps.mysimpletweets.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codepath.apps.mysimpletweets.R;
import com.codepath.apps.mysimpletweets.TwitterApplication;
import com.codepath.apps.mysimpletweets.models.direct_messages.DirectMessage;
import com.codepath.apps.mysimpletweets.networking.TwitterClient;
import com.codepath.apps.mysimpletweets.utilities.EndlessRecyclerViewScrollListener;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONObject;

public class SentDirectMessageFragment extends DirectMessageFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = super.onCreateView(inflater, container, savedInstanceState);
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
        swipeContainer.setColorSchemeResources(R.color.twitter_blue);

        populateMessages(true);
        btnNetwork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                populateMessages(true);
            }
        });
        return v;
    }

    private void populateMessages(final boolean newTimeline) {
        if (!isConnected()) {
            btnNetwork.setVisibility(View.VISIBLE);
        } else {
            btnNetwork.setVisibility(View.GONE);
            if (newTimeline == true) {
                maxId = 0L;
                directMessages.clear();
                showProgressBar();
            }


            TwitterClient client = TwitterApplication.getRestClient();
            client.getSentDirectMessages(maxId, new JsonHttpResponseHandler() {

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

                    maxId = directMessages.get(directMessages.size() - 1).getId() - 1;

                    Log.d("DEBUG", "DirectMessage Array: " + directMessages.toString());
                    hideProgressBar();

                }

                @Override
                public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                    Log.d("DEBUG", errorResponse.toString());
                    //                Toast.makeText(getBaseContext(), "FailureObject", Toast.LENGTH_SHORT).show();
                    hideProgressBar();
                }


            });
        }

        swipeContainer.setRefreshing(false);

    }
}
