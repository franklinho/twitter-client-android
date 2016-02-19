
package com.codepath.apps.mysimpletweets.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
@Table(name = "Users")
public class User implements Parcelable {
    @Column(name = "name", unique = false)
    @SerializedName("name")
    @Expose
    private String name;
    @Column(name = "profile_sidebar_fill_color", unique = false)
    @SerializedName("profile_sidebar_fill_color")
    @Expose
    private String profileSidebarFillColor;
    @Column(name = "profile_background_tile", unique = false)
    @SerializedName("profile_background_tile")
    @Expose
    private Boolean profileBackgroundTile;
    @Column(name = "profile_sidebar_border_color", unique = false)
    @SerializedName("profile_sidebar_border_color")
    @Expose
    private String profileSidebarBorderColor;
    @Column(name = "profile_image_url", unique = false)
    @SerializedName("profile_image_url")
    @Expose
    private String profileImageUrl;
    @Column(name = "created_at", unique = false)
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @Column(name = "location", unique = false)
    @SerializedName("location")
    @Expose
    private String location;
    @Column(name = "follow_request_sent", unique = false)
    @SerializedName("follow_request_sent")
    @Expose
    private Boolean followRequestSent;
    @Column(name = "id_str", unique = true, onUniqueConflict = Column.ConflictAction.REPLACE)
    @SerializedName("id_str")
    @Expose
    private String idStr;
    @Column(name = "is_translator", unique = false)
    @SerializedName("is_translator")
    @Expose
    private Boolean isTranslator;
    @Column(name = "profile_link_color", unique = false)
    @SerializedName("profile_link_color")
    @Expose
    private String profileLinkColor;
//    @SerializedName("entities")
//    @Expose
//    private Entities_ entities;
    @Column(name = "default_profile", unique = false)
    @SerializedName("default_profile")
    @Expose
    private Boolean defaultProfile;
    @Column(name = "url", unique = false)
    @SerializedName("url")
    @Expose
    private String url;
    @Column(name = "contributors_enabled", unique = false)
    @SerializedName("contributors_enabled")
    @Expose
    private Boolean contributorsEnabled;
    @Column(name = "favourites_count", unique = false)
    @SerializedName("favourites_count")
    @Expose
    private Integer favouritesCount;
    @Column(name = "profile_image_url_https", unique = false)
//    @SerializedName("utc_offset")
//    @Expose
//    private Object utcOffset;
    @SerializedName("profile_image_url_https")
    @Expose
    private String profileImageUrlHttps;
    @Column(name = "id", unique = true, onUniqueConflict = Column.ConflictAction.REPLACE)
    @SerializedName("id")
    @Expose
    private long id;
    @Column(name = "listed_count", unique = false)
    @SerializedName("listed_count")
    @Expose
    private Integer listedCount;
    @Column(name = "profile_use_background_image", unique = false)
    @SerializedName("profile_use_background_image")
    @Expose
    private Boolean profileUseBackgroundImage;
    @Column(name = "profile_text_color", unique = false)
    @SerializedName("profile_text_color")
    @Expose
    private String profileTextColor;
    @Column(name = "followers_count", unique = false)
    @SerializedName("followers_count")
    @Expose
    private Integer followersCount;
    @Column(name = "lang", unique = false)
    @SerializedName("lang")
    @Expose
    private String lang;
    @Column(name = "protected", unique = false)
    @SerializedName("protected")
    @Expose
    private Boolean _protected;
    @Column(name = "geo_enabled", unique = false)
    @SerializedName("geo_enabled")
    @Expose
    private Boolean geoEnabled;
    @Column(name = "notifications", unique = false)
    @SerializedName("notifications")
    @Expose
    private Boolean notifications;
    @Column(name = "description", unique = false)
    @SerializedName("description")
    @Expose
    private String description;
    @Column(name = "profile_background_color", unique = false)
    @SerializedName("profile_background_color")
    @Expose
    private String profileBackgroundColor;
    @Column(name = "verified", unique = false)
    @SerializedName("verified")
    @Expose
    private Boolean verified;
    @Column(name = "profile_background_image_url_https", unique = false)
//    @SerializedName("time_zone")
//    @Expose
//    private Object timeZone;
    @SerializedName("profile_background_image_url_https")
    @Expose
    private String profileBackgroundImageUrlHttps;
    @Column(name = "statuses_count", unique = false)
    @SerializedName("statuses_count")
    @Expose
    private Integer statusesCount;
    @Column(name = "profile_background_image_url", unique = false)
    @SerializedName("profile_background_image_url")
    @Expose
    private String profileBackgroundImageUrl;
    @Column(name = "default_profile_image", unique = false)
    @SerializedName("default_profile_image")
    @Expose
    private Boolean defaultProfileImage;
    @Column(name = "friends_count", unique = false)
    @SerializedName("friends_count")
    @Expose
    private Integer friendsCount;
    @Column(name = "following", unique = false)
    @SerializedName("following")
    @Expose
    private Boolean following;
    @Column(name = "show_all_inline_media", unique = false)
    @SerializedName("show_all_inline_media")
    @Expose
    private Boolean showAllInlineMedia;
    @Column(name = "screen_name", unique = false)
    @SerializedName("screen_name")
    @Expose
    private String screenName;

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
     *     The entities
     */
//    public Entities_ getEntities() {
//        return entities;
//    }

