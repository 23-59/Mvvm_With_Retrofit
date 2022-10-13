package com.a_23_59.mvvmwithretrofit;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "articles")
public class Article {

    public void setImage(String image) {
        this.image = image;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    private String image;
    private String country;
    private String author;
    private String description;
    private String language;
    private String source;
    private String title;
    private String category;
    private String publishedAt;
    @NonNull
    @PrimaryKey()
    private String url;

    public String getImage(){
        return image;
    }

    public String getCountry(){
        return country;
    }

    public String getAuthor(){
        return author;
    }

    public String getDescription(){
        return description;
    }

    public String getLanguage(){
        return language;
    }

    public String getSource(){
        return source;
    }

    public String getTitle(){
        return title;
    }

    public String getCategory(){
        return category;
    }

    public String getPublishedAt(){
        return publishedAt;
    }

    public String getUrl(){
        return url;
    }

}
