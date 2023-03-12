package com.example.news;

public class Item {
    String title,author,content,img_url,tags;
    int pub_date;
    public Item(String title, String author, int pub_date, String content, String img_url, String tags) {
        this.title = title;
        this.author = author;
        this.content = content;
        this.img_url = img_url;
        this.tags = tags;
        this.pub_date = pub_date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getTag() {
        return tags;
    }

    public void setTag(String tag) {
        this.tags = tag;
    }

    public int getDate() {
        return pub_date;
    }

    public void setDate(int date) {
        this.pub_date = date;
    }
}
