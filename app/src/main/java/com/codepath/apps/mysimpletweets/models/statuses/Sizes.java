
package com.codepath.apps.mysimpletweets.models.statuses;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Sizes implements Parcelable {

    @SerializedName("large")
    @Expose
    private Large large;
    @SerializedName("medium")
    @Expose
    private Medium medium;
    @SerializedName("small")
    @Expose
    private Small small;
    @SerializedName("thumb")
    @Expose
    private Thumb thumb;

    /**
     * 
     * @return
     *     The large
     */
    public Large getLarge() {
        return large;
    }

    /**
     * 
     * @param large
     *     The large
     */
    public void setLarge(Large large) {
        this.large = large;
    }

    /**
     * 
     * @return
     *     The medium
     */
    public Medium getMedium() {
        return medium;
    }

    /**
     * 
     * @param medium
     *     The medium
     */
    public void setMedium(Medium medium) {
        this.medium = medium;
    }

    /**
     * 
     * @return
     *     The small
     */
    public Small getSmall() {
        return small;
    }

    /**
     * 
     * @param small
     *     The small
     */
    public void setSmall(Small small) {
        this.small = small;
    }

    /**
     * 
     * @return
     *     The thumb
     */
    public Thumb getThumb() {
        return thumb;
    }

    /**
     * 
     * @param thumb
     *     The thumb
     */
    public void setThumb(Thumb thumb) {
        this.thumb = thumb;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.large, 0);
        dest.writeParcelable(this.medium, 0);
        dest.writeParcelable(this.small, flags);
        dest.writeParcelable(this.thumb, flags);
    }

    public Sizes() {
    }

    protected Sizes(Parcel in) {
        this.large = in.readParcelable(Large.class.getClassLoader());
        this.medium = in.readParcelable(Medium.class.getClassLoader());
        this.small = in.readParcelable(Small.class.getClassLoader());
        this.thumb = in.readParcelable(Thumb.class.getClassLoader());
    }

    public static final Parcelable.Creator<Sizes> CREATOR = new Parcelable.Creator<Sizes>() {
        public Sizes createFromParcel(Parcel source) {
            return new Sizes(source);
        }

        public Sizes[] newArray(int size) {
            return new Sizes[size];
        }
    };
}
