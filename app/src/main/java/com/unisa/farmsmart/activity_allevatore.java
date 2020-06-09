package com.unisa.farmsmart;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class activity_allevatore extends AppCompatActivity {
    TextView livelloMangiatoie;
    ProgressBar mangiatoieProgressBar;
    Switch switchMangiatoie;
    Switch switchCancelli;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allevatore);

        livelloMangiatoie = findViewById(R.id.livelloMangiatoie);
        mangiatoieProgressBar = findViewById(R.id.mangiatoieProgressBar);
        switchMangiatoie = findViewById(R.id.switchMangiatoie);
        switchCancelli = findViewById(R.id.switchCancelli);

        // ProgressBar logic
        Random random = new Random();
        int randomNumber = random.nextInt(100);
        mangiatoieProgressBar.setProgress(randomNumber);
        if(randomNumber >= 30) {
            livelloMangiatoie.setText("MANGIATOIA PIENA");
            livelloMangiatoie.setTextColor(Color.GREEN);
            mangiatoieProgressBar.setProgressTintList(ColorStateList.valueOf(Color.GREEN));
        }
        else {
            livelloMangiatoie.setTextColor(Color.RED);
            mangiatoieProgressBar.setProgressTintList(ColorStateList.valueOf(Color.RED));
            if(randomNumber < 30)
                livelloMangiatoie.setText("MANGIATOIA SCARSA");
        }
        // END ProgressBar

        // Switch Logic
        // On Activity opening check the status
        if(switchMangiatoie.isChecked() == false)
            switchMangiatoie.setText("Spento");
        else
            switchMangiatoie.setText("Acceso");

        if(switchCancelli.isChecked() == false)
            switchCancelli.setText("Spento");
        else
            switchCancelli.setText("Acceso");

        // OnAction Change
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);

        switchMangiatoie.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked == false)
                {
                    alertBuilder.setTitle("MANGIATOIE");
                    alertBuilder.setMessage("Le mangiatoie sono state chiuse");
                    AlertDialog alert = alertBuilder.create();
                    alert.show();
                    switchMangiatoie.setText("Spento");
                }
                else
                {
                    alertBuilder.setTitle("MANGIATOIE");
                    alertBuilder.setMessage("Le mangiatoie sono state aperte");
                    AlertDialog alert = alertBuilder.create();
                    alert.show();
                    switchMangiatoie.setText("Acceso");
                }
            }
        });

        switchCancelli.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked == false) {
                    alertBuilder.setTitle("CANCELLI");
                    alertBuilder.setMessage("I cancelli sono stati chiusi");
                    AlertDialog alert = alertBuilder.create();
                    alert.show();
                    switchCancelli.setText("Spento");
                }else {
                    alertBuilder.setTitle("CANCELLI");
                    alertBuilder.setMessage("I cancelli sono stati aperti");
                    AlertDialog alert = alertBuilder.create();
                    alert.show();
                    switchCancelli.setText("Acceso");
                }
            }
        });

        // END Switch
    }
}