    /**
     * 
     * @param entities
     *     The entities
     */
//    public void setEntities(Entities_ entities) {
//        this.entities = entities;
//    }

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
     *     The utcOffset
     */
//    public Object getUtcOffset() {
//        return utcOffset;
//    }

    /**
     * 
     * @param utcOffset
     *     The utc_offset
     */
//    public void setUtcOffset(Object utcOffset) {
//        this.utcOffset = utcOffset;
//    }

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
    public void setId(Integer id) {
        this.id = id;
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

    /**
     * 
     * @return
     *     The timeZone
     */
//    public Object getTimeZone() {
//        return timeZone;
//    }

    /**
     * 
     * @param timeZone
     *     The time_zone
     */
//    public void setTimeZone(Object timeZone) {
//        this.timeZone = timeZone;
//    }

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

    public User() {
        super();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.profileSidebarFillColor);
        dest.writeValue(this.profileBackgroundTile);
        dest.writeString(this.profileSidebarBorderColor);
        dest.writeString(this.profileImageUrl);
        dest.writeString(this.createdAt);
        dest.writeString(this.location);
        dest.writeValue(this.followRequestSent);
        dest.writeString(this.idStr);
        dest.writeValue(this.isTranslator);
        dest.writeString(this.profileLinkColor);
//        dest.writeParcelable(this.entities, flags);
        dest.writeValue(this.defaultProfile);
        dest.writeString(this.url);
        dest.writeValue(this.contributorsEnabled);
        dest.writeValue(this.favouritesCount);
        dest.writeString(this.profileImageUrlHttps);
        dest.writeLong(this.id);
        dest.writeValue(this.listedCount);
        dest.writeValue(this.profileUseBackgroundImage);
        dest.writeString(this.profileTextColor);
        dest.writeValue(this.followersCount);
        dest.writeString(this.lang);
        dest.writeValue(this._protected);
        dest.writeValue(this.geoEnabled);
        dest.writeValue(this.notifications);
        dest.writeString(this.description);
        dest.writeString(this.profileBackgroundColor);
        dest.writeValue(this.verified);
        dest.writeString(this.profileBackgroundImageUrlHttps);
        dest.writeValue(this.statusesCount);
        dest.writeString(this.profileBackgroundImageUrl);
        dest.writeValue(this.defaultProfileImage);
        dest.writeValue(this.friendsCount);
        dest.writeValue(this.following);
        dest.writeValue(this.showAllInlineMedia);
        dest.writeString(this.screenName);
    }

    protected User(Parcel in) {
        this.name = in.readString();
        this.profileSidebarFillColor = in.readString();
        this.profileBackgroundTile = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.profileSidebarBorderColor = in.readString();
        this.profileImageUrl = in.readString();
        this.createdAt = in.readString();
        this.location = in.readString();
        this.followRequestSent = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.idStr = in.readString();
        this.isTranslator = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.profileLinkColor = in.readString();
//        this.entities = in.readParcelable(Entities_.class.getClassLoader());
        this.defaultProfile = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.url = in.readString();
        this.contributorsEnabled = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.favouritesCount = (Integer) in.readValue(Integer.class.getClassLoader());
        this.profileImageUrlHttps = in.readString();
        this.id = in.readLong();
        this.listedCount = (Integer) in.readValue(Integer.class.getClassLoader());
        this.profileUseBackgroundImage = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.profileTextColor = in.readString();
        this.followersCount = (Integer) in.readValue(Integer.class.getClassLoader());
        this.lang = in.readString();
        this._protected = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.geoEnabled = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.notifications = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.description = in.readString();
        this.profileBackgroundColor = in.readString();
        this.verified = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.profileBackgroundImageUrlHttps = in.readString();
        this.statusesCount = (Integer) in.readValue(Integer.class.getClassLoader());
        this.profileBackgroundImageUrl = in.readString();
        this.defaultProfileImage = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.friendsCount = (Integer) in.readValue(Integer.class.getClassLoader());
        this.following = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.showAllInlineMedia = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.screenName = in.readString();
    }

    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
        public User createFromParcel(Parcel source) {
            return new User(source);
        }

        public User[] newArray(int size) {
            return new User[size];
        }
    };
}
