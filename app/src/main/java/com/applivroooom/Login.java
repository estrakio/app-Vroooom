package com.applivroooom;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        ecouteLogin();
        init();
    }

    private EditText username;
    private EditText password;


    private void init() {
        username = (EditText) findViewById(R.id.username_text);
        password = (EditText) findViewById(R.id.password_text);

    }


    private void ecouteLogin() {
        ((Button) findViewById(R.id.button_login)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(Login.this, "test", Toast.LENGTH_SHORT).show();


            }
        });
    }

}
