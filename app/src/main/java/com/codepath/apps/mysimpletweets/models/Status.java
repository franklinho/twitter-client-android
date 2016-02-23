
package com.codepath.apps.mysimpletweets.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Hours;
import org.joda.time.Minutes;
import org.joda.time.Months;
import org.joda.time.Seconds;
import org.joda.time.Weeks;
import org.json.JSONArray;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
@Table(name = "Statuses", id="_id")
public class Status implements Parcelable {

//    @SerializedName("coordinates")
//    @Expose
//    private Object coordinates;
    @Column(name = "truncated", unique = false)
    @SerializedName("truncated")
    @Expose
    private Boolean truncated;
    @Column(name = "created_at", unique = false)
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @Column(name = "favorited", unique = false)
    @SerializedName("favorited")
    @Expose
    private Boolean favorited;
    @Column(name = "id_str", unique = true, onUniqueConflict = Column.ConflictAction.REPLACE)
    @SerializedName("id_str")
    @Expose
    private String idStr;
//    @SerializedName("in_reply_to_user_id_str")
//    @Expose
//    private Object inReplyToUserIdStr;
    @Column(name = "entities", unique = false,onUpdate = Column.ForeignKeyAction.CASCADE, onDelete = Column.ForeignKeyAction.CASCADE)
    @SerializedName("entities")
    @Expose
    private Entities entities;

    public Entities getExtendedEntities() {
        return extendedEntities;
    }
    @Column(name = "extended_entities", unique = false,onUpdate = Column.ForeignKeyAction.CASCADE, onDelete = Column.ForeignKeyAction.CASCADE)
    @SerializedName("extended_entities")
    @Expose
    private Entities extendedEntities;
    @Column(name = "text", unique = false)
    @SerializedName("text")
    @Expose
    private String text;
//    @SerializedName("contributors")
//    @Expose
//    private Object contributors;
    @Column(name = "id", unique = true, onUniqueConflict = Column.ConflictAction.REPLACE)
    @SerializedName("id")
    @Expose
    private long id;
    @Column(name = "retweet_count", unique = false)
    @SerializedName("retweet_count")
    @Expose
    private Integer retweetCount;
//    @SerializedName("in_reply_to_status_id_str")
//    @Expose
//    private Object inReplyToStatusIdStr;
//    @SerializedName("geo")
//    @Expose
//    private Object geo;
    @Column(name = "retweeted", unique = false)
    @SerializedName("retweeted")
    @Expose
    private Boolean retweeted;
//    @SerializedName("in_reply_to_user_id")
//    @Expose
//    private Object inReplyToUserId;
//    @SerializedName("place")
//    @Expose
//    private Object place;
    @Column(name = "source", unique = false)
    @SerializedName("source")
    @Expose
    private String source;
    @Column(name = "extended_entities", unique = false,onUpdate = Column.ForeignKeyAction.CASCADE, onDelete = Column.ForeignKeyAction.CASCADE)
    @SerializedName("user")
    @Expose
    private User user;
//    @SerializedName("in_reply_to_screen_name")
//    @Expose
//    private Object inReplyToScreenName;
//    @SerializedName("in_reply_to_status_id")
//    @Expose
//    private Object inReplyToStatusId;

    public Status() {
        super();
    }

    /**
     * 
     * @return
     *     The coordinates
     */
//    public Object getCoordinates() {
//        return coordinates;
//    }

    /**
     * 
     * @param coordinates
     *     The coordinates
     */
//    public void setCoordinates(Object coordinates) {
//        this.coordinates = coordinates;
//    }

    /**
     * 
     * @return
     *     The truncated
     */
    public Boolean getTruncated() {
        return truncated;
    }

