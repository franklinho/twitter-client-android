
package com.codepath.apps.mysimpletweets.models.direct_messages;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Recipient implements Parcelable {

    @SerializedName("contributors_enabled")
    @Expose
    private Boolean contributorsEnabled;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("default_profile")
    @Expose
    private Boolean defaultProfile;
    @SerializedName("default_profile_image")
    @Expose
    private Boolean defaultProfileImage;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("favourites_count")
    @Expose
    private Integer favouritesCount;
    @SerializedName("follow_request_sent")
    @Expose
    private Boolean followRequestSent;
    @SerializedName("followers_count")
    @Expose
    private Integer followersCount;
    @SerializedName("following")
    @Expose
    private Boolean following;
    @SerializedName("friends_count")
    @Expose
    private Integer friendsCount;
    @SerializedName("geo_enabled")
    @Expose
    private Boolean geoEnabled;
    @SerializedName("id")
    @Expose
    private long id;
    @SerializedName("id_str")
    @Expose
    private String idStr;
    @SerializedName("is_translator")
    @Expose
    private Boolean isTranslator;
    @SerializedName("lang")
    @Expose
    private String lang;
    @SerializedName("listed_count")
    @Expose
    private Integer listedCount;
    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("notifications")
    @Expose
    private Boolean notifications;
    @SerializedName("profile_background_color")
    @Expose
    private String profileBackgroundColor;
    @SerializedName("profile_background_image_url")
    @Expose
    private String profileBackgroundImageUrl;
    @SerializedName("profile_background_image_url_https")
    @Expose
    private String profileBackgroundImageUrlHttps;
    @SerializedName("profile_background_tile")
    @Expose
    private Boolean profileBackgroundTile;
    @SerializedName("profile_image_url")
    @Expose
    private String profileImageUrl;
    @SerializedName("profile_image_url_https")
    @Expose
    private String profileImageUrlHttps;
    @SerializedName("profile_link_color")
    @Expose
    private String profileLinkColor;
    @SerializedName("profile_sidebar_border_color")
    @Expose
    private String profileSidebarBorderColor;
    @SerializedName("profile_sidebar_fill_color")
    @Expose
    private String profileSidebarFillColor;
    @SerializedName("profile_text_color")
    @Expose
    private String profileTextColor;
    @SerializedName("profile_use_background_image")
    @Expose
    private Boolean profileUseBackgroundImage;
    @SerializedName("protected")
    @Expose
    private Boolean _protected;
    @SerializedName("screen_name")
    @Expose
    private String screenName;
    @SerializedName("show_all_inline_media")
    @Expose
    private Boolean showAllInlineMedia;
    @SerializedName("statuses_count")
    @Expose
    private Integer statusesCount;
    @SerializedName("time_zone")
    @Expose
    private String timeZone;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("utc_offset")
    @Expose
    private Integer utcOffset;
    @SerializedName("verified")
    @Expose
    private Boolean verified;

    /**
     * 
     * @return
     *     The contributorsEnabled
     */
    public Boolean getContributorsEnabled() {
        return contributorsEnabled;
    }

    /**
     * 
     * @param contributorsEnabled
     *     The contributors_enabled
     */
    public void setContributorsEnabled(Boolean contributorsEnabled) {
        this.contributorsEnabled = contributorsEnabled;
    }

    /**
     * 
     * @return
     *     The createdAt
     */
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * 
     * @param createdAt
     *     The created_at
     */
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * 
     * @return
     *     The defaultProfile
     */
    public Boolean getDefaultProfile() {
        return defaultProfile;
    }

    /**
     * 
     * @param defaultProfile
     *     The default_profile
     */
    public void setDefaultProfile(Boolean defaultProfile) {
        this.defaultProfile = defaultProfile;
    }

    /**
     * 
     * @return
     *     The defaultProfileImage
     */
    public Boolean getDefaultProfileImage() {
        return defaultProfileImage;
    }

    /**
     * 
     * @param defaultProfileImage
     *     The default_profile_image
     */
    public void setDefaultProfileImage(Boolean defaultProfileImage) {
        this.defaultProfileImage = defaultProfileImage;
    }

    /**
     * 
     * @return
     *     The description
     */
    public String getDescription() {
        return description;
    }

    /**
     * 
     * @param description
     *     The description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 
     * @return
     *     The favouritesCount
     */
    public Integer getFavouritesCount() {
        return favouritesCount;
    }

    /**
     * 
     * @param favouritesCount
     *     The favourites_count
     */
    public void setFavouritesCount(Integer favouritesCount) {
        this.favouritesCount = favouritesCount;
    }

    /**
     * 
     * @return
     *     The followRequestSent
     */
    public Boolean getFollowRequestSent() {
        return followRequestSent;
    }

    /**
     * 
     * @param followRequestSent
     *     The follow_request_sent
     */
    public void setFollowRequestSent(Boolean followRequestSent) {
        this.followRequestSent = followRequestSent;
    }

    /**
     * 
     * @return
     *     The followersCount
     */
    public Integer getFollowersCount() {
        return followersCount;
    }

    /**
     * 
     * @param followersCount
     *     The followers_count
     */
    public void setFollowersCount(Integer followersCount) {
        this.followersCount = followersCount;
    }

    /**
     * 
     * @return
     *     The following
     */
    public Boolean getFollowing() {
        return following;
    }

    /**
     * 
     * @param following
     *     The following
     */
    public void setFollowing(Boolean following) {
        this.following = following;
    }

    /**
     * 
     * @return
     *     The friendsCount
     */
    public Integer getFriendsCount() {
        return friendsCount;
    }

    /**
     * 
     * @param friendsCount
     *     The friends_count
     */
    public void setFriendsCount(Integer friendsCount) {
        this.friendsCount = friendsCount;
    }

    /**
     * 
     * @return
     *     The geoEnabled
     */
    public Boolean getGeoEnabled() {
        return geoEnabled;
    }

    /**
     * 
     * @param geoEnabled
     *     The geo_enabled
     */
    public void setGeoEnabled(Boolean geoEnabled) {
        this.geoEnabled = geoEnabled;
    }

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
     *     The isTranslator
     */
    public Boolean getIsTranslator() {
        return isTranslator;
    }

    /**
     * 
     * @param isTranslator
     *     The is_translator
     */
    public void setIsTranslator(Boolean isTranslator) {
        this.isTranslator = isTranslator;
    }

    /**
     * 
     * @return
     *     The lang
     */
    public String getLang() {
        return lang;
    }

    /**
     * 
     * @param lang
     *     The lang
     */
    public void setLang(String lang) {
        this.lang = lang;
    }

    /**
     * 
     * @return
     *     The listedCount
     */
    public Integer getListedCount() {
        return listedCount;
    }

    /**
     * 
     * @param listedCount
     *     The listed_count
     */
    public void setListedCount(Integer listedCount) {
        this.listedCount = listedCount;
    }

    /**
     * 
     * @return
     *     The location
     */
    public String getLocation() {
        return location;
    }

    /**
     * 
     * @param location
     *     The location
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * 
     * @return
     *     The name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return
     *     The notifications
     */
    public Boolean getNotifications() {
        return notifications;
    }

    /**
     * 
     * @param notifications
     *     The notifications
     */
    public void setNotifications(Boolean notifications) {
        this.notifications = notifications;
    }

    /**
     * 
     * @return
     *     The profileBackgroundColor
     */
    public String getProfileBackgroundColor() {
        return profileBackgroundColor;
    }

    /**
     * 
     * @param profileBackgroundColor
     *     The profile_background_color
     */
    public void setProfileBackgroundColor(String profileBackgroundColor) {
        this.profileBackgroundColor = profileBackgroundColor;
    }

    /**
     * 
     * @return
     *     The profileBackgroundImageUrl
     */
    public String getProfileBackgroundImageUrl() {
        return profileBackgroundImageUrl;
    }

    /**
     * 
     * @param profileBackgroundImageUrl
     *     The profile_background_image_url
     */
    public void setProfileBackgroundImageUrl(String profileBackgroundImageUrl) {
        this.profileBackgroundImageUrl = profileBackgroundImageUrl;
    }

    /**
     * 
     * @return
     *     The profileBackgroundImageUrlHttps
     */
    public String getProfileBackgroundImageUrlHttps() {
        return profileBackgroundImageUrlHttps;
    }

    /**
     * 
     * @param profileBackgroundImageUrlHttps
     *     The profile_background_image_url_https
     */
    public void setProfileBackgroundImageUrlHttps(String profileBackgroundImageUrlHttps) {
        this.profileBackgroundImageUrlHttps = profileBackgroundImageUrlHttps;
    }

    /**
     * 
     * @return
     *     The profileBackgroundTile
     */
    public Boolean getProfileBackgroundTile() {
        return profileBackgroundTile;
    }

    /**
     * 
     * @param profileBackgroundTile
     *     The profile_background_tile
     */
    public void setProfileBackgroundTile(Boolean profileBackgroundTile) {
        this.profileBackgroundTile = profileBackgroundTile;
    }

    /**
     * 
     * @return
     *     The profileImageUrl
     */
    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    /**
     * 
     * @param profileImageUrl
     *     The profile_image_url
     */
    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

    /**
     * 
     * @return
     *     The profileImageUrlHttps
     */
    public String getProfileImageUrlHttps() {
        return profileImageUrlHttps;
    }

    /**
     * 
     * @param profileImageUrlHttps
     *     The profile_image_url_https
     */
    public void setProfileImageUrlHttps(String profileImageUrlHttps) {
        this.profileImageUrlHttps = profileImageUrlHttps;
    }

    /**
     * 
     * @return
     *     The profileLinkColor
     */
    public String getProfileLinkColor() {
        return profileLinkColor;
    }

    /**
     * 
     * @param profileLinkColor
     *     The profile_link_color
     */
    public void setProfileLinkColor(String profileLinkColor) {
        this.profileLinkColor = profileLinkColor;
    }

    /**
     * 
     * @return
     *     The profileSidebarBorderColor
     */
    public String getProfileSidebarBorderColor() {
        return profileSidebarBorderColor;
    }

    /**
     * 
     * @param profileSidebarBorderColor
     *     The profile_sidebar_border_color
     */
    public void setProfileSidebarBorderColor(String profileSidebarBorderColor) {
        this.profileSidebarBorderColor = profileSidebarBorderColor;
    }

    /**
     * 
     * @return
     *     The profileSidebarFillColor
     */
    public String getProfileSidebarFillColor() {
        return profileSidebarFillColor;
    }

    /**
     * 
     * @param profileSidebarFillColor
     *     The profile_sidebar_fill_color
     */
    public void setProfileSidebarFillColor(String profileSidebarFillColor) {
        this.profileSidebarFillColor = profileSidebarFillColor;
    }

    /**
     * 
     * @return
     *     The profileTextColor
     */
    public String getProfileTextColor() {
        return profileTextColor;
    }

    /**
     * 
     * @param profileTextColor
     *     The profile_text_color
     */
    public void setProfileTextColor(String profileTextColor) {
        this.profileTextColor = profileTextColor;
    }

    /**
     * 
     * @return
     *     The profileUseBackgroundImage
     */
    public Boolean getProfileUseBackgroundImage() {
        return profileUseBackgroundImage;
    }

    /**
     * 
     * @param profileUseBackgroundImage
     *     The profile_use_background_image
     */
    public void setProfileUseBackgroundImage(Boolean profileUseBackgroundImage) {
        this.profileUseBackgroundImage = profileUseBackgroundImage;
    }

    /**
     * 
     * @return
     *     The _protected
     */
    public Boolean getProtected() {
        return _protected;
    }

    /**
     * 
     * @param _protected
     *     The protected
     */
    public void setProtected(Boolean _protected) {
        this._protected = _protected;
    }

    /**
     * 
     * @return
     *     The screenName
     */
    public String getScreenName() {
        return screenName;
    }

    /**
     * 
     * @param screenName
     *     The screen_name
     */
    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    /**
     * 
     * @return
     *     The showAllInlineMedia
     */
    public Boolean getShowAllInlineMedia() {
        return showAllInlineMedia;
    }

    /**
     * 
     * @param showAllInlineMedia
     *     The show_all_inline_media
     */
    public void setShowAllInlineMedia(Boolean showAllInlineMedia) {
        this.showAllInlineMedia = showAllInlineMedia;
    }

    /**
     * 
     * @return
     *     The statusesCount
     */
    public Integer getStatusesCount() {
        return statusesCount;
    }

    /**
     * 
     * @param statusesCount
     *     The statuses_count
     */
    public void setStatusesCount(Integer statusesCount) {
        this.statusesCount = statusesCount;
    }

    /**
     * 
     * @return
     *     The timeZone
     */
    public String getTimeZone() {
        return timeZone;
    }

    /**
     * 
     * @param timeZone
     *     The time_zone
     */
    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
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
     *     The utcOffset
     */
    public Integer getUtcOffset() {
        return utcOffset;
    }

    /**
     * 
     * @param utcOffset
     *     The utc_offset
     */
    public void setUtcOffset(Integer utcOffset) {
        this.utcOffset = utcOffset;
    }

    /**
     * 
     * @return
     *     The verified
     */
    public Boolean getVerified() {
        return verified;
    }

    /**
     * 
     * @param verified
     *     The verified
     */
    public void setVerified(Boolean verified) {
        this.verified = verified;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.contributorsEnabled);
        dest.writeString(this.createdAt);
        dest.writeValue(this.defaultProfile);
        dest.writeValue(this.defaultProfileImage);
        dest.writeString(this.description);
        dest.writeValue(this.favouritesCount);
        dest.writeValue(this.followRequestSent);
        dest.writeValue(this.followersCount);
        dest.writeValue(this.following);
        dest.writeValue(this.friendsCount);
        dest.writeValue(this.geoEnabled);
        dest.writeValue(this.id);
        dest.writeString(this.idStr);
        dest.writeValue(this.isTranslator);
        dest.writeString(this.lang);
        dest.writeValue(this.listedCount);
        dest.writeString(this.location);
        dest.writeString(this.name);
        dest.writeValue(this.notifications);
        dest.writeString(this.profileBackgroundColor);
        dest.writeString(this.profileBackgroundImageUrl);
        dest.writeString(this.profileBackgroundImageUrlHttps);
        dest.writeValue(this.profileBackgroundTile);
        dest.writeString(this.profileImageUrl);
        dest.writeString(this.profileImageUrlHttps);
        dest.writeString(this.profileLinkColor);
        dest.writeString(this.profileSidebarBorderColor);
        dest.writeString(this.profileSidebarFillColor);
        dest.writeString(this.profileTextColor);
        dest.writeValue(this.profileUseBackgroundImage);
        dest.writeValue(this._protected);
        dest.writeString(this.screenName);
        dest.writeValue(this.showAllInlineMedia);
        dest.writeValue(this.statusesCount);
        dest.writeString(this.timeZone);
        dest.writeString(this.url);
        dest.writeValue(this.utcOffset);
        dest.writeValue(this.verified);
    }

    public Recipient() {
    }

    protected Recipient(Parcel in) {
        this.contributorsEnabled = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.createdAt = in.readString();
        this.defaultProfile = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.defaultProfileImage = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.description = in.readString();
        this.favouritesCount = (Integer) in.readValue(Integer.class.getClassLoader());
        this.followRequestSent = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.followersCount = (Integer) in.readValue(Integer.class.getClassLoader());
        this.following = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.friendsCount = (Integer) in.readValue(Integer.class.getClassLoader());
        this.geoEnabled = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.id = (Integer) in.readValue(Integer.class.getClassLoader());
        this.idStr = in.readString();
        this.isTranslator = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.lang = in.readString();
        this.listedCount = (Integer) in.readValue(Integer.class.getClassLoader());
        this.location = in.readString();
        this.name = in.readString();
        this.notifications = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.profileBackgroundColor = in.readString();
        this.profileBackgroundImageUrl = in.readString();
        this.profileBackgroundImageUrlHttps = in.readString();
        this.profileBackgroundTile = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.profileImageUrl = in.readString();
        this.profileImageUrlHttps = in.readString();
        this.profileLinkColor = in.readString();
        this.profileSidebarBorderColor = in.readString();
        this.profileSidebarFillColor = in.readString();
        this.profileTextColor = in.readString();
        this.profileUseBackgroundImage = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this._protected = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.screenName = in.readString();
        this.showAllInlineMedia = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.statusesCount = (Integer) in.readValue(Integer.class.getClassLoader());
        this.timeZone = in.readString();
        this.url = in.readString();
        this.utcOffset = (Integer) in.readValue(Integer.class.getClassLoader());
        this.verified = (Boolean) in.readValue(Boolean.class.getClassLoader());
    }

    public static final Parcelable.Creator<Recipient> CREATOR = new Parcelable.Creator<Recipient>() {
        public Recipient createFromParcel(Parcel source) {
            return new Recipient(source);
        }

        public Recipient[] newArray(int size) {
            return new Recipient[size];
        }
    };
}
