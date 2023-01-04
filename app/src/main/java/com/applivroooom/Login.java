package com.applivroooom;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.applivroooom.data.DataExpert;
import com.applivroooom.outils.AccesHTTP;
import com.applivroooom.outils.AsyncResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Login extends AppCompatActivity implements AsyncResponse {

    private EditText username;
    private EditText password;
    private Button btnLogin;
    private static final String LOGINADDR = "http://192.168.1.6/appMobile/login.php";


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        init();
        ecouteLogin();
    }


    private void init() {
        username = findViewById(R.id.username_text);
        password = findViewById(R.id.password_text);
        btnLogin = findViewById(R.id.button_login);

    }


    private void ecouteLogin() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                ArrayList list = new ArrayList();
                list.add(username.getText());
                list.add(password.getText());

                //JSONArray json_array = new JSONArray(list);
                Log.d("test", "onClick: "+ list);

                requestLogin(list);

            }
        });
    }


    private void requestLogin(ArrayList donnee) {
        Log.d("request", "requestLogin: "+ donnee.get(0) + donnee.get(1));

        AccesHTTP accesDonnees = new AccesHTTP();
        accesDonnees.delegate = this;

        accesDonnees.addParams("login", donnee.get(0).toString());
        accesDonnees.addParams("password", donnee.get(1).toString());

        accesDonnees.execute(LOGINADDR);
    }

    @Override
    public void processFinish(String output) {
        Log.d("serveurlogin", "processFinish: "+ output);

        try {
            JSONObject reponse = new JSONObject(output);

            if (!reponse.getString("login").equals("False")) {
                Log.d("login", "login successful");

                DataExpert dataExpert = DataExpert.getInstance(output);

                Log.d("loginsuccess", "nom Expert: " + dataExpert.getNom());
                Log.d("loginsuccess", "prenom Expert: " + dataExpert.getPrenom());

                Intent intent = new Intent(getApplicationContext(), Accueil.class);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(this, "Mot de passe ou indentifiant incorect", Toast.LENGTH_SHORT).show();
            }
        } catch (JSONException e) {
            e.printStackTrace();
            Log.d("erreur", "erreurJSON: " +e);
        }


    }

}
