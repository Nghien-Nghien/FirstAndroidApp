package com.example.firstandroidapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText textId = findViewById(R.id.edittext1);
        EditText textPassword = findViewById(R.id.edittext2);
        Button button = findViewById(R.id.button);
        Button button_Activity3 = findViewById(R.id.button_activity3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textId.getText().toString().equals("") || textPassword.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "You not yet input username or password. Please recheck!", Toast.LENGTH_LONG).show();
                } else if (textId.getText().toString().equals("Admin") && textPassword.getText().toString().equals("Android")) {
                    openActivity2();
                } else {
                    Toast.makeText(MainActivity.this, "Wrong input", Toast.LENGTH_SHORT).show();
                }
            }
        });

        button_Activity3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textId.getText().toString().equals("") || textPassword.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "Please input both ID & Pass", Toast.LENGTH_SHORT).show();
                } else {
                    String ID = String.format(textId.getText().toString());
                    String Password = String.format(textPassword.getText().toString());
                    Intent intent = new Intent(MainActivity.this, Activity3.class);
                    intent.putExtra("ID", ID);
                    intent.putExtra("Password", Password);
                    startActivityIfNeeded(intent, 1);
                }
            }
        });
    }

    public void openActivity2() {
        Intent intent = new Intent(MainActivity.this, Activity2.class);
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            String showinfor = data.getStringExtra("showinfor");
            EditText showinforinEditText1 = findViewById(R.id.edittext1);
            showinforinEditText1.setText(showinfor);
        }
    }
}
