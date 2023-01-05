package com.applivroooom.data;

import org.json.JSONException;
import org.json.JSONObject;

public class DataVoiture {

    private static DataVoiture instance;
    private String plaque_d_immatriculation;
    private String couleur;
    private String nommodele;
    private String nom;
    private String prenom;
    private String datedebutlocation;
    private String dureelocation;
    private String datefinlocation;
    private String idmarque;

    private DataVoiture( String data) {

        try {
            JSONObject mainObject = new JSONObject(data);
            JSONObject ExpertJson = mainObject.getJSONObject("dataVehicule");
            this.plaque_d_immatriculation = ExpertJson.getString("plaque_d_immatriculation");
            this.couleur = ExpertJson.getString("couleur");
            this.nommodele = ExpertJson.getString("nommodele");
            this.nom = ExpertJson.getString("nom");
            this.prenom = ExpertJson.getString("prenom");
            this.datedebutlocation = ExpertJson.getString("datedebutlocation");
            this.dureelocation = ExpertJson.getString("dureelocation");
            this.datefinlocation = ExpertJson.getString("datefinlocation");
            this.idmarque = ExpertJson.getString("idmarque");

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public static synchronized DataVoiture getInstance(String data) {
        if (instance == null) {
            instance = new DataVoiture(data);
        }
        return instance;
    }

    public void eraseInstance() {
        instance = null;
    }

    public String getPlaque_d_immatriculation() {
        return plaque_d_immatriculation;
    }

    public String getCouleur() {
        return couleur;
    }

    public String getNommodele() {
        return nommodele;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getDatedebutlocation() {
        return datedebutlocation;
    }

    public String getDureelocation() {
        return dureelocation;
    }

    public String getDatefinlocation() {
        return datefinlocation;
    }

    public String getIdmarque() {
        return idmarque;
    }
}
