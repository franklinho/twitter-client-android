
package com.codepath.apps.mysimpletweets.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Entities implements Parcelable {

//    @SerializedName("extended_entities")
//    @Expose
//    private Extended extended;
//    @SerializedName("hashtags")
//    @Expose
//    private List<Object> hashtags = new ArrayList<Object>();
//    @SerializedName("symbols")
//    @Expose
//    private List<Object> symbols = new ArrayList<Object>();
//    @SerializedName("urls")
//    @Expose
//    private List<Object> urls = new ArrayList<Object>();
//    @SerializedName("user_mentions")
//    @Expose
//    private List<Object> userMentions = new ArrayList<Object>();
    @SerializedName("media")
    @Expose
    private List<Medium_> media = new ArrayList<Medium_>();

    /**
     * 
     * @return
     *     The extended
     */
//    public Extended getExtended() {
//        return extended;
//    }

    /**
     * 
     * @param extended
     *     The extended
     */
//    public void setExtended(Extended extended) {
//        this.extended = extended;
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
     *     The symbols
     */
//    public List<Object> getSymbols() {
//        return symbols;
//    }

    /**
     * 
     * @param symbols
     *     The symbols
     */
//    public void setSymbols(List<Object> symbols) {
//        this.symbols = symbols;
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

    /**
     * 
     * @return
     *     The media
     */
    public List<Medium_> getMedia() {
        return media;
    }

    /**
     * 
     * @param media
     *     The media
     */
    public void setMedia(List<Medium_> media) {
        this.media = media;
    }

    public Entities() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
//        dest.writeParcelable(this.extended, 0);
        dest.writeTypedList(media);
    }

    protected Entities(Parcel in) {
//        this.extended = in.readParcelable(Extended.class.getClassLoader());
        this.media = in.createTypedArrayList(Medium_.CREATOR);
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
