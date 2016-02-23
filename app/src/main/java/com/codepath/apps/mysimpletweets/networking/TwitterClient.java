package com.codepath.apps.mysimpletweets.networking;

import android.content.Context;
import android.util.Log;

import com.codepath.apps.mysimpletweets.models.Status;
import com.codepath.apps.mysimpletweets.models.User;
import com.codepath.oauth.OAuthBaseClient;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.apache.http.Header;
import org.json.JSONObject;
import org.scribe.builder.api.Api;
import org.scribe.builder.api.TwitterApi;

/*
 * 
 * This is the object responsible for communicating with a REST API. 
 * Specify the constants below to change the API being communicated with.
 * See a full list of supported API classes: 
 *   https://github.com/fernandezpablo85/scribe-java/tree/master/src/main/java/org/scribe/builder/api
 * Key and Secret are provided by the developer site for the given API i.e dev.twitter.com
 * Add methods for each relevant endpoint in the API.
 * 
 * NOTE: You may want to rename this object based on the service i.e TwitterClient or FlickrClient
 * 
 */
public class TwitterClient extends OAuthBaseClient {
	public static final Class<? extends Api> REST_API_CLASS = TwitterApi.class; // Change this
	public static final String REST_URL = "https://api.twitter.com/1.1"; // Change this, base API URL
	public static final String REST_CONSUMER_KEY = "sdqP7Ytz6LLZ9evZwzo486hDd";       // Change this
	public static final String REST_CONSUMER_SECRET = "JGQutpCG0MDmn1BtXGPHdzlQO6xLB8szP4n1OPik0HhzTzzlvh"; // Change this
	public static final String REST_CALLBACK_URL = "oauth://cpsimpletweets"; // Change this (here and in manifest)
    public static User currentUser;
    public static User user;

	public TwitterClient(Context context) {
		super(context, REST_API_CLASS, REST_URL, REST_CONSUMER_KEY, REST_CONSUMER_SECRET, REST_CALLBACK_URL);
	}

	// CHANGE THIS
	// DEFINE METHODS for different API endpoints here
//	public void getInterestingnessList(AsyncHttpResponseHandler handler) {
//		String apiUrl = getApiUrl("?nojsoncallback=1&method=flickr.interestingness.getList");
//		// Can specify query string params directly or through RequestParams.
//		RequestParams params = new RequestParams();
//		params.put("format", "json");
//		client.get(apiUrl, params, handler);
//	}

	//Method == Endpoint

	//HomeTimeline - Gets us a timeline


    public void getHomeTimeline(JsonHttpResponseHandler handler, long maxId ) {
        String apiUrl = getApiUrl("statuses/home_timeline.json");
        RequestParams params = new RequestParams();
        params.put("count", 25);

        if (maxId != 0L) {
            params.put("max_id", maxId);
        }
        getClient().get(apiUrl, params, handler);
    }

    //Mentions timeline
    public void getMentionsTimeline(JsonHttpResponseHandler handler, long maxId ) {
        String apiUrl = getApiUrl("statuses/mentions_timeline.json");
        RequestParams params = new RequestParams();
        params.put("count", 25);
        if (maxId != 0L) {
            params.put("max_id", maxId);
        }
        getClient().get(apiUrl, params, handler);
    }

    //UserTimeline timeline
    public void getUserTimeline(JsonHttpResponseHandler handler, long maxId , long userId) {
        String apiUrl = getApiUrl("statuses/user_timeline.json");
        RequestParams params = new RequestParams();
        params.put("count", 25);
        params.put("user_id", userId);
        if (maxId != 0L) {
            params.put("max_id", maxId);
        }
        getClient().get(apiUrl, params, handler);
    }

    public void getSearchTimeline(JsonHttpResponseHandler handler, String query ) {
        String apiUrl = getApiUrl("search/tweets.json");
        RequestParams params = new RequestParams();
        params.put("count", 25);
        params.put("q",query);
        getClient().get(apiUrl, params, handler);
    }

    // Post a status update

    public void postStatusUpdate(String text, Status status, JsonHttpResponseHandler handler) {
        String apiUrl = getApiUrl("statuses/update.json");
        RequestParams params = new RequestParams();
        params.put("status",text);
        if (status != null) {
            params.put("in_reply_to_status_id", status.getId());
        }
        getClient().post(apiUrl,params, handler);
    }

    public void postRetweet(long statusId, JsonHttpResponseHandler handler) {
        String apiUrl = getApiUrl("statuses/retweet/:id.json");
        RequestParams params = new RequestParams();
        params.put("id",statusId);
        getClient().post(apiUrl, params, handler);

    }

    public void postUnRetweet(long statusId, JsonHttpResponseHandler handler) {
        String apiUrl = getApiUrl("statuses/unretweet/:id.json");
        RequestParams params = new RequestParams();
        params.put("id",statusId);
        getClient().post(apiUrl, params, handler);

    }

    public void postLike(long statusId, JsonHttpResponseHandler handler) {
        String apiUrl = getApiUrl("favorites/create.json");
        RequestParams params = new RequestParams();
        params.put("id",statusId);
        getClient().post(apiUrl, params, handler);

    }

    public void postUnlike(long statusId, JsonHttpResponseHandler handler) {
        String apiUrl = getApiUrl("favorites/destroy.json");
        RequestParams params = new RequestParams();
        params.put("id",statusId);
        getClient().post(apiUrl, params, handler);

    }

    public User getCurrentUser() {
        if (currentUser == null) {
            String apiUrl = getApiUrl("account/verify_credentials.json");
            getClient().get(apiUrl,new JsonHttpResponseHandler(){
                @Override
                public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                    Gson gson = new GsonBuilder().create();

                    currentUser =  gson.fromJson(response.toString(), User.class);

                }

                @Override
                public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                    Log.d("DEBUG","Failed to grab user object" );
                }
            });
        }

        return currentUser;


    }

    public void getUserProfile(long userId, JsonHttpResponseHandler handler) {

        String apiUrl = getApiUrl("users/show.json");
        RequestParams params = new RequestParams();
        params.put("user_id", userId);
        getClient().get(apiUrl,params,handler);


    }

    // Compose Tweet

	/* 1. Define the endpoint URL with getApiUrl and pass a relative path to the endpoint
	 * 	  i.e getApiUrl("statuses/home_timeline.json");
	 * 2. Define the parameters to pass to the request (query or body)
	 *    i.e RequestParams params = new RequestParams("foo", "bar");
	 * 3. Define the request method and make a call to the client
	 *    i.e client.get(apiUrl, params, handler);
	 *    i.e client.post(apiUrl, params, handler);
	 */
}