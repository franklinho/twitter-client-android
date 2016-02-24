
package com.codepath.apps.mysimpletweets.models.statuses;

import android.os.Parcel;
import android.os.Parcelable;

import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
@Table(name="Medium__", id="_id")
public class Medium__ implements Parcelable {

    @Column(name = "w", unique = false)
    @SerializedName("w")
    @Expose
    private Integer w;
    @Column(name = "h", unique = false)
    @SerializedName("h")
    @Expose
    private Integer h;
    @Column(name = "resize", unique = false)
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

    public Medium__() {
    }

    protected Medium__(Parcel in) {
        this.w = (Integer) in.readValue(Integer.class.getClassLoader());
        this.h = (Integer) in.readValue(Integer.class.getClassLoader());
        this.resize = in.readString();
    }

    public static final Parcelable.Creator<Medium__> CREATOR = new Parcelable.Creator<Medium__>() {
        public Medium__ createFromParcel(Parcel source) {
            return new Medium__(source);
        }

        public Medium__[] newArray(int size) {
            return new Medium__[size];
        }
    };
}
