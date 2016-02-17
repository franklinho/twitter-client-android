package com.codepath.apps.mysimpletweets.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.codepath.apps.mysimpletweets.R;
import com.codepath.apps.mysimpletweets.models.Status;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by franklinho on 2/16/16.
 */
public class StatusesArrayAdapter extends RecyclerView.Adapter<StatusesArrayAdapter.ViewHolder> {
    private List<Status> mStatuses;

    public StatusesArrayAdapter(List<Status> statuses) {
        mStatuses = statuses;
    }

    public static class ViewHolder extends  RecyclerView.ViewHolder {

        @Bind(R.id.tvUsername) TextView tvUsername;
        @Bind(R.id.tvRelativeTimeStamp) TextView tvRelativeTimeStamp;
        @Bind(R.id.tvBody) TextView tvBody;
        @Bind(R.id.ivProfileImage) ImageView ivProfileImage;

//        TextView tvUsername;
//        TextView tvRelativeTimeStamp;
//        TextView tvBody;
//        ImageView ivProfileImage;

        private Context context;


        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
//            tvUsername = (TextView) itemView.findViewById(R.id.tvUsername);
//            tvRelativeTimeStamp = (TextView) itemView.findViewById(R.id.tvRelativeTimeStamp);
//            tvBody = (TextView) itemView.findViewById(R.id.tvBody);
//            ivProfileImage = (ImageView) itemView.findViewById(R.id.ivProfileImage);

            context=itemView.getContext();
        }
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View statusView = inflater.inflate(R.layout.item_status, parent, false);
        ViewHolder viewHolder = new ViewHolder(statusView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        com.codepath.apps.mysimpletweets.models.Status status = mStatuses.get(position);

        ImageView ivProfileImage = holder.ivProfileImage;
        TextView tvUsername = holder.tvUsername;
        TextView tvBody = holder.tvBody;
        TextView tvRelativeTimeStamp = holder.tvRelativeTimeStamp;

//        if (tvUsername != null) {
            tvUsername.setText(status.getUser().getName());
//        }
//        if (tvBody != null) {
            tvBody.setText(status.getText());
//        }
//        if (tvRelativeTimeStamp != null) {
            tvRelativeTimeStamp.setText(status.getRelativeTimeAgo());
//        }
//        if (ivProfileImage != null) {
            ivProfileImage.setImageResource(android.R.color.transparent); // Clear imageview
            Picasso.with(holder.context).load(status.getUser().getProfileImageUrl()).into(ivProfileImage);
//        }

    }

    @Override
    public int getItemCount() {
        return mStatuses.size();
    }


}
