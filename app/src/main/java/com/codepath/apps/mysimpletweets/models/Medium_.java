
package com.codepath.apps.mysimpletweets.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Medium_ implements Parcelable {

    @SerializedName("id")
    @Expose
    private long id;
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
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("display_url")
    @Expose
    private String displayUrl;
    @SerializedName("expanded_url")
    @Expose
    private String expandedUrl;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("sizes")
    @Expose
    private Sizes_ sizes;

    /**
     * 
     * @return
     *     The id
     */
    public long getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    public void setId(long id) {
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
     *     The sizes
     */
    public Sizes_ getSizes() {
        return sizes;
    }

    /**
     * 
     * @param sizes
     *     The sizes
     */
    public void setSizes(Sizes_ sizes) {
        this.sizes = sizes;
    }

    public Medium_() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.id);
        dest.writeString(this.idStr);
        dest.writeList(this.indices);
        dest.writeString(this.mediaUrl);
        dest.writeString(this.mediaUrlHttps);
        dest.writeString(this.url);
        dest.writeString(this.displayUrl);
        dest.writeString(this.expandedUrl);
        dest.writeString(this.type);
        dest.writeParcelable(this.sizes, 0);
    }

    protected Medium_(Parcel in) {
        this.id = in.readLong();
        this.idStr = in.readString();
        this.indices = new ArrayList<Integer>();
        in.readList(this.indices, List.class.getClassLoader());
        this.mediaUrl = in.readString();
        this.mediaUrlHttps = in.readString();
        this.url = in.readString();
        this.displayUrl = in.readString();
        this.expandedUrl = in.readString();
        this.type = in.readString();
        this.sizes = in.readParcelable(Sizes_.class.getClassLoader());
    }

    public static final Creator<Medium_> CREATOR = new Creator<Medium_>() {
        public Medium_ createFromParcel(Parcel source) {
            return new Medium_(source);
        }

        public Medium_[] newArray(int size) {
            return new Medium_[size];
        }
    };
}
