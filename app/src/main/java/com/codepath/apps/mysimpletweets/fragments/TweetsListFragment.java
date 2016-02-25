package com.codepath.apps.mysimpletweets.fragments;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.codepath.apps.mysimpletweets.R;
import com.codepath.apps.mysimpletweets.TwitterApplication;
import com.codepath.apps.mysimpletweets.adapters.StatusesArrayAdapter;
import com.codepath.apps.mysimpletweets.models.statuses.Status;
import com.codepath.apps.mysimpletweets.networking.TwitterClient;

import java.io.IOException;
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

    @Bind(R.id.pbProgressAction)
    View pbProgessAction;

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

    @Bind(R.id.btnNetwork)
    Button btnNetwork;


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

        if (!isConnected()) {
            btnNetwork.setVisibility(View.VISIBLE);
        } else {
            btnNetwork.setVisibility(View.GONE);
        }




        return v;
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

    public void insertNewStatus(Status status) {
        statuses.add(0, status);
        aStatuses.notifyItemInserted(0);
        rvTweets.scrollToPosition(0);
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
                = (ConnectivityManager) getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
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
    public void onResume() {
        super.onResume();
        if (!isConnected()) {
            btnNetwork.setVisibility(View.VISIBLE);
        } else {
            btnNetwork.setVisibility(View.GONE);
        }

    }

}
