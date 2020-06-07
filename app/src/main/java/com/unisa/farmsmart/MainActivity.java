package com.unisa.farmsmart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button button1;
    Button button2;
    Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
    }

    public void clickAgricoltore(View view) {
        Intent intent = new Intent(this, activity_agricoltore.class);
        startActivity(intent);
    }

    public void clickAllevatore(View view) {
        Intent intent = new Intent(this, activity_allevatore.class);
        startActivity(intent);
    }

    public void clickVivaista(View view) {
        Intent intent = new Intent(this, activity_vivaista.class);
        startActivity(intent);
    }
}