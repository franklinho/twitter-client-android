
package com.codepath.apps.mysimpletweets.models;

import android.os.Parcel;
import android.os.Parcelable;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")

public class Entities implements Parcelable {

//    @SerializedName("urls")
//    @Expose
//    private List<Object> urls = new ArrayList<Object>();
//    @SerializedName("hashtags")
//    @Expose
//    private List<Object> hashtags = new ArrayList<Object>();
//    @SerializedName("user_mentions")
//    @Expose
//    private List<Object> userMentions = new ArrayList<Object>();

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

    public Entities() {
        super();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
//        dest.writeList(this.urls);
//        dest.writeList(this.hashtags);
//        dest.writeList(this.userMentions);
    }

    protected Entities(Parcel in) {
//        this.urls = new ArrayList<Object>();
//        in.readList(this.urls, List.class.getClassLoader());
//        this.hashtags = new ArrayList<Object>();
//        in.readList(this.hashtags, List.class.getClassLoader());
//        this.userMentions = new ArrayList<Object>();
//        in.readList(this.userMentions, List.class.getClassLoader());
    }

    public static final Creator<Entities> CREATOR = new Creator<Entities>() {
        public Entities createFromParcel(Parcel source) {
            return new Entities(source);
        }

        public Entities[] newArray(int size) {
            return new Entities[size];
        }
    };
}
