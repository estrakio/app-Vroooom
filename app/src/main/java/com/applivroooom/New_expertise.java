package com.applivroooom;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class New_expertise extends AppCompatActivity {

    private EditText txt_piece;
    private EditText txt_description;
    private Button btn_photo;
    private Button btn_valider;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_expertise);

        init();
        ecouteEnvoie();
        ecoutePhoto();
    }

    private void init() {
        btn_photo = findViewById(R.id.btn_photo);
        btn_valider = findViewById(R.id.btn_valider);
        txt_piece = findViewById(R.id.edtxt_piece);
        txt_description = findViewById(R.id.edtxt_description);
    }

    private void ecoutePhoto() {
        btn_photo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Toast.makeText(New_expertise.this, "photo", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void ecouteEnvoie() {
        btn_valider.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Toast.makeText(New_expertise.this, "Envoie", Toast.LENGTH_SHORT).show();

                finish();
            }
        });
    }
}
