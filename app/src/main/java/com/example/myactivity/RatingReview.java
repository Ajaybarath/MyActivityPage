package com.example.myactivity;

public class RatingReview {

    private int rating;
    private String name, review, image;

    RatingReview(int rating, String name, String review, String image){

        this.review = review;
        this.rating = rating;
        this.name = name;
        this.image = image;

    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getRating() {
        return rating;
    }

    public String getName() {
        return name;
    }

    public String getReview() {
        return review;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setReview(String review) {
        this.review = review;
    }

}
