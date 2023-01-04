package com.applivroooom.data;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class Dossier {
    private static Dossier instance;
    private ArrayList<Expertise> list_expertise;

    private Dossier(String json) {
        list_expertise = new ArrayList<Expertise>();

        // ObjectMapper instantiation
        ObjectMapper objectMapper = new ObjectMapper();

        // Deserialization into the `Employee` class
        Dossier dossier = objectMapper.readValue(json, Dossier.class);

        System.out.println(dossier);
    }

    public static synchronized Dossier new_dossier(String json) {
        if (instance == null) {
            instance = new Dossier(json);
        }
        return instance;
    }

    public static synchronized Dossier getInstance() {
        return instance;
    }

    public List<Expertise> getList_expertise() {
        return list_expertise;
    }

    public void add_expertise(Expertise expertise) {
        Log.d("expertise test", "add_expertise: "+ expertise.getDescription().toString());
        list_expertise.add(expertise);
    }
}
