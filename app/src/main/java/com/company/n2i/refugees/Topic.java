package com.company.n2i.refugees;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by julien on 02/12/16.
 */

public class Topic implements Serializable{

    public String id;
    public String CategorieName;
    public String CategorieFrench;
    public Byte[] CategorieImage;
    public String Titre;
    public String Contenu;
    public Double lat;
    public Double lng;
    public String Adresse;
    public String DateEvent;
    public String ContactTel;
    public String ContactMail;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategorieName() {
        return CategorieName;
    }

    public void setCategorieName(String categorieName) {
        CategorieName = categorieName;
    }

    public Byte[] getCategorieImage() {
        return CategorieImage;
    }

    public void setCategorieImage(Byte[] categorieImage) {
        CategorieImage = categorieImage;
    }

    public String getTitre() {
        return Titre;
    }

    public void setTitre(String titre) {
        Titre = titre;
    }

    public String getContenu() {
        return Contenu;
    }

    public void setContenu(String contenu) {
        Contenu = contenu;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public String getAdresse() {
        return Adresse;
    }

    public void setAdresse(String adresse) {
        Adresse = adresse;
    }

    public String getDateEvent() {
        return DateEvent;
    }

    public void setDateEvent(String dateEvent) {
        DateEvent = dateEvent;
    }

    public String getContactTel() {
        return ContactTel;
    }

    public void setContactTel(String contactTel) {
        ContactTel = contactTel;
    }

    public String getContactMail() {
        return ContactMail;
    }

    public void setContactMail(String contactMail) {
        ContactMail = contactMail;
    }

    public String getCategorieFrench() {
        return CategorieFrench;
    }

    public void setCategorieFrench(String categorieFrench) {
        CategorieFrench = categorieFrench;
    }

}
