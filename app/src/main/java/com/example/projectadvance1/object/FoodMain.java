package com.example.projectadvance1.object;

public class FoodMain {
    private String nameFood;
    private int imgFood;
    private int imgStar;
    private String moTa;
    private int coverPhoto;

    public FoodMain(String nameFood, int imgFood, int coverPhoto) {
        this.nameFood = nameFood;
        this.imgFood = imgFood;
        this.coverPhoto = coverPhoto;
    }

    public FoodMain(int imgFood, String nameFood,int imgStar, String moTa, int coverPhoto) {
        this.nameFood = nameFood;
        this.imgFood = imgFood;
        this.coverPhoto = coverPhoto;
        this.imgStar = imgStar;
        this.moTa = moTa;
    }

    public FoodMain(int imgFood, String nameFood, int imgStar, String moTa) {
        this.imgFood = imgFood;
        this.nameFood = nameFood;
        this.imgStar = imgStar;
        this.moTa = moTa;
    }

    public int getCoverPhoto() {
        return coverPhoto;
    }

    public void setCoverPhoto(int coverPhoto) {
        this.coverPhoto = coverPhoto;
    }

    public String getNameFood() {
        return nameFood;
    }

    public void setNameFood(String nameFood) {
        this.nameFood = nameFood;
    }

    public int getImgFood() {
        return imgFood;
    }

    public void setImgFood(int imgFood) {
        this.imgFood = imgFood;
    }

    public int getImgStar() {
        return imgStar;
    }

    public void setImgStar(int imgStar) {
        this.imgStar = imgStar;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
}
