package com.unisa.farmsmart;

import android.annotation.SuppressLint;
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

public class activity_agricoltore extends AppCompatActivity {

    TextView temperatura;
    TextView livelloUmidita;
    TextView livelloBiologica;
    TextView livelloInquinanti;
    ProgressBar umiditaProgressBar;
    ProgressBar biologicaProgressBar;
    ProgressBar inquinantiProgressBar;
    Switch switchIrrigatori;
    Switch switchAspiratori;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agricoltore);

        temperatura = findViewById(R.id.temperatura);
        umiditaProgressBar = findViewById(R.id.umiditaProgressBar);
        switchIrrigatori = findViewById(R.id.switchIrrigatori);
        switchAspiratori = findViewById(R.id.switchAspiratori);
        livelloUmidita = findViewById(R.id.livelloUmidita);
        livelloBiologica = findViewById(R.id.textBiologica);
        livelloInquinanti = findViewById(R.id.textInquinanti);
        biologicaProgressBar = findViewById(R.id.biologicaProgressBar);
        inquinantiProgressBar = findViewById(R.id.inquinantiProgressBar);


        // RandomMethod for temperatura
            Random random = new Random();
            int randomNumber = random.nextInt(30);

            temperatura.setText(Integer.toString(randomNumber) + "°");
        // END RandomMethod

        // ProgressBar Logic
            randomNumber = random.nextInt(100);
            umiditaProgressBar.setProgress(randomNumber);
            if(randomNumber >= 45 && randomNumber <= 65) {
                livelloUmidita.setText("UMIDITA' OTTIMALE");
                livelloUmidita.setTextColor(Color.GREEN);
                umiditaProgressBar.setProgressTintList(ColorStateList.valueOf(Color.GREEN));
            }
            else {
                livelloUmidita.setTextColor(Color.RED);
                umiditaProgressBar.setProgressTintList(ColorStateList.valueOf(Color.RED));
                if(randomNumber > 65)
                    livelloUmidita.setText("UMIDITA' ELEVATA");
                else
                    livelloUmidita.setText("UMIDITA' BASSA");
            }

        randomNumber = random.nextInt(100);
        biologicaProgressBar.setProgress(randomNumber);
        if(randomNumber >= 45 && randomNumber <= 65) {
            livelloBiologica.setText("QUALITA' OTTIMALE");
            livelloBiologica.setTextColor(Color.GREEN);
            biologicaProgressBar.setProgressTintList(ColorStateList.valueOf(Color.GREEN));
        }
        else {
            livelloBiologica.setTextColor(Color.RED);
            biologicaProgressBar.setProgressTintList(ColorStateList.valueOf(Color.RED));
            if(randomNumber > 65)
                livelloBiologica.setText("QUALITA' ELEVATA");
            else
                livelloBiologica.setText("QUALITA' BASSA");
        }

        randomNumber = random.nextInt(100);
        inquinantiProgressBar.setProgress(randomNumber);
        if(randomNumber >= 45 && randomNumber <= 65) {
            livelloInquinanti.setText("OTTIMALE");
            livelloInquinanti.setTextColor(Color.GREEN);
            inquinantiProgressBar.setProgressTintList(ColorStateList.valueOf(Color.GREEN));
        }
        else {
            livelloInquinanti.setTextColor(Color.RED);
            inquinantiProgressBar.setProgressTintList(ColorStateList.valueOf(Color.RED));
            if(randomNumber > 65)
                livelloInquinanti.setText("ALTO");
            else
                livelloInquinanti.setText("BASSO");
        }
        // END ProgressBar

        // Switch Logic
            // On Activity opening check the status
            if(switchIrrigatori.isChecked() == false)
                switchIrrigatori.setText("Spento");
            else
                switchIrrigatori.setText("Acceso");

            if(switchAspiratori.isChecked() == false)
                switchAspiratori.setText("Spento");
            else
                switchAspiratori.setText("Acceso");

            // OnAction Change
            AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);

            switchIrrigatori.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked == false)
                    {
                        alertBuilder.setTitle("IRRIGATORI");
                        alertBuilder.setMessage("Gli irrigatori sono stati spenti");
                        AlertDialog alert = alertBuilder.create();
                        alert.show();
                        switchIrrigatori.setText("Spento");
                    }
                    else
                    {
                        alertBuilder.setTitle("IRRIGATORI");
                        alertBuilder.setMessage("Gli irrigatori sono stati accesi");
                        AlertDialog alert = alertBuilder.create();
                        alert.show();
                        switchIrrigatori.setText("Acceso");
                    }
                }
            });

            switchAspiratori.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked == false) {
                        alertBuilder.setTitle("ASPIRATORI");
                        alertBuilder.setMessage("Gli aspiratori sono stati spenti");
                        AlertDialog alert = alertBuilder.create();
                        alert.show();
                        switchAspiratori.setText("Spento");
                    }else {
                        alertBuilder.setTitle("Aspiratori");
                        alertBuilder.setMessage("Gli aspiratori sono stati accesi");
                        AlertDialog alert = alertBuilder.create();
                        alert.show();
                        switchAspiratori.setText("Acceso");
                    }
                 }
            });
        // END Switch Logic


    }
}