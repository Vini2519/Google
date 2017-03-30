package com.BmCollege.app.Syllabus;

/**
 * Created by Vineet Jain on 27-02-2017.
 */

public class SyllabusFirebaseModel {
    String images,link;
    String titles;

    public SyllabusFirebaseModel(){

    }

    public SyllabusFirebaseModel(String images, String link, String titles) {
        this.images = images;
        this.link = link;
        this.titles = titles;
    }

    public String getImages() {

        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTitles() {
        return titles;
    }

    public void setTitles(String titles) {
        this.titles = titles;
    }
}
