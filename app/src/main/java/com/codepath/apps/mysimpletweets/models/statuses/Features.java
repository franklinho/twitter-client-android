
package com.codepath.apps.mysimpletweets.models.statuses;

import android.os.Parcel;
import android.os.Parcelable;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Features implements Parcelable {


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    public Features() {
    }

    protected Features(Parcel in) {
    }

    public static final Parcelable.Creator<Features> CREATOR = new Parcelable.Creator<Features>() {
        public Features createFromParcel(Parcel source) {
            return new Features(source);
        }

        public Features[] newArray(int size) {
            return new Features[size];
        }
    };
}
