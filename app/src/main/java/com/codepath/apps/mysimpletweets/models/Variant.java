
package com.codepath.apps.mysimpletweets.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Variant implements Parcelable {

    @SerializedName("bitrate")
    @Expose
    private Integer bitrate;
    @SerializedName("content_type")
    @Expose
    private String contentType;
    @SerializedName("url")
    @Expose
    private String url;

    /**
     * 
     * @return
     *     The bitrate
     */
    public Integer getBitrate() {
        return bitrate;
    }

    /**
     * 
     * @param bitrate
     *     The bitrate
     */
    public void setBitrate(Integer bitrate) {
        this.bitrate = bitrate;
    }

    /**
     * 
     * @return
     *     The contentType
     */
    public String getContentType() {
        return contentType;
    }

    /**
     * 
     * @param contentType
     *     The content_type
     */
    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

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

    public Variant() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.bitrate);
        dest.writeString(this.contentType);
        dest.writeString(this.url);
    }

    protected Variant(Parcel in) {
        this.bitrate = (Integer) in.readValue(Integer.class.getClassLoader());
        this.contentType = in.readString();
        this.url = in.readString();
    }

    public static final Creator<Variant> CREATOR = new Creator<Variant>() {
        public Variant createFromParcel(Parcel source) {
            return new Variant(source);
        }

        public Variant[] newArray(int size) {
            return new Variant[size];
        }
    };
}
