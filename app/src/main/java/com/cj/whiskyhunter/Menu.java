package com.cj.whiskyhunter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Menu extends AppCompatActivity implements View.OnClickListener {

    private ImageButton btnWhiskys;
    private ImageButton btnDistilleries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btnWhiskys = findViewById(R.id.btnWhiskys);
        btnDistilleries = findViewById(R.id.btnDistilleries);
        btnWhiskys.setOnClickListener(this);
        btnDistilleries.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnWhiskys:
                Intent intentWhiskys = new Intent(this, MainActivity.class);
                startActivity(intentWhiskys);
                break;
            case R.id.btnDistilleries:
                Intent intentDistilleries = new Intent(this, Distilleries.class);
                startActivity(intentDistilleries);
        }
    }
}
