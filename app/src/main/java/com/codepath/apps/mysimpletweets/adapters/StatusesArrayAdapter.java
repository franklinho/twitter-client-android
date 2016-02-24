package com.codepath.apps.mysimpletweets.adapters;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.codepath.apps.mysimpletweets.R;
import com.codepath.apps.mysimpletweets.TwitterApplication;
import com.codepath.apps.mysimpletweets.activities.ImageStatusDetailActivity;
import com.codepath.apps.mysimpletweets.activities.ProfileActivity;
import com.codepath.apps.mysimpletweets.activities.StatusDetailActivity;
import com.codepath.apps.mysimpletweets.activities.TimelineActivity;
import com.codepath.apps.mysimpletweets.activities.VideoStatusDetailActivity;
import com.codepath.apps.mysimpletweets.fragments.ComposeDialog;
import com.codepath.apps.mysimpletweets.models.DynamicHeightImageView;
import com.codepath.apps.mysimpletweets.models.DynamicHeightVideoView;
import com.codepath.apps.mysimpletweets.models.statuses.Entities;
import com.codepath.apps.mysimpletweets.models.LinkifiedTextView;
import com.codepath.apps.mysimpletweets.models.statuses.Medium_;
import com.codepath.apps.mysimpletweets.models.statuses.Status;
import com.codepath.apps.mysimpletweets.models.statuses.Thumb_;
import com.codepath.apps.mysimpletweets.models.statuses.Variant;
import com.codepath.apps.mysimpletweets.models.statuses.VideoInfo;
import com.codepath.apps.mysimpletweets.networking.TwitterClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by franklinho on 2/16/16.
 */
