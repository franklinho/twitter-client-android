
package com.codepath.apps.mysimpletweets.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")

public class Url implements Parcelable {

    @SerializedName("urls")
    @Expose
    private List<Url_> urls = new ArrayList<Url_>();

    /**
     * 
     * @return
     *     The urls
     */
    public List<Url_> getUrls() {
        return urls;
    }

    /**
     * 
     * @param urls
     *     The urls
     */
    public void setUrls(List<Url_> urls) {
        this.urls = urls;
    }

    public Url() {
        super();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(urls);
    }

    protected Url(Parcel in) {
        this.urls = in.createTypedArrayList(Url_.CREATOR);
    }

    public static final Parcelable.Creator<Url> CREATOR = new Parcelable.Creator<Url>() {
        public Url createFromParcel(Parcel source) {
            return new Url(source);
        }

        public Url[] newArray(int size) {
            return new Url[size];
        }
    };
}
