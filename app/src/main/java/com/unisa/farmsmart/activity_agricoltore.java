package com.unisa.farmsmart;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class activity_agricoltore extends AppCompatActivity {

    TextView temperatura;
    ProgressBar umiditaProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agricoltore);

        temperatura = findViewById(R.id.temperatura);
        umiditaProgressBar = findViewById(R.id.umiditaProgressBar);

        // RandomMethod for temperatura
            Random random = new Random();
            int randomNumber = random.nextInt(30);

            temperatura.setText(Integer.toString(randomNumber) + "°");
        // END RandomMethod

        // ProgressBar Logic

            randomNumber = random.nextInt(100);
            umiditaProgressBar.setProgress(randomNumber);
            if(randomNumber >= 45 && randomNumber <= 65)
                umiditaProgressBar.setProgressTintList(ColorStateList.valueOf(Color.GREEN));
            else
                umiditaProgressBar.setProgressTintList(ColorStateList.valueOf(Color.RED));
        // END ProgressBar


    }
}