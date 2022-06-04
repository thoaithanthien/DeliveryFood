package com.example.projectadvance1.object;

public class FragmentCakes {
    private int imgFood;
    private String nameFood;
    private int imgStar;
    private String moTa;

    public FragmentCakes(int imgFood, String nameFood, int imgStar, String moTa) {
        this.imgFood = imgFood;
        this.nameFood = nameFood;
        this.imgStar = imgStar;
        this.moTa = moTa;
    }

    public int getImgFood() {
        return imgFood;
    }

    public void setImgFood(int imgFood) {
        this.imgFood = imgFood;
    }

    public String getNameFood() {
        return nameFood;
    }

    public void setNameFood(String nameFood) {
        this.nameFood = nameFood;
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
