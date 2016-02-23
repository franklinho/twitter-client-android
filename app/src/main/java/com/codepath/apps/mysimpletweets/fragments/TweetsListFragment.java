package com.codepath.apps.mysimpletweets.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codepath.apps.mysimpletweets.R;
import com.codepath.apps.mysimpletweets.TwitterApplication;
import com.codepath.apps.mysimpletweets.adapters.StatusesArrayAdapter;
import com.codepath.apps.mysimpletweets.models.Status;
import com.codepath.apps.mysimpletweets.networking.TwitterClient;
import com.codepath.apps.mysimpletweets.utilities.EndlessRecyclerViewScrollListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by franklinho on 2/22/16.
 */
public class TweetsListFragment extends Fragment {



    public List<Status> getStatuses() {
        return statuses;
    }

    public void setStatuses(List<Status> statuses) {
        this.statuses = statuses;
    }



    List<Status> statuses;
    StatusesArrayAdapter aStatuses;
    @Bind(R.id.rvTweets)
    public RecyclerView rvTweets;

    public SwipeRefreshLayout getSwipeContainer() {
        return swipeContainer;
    }

    public void setSwipeContainer(SwipeRefreshLayout swipeContainer) {
        this.swipeContainer = swipeContainer;
    }

    @Bind(R.id.swipeContainer)
    SwipeRefreshLayout swipeContainer;

    public LinearLayoutManager getLinearLayoutManager() {
        return linearLayoutManager;
    }

    public void setLinearLayoutManager(LinearLayoutManager linearLayoutManager) {
        this.linearLayoutManager = linearLayoutManager;
    }

    LinearLayoutManager linearLayoutManager;

    public long getMaxId() {
        return maxId;
    }

    public void setMaxId(long maxId) {
        this.maxId = maxId;
    }

    public long maxId;
    TwitterClient client;


    // Inflation logic

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_tweets_list, container, false);
        ButterKnife.bind(this, v);
        client = TwitterApplication.getRestClient();
        //Connect adapter to listview
        rvTweets.setAdapter(aStatuses);

        swipeContainer.setColorSchemeResources(R.color.twitter_blue);




        return v;
    }

    public void addOnScrollListener(EndlessRecyclerViewScrollListener listener) {
        rvTweets.addOnScrollListener(listener);
    }

    public void setOnRefreshListener(SwipeRefreshLayout.OnRefreshListener listener) {
        swipeContainer.setOnRefreshListener(listener);
    }


    //Creation lifecycle


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Create arraylist datasource
        statuses = new ArrayList<>();
        //Construct the adapter
        aStatuses = new StatusesArrayAdapter(statuses, getContext());


    }






//    public String loadJSONFromAsset() {
//        String json = null;
//        try {
//
//            InputStream is = getAssets().open("jsonplaceholder.json");
//
//            int size = is.available();
//
//            byte[] buffer = new byte[size];
//
//            is.read(buffer);
//
//            is.close();
//
//            json = new String(buffer, "UTF-8");
//
//
//        } catch (IOException ex) {
//            ex.printStackTrace();
//            return null;
//        }
//        return json;
//
//    }

    public void insertNewStatus(Status status) {
        statuses.add(0, status);
        aStatuses.notifyItemInserted(0);
        rvTweets.scrollToPosition(0);
    }

    public void clearStatuses() {
        statuses.clear();
    }

    public void addAll(List<Status> statuses, boolean newTimeline) {
        int curSize = statuses.size();
        //Add them to the adapter
        this.statuses.addAll(statuses);
        if (newTimeline == false) {
            aStatuses.notifyItemRangeInserted(curSize, statuses.size() - 1);
        } else {
            aStatuses.notifyDataSetChanged();
        }

        maxId = statuses.get(statuses.size() - 1).getId() - 1;
    }
}
