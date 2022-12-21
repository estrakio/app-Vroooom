package com.applivroooom.data;

import org.json.JSONException;
import org.json.JSONObject;

public class DataExpert {
    private static DataExpert instance;
    private String nom;
    private String prenom;

    private DataExpert( String data) {

        try {
            JSONObject mainObject = new JSONObject(data);
            JSONObject ExpertJson = mainObject.getJSONObject("login");
            this.nom = ExpertJson.getString("nom");
            this.prenom = ExpertJson.getString("prenom");

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public static synchronized DataExpert getInstance(String data) {
        if (instance == null) {
            instance = new DataExpert(data);
        }
        return instance;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

}
