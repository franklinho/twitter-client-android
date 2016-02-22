package com.codepath.apps.mysimpletweets.activities;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.codepath.apps.mysimpletweets.R;
import com.codepath.apps.mysimpletweets.TwitterApplication;
import com.codepath.apps.mysimpletweets.fragments.ComposeDialog;
import com.codepath.apps.mysimpletweets.models.DynamicHeightVideoView;
import com.codepath.apps.mysimpletweets.models.Entities;
import com.codepath.apps.mysimpletweets.models.Status;
import com.codepath.apps.mysimpletweets.models.Variant;
import com.codepath.apps.mysimpletweets.models.VideoInfo;
import com.codepath.apps.mysimpletweets.networking.TwitterClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import butterknife.Bind;
import butterknife.ButterKnife;

public class VideoStatusDetailActivity extends AppCompatActivity implements ComposeDialog.InsertNewStatus {
    Status status;
    @Bind(R.id.ivProfileImage) ImageView ivProfileImage;
    @Bind(R.id.tvName) TextView tvName;
    @Bind(R.id.tvScreenName) TextView tvScreenName;
    @Bind(R.id.tvBody) TextView tvBody;
    @Bind(R.id.tvRetweetCount) TextView tvRetweetCount;
    @Bind(R.id.tvTimestamp) TextView tvTimestamp;
    @Bind(R.id.ibtnReply) ImageButton ibtnReply;
    @Bind(R.id.ibtnRetweet) ImageButton ibtnRetweet;
    @Bind(R.id.ibtnFavorite) ImageButton ibtnFavorite;
    @Bind(R.id.vvStatusVideo)
    DynamicHeightVideoView vvStatusVideo;
    private TwitterClient client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_status_detail);
        ButterKnife.bind(this);

        client = TwitterApplication.getRestClient();
        status = getIntent().getParcelableExtra("status");
        tvBody.setMaxLines(Integer.MAX_VALUE);

        if (status != null) {
            tvName.setText(status.getUser().getName());
            tvScreenName.setText(status.getUser().getScreenName());
            Glide.with(this).load(status.getUser().getProfileImageUrl()).into(ivProfileImage);
            tvRetweetCount.setText(status.getRetweetCount().toString());
            tvBody.setText(status.getText());
            tvTimestamp.setText(status.getFormattedTimeStamp());

            Entities extendedEntities = status.getExtendedEntities();
            VideoInfo videoInfo = extendedEntities.getMedia().get(0).getVideoInfo();
            if (videoInfo != null) {
                Variant videoVariant = videoInfo.getVariants().get(0);
                vvStatusVideo.setHeightRatio((double) videoInfo.getAspectRatio().get(1) / videoInfo.getAspectRatio().get(0));


                vvStatusVideo.setVideoPath(videoVariant.getUrl());
                MediaController mediaController = new MediaController(this);
                mediaController.setAnchorView(vvStatusVideo);
            vvStatusVideo.setMediaController(mediaController);
            vvStatusVideo.requestFocus();
                vvStatusVideo.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mp) {
                        vvStatusVideo.start();
                    }
                });

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

            ibtnReply.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    android.support.v4.app.FragmentManager fm = getSupportFragmentManager();
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

        }
    }

    @Override
    public void insertNewStatus(Status status) {

    }
}