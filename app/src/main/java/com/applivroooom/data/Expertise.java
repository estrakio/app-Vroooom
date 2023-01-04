package com.applivroooom.data;

public class Expertise {

    private static Expertise instance;

    private String nom_piece;
    private String description;
    private String photo;

    public Expertise() {

    }

    public static synchronized Expertise new_expertise() {
        instance = new Expertise();
    return instance;
    }

    public static synchronized Expertise getInstance() {
        return instance;
    }

    public String getNom_piece() {
        return nom_piece;
    }

    public void setNom_piece(String nom_piece) {
        instance.nom_piece = nom_piece;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        instance.description = description;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        instance.photo = photo;
    }
}
