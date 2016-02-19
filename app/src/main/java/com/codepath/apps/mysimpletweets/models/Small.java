
package com.codepath.apps.mysimpletweets.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Small implements Parcelable {

    @SerializedName("h")
    @Expose
    private Integer h;
    @SerializedName("resize")
    @Expose
    private String resize;
    @SerializedName("w")
    @Expose
    private Integer w;

    /**
     * 
     * @return
     *     The h
     */
    public Integer getH() {
        return h;
    }

    /**
     * 
     * @param h
     *     The h
     */
    public void setH(Integer h) {
        this.h = h;
    }

    /**
     * 
     * @return
     *     The resize
     */
    public String getResize() {
        return resize;
    }

    /**
     * 
     * @param resize
     *     The resize
     */
    public void setResize(String resize) {
        this.resize = resize;
    }

    /**
     * 
     * @return
     *     The w
     */
    public Integer getW() {
        return w;
    }

    /**
     * 
     * @param w
     *     The w
     */
    public void setW(Integer w) {
        this.w = w;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.h);
        dest.writeString(this.resize);
        dest.writeValue(this.w);
    }

    public Small() {
    }

    protected Small(Parcel in) {
        this.h = (Integer) in.readValue(Integer.class.getClassLoader());
        this.resize = in.readString();
        this.w = (Integer) in.readValue(Integer.class.getClassLoader());
    }

    public static final Parcelable.Creator<Small> CREATOR = new Parcelable.Creator<Small>() {
        public Small createFromParcel(Parcel source) {
            return new Small(source);
        }

        public Small[] newArray(int size) {
            return new Small[size];
        }
    };
}