public class StatusesArrayAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Status> mStatuses;
    private Context context;
    private TwitterClient client;
    private final int NORMAL = 0, IMAGE = 1, VIDEO = 2;



    public StatusesArrayAdapter(List<Status> statuses, Context context) {
        mStatuses = statuses;
        this.context = context;
    }

    public static class StatusViewHolder extends  RecyclerView.ViewHolder implements View.OnClickListener {

        public Status status;
        @Bind(R.id.tvName) TextView tvName;
        @Bind(R.id.tvRelativeTimeStamp) TextView tvRelativeTimeStamp;
        @Bind(R.id.tvBody)
        LinkifiedTextView tvBody;
        @Bind(R.id.tvScreenName) TextView tvScreenName;
        @Bind(R.id.ivProfileImage) ImageView ivProfileImage;
        @Bind(R.id.tvRetweetCount) TextView tvRetweetCount;
        @Bind(R.id.ibtnFavorite) ImageButton ibtnFavorite;
        @Bind(R.id.ibtnRetweet) ImageButton ibtnRetweet;
        @Bind(R.id.ibtnReply) ImageButton ibtnReply;

        private Context context;


        public StatusViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            context=itemView.getContext();
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getLayoutPosition();
            Intent i = new Intent(context, StatusDetailActivity.class);
            i.putExtra("status", status );
            context.startActivity(i);
        }
    }

    public static class ImageStatusViewHolder extends  RecyclerView.ViewHolder implements View.OnClickListener {

        public Status status;
        @Bind(R.id.tvName) TextView tvName;
        @Bind(R.id.tvRelativeTimeStamp) TextView tvRelativeTimeStamp;
        @Bind(R.id.tvBody)
        LinkifiedTextView tvBody;
        @Bind(R.id.tvScreenName) TextView tvScreenName;
        @Bind(R.id.ivProfileImage) ImageView ivProfileImage;
        @Bind(R.id.tvRetweetCount) TextView tvRetweetCount;
        @Bind(R.id.ibtnFavorite) ImageButton ibtnFavorite;
        @Bind(R.id.ibtnRetweet) ImageButton ibtnRetweet;
        @Bind(R.id.ibtnReply) ImageButton ibtnReply;
        @Bind(R.id.ivStatusImage) DynamicHeightImageView ivStatusImage;



        private Context context;


        public ImageStatusViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            context=itemView.getContext();
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getLayoutPosition();
            Intent i = new Intent(context, ImageStatusDetailActivity.class);
            i.putExtra("status", status );
            context.startActivity(i);
        }
    }

    public static class VideoStatusViewHolder extends  RecyclerView.ViewHolder implements View.OnClickListener {

        public Status status;
        @Bind(R.id.tvName) TextView tvName;
        @Bind(R.id.tvRelativeTimeStamp) TextView tvRelativeTimeStamp;
        @Bind(R.id.tvBody)
        LinkifiedTextView tvBody;
        @Bind(R.id.tvScreenName) TextView tvScreenName;
        @Bind(R.id.ivProfileImage) ImageView ivProfileImage;
        @Bind(R.id.tvRetweetCount) TextView tvRetweetCount;
        @Bind(R.id.ibtnFavorite) ImageButton ibtnFavorite;
        @Bind(R.id.ibtnRetweet) ImageButton ibtnRetweet;
        @Bind(R.id.ibtnReply) ImageButton ibtnReply;
        @Bind(R.id.vvStatusVideo) DynamicHeightVideoView vvStatusVideo;



        private Context context;


        public VideoStatusViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            context=itemView.getContext();
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getLayoutPosition();
            Intent i = new Intent(context, VideoStatusDetailActivity.class);
            i.putExtra("status", status );
            context.startActivity(i);
        }
    }

    @Override
    public int getItemViewType(int position) {
        Entities extendedEntities = mStatuses.get(position).getExtendedEntities();
        if (extendedEntities != null && extendedEntities.getMedia().get(0).getVideoInfo() != null) {
            return VIDEO;
        }
         else if (extendedEntities != null && mStatuses.get(position).getEntities().getMedia().size() > 0 && mStatuses.get(position).getEntities().getMedia().get(0).getType().equals("photo")) {
            return IMAGE;
        } else {
            return NORMAL;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        RecyclerView.ViewHolder viewHolder;

        switch (viewType) {
            case VIDEO:
                View videoView = inflater.inflate(R.layout.item_video_status, parent, false);
                viewHolder = new VideoStatusViewHolder(videoView);
                break;
            case IMAGE:
                View imageView = inflater.inflate(R.layout.item_image_status, parent, false);
                viewHolder = new ImageStatusViewHolder(imageView);
                break;
            default:
                View statusView = inflater.inflate(R.layout.item_status, parent, false);
                viewHolder = new StatusViewHolder(statusView);
                break;
        }

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (holder.getItemViewType()) {
            case VIDEO:
                VideoStatusViewHolder videoViewHolder = (VideoStatusViewHolder) holder;
                configureVideoStatusViewHolder(videoViewHolder, position);
                break;
            case IMAGE:
                ImageStatusViewHolder imageViewHolder = (ImageStatusViewHolder) holder;
                configureImageStatusViewHolder(imageViewHolder, position);
                break;
            default:
                StatusViewHolder statusViewHolder = (StatusViewHolder) holder;
                configureStatusViewHolder(statusViewHolder,position);
                break;
        }



    }

    @Override
    public int getItemCount() {
        return mStatuses.size();
    }


    public void clear() {
        mStatuses.clear();
        notifyDataSetChanged();
    }

    public void addAll(List<Status> statuses) {
        mStatuses.addAll(statuses);
        notifyDataSetChanged();
    }

    private void configureStatusViewHolder(StatusViewHolder holder, int position) {
        final Status status = mStatuses.get(position);
        holder.status = status;

        ImageView ivProfileImage = holder.ivProfileImage;
        TextView tvName = holder.tvName;
        LinkifiedTextView tvBody = holder.tvBody;
        TextView tvRelativeTimeStamp = holder.tvRelativeTimeStamp;
        TextView tvScreenName = holder.tvScreenName;
        final TextView tvRetweetCount = holder.tvRetweetCount;
        final ImageButton ibtnFavorite = holder.ibtnFavorite;
        final ImageButton ibtnRetweet = holder.ibtnRetweet;
        ImageButton ibtnReply = holder.ibtnReply;


        tvBody.setMaxLines(Integer.MAX_VALUE);

        tvName.setText(status.getUser().getName());
        tvBody.setText(status.getText());
        tvRelativeTimeStamp.setText(status.getRelativeTimeAgo());
        tvScreenName.setText("@" + status.getUser().getScreenName());

        ivProfileImage.setImageResource(android.R.color.transparent); // Clear imageview
//            Picasso.with(holder.context).load(status.getUser().getProfileImageUrl()).into(ivProfileImage);
        Glide.with(holder.context).load(status.getUser().getProfileImageUrl()).into(ivProfileImage);

        if (status.getRetweetCount() != null) {
            tvRetweetCount.setText(Integer.toString(status.getRetweetCount()));
        }
        if (status.getFavorited() == true) {
            ibtnFavorite.setImageResource(R.drawable.heart_icon_red);
        } else {
            ibtnFavorite.setImageResource(R.drawable.heart_icon);
        }

        if (status.getRetweeted() == true) {
            ibtnRetweet.setImageResource(R.drawable.retweet_icon_green);
        } else {
            ibtnRetweet.setImageResource(R.drawable.retweet_icon);
        }

        final Animation animScale = AnimationUtils.loadAnimation(context, R.anim.anim_scale);
        ibtnReply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                v.startAnimation(animScale);
                android.support.v4.app.FragmentManager fm = ((TimelineActivity) context).getSupportFragmentManager();
                ComposeDialog composeDialog = ComposeDialog.newInstance();
                Bundle bundle = new Bundle();
                bundle.putParcelable("status", status);
                composeDialog.setArguments(bundle);
                composeDialog.show(fm, "fragment_compose");
            }
        });

        ibtnRetweet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                client = TwitterApplication.getRestClient();
                if (status.getRetweeted()) {
                    client.postUnRetweet(status.getId(), new JsonHttpResponseHandler());
                    status.setRetweeted(false);
                    status.setRetweetCount(status.getRetweetCount() - 1);
                    tvRetweetCount.setText(Integer.toString(status.getRetweetCount()));
                    ibtnRetweet.setImageResource(R.drawable.retweet_icon);
                    v.startAnimation(animScale);
                } else {
                    client.postRetweet(status.getId(), new JsonHttpResponseHandler());
                    status.setRetweeted(true);
                    status.setRetweetCount(status.getRetweetCount() + 1);
                    tvRetweetCount.setText(Integer.toString(status.getRetweetCount()));
                    ibtnRetweet.setImageResource(R.drawable.retweet_icon_green);
                    v.startAnimation(animScale);
                }

            }
        });

        ibtnFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                client = TwitterApplication.getRestClient();
                if (status.getFavorited()) {
                    client.postUnlike(status.getId(), new JsonHttpResponseHandler());
                    status.setFavorited(false);
                    ibtnFavorite.setImageResource(R.drawable.heart_icon);
                    v.startAnimation(animScale);
                } else {
                    client.postLike(status.getId(), new JsonHttpResponseHandler());
                    status.setFavorited(true);
                    ibtnFavorite.setImageResource(R.drawable.heart_icon_red);
                    v.startAnimation(animScale);
                }

            }
        });

        ivProfileImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, ProfileActivity.class);
                i.putExtra("user", status.getUser());
                context.startActivity(i);
            }
        });

    }



    private void configureImageStatusViewHolder(ImageStatusViewHolder holder, int position) {
        final Status status = mStatuses.get(position);
        holder.status = status;

        ImageView ivProfileImage = holder.ivProfileImage;
        TextView tvName = holder.tvName;
        LinkifiedTextView tvBody = holder.tvBody;
        TextView tvRelativeTimeStamp = holder.tvRelativeTimeStamp;
        TextView tvScreenName = holder.tvScreenName;
        final TextView tvRetweetCount = holder.tvRetweetCount;
        final ImageButton ibtnFavorite = holder.ibtnFavorite;
        final ImageButton ibtnRetweet = holder.ibtnRetweet;
        ImageButton ibtnReply = holder.ibtnReply;
        DynamicHeightImageView ivStatusImage = holder.ivStatusImage;


        tvBody.setMaxLines(Integer.MAX_VALUE);


        tvName.setText(status.getUser().getName());
        tvBody.setText(status.getText());
        tvRelativeTimeStamp.setText(status.getRelativeTimeAgo());
        tvScreenName.setText("@"+status.getUser().getScreenName());

        ivProfileImage.setImageResource(android.R.color.transparent); // Clear imageview
//            Picasso.with(holder.context).load(status.getUser().getProfileImageUrl()).into(ivProfileImage);
        Glide.with(holder.context).load(status.getUser().getProfileImageUrl()).into(ivProfileImage);

        tvRetweetCount.setText(Integer.toString(status.getRetweetCount()));
        if (status.getFavorited() == true) {
            ibtnFavorite.setImageResource(R.drawable.heart_icon_red);
        } else {
            ibtnFavorite.setImageResource(R.drawable.heart_icon);
        }

        if (status.getRetweeted() == true) {
            ibtnRetweet.setImageResource(R.drawable.retweet_icon_green);
        } else {
            ibtnRetweet.setImageResource(R.drawable.retweet_icon);
        }

        ivStatusImage.setImageResource(android.R.color.transparent);
//        Medium_ media = status.getEntities().getMedia().get(0);
//        Medium__ imageMediumSize = media.getSizes().getMedium();
//        ivStatusImage.setHeightRatio((double) imageMediumSize.getH() / imageMediumSize.getW() );
//        Glide.with(holder.context).load(media.getMediaUrl()).fitCenter().into(ivStatusImage);


        Medium_ media = status.getEntities().getMedia().get(0);
        Thumb_ imageThumbSize = media.getSizes().getThumb();
//        ivStatusImage.setHeightRatio((double) imageThumbSize.getH() / imageThumbSize.getW() );
        ivStatusImage.setHeightRatio((double) 260 / 510 );
        Glide.with(holder.context).load(media.getMediaUrl()).centerCrop().into(ivStatusImage);


        ibtnReply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                android.support.v4.app.FragmentManager fm = ((TimelineActivity) context).getSupportFragmentManager();
                ComposeDialog composeDialog = ComposeDialog.newInstance();
                Bundle bundle = new Bundle();
                bundle.putParcelable("status", status);
                composeDialog.setArguments(bundle);
                composeDialog.show(fm, "fragment_compose");
            }
        });

        ibtnRetweet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                client = TwitterApplication.getRestClient();
                if (status.getRetweeted()) {
                    client.postUnRetweet(status.getId(), new JsonHttpResponseHandler());
                    status.setRetweeted(false);
                    status.setRetweetCount(status.getRetweetCount() - 1);
                    tvRetweetCount.setText(Integer.toString(status.getRetweetCount()));
                    ibtnRetweet.setImageResource(R.drawable.retweet_icon);
                } else {
                    client.postRetweet(status.getId(), new JsonHttpResponseHandler());
                    status.setRetweeted(true);
                    status.setRetweetCount(status.getRetweetCount() + 1);
                    tvRetweetCount.setText(Integer.toString(status.getRetweetCount()));
                    ibtnRetweet.setImageResource(R.drawable.retweet_icon_green);
                }

            }
        });

        ibtnFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                client = TwitterApplication.getRestClient();
                if (status.getFavorited()) {
                    client.postUnlike(status.getId(), new JsonHttpResponseHandler());
                    status.setFavorited(false);
                    ibtnFavorite.setImageResource(R.drawable.heart_icon);
                } else {
                    client.postLike(status.getId(), new JsonHttpResponseHandler());
                    status.setFavorited(true);
                    ibtnFavorite.setImageResource(R.drawable.heart_icon_red);
                }

            }
        });
        ivProfileImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, ProfileActivity.class);
                i.putExtra("user", status.getUser());
                context.startActivity(i);
            }
        });

    }



    private void configureVideoStatusViewHolder(VideoStatusViewHolder holder, int position) {
        final Status status = mStatuses.get(position);
        holder.status = status;

        ImageView ivProfileImage = holder.ivProfileImage;
        TextView tvName = holder.tvName;
        LinkifiedTextView tvBody = holder.tvBody;
        TextView tvRelativeTimeStamp = holder.tvRelativeTimeStamp;
        TextView tvScreenName = holder.tvScreenName;
        final TextView tvRetweetCount = holder.tvRetweetCount;
        final ImageButton ibtnFavorite = holder.ibtnFavorite;
        final ImageButton ibtnRetweet = holder.ibtnRetweet;
        ImageButton ibtnReply = holder.ibtnReply;
        final DynamicHeightVideoView vvStatusVideo = holder.vvStatusVideo;


        tvBody.setMaxLines(Integer.MAX_VALUE);


        tvName.setText(status.getUser().getName());
        tvBody.setText(status.getText());
        tvRelativeTimeStamp.setText(status.getRelativeTimeAgo());
        tvScreenName.setText("@"+status.getUser().getScreenName());

        ivProfileImage.setImageResource(android.R.color.transparent); // Clear imageview
//            Picasso.with(holder.context).load(status.getUser().getProfileImageUrl()).into(ivProfileImage);
        Glide.with(holder.context).load(status.getUser().getProfileImageUrl()).into(ivProfileImage);

        tvRetweetCount.setText(Integer.toString(status.getRetweetCount()));
        if (status.getFavorited() == true) {
            ibtnFavorite.setImageResource(R.drawable.heart_icon_red);
        } else {
            ibtnFavorite.setImageResource(R.drawable.heart_icon);
        }

        if (status.getRetweeted() == true) {
            ibtnRetweet.setImageResource(R.drawable.retweet_icon_green);
        } else {
            ibtnRetweet.setImageResource(R.drawable.retweet_icon);
        }

//        ivStatusImage.setImageResource(android.R.color.transparent);
//        Medium_ media = status.getEntities().getMedia().get(0);
//        Medium__ imageMediumSize = media.getSizes().getMedium();
//        ivStatusImage.setHeightRatio((double) imageMediumSize.getH() / imageMediumSize.getW() );
//        Glide.with(holder.context).load(media.getMediaUrl()).fitCenter().into(ivStatusImage);


//        Medium_ media = status.getEntities().getMedia().get(0);
//        Thumb_ imageThumbSize = media.getSizes().getThumb();
//        ivStatusImage.setHeightRatio((double) imageThumbSize.getH() / imageThumbSize.getW() );
//        ivStatusImage.setHeightRatio((double) 260 / 510 );
//        Glide.with(holder.context).load(media.getMediaUrl()).centerCrop().into(ivStatusImage);

        Entities extendedEntities = status.getExtendedEntities();
        VideoInfo videoInfo = extendedEntities.getMedia().get(0).getVideoInfo();
        if (videoInfo != null) {
            vvStatusVideo.setVisibility(View.VISIBLE);
            Variant videoVariant = videoInfo.getVariants().get(0);
            vvStatusVideo.setHeightRatio((double) videoInfo.getAspectRatio().get(1) / videoInfo.getAspectRatio().get(0));


            vvStatusVideo.setVideoPath(videoVariant.getUrl());
            MediaController mediaController = new MediaController(holder.context);
            mediaController.setAnchorView(holder.vvStatusVideo);
//            vvStatusVideo.setMediaController(mediaController);
//            vvStatusVideo.requestFocus();
            vvStatusVideo.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mp.setLooping(true);
                    vvStatusVideo.start();

                }
            });

            vvStatusVideo.setOnErrorListener(new MediaPlayer.OnErrorListener() {
                @Override
                public boolean onError(MediaPlayer mp, int what, int extra) {
                    vvStatusVideo.setVisibility(View.GONE);
                    return true;
                }
            });

        }


        ibtnReply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                android.support.v4.app.FragmentManager fm = ((TimelineActivity) context).getSupportFragmentManager();
                ComposeDialog composeDialog = ComposeDialog.newInstance();
                Bundle bundle = new Bundle();
                bundle.putParcelable("status", status);
                composeDialog.setArguments(bundle);
                composeDialog.show(fm, "fragment_compose");
            }
        });

        ibtnRetweet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                client = TwitterApplication.getRestClient();
                if (status.getRetweeted()) {
                    client.postUnRetweet(status.getId(), new JsonHttpResponseHandler());
                    status.setRetweeted(false);
                    status.setRetweetCount(status.getRetweetCount() - 1);
                    tvRetweetCount.setText(Integer.toString(status.getRetweetCount()));
                    ibtnRetweet.setImageResource(R.drawable.retweet_icon);
                } else {
                    client.postRetweet(status.getId(), new JsonHttpResponseHandler());
                    status.setRetweeted(true);
                    status.setRetweetCount(status.getRetweetCount() + 1);
                    tvRetweetCount.setText(Integer.toString(status.getRetweetCount()));
                    ibtnRetweet.setImageResource(R.drawable.retweet_icon_green);
                }

            }
        });

        ibtnFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                client = TwitterApplication.getRestClient();
                if (status.getFavorited()) {
                    client.postUnlike(status.getId(), new JsonHttpResponseHandler());
                    status.setFavorited(false);
                    ibtnFavorite.setImageResource(R.drawable.heart_icon);
                } else {
                    client.postLike(status.getId(), new JsonHttpResponseHandler());
                    status.setFavorited(true);
                    ibtnFavorite.setImageResource(R.drawable.heart_icon_red);
                }

            }
        });
        ivProfileImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, ProfileActivity.class);
                i.putExtra("user", status.getUser());
                context.startActivity(i);
            }
        });

    }

}
