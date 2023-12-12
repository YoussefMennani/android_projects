package com.iao.android_projects.tp4.Restaurant;

public class MenuRestaurantModel {

    Long id;
    int  image;
    double prix;
    String title;
    String description;

    public MenuRestaurantModel(Long id, int image, double prix,String title, String description) {
        this.id = id;
        this.image = image;
        this.prix = prix;
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public int getImage() {
        return image;
    }

    public double getPrix() {
        return prix;
    }

    public String getDescription() {
        return description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
