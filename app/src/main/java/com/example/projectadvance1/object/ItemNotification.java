package com.example.projectadvance1.object;

public class ItemNotification {

    private int idNotification;
    private String titleNotification;
    private String descriptionNotification;
    private String dateNotification;
    private String imgNotification;

    public ItemNotification(int idNotification, String titleNotification, String descriptionNotification, String dateNotification, String imgNotification) {
        this.idNotification = idNotification;
        this.titleNotification = titleNotification;
        this.descriptionNotification = descriptionNotification;
        this.dateNotification = dateNotification;
        this.imgNotification = imgNotification;
    }

    public int getIdNotification() {
        return idNotification;
    }

    public void setIdNotification(int idNotification) {
        this.idNotification = idNotification;
    }

    public String getTitleNotification() {
        return titleNotification;
    }

    public void setTitleNotification(String titleNotification) {
        this.titleNotification = titleNotification;
    }

    public String getDescriptionNotification() {
        return descriptionNotification;
    }

    public void setDescriptionNotification(String descriptionNotification) {
        this.descriptionNotification = descriptionNotification;
    }

    public String getDateNotification() {
        return dateNotification;
    }

    public void setDateNotification(String dateNotification) {
        this.dateNotification = dateNotification;
    }

    public String getImgNotification() {
        return imgNotification;
    }

    public void setImgNotification(String imgNotification) {
        this.imgNotification = imgNotification;
    }
}
