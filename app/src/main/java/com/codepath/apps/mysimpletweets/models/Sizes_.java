
package com.codepath.apps.mysimpletweets.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Sizes_ implements Parcelable {

    @SerializedName("medium")
    @Expose
    private Medium__ medium;
    @SerializedName("thumb")
    @Expose
    private Thumb_ thumb;
    @SerializedName("small")
    @Expose
    private Small_ small;
    @SerializedName("large")
    @Expose
    private Large_ large;

    /**
     * 
     * @return
     *     The medium
     */
    public Medium__ getMedium() {
        return medium;
    }

    /**
     * 
     * @param medium
     *     The medium
     */
    public void setMedium(Medium__ medium) {
        this.medium = medium;
    }

    /**
     * 
     * @return
     *     The thumb
     */
    public Thumb_ getThumb() {
        return thumb;
    }

    /**
     * 
     * @param thumb
     *     The thumb
     */
    public void setThumb(Thumb_ thumb) {
        this.thumb = thumb;
    }

    /**
     * 
     * @return
     *     The small
     */
    public Small_ getSmall() {
        return small;
    }

    /**
     * 
     * @param small
     *     The small
     */
    public void setSmall(Small_ small) {
        this.small = small;
    }

    /**
     * 
     * @return
     *     The large
     */
    public Large_ getLarge() {
        return large;
    }

    /**
     * 
     * @param large
     *     The large
     */
    public void setLarge(Large_ large) {
        this.large = large;
    }

    public Sizes_() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.medium, 0);
        dest.writeParcelable(this.thumb, 0);
        dest.writeParcelable(this.small, flags);
        dest.writeParcelable(this.large, 0);
    }

    protected Sizes_(Parcel in) {
        this.medium = in.readParcelable(Medium__.class.getClassLoader());
        this.thumb = in.readParcelable(Thumb_.class.getClassLoader());
        this.small = in.readParcelable(Small_.class.getClassLoader());
        this.large = in.readParcelable(Large_.class.getClassLoader());
    }

    public static final Creator<Sizes_> CREATOR = new Creator<Sizes_>() {
        public Sizes_ createFromParcel(Parcel source) {
            return new Sizes_(source);
        }

        public Sizes_[] newArray(int size) {
            return new Sizes_[size];
        }
    };
}
