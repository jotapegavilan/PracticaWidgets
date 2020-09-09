package com.gavilan.practica_widgets;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText txtNombre;
    private Button btnValorar;
    private RadioGroup radioGroup;
    private CheckBox checkBox;
    private RatingBar ratingBar;
    private boolean NombreOk = false;
    private boolean RadioOk = false;
    private String RbSelect;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtNombre = findViewById(R.id.txtNombre);
        btnValorar = findViewById(R.id.btnValorar);
        radioGroup = findViewById(R.id.radioGroup);
        checkBox = findViewById(R.id.checkBox);
        ratingBar = findViewById(R.id.ratingBar);

        ratingBar.setEnabled(false);
        btnValorar.setEnabled(false);
        checkBox.setEnabled(false);

        btnValorar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre = txtNombre.getText().toString();
                float rating = ratingBar.getRating();
                boolean recomienda = checkBox.isChecked();
                if(RbSelect == "SI"){
                    String loRecomienda;
                    if(recomienda == true){
                        loRecomienda = "Si";
                    }else{
                        loRecomienda = "No";
                    }
                    Toast.makeText(MainActivity.this,
                            "Nombre: "+nombre+"\nConoce firefox: "+RbSelect+
                            "\nRating: "+rating+"\nRecomienda firefox: "+loRecomienda,
                            Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(MainActivity.this,
                            "Nombre: "+nombre+"\nConoce firefox: "+RbSelect,
                            Toast.LENGTH_LONG).show();
                }

            }
        });


        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i == R.id.btnSi){
                    ratingBar.setEnabled(true);
                    checkBox.setEnabled(true);
                    RbSelect = "SI";
                }else{
                    ratingBar.setRating(0);
                    ratingBar.setEnabled(false);
                    checkBox.setChecked(false);
                    checkBox.setEnabled(false);
                    RbSelect = "NO";
                }
                RadioOk = true;
                if(NombreOk == true){
                    btnValorar.setEnabled(true);
                }

            }
        });

        txtNombre.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Toast.makeText(MainActivity.this,
                        "Texto: "+charSequence,
                        Toast.LENGTH_SHORT).show();
                if(charSequence.length() < 3){
                    txtNombre.setError("El nombre es muy corto");
                    NombreOk = false;
                    btnValorar.setEnabled(false);

                }else{
                    NombreOk = true;
                    if(RadioOk == true){
                        btnValorar.setEnabled(true);
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });










    }
}