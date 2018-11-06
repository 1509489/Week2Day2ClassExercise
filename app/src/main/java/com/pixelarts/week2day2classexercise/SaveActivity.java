package com.pixelarts.week2day2classexercise;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SaveActivity extends AppCompatActivity {

    private EditText etSave, etKey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save);

        etSave = findViewById(R.id.etSave);
        etKey = findViewById(R.id.etKey);

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    public void save(View view) {

        SharedPreferences sharedPreferences = getSharedPreferences("sp", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(etKey.getText().toString(), etSave.getText().toString());
        editor.commit();
        Intent sharedPrefIntent = new Intent(this, MainActivity.class);
        sharedPrefIntent.setAction("sharedPrefs");
        sharedPrefIntent.putExtra("key", etKey.getText().toString());
        startActivity(sharedPrefIntent);
        Toast.makeText(this, "Saved Successfully", Toast.LENGTH_SHORT).show();
    }
}
