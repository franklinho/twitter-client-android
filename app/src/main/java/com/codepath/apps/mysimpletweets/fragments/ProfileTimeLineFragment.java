package com.codepath.apps.mysimpletweets.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codepath.apps.mysimpletweets.models.statuses.Entities;
import com.codepath.apps.mysimpletweets.models.statuses.Status;
import com.codepath.apps.mysimpletweets.utilities.EndlessRecyclerViewScrollListener;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by franklinho on 2/22/16.
 */
public class ProfileTimeLineFragment extends TweetsListFragment{

    long userId;
    boolean mediaOnly;
    public static ProfileTimeLineFragment newInstance(long userId) {
        ProfileTimeLineFragment profileTimeLineFragment = new ProfileTimeLineFragment();
        Bundle args = new Bundle();
        args.putLong("userId", userId);
        profileTimeLineFragment.setArguments(args);
        return profileTimeLineFragment;
    }

    public static ProfileTimeLineFragment newInstance(long userId, boolean mediaOnly) {
        ProfileTimeLineFragment profileTimeLineFragment = new ProfileTimeLineFragment();
        Bundle args = new Bundle();
        args.putLong("userId", userId);
        args.putBoolean("media", mediaOnly);
        profileTimeLineFragment.setArguments(args);
        return profileTimeLineFragment;
    }




    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = super.onCreateView(inflater, container, savedInstanceState);
        userId = getArguments().getLong("userId");
        mediaOnly = getArguments().getBoolean("media");

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
    public void populateTimeline(final boolean newTimeline) {


        if (newTimeline == true) {
            setMaxId(0L);
            statuses.clear();
            showProgressBar();
        }


        client.getUserTimeline(new JsonHttpResponseHandler() {


            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray json) {
                Log.d("DEBUG", json.toString());
//                Toast.makeText(getBaseContext(), "SuccessArray", Toast.LENGTH_SHORT).show();


                int curSize = statuses.size();
                //Add them to the adapter

                List<Status> tempStatusesArray = Status.fromJSONArray(json);
                if (mediaOnly == false) {
                    statuses.addAll(tempStatusesArray);
                } else {
                    for (int i = 0; i < tempStatusesArray.size(); i++) {
                        Status tempStatus = tempStatusesArray.get(i);

                        Entities extendedEntities = tempStatus.getExtendedEntities();


                        if (extendedEntities != null && extendedEntities.getMedia().get(0).getVideoInfo() != null) {
                            statuses.add(tempStatus);
                        } else if (extendedEntities != null && tempStatus.getEntities().getMedia().size() > 0 && tempStatus.getEntities().getMedia().get(0).getType().equals("photo")) {
                            statuses.add(tempStatus);
                        }
                    }
                }

                if (newTimeline == false) {
                    aStatuses.notifyItemRangeInserted(curSize, statuses.size() - 1);
                } else {
                    aStatuses.notifyDataSetChanged();
                }

                if (statuses.size() > 0) {
                    setMaxId(tempStatusesArray.get(tempStatusesArray.size() - 1).getId() - 1) ;
                } else {
                    populateTimeline(false);
                }

                Log.d("DEBUG", "Status Array: " + statuses.toString());
                hideProgressBar();
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                Log.d("DEBUG", errorResponse.toString());
//                Toast.makeText(getBaseContext(), "FailureObject", Toast.LENGTH_SHORT).show();
                hideProgressBar();
            }


        }, getMaxId(), userId);

        swipeContainer.setRefreshing(false);

    }
}
