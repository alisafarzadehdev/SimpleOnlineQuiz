package com.alisafarzadeh.rejimghazaei.Adapters;

public class Article {
    String title;
    String content;
    String img;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Article(String title, String content, String img) {
        this.title = title;
        this.content = content;
        this.img = img;
    }

    public Article(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
