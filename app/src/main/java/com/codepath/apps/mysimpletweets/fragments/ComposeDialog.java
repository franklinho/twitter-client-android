package com.codepath.apps.mysimpletweets.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.codepath.apps.mysimpletweets.R;
import com.codepath.apps.mysimpletweets.TwitterApplication;
import com.codepath.apps.mysimpletweets.models.statuses.Status;
import com.codepath.apps.mysimpletweets.models.statuses.User;
import com.codepath.apps.mysimpletweets.networking.TwitterClient;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.apache.http.Header;
import org.json.JSONObject;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by franklinho on 2/17/16.
 */
public class ComposeDialog extends android.support.v4.app.DialogFragment{
    @Bind(R.id.ibtnClose)
    ImageButton ibtnClose;
    @Bind(R.id.tvName)
    TextView tvName;
    @Bind(R.id.tvScreenName)
    TextView tvScreenName;
    @Bind(R.id.tvCharacterCount)
    TextView tvCharacterCount;
    @Bind(R.id.btnTweet)
    Button btnTweet;
    @Bind(R.id.etTweetField)
    EditText etTweetField;
    @Bind(R.id.ivProfileImage)
    ImageView ivProfileImage;
    InsertNewStatus dataPasser;
    Status replyStatus;

    @Bind(R.id.tvInReplyTo)
    TextView tvInReplyTo;

    @Bind(R.id.ivDownArrow)
    ImageView ivDownArrow;


    private TwitterClient client;

    public ComposeDialog() {

    }

    public interface  InsertNewStatus {
        public void insertNewStatus(Status status);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        dataPasser = (InsertNewStatus) activity;
    }

    public static ComposeDialog newInstance() {

        Bundle args = new Bundle();

        ComposeDialog fragment = new ComposeDialog();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_compose, container);
        ButterKnife.bind(this, view);

        replyStatus = getArguments().getParcelable("status");
        if (replyStatus != null) {
            etTweetField.setText("@" + replyStatus.getUser().getScreenName());
            etTweetField.setSelection(etTweetField.getText().length());
            ivDownArrow.setVisibility(View.VISIBLE);
            tvInReplyTo.setText("In reply to " + replyStatus.getUser().getScreenName());
            tvInReplyTo.setVisibility(View.VISIBLE);

        }

        client = TwitterApplication.getRestClient();

        User currentUser = client.getCurrentUser();
        if (currentUser != null) {
            if (currentUser.getName() != null) {
                tvName.setText(currentUser.getName());
            }
            if (currentUser.getScreenName() != null) {
                tvScreenName.setText("@"+currentUser.getScreenName());
            }
            if (currentUser.getProfileImageUrl() != null) {
//                Picasso.with(getContext()).load(currentUser.getProfileImageUrl()).into(ivProfileImage);
                Glide.with(getContext()).load(currentUser.getProfileImageUrl()).into(ivProfileImage);
            }

        }

        ibtnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        btnTweet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etTweetField.getText().length() > 0) {

                    client.postStatusUpdate(etTweetField.getText().toString(),replyStatus, new JsonHttpResponseHandler() {
                        @Override
                        public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                            Toast.makeText(getContext(), "Tweet Posted Successfully", Toast.LENGTH_SHORT).show();
                            Status status = new Status();
//                            if (client.getCurrentUser() != null) {
//                                status.setUser(client.getCurrentUser());
//                            }
//                            status.setText(etTweetField.getText().toString());
//                            String twitterFormat = "EEE MMM dd HH:mm:ss ZZZZZ yyyy";
//                            SimpleDateFormat sf = new SimpleDateFormat(twitterFormat, Locale.ENGLISH);
//                            status.setCreatedAt(sf.format(new Date()));

                            Gson gson = new GsonBuilder().create();

                            status =  gson.fromJson(response.toString(), Status.class);
                            dataPasser.insertNewStatus(status);
                            dismiss();
                        }

                        @Override
                        public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                            Toast.makeText(getContext(), "Tweet Failed To Post", Toast.LENGTH_SHORT).show();
                            Log.d("DEBUG", errorResponse.toString());

                        }
                    });
                }
            }
        });

        if (etTweetField.getText().length() == 0 ) {
            btnTweet.setEnabled(false);
        }

        etTweetField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() == 0 || s.length() > 140) {
                    btnTweet.setEnabled(false);
                } else {
                    btnTweet.setEnabled(true);
                }
                tvCharacterCount.setText(Integer.toString(140 - s.length()));

                if (s.length() > 140) {
                    tvCharacterCount.setTextColor(getResources().getColor(R.color.red));
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

//    @NonNull
//    @Override
//    public Dialog onCreateDialog(Bundle savedInstanceState) {
//        Dialog dialog = super.onCreateDialog(savedInstanceState);
//
//        //Requesting window with no title
//        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
//
//        return dialog;
//    }
}
