package com.applivroooom.data;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class Dossier {
    private static Dossier instance;
    private ArrayList<Expertise> list_expertise;

    private Dossier() {
        list_expertise = new ArrayList<Expertise>();

    }

    public static synchronized Dossier new_dossier() {
        if (instance == null) {
            instance = new Dossier();
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