    /**
     * 
     * @param truncated
     *     The truncated
     */
    public void setTruncated(Boolean truncated) {
        this.truncated = truncated;
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
     *     The favorited
     */
    public Boolean getFavorited() {
        return favorited;
    }

    /**
     * 
     * @param favorited
     *     The favorited
     */
    public void setFavorited(Boolean favorited) {
        this.favorited = favorited;
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
     *     The inReplyToUserIdStr
     */
//    public Object getInReplyToUserIdStr() {
//        return inReplyToUserIdStr;
//    }

    /**
     * 
     * @param inReplyToUserIdStr
     *     The in_reply_to_user_id_str
     */
//    public void setInReplyToUserIdStr(Object inReplyToUserIdStr) {
//        this.inReplyToUserIdStr = inReplyToUserIdStr;
//    }

    /**
     * 
     * @return
     *     The entities
     */
    public Entities getEntities() {
        return entities;
    }

    /**
     * 
     * @param entities
     *     The entities
     */
    public void setEntities(Entities entities) {
        this.entities = entities;
    }

    /**
     * 
     * @return
     *     The text
     */
    public String getText() {
        return text;
    }

    /**
     * 
     * @param text
     *     The text
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * 
     * @return
     *     The contributors
     */
//    public Object getContributors() {
//        return contributors;
//    }

    /**
     * 
     * @param contributors
     *     The contributors
     */
//    public void setContributors(Object contributors) {
//        this.contributors = contributors;
//    }

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
     *     The retweetCount
     */
    public Integer getRetweetCount() {
        return retweetCount;
    }

    /**
     * 
     * @param retweetCount
     *     The retweet_count
     */
    public void setRetweetCount(Integer retweetCount) {
        this.retweetCount = retweetCount;
    }

    /**
     * 
     * @return
     *     The inReplyToStatusIdStr
     */
//    public Object getInReplyToStatusIdStr() {
//        return inReplyToStatusIdStr;
//    }

    /**
     * 
     * @param inReplyToStatusIdStr
     *     The in_reply_to_status_id_str
     */
//    public void setInReplyToStatusIdStr(Object inReplyToStatusIdStr) {
//        this.inReplyToStatusIdStr = inReplyToStatusIdStr;
//    }

    /**
     * 
     * @return
     *     The geo
     */
//    public Object getGeo() {
//        return geo;
//    }

    /**
     * 
     * @param geo
     *     The geo
     */
//    public void setGeo(Object geo) {
//        this.geo = geo;
//    }

    /**
     * 
     * @return
     *     The retweeted
     */
    public Boolean getRetweeted() {
        return retweeted;
    }

    /**
     * 
     * @param retweeted
     *     The retweeted
     */
    public void setRetweeted(Boolean retweeted) {
        this.retweeted = retweeted;
    }

    /**
     * 
     * @return
     *     The inReplyToUserId
     */
//    public Object getInReplyToUserId() {
//        return inReplyToUserId;
//    }

    /**
     * 
     * @param inReplyToUserId
     *     The in_reply_to_user_id
     */
//    public void setInReplyToUserId(Object inReplyToUserId) {
//        this.inReplyToUserId = inReplyToUserId;
//    }

    /**
     * 
     * @return
     *     The place
     */
//    public Object getPlace() {
//        return place;
//    }

    /**
     * 
     * @param place
     *     The place
     */
//    public void setPlace(Object place) {
//        this.place = place;
//    }

    /**
     * 
     * @return
     *     The source
     */
    public String getSource() {
        return source;
    }

    /**
     * 
     * @param source
     *     The source
     */
    public void setSource(String source) {
        this.source = source;
    }

    /**
     * 
     * @return
     *     The user
     */
    public User getUser() {
        return user;
    }

    /**
     * 
     * @param user
     *     The user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * 
     * @return
     *     The inReplyToScreenName
     */
//    public Object getInReplyToScreenName() {
//        return inReplyToScreenName;
//    }

    /**
     * 
     * @param inReplyToScreenName
     *     The in_reply_to_screen_name
     */
//    public void setInReplyToScreenName(Object inReplyToScreenName) {
//        this.inReplyToScreenName = inReplyToScreenName;
//    }

    /**
     * 
     * @return
     *     The inReplyToStatusId
     */
//    public Object getInReplyToStatusId() {
//        return inReplyToStatusId;
//    }

    /**
     * 
     * @param inReplyToStatusId
     *     The in_reply_to_status_id
     */
//    public void setInReplyToStatusId(Object inReplyToStatusId) {
//        this.inReplyToStatusId = inReplyToStatusId;
//    }

    public static List<Status> fromJSONArray(JSONArray json) {
        Type listType = new TypeToken<List<Status>>() {}.getType();
        Gson gson = new GsonBuilder().create();

        return (List<Status>) gson.fromJson(json.toString(), listType);

    }

    public String getFormattedTimeStamp() {


        String twitterFormat = "EEE MMM dd HH:mm:ss ZZZZZ yyyy";
        SimpleDateFormat sf = new SimpleDateFormat(twitterFormat, Locale.ENGLISH);
        sf.setLenient(true);

        String formattedDate = "";
        try {
            Date createdDate = sf.parse(getCreatedAt());

            String normalFormat = "MMM dd yyyy hh:mm:ss aa";
            SimpleDateFormat nf = new SimpleDateFormat(normalFormat);
            formattedDate = nf.format(createdDate).toString();
        } catch (ParseException e) {

        }




        return formattedDate;
    }

    public String getRelativeTimeAgo() {
        String twitterFormat = "EEE MMM dd HH:mm:ss ZZZZZ yyyy";
        SimpleDateFormat sf = new SimpleDateFormat(twitterFormat, Locale.ENGLISH);
        sf.setLenient(true);


        String relativeDate = "";
        try {
            DateTime createdDateTime = new DateTime(sf.parse(getCreatedAt()).getTime());
            DateTime currentDateTime = new DateTime();




            int secondDifference = Seconds.secondsBetween(createdDateTime.toLocalDateTime(), currentDateTime.toLocalDateTime()).getSeconds();
            if (secondDifference < 60) {
                relativeDate = Integer.toString(secondDifference) + "s";
            } else if (Minutes.minutesBetween(createdDateTime.toLocalDateTime(), currentDateTime.toLocalDateTime()).getMinutes() < 60) {
                relativeDate = Integer.toString(Minutes.minutesBetween(createdDateTime.toLocalDateTime(), currentDateTime.toLocalDateTime()).getMinutes())+"m";
            } else if (Hours.hoursBetween(createdDateTime.toLocalDateTime(), currentDateTime.toLocalDateTime()).getHours() < 24) {
                relativeDate = Integer.toString(Hours.hoursBetween(createdDateTime.toLocalDateTime(),currentDateTime.toLocalDateTime()).getHours())+"h";
            } else if (Weeks.weeksBetween(createdDateTime.toLocalDateTime(), currentDateTime.toLocalDateTime()).getWeeks() < 1) {
                relativeDate = Integer.toString(Days.daysBetween(createdDateTime.toLocalDateTime(), currentDateTime.toLocalDateTime()).getDays()) + "d";
            } else if (Months.monthsBetween(createdDateTime.toLocalDateTime(), currentDateTime.toLocalDateTime()).getMonths() < 1) {
                relativeDate = Integer.toString(Weeks.weeksBetween(createdDateTime.toLocalDateTime(), currentDateTime.toLocalDateTime()).getWeeks()) + "w";
            } else {
                relativeDate = Integer.toString(Months.monthsBetween(createdDateTime.toLocalDateTime(), currentDateTime.toLocalDateTime()).getMonths())+"M";
            }
        } catch (ParseException e) {
            e.printStackTrace();

        }


        return relativeDate;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.truncated);
        dest.writeString(this.createdAt);
        dest.writeValue(this.favorited);
        dest.writeString(this.idStr);
        dest.writeParcelable(this.entities, 0);
        dest.writeParcelable(this.extendedEntities, 0);
        dest.writeString(this.text);
        dest.writeLong(this.id);
        dest.writeValue(this.retweetCount);
        dest.writeValue(this.retweeted);
        dest.writeString(this.source);
        dest.writeParcelable(this.user, 0);
    }

    protected Status(Parcel in) {
        this.truncated = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.createdAt = in.readString();
        this.favorited = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.idStr = in.readString();
        this.entities = in.readParcelable(Entities.class.getClassLoader());
        this.extendedEntities = in.readParcelable(Entities.class.getClassLoader());
        this.text = in.readString();
        this.id = in.readLong();
        this.retweetCount = (Integer) in.readValue(Integer.class.getClassLoader());
        this.retweeted = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.source = in.readString();
        this.user = in.readParcelable(User.class.getClassLoader());
    }

    public static final Creator<Status> CREATOR = new Creator<Status>() {
        public Status createFromParcel(Parcel source) {
            return new Status(source);
        }

        public Status[] newArray(int size) {
            return new Status[size];
        }
    };
}
