
package com.codepath.apps.mysimpletweets.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")

public class Entities_ implements Parcelable {

    @SerializedName("url")
    @Expose
    private Url url;
//    @SerializedName("description")
//    @Expose
//    private Object description;

    /**
     * 
     * @return
     *     The url
     */
    public Url getUrl() {
        return url;
    }

    /**
     * 
     * @param url
     *     The url
     */
    public void setUrl(Url url) {
        this.url = url;
    }

    /**
     * 
     * @return
     *     The description
     */
//    public Object getDescription() {
//        return description;
//    }

    /**
     * 
     * @param description
     *     The description
     */
//    public void setDescription(Object description) {
//        this.description = description;
//    }

    public Entities_() {
        super();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.url, 0);
//        dest.writeParcelable(this.description, flags);
    }

    protected Entities_(Parcel in) {
        this.url = in.readParcelable(Url.class.getClassLoader());
//        this.description = in.readParcelable(Object.class.getClassLoader());
    }

    public static final Parcelable.Creator<Entities_> CREATOR = new Parcelable.Creator<Entities_>() {
        public Entities_ createFromParcel(Parcel source) {
            return new Entities_(source);
        }

        public Entities_[] newArray(int size) {
            return new Entities_[size];
        }
    };
}
