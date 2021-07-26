package com.example.firstandroidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Activity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        Intent intent = getIntent();
        final String ID = intent.getStringExtra("ID");
        final String Password = intent.getStringExtra("Password");
        EditText edittext1 = findViewById(R.id.edittext1);
        edittext1.setText(ID);
        EditText edittext2 = findViewById(R.id.edittext2);
        edittext2.setText(Password);

        Button button_send_back = findViewById(R.id.button_send_back);
        button_send_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String showinfor = ID + " - " + Password;
                Intent showinforintent = new Intent();
                showinforintent.putExtra("showinfor", showinfor);
                setResult(RESULT_OK, showinforintent);
                finish();
            }
        });
    }
}