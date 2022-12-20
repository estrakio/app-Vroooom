package com.applivroooom;

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

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class Login extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private static AccesDistant accesDistant;


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

                accesDistant.login(list);

            }
        });
    }

}
