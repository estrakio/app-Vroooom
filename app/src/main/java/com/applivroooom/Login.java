package com.applivroooom;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        init();
    }

    private EditText username;
    private EditText password;


    private void init() {
        username = (EditText) findViewById(R.id.username_text);
        password = (EditText) findViewById(R.id.password_text);

        //this.controle = Controle.getInstance(this);
        //ecouteCalcul();
        //recupProfil();
    }

}
