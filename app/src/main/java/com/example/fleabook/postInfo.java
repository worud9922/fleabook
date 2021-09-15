package com.example.fleabook;

public class postInfo {

    private String writeUser;
    private String title;
    private String contents;
    private String price;

    public postInfo(String writeUser, String title,String contents,String price) {
        this.writeUser=writeUser;
        this.title=title;
        this.contents=contents;
        this.price=price;
    }

    public String getwriteUser() {
        return this.writeUser;
    }

    public void setwriteUser(String writeUser) {
        this.writeUser = writeUser;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return this.contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getPrice() {
        return this.price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
