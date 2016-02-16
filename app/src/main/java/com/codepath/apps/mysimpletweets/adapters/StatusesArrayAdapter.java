package com.codepath.apps.mysimpletweets.adapters;

import android.content.Context;
import android.widget.ArrayAdapter;

import com.codepath.apps.mysimpletweets.models.Status;

import java.util.List;

/**
 * Created by franklinho on 2/16/16.
 */
public class StatusesArrayAdapter extends ArrayAdapter<Status>{
    public StatusesArrayAdapter(Context context, List<Status> statuses) {
        super(context, android.R.layout.simple_list_item_1, statuses);
    }

    // Override custom template
}
