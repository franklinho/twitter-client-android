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
import com.codepath.apps.mysimpletweets.adapters.DirectMessagesArrayAdapter;
import com.codepath.apps.mysimpletweets.models.direct_messages.DirectMessage;
import com.codepath.apps.mysimpletweets.networking.TwitterClient;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;


public class DirectMessageFragment extends Fragment {
    public List<DirectMessage> getStatuses() {
        return directMessages;
    }

    public void setDirectMessages(List<DirectMessage> directMessages) {
        this.directMessages = directMessages;
    }

    List<DirectMessage> directMessages;
    LinearLayoutManager linearLayoutManager;
    @Bind(R.id.rvDirectMessages)
    RecyclerView rvDirectMessages;
    DirectMessagesArrayAdapter aDirectMessages;
    long maxId;
    long cursor;

    @Bind(R.id.swipeContainer)
    SwipeRefreshLayout swipeContainer;
    int currentRequestCount = 0;




    TwitterClient client;


    // Inflation logic

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_direct_message, container, false);
        ButterKnife.bind(this, v);
        client = TwitterApplication.getRestClient();
        //Connect adapter to listview

        rvDirectMessages.setAdapter(aDirectMessages);
        linearLayoutManager = new LinearLayoutManager(getContext());
        rvDirectMessages.setLayoutManager(linearLayoutManager);
        swipeContainer.setColorSchemeResources(R.color.twitter_blue);



        return v;
    }

    //Creation lifecycle
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        directMessages = new ArrayList<>();
        aDirectMessages = new DirectMessagesArrayAdapter(directMessages, getContext());



    }




}
