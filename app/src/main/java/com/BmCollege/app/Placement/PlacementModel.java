package com.BmCollege.app.Placement;

/**
 * Created by Vineet Jain on 21-02-2017.
 */

public class PlacementModel {

    String place_img, place_title, place_file;

    public PlacementModel() {

    }

    public PlacementModel(String place_img, String place_title, String place_file) {
        this.place_img = place_img;
        this.place_title = place_title;
        this.place_file = place_file;
    }

    public String getPlace_img() {

        return place_img;
    }

    public void setPlace_img(String place_img) {
        this.place_img = place_img;
    }

    public String getPlace_title() {
        return place_title;
    }

    public void setPlace_title(String place_title) {
        this.place_title = place_title;
    }

    public String getPlace_file() {
        return place_file;
    }

    public void setPlace_file(String place_file) {
        this.place_file = place_file;
    }
}