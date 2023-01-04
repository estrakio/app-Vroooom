package com.applivroooom.data;

public class Expertise {

    private static Expertise instance;

    private String piece;
    private String description;
    private String lienphoto;

    public Expertise() {

    }

    public static synchronized Expertise new_expertise() {
        instance = new Expertise();
    return instance;
    }

    public static synchronized Expertise getInstance() {
        return instance;
    }

    public String getPiece() {
        return piece;
    }

    public void setPiece(String piece) {
        instance.piece = piece;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        instance.description = description;
    }

    public String getLienphoto() {
        return lienphoto;
    }

    public void setLienphoto(String lienphoto) {
        instance.lienphoto = lienphoto;
    }
}
