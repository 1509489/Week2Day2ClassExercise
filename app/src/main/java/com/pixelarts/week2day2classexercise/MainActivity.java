package com.pixelarts.week2day2classexercise;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvDisplay;
    private Button btnSave, btnQuery;
    String key;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvDisplay = findViewById(R.id.tvDisplay);
        btnQuery = findViewById(R.id.btnQuery);
        btnSave = findViewById(R.id.btnSave);


        key = getIntent().getStringExtra("key");


    }

    public void onSave(View view) {

        Intent intent = new Intent(this, SaveActivity.class);
        startActivity(intent);

    }

    public void onQuery(View view) {
        Intent intent = new Intent(this, QueryActivity.class);
        intent.putExtra("key", key);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();


        SharedPreferences sharedPreferences = getSharedPreferences("sp", Context.MODE_PRIVATE);
        String save = sharedPreferences.getString(key, "");
        tvDisplay.setText(save);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == Activity.RESULT_OK && resultCode == 2)
        {
            String name = data.getStringExtra(key);
            tvDisplay.setText(name);
        }
    }

    public void clear(View view) {
        tvDisplay.setText("");
    }
}
