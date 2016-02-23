package com.codepath.apps.mysimpletweets.activities;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.codepath.apps.mysimpletweets.R;
import com.codepath.apps.mysimpletweets.fragments.QueryTimeLineFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SearchResultsActivity extends AppCompatActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();

        actionBar.setLogo(R.drawable.space_between_icon);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
//        actionBar.setDefaultDisplayHomeAsUpEnabled(false);
//        actionBar.setHomeAsUpIndicator(actionBar.DISPLAY_HOME_AS_UP);
        actionBar.setDisplayHomeAsUpEnabled(true);

        actionBar.setDisplayShowTitleEnabled(false);


        String query = getIntent().getStringExtra("query");


        android.support.v4.app.FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

        //Create user timeline fragment

        QueryTimeLineFragment queryTimeLineFragment = QueryTimeLineFragment.newInstance(query);
        //Display user fragment (dynamically)

        ft.replace(R.id.flContainer, queryTimeLineFragment);
        ft.commit();
    }
}
