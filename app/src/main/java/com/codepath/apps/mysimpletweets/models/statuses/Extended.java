
package com.codepath.apps.mysimpletweets.models.statuses;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Extended implements Parcelable {

    @SerializedName("display_url")
    @Expose
    private String displayUrl;
    @SerializedName("expanded_url")
    @Expose
    private String expandedUrl;
    @SerializedName("features")
    @Expose
    private Features features;
    @SerializedName("id")
    @Expose
    private Double id;
    @SerializedName("id_str")
    @Expose
    private String idStr;
    @SerializedName("indices")
    @Expose
    private List<Integer> indices = new ArrayList<Integer>();
    @SerializedName("media_url")
    @Expose
    private String mediaUrl;
    @SerializedName("media_url_https")
    @Expose
    private String mediaUrlHttps;
    @SerializedName("sizes")
    @Expose
    private Sizes sizes;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("video_info")
    @Expose
    private VideoInfo videoInfo;

    /**
     * 
     * @return
     *     The displayUrl
     */
    public String getDisplayUrl() {
        return displayUrl;
    }

    /**
     * 
     * @param displayUrl
     *     The display_url
     */
    public void setDisplayUrl(String displayUrl) {
        this.displayUrl = displayUrl;
    }

    /**
     * 
     * @return
     *     The expandedUrl
     */
    public String getExpandedUrl() {
        return expandedUrl;
    }

    /**
     * 
     * @param expandedUrl
     *     The expanded_url
     */
    public void setExpandedUrl(String expandedUrl) {
        this.expandedUrl = expandedUrl;
    }

    /**
     * 
     * @return
     *     The features
     */
    public Features getFeatures() {
        return features;
    }

    /**
     * 
     * @param features
     *     The features
     */
    public void setFeatures(Features features) {
        this.features = features;
    }

    /**
     * 
     * @return
     *     The id
     */
    public Double getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    public void setId(Double id) {
        this.id = id;
    }

    /**
     * 
     * @return
     *     The idStr
     */
    public String getIdStr() {
        return idStr;
    }

    /**
     * 
     * @param idStr
     *     The id_str
     */
    public void setIdStr(String idStr) {
        this.idStr = idStr;
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
     *     The mediaUrl
     */
    public String getMediaUrl() {
        return mediaUrl;
    }

    /**
     * 
     * @param mediaUrl
     *     The media_url
     */
    public void setMediaUrl(String mediaUrl) {
        this.mediaUrl = mediaUrl;
    }

    /**
     * 
     * @return
     *     The mediaUrlHttps
     */
    public String getMediaUrlHttps() {
        return mediaUrlHttps;
    }

    /**
     * 
     * @param mediaUrlHttps
     *     The media_url_https
     */
    public void setMediaUrlHttps(String mediaUrlHttps) {
        this.mediaUrlHttps = mediaUrlHttps;
    }

    /**
     * 
     * @return
     *     The sizes
     */
    public Sizes getSizes() {
        return sizes;
    }

    /**
     * 
     * @param sizes
     *     The sizes
     */
    public void setSizes(Sizes sizes) {
        this.sizes = sizes;
    }

    /**
     * 
     * @return
     *     The type
     */
    public String getType() {
        return type;
    }

    /**
     * 
     * @param type
     *     The type
     */
    public void setType(String type) {
        this.type = type;
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

    /**
     * 
     * @return
     *     The videoInfo
     */
    public VideoInfo getVideoInfo() {
        return videoInfo;
    }

    /**
     * 
     * @param videoInfo
     *     The video_info
     */
    public void setVideoInfo(VideoInfo videoInfo) {
        this.videoInfo = videoInfo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.displayUrl);
        dest.writeString(this.expandedUrl);
        dest.writeParcelable(this.features, flags);
        dest.writeValue(this.id);
        dest.writeString(this.idStr);
        dest.writeList(this.indices);
        dest.writeString(this.mediaUrl);
        dest.writeString(this.mediaUrlHttps);
        dest.writeParcelable(this.sizes, flags);
        dest.writeString(this.type);
        dest.writeString(this.url);
        dest.writeParcelable(this.videoInfo, flags);
    }

    public Extended() {
    }

    protected Extended(Parcel in) {
        this.displayUrl = in.readString();
        this.expandedUrl = in.readString();
        this.features = in.readParcelable(Features.class.getClassLoader());
        this.id = (Double) in.readValue(Double.class.getClassLoader());
        this.idStr = in.readString();
        this.indices = new ArrayList<Integer>();
        in.readList(this.indices, List.class.getClassLoader());
        this.mediaUrl = in.readString();
        this.mediaUrlHttps = in.readString();
        this.sizes = in.readParcelable(Sizes.class.getClassLoader());
        this.type = in.readString();
        this.url = in.readString();
        this.videoInfo = in.readParcelable(VideoInfo.class.getClassLoader());
    }

    public static final Parcelable.Creator<Extended> CREATOR = new Parcelable.Creator<Extended>() {
        public Extended createFromParcel(Parcel source) {
            return new Extended(source);
        }

        public Extended[] newArray(int size) {
            return new Extended[size];
        }
    };
}
