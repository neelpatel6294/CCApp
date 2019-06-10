package com.sample.comcast.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Icon implements Parcelable
{

    @SerializedName("Height")
    @Expose
    private String height;
    @SerializedName("Width")
    @Expose
    private String width;
    @SerializedName("URL")
    @Expose
    private String uRL;
    public final static Creator<Icon> CREATOR = new Creator<Icon>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Icon createFromParcel(Parcel in) {
            return new Icon(in);
        }

        public Icon[] newArray(int size) {
            return (new Icon[size]);
        }

    }
            ;

    protected Icon(Parcel in) {
        this.height = ((String) in.readValue((String.class.getClassLoader())));
        this.width = ((String) in.readValue((String.class.getClassLoader())));
        this.uRL = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Icon() {
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getURL() {
        return uRL;
    }

    public void setURL(String uRL) {
        this.uRL = uRL;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(height);
        dest.writeValue(width);
        dest.writeValue(uRL);
    }

    public int describeContents() {
        return 0;
    }

}