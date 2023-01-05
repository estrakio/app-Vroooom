package com.applivroooom.data;

import android.util.Log;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.google.gson.Gson;

public class Dossier {
    private static Dossier instance;
    private ArrayList<Expertise> list_expertise;
    private ArrayList<Expertise> new_list_expertise;

    private Dossier() {
        list_expertise = new ArrayList<Expertise>();
        new_list_expertise = new ArrayList<Expertise>();
    }

    public static synchronized Dossier new_dossier(String json) {
        Log.d("doss", "new_dossier: "+ json);
        if (instance == null) {
//            Log.d("dosstest", "new_dossier: "+ json.toString());
            instance = new Gson().fromJson(json, Dossier.class);

            if (Objects.equals(json, "null")) {
                Log.d("doss", "new_dossier: "+ json);
                instance = new Dossier();
            }
        }
        return instance;
    }

    public static synchronized Dossier getInstance() {
        return instance;
    }

    public List<Expertise> getList_expertise() {
        return list_expertise;
    }

    public ArrayList<Expertise> getNew_list_expertise() {
        return new_list_expertise;
    }

    public void add_expertise(Expertise expertise) {
        Log.d("expertise test", "add_expertise: "+ expertise.getDescription().toString());
        new_list_expertise.add(expertise);
    }
}
