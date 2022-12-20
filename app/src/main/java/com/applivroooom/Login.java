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

import com.applivroooom.outils.AccesHTTP;
import com.applivroooom.outils.AsyncResponse;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Login extends AppCompatActivity implements AsyncResponse {

    private EditText username;
    private EditText password;
    private static AccesDistant accesDistant;
    private static final String LOGINADDR = "http://192.168.1.6/appMobile/login.php";



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        init();
        ecouteLogin();
    }


    private void init() {
        username = (EditText) findViewById(R.id.username_text);
        password = (EditText) findViewById(R.id.password_text);

        accesDistant = new AccesDistant();

    }


    private void ecouteLogin() {
        ((Button) findViewById(R.id.button_login)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(Login.this, password.getText(), Toast.LENGTH_SHORT).show();

                ArrayList list = new ArrayList();
                list.add(username.getText());
                list.add(password.getText());

                //JSONArray json_array = new JSONArray(list);
                Log.d("test", "onClick: "+ list);

                requestLogin(list);

            }
        });
    }


    public void requestLogin(ArrayList donnee) {
        Log.d("request", "envoi: "+ donnee.get(0));

        AccesHTTP accesDonnees = new AccesHTTP();
        accesDonnees.delegate = this;

        accesDonnees.addParams("login", donnee.get(0).toString());
        accesDonnees.addParams("password", donnee.get(1).toString());

        accesDonnees.execute(LOGINADDR);
    }

    @Override
    public void processFinish(String output) {
        Log.d("serveurlogin", "processFinish: "+ output);

        String message = output;

        if (Objects.equals(message, "{\"login\":\"True\"}")) {
            Log.d("login", "login successful");

            Intent intent = new Intent(getApplicationContext(), Accueil.class);
            startActivity(intent);
            finish();
        }
    }

}
