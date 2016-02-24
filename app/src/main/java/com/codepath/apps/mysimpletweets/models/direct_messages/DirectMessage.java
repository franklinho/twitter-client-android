
package com.codepath.apps.mysimpletweets.models.direct_messages;

import android.os.Parcel;
import android.os.Parcelable;

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
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class DirectMessage implements Parcelable {

    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("entities")
    @Expose
    private Entities entities;
    @SerializedName("id")
    @Expose
    private long id;
    @SerializedName("id_str")
    @Expose
    private String idStr;
    @SerializedName("recipient")
    @Expose
    private Recipient recipient;
    @SerializedName("recipient_id")
    @Expose
    private Integer recipientId;
    @SerializedName("recipient_screen_name")
    @Expose
    private String recipientScreenName;
    @SerializedName("sender")
    @Expose
    private Sender sender;
    @SerializedName("sender_id")
    @Expose
    private Integer senderId;
    @SerializedName("sender_screen_name")
    @Expose
    private String senderScreenName;
    @SerializedName("text")
    @Expose
    private String text;

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
     *     The recipient
     */
    public Recipient getRecipient() {
        return recipient;
    }

    /**
     * 
     * @param recipient
     *     The recipient
     */
    public void setRecipient(Recipient recipient) {
        this.recipient = recipient;
    }

    /**
     * 
     * @return
     *     The recipientId
     */
    public Integer getRecipientId() {
        return recipientId;
    }

    /**
     * 
     * @param recipientId
     *     The recipient_id
     */
    public void setRecipientId(Integer recipientId) {
        this.recipientId = recipientId;
    }

    /**
     * 
     * @return
     *     The recipientScreenName
     */
    public String getRecipientScreenName() {
        return recipientScreenName;
    }

    /**
     * 
     * @param recipientScreenName
     *     The recipient_screen_name
     */
    public void setRecipientScreenName(String recipientScreenName) {
        this.recipientScreenName = recipientScreenName;
    }

    /**
     * 
     * @return
     *     The sender
     */
    public Sender getSender() {
        return sender;
    }

    /**
     * 
     * @param sender
     *     The sender
     */
    public void setSender(Sender sender) {
        this.sender = sender;
    }

    /**
     * 
     * @return
     *     The senderId
     */
    public Integer getSenderId() {
        return senderId;
    }

    /**
     * 
     * @param senderId
     *     The sender_id
     */
    public void setSenderId(Integer senderId) {
        this.senderId = senderId;
    }

    /**
     * 
     * @return
     *     The senderScreenName
     */
    public String getSenderScreenName() {
        return senderScreenName;
    }

    /**
     * 
     * @param senderScreenName
     *     The sender_screen_name
     */
    public void setSenderScreenName(String senderScreenName) {
        this.senderScreenName = senderScreenName;
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.createdAt);
        dest.writeParcelable(this.entities, 0);
        dest.writeValue(this.id);
        dest.writeString(this.idStr);
        dest.writeParcelable(this.recipient, flags);
        dest.writeValue(this.recipientId);
        dest.writeString(this.recipientScreenName);
        dest.writeParcelable(this.sender, flags);
        dest.writeValue(this.senderId);
        dest.writeString(this.senderScreenName);
        dest.writeString(this.text);
    }

    public DirectMessage() {
    }

    protected DirectMessage(Parcel in) {
        this.createdAt = in.readString();
        this.entities = in.readParcelable(Entities.class.getClassLoader());
        this.id = (Integer) in.readValue(Integer.class.getClassLoader());
        this.idStr = in.readString();
        this.recipient = in.readParcelable(Recipient.class.getClassLoader());
        this.recipientId = (Integer) in.readValue(Integer.class.getClassLoader());
        this.recipientScreenName = in.readString();
        this.sender = in.readParcelable(Sender.class.getClassLoader());
        this.senderId = (Integer) in.readValue(Integer.class.getClassLoader());
        this.senderScreenName = in.readString();
        this.text = in.readString();
    }

    public static final Parcelable.Creator<DirectMessage> CREATOR = new Parcelable.Creator<DirectMessage>() {
        public DirectMessage createFromParcel(Parcel source) {
            return new DirectMessage(source);
        }

        public DirectMessage[] newArray(int size) {
            return new DirectMessage[size];
        }
    };

    public static List<DirectMessage> fromJSONArray(JSONArray json) {
        Type listType = new TypeToken<List<DirectMessage>>() {}.getType();
        Gson gson = new GsonBuilder().create();

        return (List<DirectMessage>) gson.fromJson(json.toString(), listType);

    }

    public static DirectMessage fromJSON(JSONObject json) {

        Gson gson = new GsonBuilder().create();

        return (DirectMessage) gson.fromJson(json.toString(), DirectMessage.class);

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
//                relativeDate = Integer.toString(Months.monthsBetween(createdDateTime.toLocalDateTime(), currentDateTime.toLocalDateTime()).getMonths())+"M";
                String dateFormat = "MM/dd/yyyy";
                SimpleDateFormat nf = new SimpleDateFormat(dateFormat);
                relativeDate = nf.format(sf.parse(getCreatedAt())).toString();

            }
        } catch (ParseException e) {
            e.printStackTrace();

        }


        return relativeDate;
    }
}
