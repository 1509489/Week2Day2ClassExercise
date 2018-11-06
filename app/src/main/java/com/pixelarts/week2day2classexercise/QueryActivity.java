package com.pixelarts.week2day2classexercise;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class QueryActivity extends AppCompatActivity {

    EditText etQuery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query);

        etQuery = findViewById(R.id.etQuery);


    }

    public void query(View view) {
        String key = getIntent().getStringExtra("key");

        String value = etQuery.getText().toString();
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(key, value);
        setResult(Activity.RESULT_OK, intent);
        finish();

        Toast.makeText(this, "Query Successful", Toast.LENGTH_SHORT).show();
    }
}
