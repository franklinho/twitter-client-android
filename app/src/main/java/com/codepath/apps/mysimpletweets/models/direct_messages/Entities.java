
package com.codepath.apps.mysimpletweets.models.direct_messages;

import android.os.Parcel;
import android.os.Parcelable;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Entities implements Parcelable {

//    @SerializedName("hashtags")
//    @Expose
//    private List<Object> hashtags = new ArrayList<Object>();
//    @SerializedName("urls")
//    @Expose
//    private List<Object> urls = new ArrayList<Object>();
//    @SerializedName("user_mentions")
//    @Expose
//    private List<Object> userMentions = new ArrayList<Object>();

    /**
     * 
     * @return
     *     The hashtags
     */
//    public List<Object> getHashtags() {
//        return hashtags;
//    }

    /**
     * 
     * @param hashtags
     *     The hashtags
     */
//    public void setHashtags(List<Object> hashtags) {
//        this.hashtags = hashtags;
//    }

    /**
     * 
     * @return
     *     The urls
     */
//    public List<Object> getUrls() {
//        return urls;
//    }

    /**
     * 
     * @param urls
     *     The urls
     */
//    public void setUrls(List<Object> urls) {
//        this.urls = urls;
//    }

    /**
     * 
     * @return
     *     The userMentions
     */
//    public List<Object> getUserMentions() {
//        return userMentions;
//    }

    /**
     * 
     * @param userMentions
     *     The user_mentions
     */
//    public void setUserMentions(List<Object> userMentions) {
//        this.userMentions = userMentions;
//    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    public Entities() {
    }

    protected Entities(Parcel in) {
    }

    public static final Parcelable.Creator<Entities> CREATOR = new Parcelable.Creator<Entities>() {
        public Entities createFromParcel(Parcel source) {
            return new Entities(source);
        }

        public Entities[] newArray(int size) {
            return new Entities[size];
        }
    };
}
