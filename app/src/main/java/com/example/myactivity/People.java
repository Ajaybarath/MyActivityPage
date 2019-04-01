package com.example.myactivity;

public class People {

    String name;
    String image;

    People(String name, String image){

        this.name = name;
        this.image = image;

    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
