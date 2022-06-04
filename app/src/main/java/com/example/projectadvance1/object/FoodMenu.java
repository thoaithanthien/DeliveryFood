package com.example.projectadvance1.object;

public class FoodMenu {
    private int imgMenu;
    private String nameMenu;
    private String priceMenu;
    private String moTaMenu;
    private String titleMenuCollapse;
    private int imgMenuCollapse;
    private int imgTitleMenu;
    private int imgCover;

    public FoodMenu(int imgMenu, String nameMenu, String priceMenu, String moTaMenu, String titleMenuCollapse, int imgMenuCollapse, int imgTitleMenu, int imgCover) {
        this.imgMenu = imgMenu;
        this.nameMenu = nameMenu;
        this.priceMenu = priceMenu;
        this.moTaMenu = moTaMenu;
        this.titleMenuCollapse = titleMenuCollapse;
        this.imgMenuCollapse = imgMenuCollapse;
        this.imgTitleMenu = imgTitleMenu;
        this.imgCover = imgCover;
    }

    public int getImgCover() {
        return imgCover;
    }

    public void setImgCover(int imgCover) {
        this.imgCover = imgCover;
    }

    public int getImgMenu() {
        return imgMenu;
    }

    public void setImgMenu(int imgMenu) {
        this.imgMenu = imgMenu;
    }

    public String getNameMenu() {
        return nameMenu;
    }

    public void setNameMenu(String nameMenu) {
        this.nameMenu = nameMenu;
    }

    public String getPriceMenu() {
        return priceMenu;
    }

    public void setPriceMenu(String priceMenu) {
        this.priceMenu = priceMenu;
    }

    public String getMoTaMenu() {
        return moTaMenu;
    }

    public void setMoTaMenu(String moTaMenu) {
        this.moTaMenu = moTaMenu;
    }

    public String getTitleMenuCollapse() {
        return titleMenuCollapse;
    }

    public void setTitleMenuCollapse(String titleMenuCollapse) {
        this.titleMenuCollapse = titleMenuCollapse;
    }

    public int getImgMenuCollapse() {
        return imgMenuCollapse;
    }

    public void setImgMenuCollapse(int imgMenuCollapse) {
        this.imgMenuCollapse = imgMenuCollapse;
    }

    public int getImgTitleMenu() {
        return imgTitleMenu;
    }

    public void setImgTitleMenu(int imgTitleMenu) {
        this.imgTitleMenu = imgTitleMenu;
    }
}
