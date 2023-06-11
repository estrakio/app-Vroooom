package com.applivroooom;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.applivroooom.data.Dossier;
import com.applivroooom.data.Expertise;

import java.io.ByteArrayOutputStream;

public class   New_expertise extends AppCompatActivity {

    public static final int CAMERA_ACTION_CODE= 1;
    private EditText txt_piece;
    private EditText txt_description;
    private String photo;
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
//                Toast.makeText(New_expertise.this, "photo", Toast.LENGTH_SHORT).show();

                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                ActivityCompat.startActivityForResult(New_expertise.this, cameraIntent, CAMERA_ACTION_CODE, null);
            }
        });
    }

    private void ecouteEnvoie() {
        btn_valider.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

//                Toast.makeText(New_expertise.this, "Envoie", Toast.LENGTH_SHORT).show();

                Dossier dossier = Dossier.getInstance();
                Expertise expertise = Expertise.new_expertise();


                expertise.setPiece(txt_piece.getText().toString());
                Log.d("expertise", "onClick: "+ expertise.getPiece().toString());
                expertise.setDescription(txt_description.getText().toString());
                Log.d("expertise", "onClick: "+ expertise.getDescription().toString());
                expertise.setLienphoto(photo);

                dossier.add_expertise(expertise);

                Log.d("dossier", "onClick: "+ dossier.getNew_list_expertise().get(0).getPiece().toString());

                Intent intent = new Intent(getApplicationContext(), Rapport.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAMERA_ACTION_CODE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap image = (Bitmap) extras.get("data");

            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            image.compress(Bitmap.CompressFormat.JPEG, 100, stream);
            byte[] imageBytes = stream.toByteArray();

            photo = Base64.encodeToString(imageBytes, Base64.DEFAULT);
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
