package com.pixelarts.week2day2classexercise;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private TextView tvDisplay;
    private Button btnSave, btnQuery;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvDisplay = findViewById(R.id.tvDisplay);
        btnQuery = findViewById(R.id.btnQuery);
        btnSave = findViewById(R.id.btnSave);

    }

    public void onSave(View view) {

        Intent intent = new Intent(this, SaveActivity.class);
        startActivity(intent);

    }

    public void onQuery(View view) {
        Intent intent = new Intent(this, QueryActivity.class);
        startActivity(intent);
    }

    public void onSearch (View view)
    {
        SharedPreferences sharedPreferences = getSharedPreferences("sp", Context.MODE_PRIVATE);
        String queryKey = getIntent().getStringExtra("query");
        String value = sharedPreferences.getString(queryKey, "");
        Intent intent = new Intent(this, WebActivity.class);
        intent.putExtra("search", value);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sharedPreferences = getSharedPreferences("sp", Context.MODE_PRIVATE);



        String savedValue = getIntent().getStringExtra("savedValue");
        tvDisplay.setText(savedValue);

        String queryKey = getIntent().getStringExtra("query");
        String query = sharedPreferences.getString(queryKey, "");
        if(sharedPreferences.contains(queryKey)) {
            tvDisplay.setText(query);
        }

    }



    public void clear(View view) {
        tvDisplay.setText("");
    }
}
