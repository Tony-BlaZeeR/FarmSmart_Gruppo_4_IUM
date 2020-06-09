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

public class activity_vivaista extends AppCompatActivity {
    TextView temperatura;
    TextView livelloUmidita;
    ProgressBar umiditaProgressBar;
    Switch switchLuci;
    Switch switchAnnaffiatoi;
    Switch switchPortelloni;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vivaista);

        temperatura = findViewById(R.id.livelloTemperatura);
        livelloUmidita = findViewById(R.id.livelloUmidita);
        umiditaProgressBar = findViewById(R.id.umiditaProgressBar);
        switchLuci = findViewById(R.id.switchLuci);
        switchAnnaffiatoi = findViewById(R.id.switchAnnaffiatoi);
        switchPortelloni = findViewById(R.id.switchPortelloni);

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
        // END ProgressBar

        // Switch Logic
        // On Activity opening check the status
        if(switchLuci.isChecked() == false)
            switchLuci.setText("Spento");
        else
            switchLuci.setText("Acceso");

        if(switchAnnaffiatoi.isChecked() == false)
            switchAnnaffiatoi.setText("Spento");
        else
            switchAnnaffiatoi.setText("Acceso");

        if(switchPortelloni.isChecked() == false)
            switchPortelloni.setText("Spento");
        else
            switchPortelloni.setText("Acceso");

        // OnAction Change
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);

        switchLuci.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked == false)
                {
                    alertBuilder.setTitle("LUCI");
                    alertBuilder.setMessage("Le luci sono state spente");
                    AlertDialog alert = alertBuilder.create();
                    alert.show();
                    switchLuci.setText("Spento");
                }
                else
                {
                    alertBuilder.setTitle("LUCI");
                    alertBuilder.setMessage("Le luci sono state accese");
                    AlertDialog alert = alertBuilder.create();
                    alert.show();
                    switchLuci.setText("Acceso");
                }
            }
        });

        switchAnnaffiatoi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked == false) {
                    alertBuilder.setTitle("ANNAFFIATOI");
                    alertBuilder.setMessage("Gli annaffiatoi sono stati spenti");
                    AlertDialog alert = alertBuilder.create();
                    alert.show();
                    switchAnnaffiatoi.setText("Spento");
                }else {
                    alertBuilder.setTitle("ANNAFFIATOI");
                    alertBuilder.setMessage("Gli annaffiatoi sono stati accesi");
                    AlertDialog alert = alertBuilder.create();
                    alert.show();
                    switchAnnaffiatoi.setText("Acceso");
                }
            }
        });

        switchPortelloni.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked == false) {
                    alertBuilder.setTitle("PORTELLONI");
                    alertBuilder.setMessage("I portelloni sono stati chiusi");
                    AlertDialog alert = alertBuilder.create();
                    alert.show();
                    switchPortelloni.setText("Spento");
                }else {
                    alertBuilder.setTitle("PORTELLONI");
                    alertBuilder.setMessage("I portelloni sono stati aperti");
                    AlertDialog alert = alertBuilder.create();
                    alert.show();
                    switchPortelloni.setText("Acceso");
                }
            }
        });
        // END Switch Logic
    }
}
