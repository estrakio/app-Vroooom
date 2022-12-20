package com.applivroooom;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.applivroooom.outils.AccesHTTP;
import com.applivroooom.outils.AsyncResponse;

import java.util.ArrayList;
import java.util.Objects;

public class AccesDistant implements AsyncResponse {

    private static final String LOGINADDR = "http://192.168.1.6/appMobile/login.php";

    public AccesDistant() {
        super();

    }

    
    @Override
    public void processFinish(String output) {
        Log.d("serveur", "processFinish: "+ output);

        String message = output;

        if (Objects.equals(message, "True")) {
            Log.d("login", "login successful");


        }
    }

    public void login(ArrayList donnee) {
        Log.d("request", "envoi: "+ donnee.get(0));

        AccesHTTP accesDonnees = new AccesHTTP();
        accesDonnees.delegate = this;

        accesDonnees.addParams("login", donnee.get(0).toString());
        accesDonnees.addParams("password", donnee.get(1).toString());

        accesDonnees.execute(LOGINADDR);
    }
}
