package com.sample.comcast.model;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RelatedTopic implements Parcelable
{

    @SerializedName("Icon")
    @Expose
    private Icon icon;
    @SerializedName("FirstURL")
    @Expose
    private String firstURL;
    @SerializedName("Result")
    @Expose
    private String result;
    @SerializedName("Text")
    @Expose
    private String text;
    public final static Creator<RelatedTopic> CREATOR = new Creator<RelatedTopic>() {


        @SuppressWarnings({
                "unchecked"
        })
        public RelatedTopic createFromParcel(Parcel in) {
            return new RelatedTopic(in);
        }

        public RelatedTopic[] newArray(int size) {
            return (new RelatedTopic[size]);
        }

    }
            ;

    protected RelatedTopic(Parcel in) {
        this.icon = ((Icon) in.readValue((Icon.class.getClassLoader())));
        this.firstURL = ((String) in.readValue((String.class.getClassLoader())));
        this.result = ((String) in.readValue((String.class.getClassLoader())));
        this.text = ((String) in.readValue((String.class.getClassLoader())));
    }

    public RelatedTopic() {
    }

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public String getFirstURL() {
        return firstURL;
    }

    public void setFirstURL(String firstURL) {
        this.firstURL = firstURL;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(icon);
        dest.writeValue(firstURL);
        dest.writeValue(result);
        dest.writeValue(text);
    }

    public int describeContents() {
        return 0;
    }

}