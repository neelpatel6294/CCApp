package com.sample.comcast.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class One implements Parcelable
{

    @SerializedName("AbstractSource")
    @Expose
    private String abstractSource;
    @SerializedName("ImageHeight")
    @Expose
    private Integer imageHeight;
    @SerializedName("RelatedTopics")
    @Expose
    private List<RelatedTopic> relatedTopics = null;
    @SerializedName("ImageIsLogo")
    @Expose
    private Integer imageIsLogo;
    @SerializedName("DefinitionSource")
    @Expose
    private String definitionSource;
    @SerializedName("AbstractURL")
    @Expose
    private String abstractURL;
    @SerializedName("Results")
    @Expose
    private List<Object> results = null;
    @SerializedName("Answer")
    @Expose
    private String answer;
    @SerializedName("Entity")
    @Expose
    private String entity;
    @SerializedName("AbstractText")
    @Expose
    private String abstractText;
    @SerializedName("Infobox")
    @Expose
    private String infobox;
    @SerializedName("DefinitionURL")
    @Expose
    private String definitionURL;
    @SerializedName("Image")
    @Expose
    private String image;
    @SerializedName("Abstract")
    @Expose
    private String _abstract;
    @SerializedName("meta")
    @Expose
    private Meta meta;
    @SerializedName("Redirect")
    @Expose
    private String redirect;
    @SerializedName("Type")
    @Expose
    private String type;
    @SerializedName("ImageWidth")
    @Expose
    private Integer imageWidth;
    @SerializedName("AnswerType")
    @Expose
    private String answerType;
    @SerializedName("Definition")
    @Expose
    private String definition;
    @SerializedName("Heading")
    @Expose
    private String heading;
    public final static Creator<One> CREATOR = new Creator<One>() {


        @SuppressWarnings({
                "unchecked"
        })
        public One createFromParcel(Parcel in) {
            return new One(in);
        }

        public One[] newArray(int size) {
            return (new One[size]);
        }

    }
            ;

    protected One(Parcel in) {
        this.abstractSource = ((String) in.readValue((String.class.getClassLoader())));
        this.imageHeight = ((Integer) in.readValue((Integer.class.getClassLoader())));
        in.readList(this.relatedTopics, (RelatedTopic.class.getClassLoader()));
        this.imageIsLogo = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.definitionSource = ((String) in.readValue((String.class.getClassLoader())));
        this.abstractURL = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.results, (Object.class.getClassLoader()));
        this.answer = ((String) in.readValue((String.class.getClassLoader())));
        this.entity = ((String) in.readValue((String.class.getClassLoader())));
        this.abstractText = ((String) in.readValue((String.class.getClassLoader())));
        this.infobox = ((String) in.readValue((String.class.getClassLoader())));
        this.definitionURL = ((String) in.readValue((String.class.getClassLoader())));
        this.image = ((String) in.readValue((String.class.getClassLoader())));
        this._abstract = ((String) in.readValue((String.class.getClassLoader())));
        this.meta = ((Meta) in.readValue((Meta.class.getClassLoader())));
        this.redirect = ((String) in.readValue((String.class.getClassLoader())));
        this.type = ((String) in.readValue((String.class.getClassLoader())));
        this.imageWidth = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.answerType = ((String) in.readValue((String.class.getClassLoader())));
        this.definition = ((String) in.readValue((String.class.getClassLoader())));
        this.heading = ((String) in.readValue((String.class.getClassLoader())));
    }

    public One() {
    }

    public String getAbstractSource() {
        return abstractSource;
    }

    public void setAbstractSource(String abstractSource) {
        this.abstractSource = abstractSource;
    }

    public Integer getImageHeight() {
        return imageHeight;
    }

    public void setImageHeight(Integer imageHeight) {
        this.imageHeight = imageHeight;
    }

    public List<RelatedTopic> getRelatedTopics() {
        return relatedTopics;
    }

    public void setRelatedTopics(List<RelatedTopic> relatedTopics) {
        this.relatedTopics = relatedTopics;
    }

    public Integer getImageIsLogo() {
        return imageIsLogo;
    }

    public void setImageIsLogo(Integer imageIsLogo) {
        this.imageIsLogo = imageIsLogo;
    }

    public String getDefinitionSource() {
        return definitionSource;
    }

    public void setDefinitionSource(String definitionSource) {
        this.definitionSource = definitionSource;
    }

    public String getAbstractURL() {
        return abstractURL;
    }

    public void setAbstractURL(String abstractURL) {
        this.abstractURL = abstractURL;
    }

    public List<Object> getResults() {
        return results;
    }

    public void setResults(List<Object> results) {
        this.results = results;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public String getAbstractText() {
        return abstractText;
    }

    public void setAbstractText(String abstractText) {
        this.abstractText = abstractText;
    }

    public String getInfobox() {
        return infobox;
    }

    public void setInfobox(String infobox) {
        this.infobox = infobox;
    }

    public String getDefinitionURL() {
        return definitionURL;
    }

    public void setDefinitionURL(String definitionURL) {
        this.definitionURL = definitionURL;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAbstract() {
        return _abstract;
    }

    public void setAbstract(String _abstract) {
        this._abstract = _abstract;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public String getRedirect() {
        return redirect;
    }

    public void setRedirect(String redirect) {
        this.redirect = redirect;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getImageWidth() {
        return imageWidth;
    }

    public void setImageWidth(Integer imageWidth) {
        this.imageWidth = imageWidth;
    }

    public String getAnswerType() {
        return answerType;
    }

    public void setAnswerType(String answerType) {
        this.answerType = answerType;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(abstractSource);
        dest.writeValue(imageHeight);
        dest.writeList(relatedTopics);
        dest.writeValue(imageIsLogo);
        dest.writeValue(definitionSource);
        dest.writeValue(abstractURL);
        dest.writeList(results);
        dest.writeValue(answer);
        dest.writeValue(entity);
        dest.writeValue(abstractText);
        dest.writeValue(infobox);
        dest.writeValue(definitionURL);
        dest.writeValue(image);
        dest.writeValue(_abstract);
        dest.writeValue(meta);
        dest.writeValue(redirect);
        dest.writeValue(type);
        dest.writeValue(imageWidth);
        dest.writeValue(answerType);
        dest.writeValue(definition);
        dest.writeValue(heading);
    }

    public int describeContents() {
        return 0;
    }

}