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
            JSONObject ExpertJson = mainObject.getJSONObject("login");
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




}
