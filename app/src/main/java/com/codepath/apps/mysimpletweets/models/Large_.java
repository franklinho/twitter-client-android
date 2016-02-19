
package com.codepath.apps.mysimpletweets.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Large_ implements Parcelable {

    @SerializedName("w")
    @Expose
    private Integer w;
    @SerializedName("h")
    @Expose
    private Integer h;
    @SerializedName("resize")
    @Expose
    private String resize;

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.w);
        dest.writeValue(this.h);
        dest.writeString(this.resize);
    }

    public Large_() {
    }

    protected Large_(Parcel in) {
        this.w = (Integer) in.readValue(Integer.class.getClassLoader());
        this.h = (Integer) in.readValue(Integer.class.getClassLoader());
        this.resize = in.readString();
    }

    public static final Parcelable.Creator<Large_> CREATOR = new Parcelable.Creator<Large_>() {
        public Large_ createFromParcel(Parcel source) {
            return new Large_(source);
        }

        public Large_[] newArray(int size) {
            return new Large_[size];
        }
    };
}
