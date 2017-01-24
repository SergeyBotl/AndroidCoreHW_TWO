package com.example.sergey.lesson12_newspaper;

import android.os.Parcel;
import android.os.Parcelable;

public class Newspaper implements Parcelable {
    private long id;
    private String titleArticle;
    private String article;

    public Newspaper( String titleArticle, String article) {
        this.titleArticle = titleArticle;
        this.article = article;
    }

    protected Newspaper(Parcel in) {
        id = in.readLong();
        titleArticle = in.readString();
        article = in.readString();
    }

    public static final Creator<Newspaper> CREATOR = new Creator<Newspaper>() {
        @Override
        public Newspaper createFromParcel(Parcel in) {
            return new Newspaper(in);
        }

        @Override
        public Newspaper[] newArray(int size) {
            return new Newspaper[size];
        }
    };

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitleArticle() {
        return titleArticle;
    }

    public String getArticle() {
        return article;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(id);
        parcel.writeString(titleArticle);
        parcel.writeString(article);
    }
}
