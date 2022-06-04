package com.example.projectadvance1.object;

public class ContactAS {
    private int idAS;
    private String phoneAS;
    private String emailAS;
    private String AboutUs;

    public ContactAS(int idAS, String phoneAS, String emailAS, String aboutUs) {
        this.idAS = idAS;
        this.phoneAS = phoneAS;
        this.emailAS = emailAS;
        this.AboutUs = aboutUs;
    }

    public int getIdAS() {
        return idAS;
    }

    public void setIdAS(int idAS) {
        this.idAS = idAS;
    }

    public String getPhoneAS() {
        return phoneAS;
    }

    public void setPhoneAS(String phoneAS) {
        this.phoneAS = phoneAS;
    }

    public String getEmailAS() {
        return emailAS;
    }

    public void setEmailAS(String emailAS) {
        this.emailAS = emailAS;
    }

    public String getAboutUs() {
        return AboutUs;
    }

    public void setAboutUs(String aboutUs) {
        AboutUs = aboutUs;
    }
}
