package com.BmCollege.app.Home;

/**
 * Created by Vineet Jain on 13-02-2017.
 */

public class FirebaseModel {

    String image_url, title, file;

    public FirebaseModel() {
    }

    public FirebaseModel(String image_url, String title, String file) {

        this.image_url = image_url;
        this.title = title;
        this.file = file;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }
}
