package com.codepath.apps.mysimpletweets.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codepath.apps.mysimpletweets.models.statuses.Status;
import com.codepath.apps.mysimpletweets.utilities.EndlessRecyclerViewScrollListener;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by franklinho on 2/22/16.
 */
public class QueryTimeLineFragment extends TweetsListFragment{

    public static QueryTimeLineFragment newInstance(String query) {
        QueryTimeLineFragment queryTimeLineFragment = new QueryTimeLineFragment();
        Bundle args = new Bundle();
        args.putString("query", query);
        queryTimeLineFragment.setArguments(args);
        return queryTimeLineFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = super.onCreateView(inflater, container, savedInstanceState);

        linearLayoutManager = new LinearLayoutManager(getContext());
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

        populateTimeline(true);
        return v;
    }

    // Send api request to get timeline json and fills listview with tweet objects
    private void populateTimeline(final boolean newTimeline) {
        if (newTimeline == true) {
            maxId = 0L;
            statuses.clear();
            showProgressBar();
        }

        String query = getArguments().getString("query");

        client.getSearchTimeline(new JsonHttpResponseHandler() {

//            @Override
//            public void onSuccess(int statusCode, Header[] headers, JSONArray json) {
//                Log.d("DEBUG", json.toString());
////                Toast.makeText(getBaseContext(), "SuccessArray", Toast.LENGTH_SHORT).show();
//
//
//                int curSize = statuses.size();
//                //Add them to the adapter
//
//                statuses.addAll(Status.fromJSONArray(json));
//
//                //Add them to the adapter
//                statuses.addAll(statuses);
//                if (newTimeline == false) {
//                    aStatuses.notifyItemRangeInserted(curSize, statuses.size() - 1);
//                } else {
//                    aStatuses.notifyDataSetChanged();
//                }
//
//                maxId = statuses.get(statuses.size() - 1).getId() - 1;
//
//                Log.d("DEBUG", "Status Array: " + statuses.toString());
//            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject json) {
                Log.d("DEBUG", json.toString());
//                Toast.makeText(getBaseContext(), "SuccessArray", Toast.LENGTH_SHORT).show();


                int curSize = statuses.size();
                //Add them to the adapter

                try {
                    JSONArray jsonStatuses = json.getJSONArray("statuses");
                    statuses.addAll(Status.fromJSONArray(jsonStatuses));

                    if (newTimeline == false) {
                        aStatuses.notifyItemRangeInserted(curSize, statuses.size() - 1);
                    } else {
                        aStatuses.notifyDataSetChanged();
                    }

                    if (statuses.size() > 0) {
                        maxId = statuses.get(statuses.size() - 1).getId() - 1 ;
                    }

                    Log.d("DEBUG", "Status Array: " + statuses.toString());
                } catch (JSONException e) {
                    Log.d("DEBUG", e.toString());
                }
                hideProgressBar();

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                Log.d("DEBUG", errorResponse.toString());
//                Toast.makeText(getBaseContext(), "FailureObject", Toast.LENGTH_SHORT).show();
                hideProgressBar();
            }


        }, maxId, query);

        swipeContainer.setRefreshing(false);

    }
}
