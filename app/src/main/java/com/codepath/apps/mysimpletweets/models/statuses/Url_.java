
package com.codepath.apps.mysimpletweets.models.statuses;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")

public class Url_ implements Parcelable {

//    @SerializedName("expanded_url")
//    @Expose
//    private Object expandedUrl;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("indices")
    @Expose
    private List<Integer> indices = new ArrayList<Integer>();
//    @SerializedName("display_url")
//    @Expose
//    private Object displayUrl;

    /**
     * 
     * @return
     *     The expandedUrl
     */
//    public Object getExpandedUrl() {
//        return expandedUrl;
//    }

    /**
     * 
     * @param expandedUrl
     *     The expanded_url
     */
//    public void setExpandedUrl(Object expandedUrl) {
//        this.expandedUrl = expandedUrl;
//    }

    /**
     * 
     * @return
     *     The url
     */
    public String getUrl() {
        return url;
    }

    /**
     * 
     * @param url
     *     The url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 
     * @return
     *     The indices
     */
    public List<Integer> getIndices() {
        return indices;
    }

    /**
     * 
     * @param indices
     *     The indices
     */
    public void setIndices(List<Integer> indices) {
        this.indices = indices;
    }

    /**
     * 
     * @return
     *     The displayUrl
     */
//    public Object getDisplayUrl() {
//        return displayUrl;
//    }

    /**
     * 
     * @param displayUrl
     *     The display_url
     */
//    public void setDisplayUrl(Object displayUrl) {
//        this.displayUrl = displayUrl;
//    }

    public Url_() {
        super();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.url);
        dest.writeList(this.indices);
    }

    protected Url_(Parcel in) {
        this.url = in.readString();
        this.indices = new ArrayList<Integer>();
        in.readList(this.indices, List.class.getClassLoader());
    }

    public static final Parcelable.Creator<Url_> CREATOR = new Parcelable.Creator<Url_>() {
        public Url_ createFromParcel(Parcel source) {
            return new Url_(source);
        }

        public Url_[] newArray(int size) {
            return new Url_[size];
        }
    };
}
