package com.lizard.watchly;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //S

        Intent intent = new Intent(MainActivity.this, Login.class);

        startActivity(intent);
        //S
    }
}

