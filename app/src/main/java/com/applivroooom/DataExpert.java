package com.applivroooom;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DataExpert {
    private static DataExpert instance;
    private String nom;
    private String prenom;
    private String societe;

    private DataExpert( String data) {

        JSONObject mainObject = null;
        JSONObject ExpertJson = null;

        try {
            mainObject = new JSONObject(data);
            ExpertJson = mainObject.getJSONObject("1");
            this.nom = ExpertJson.getString("nom");
            this.prenom = ExpertJson.getString("prenom");
            this.societe = ExpertJson.getString("societe");

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

    public String getSociete() {
        return societe;
    }
}
