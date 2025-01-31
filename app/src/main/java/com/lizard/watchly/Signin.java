package com.lizard.watchly;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.view.View;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.content.Intent;
import java.sql.*;

public class Signin extends AppCompatActivity {

    private EditText emailEditText;
    private EditText passwordEditText;
    private Button signinButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        emailEditText = findViewById(R.id.editTextTextEmailAddress);
        passwordEditText = findViewById(R.id.editTextTextPassword);
        signinButton = findViewById(R.id.signin_button);

        signinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isNetworkAvailable()) {
                    String email = emailEditText.getText().toString();
                    String password = passwordEditText.getText().toString();

                    try {
                        Connection connection = DriverManager.getConnection("jdbc:mysql://sql12.freemysqlhosting.net:3306/sql12621844", "sql12621844", "dhMHMq6TTX");
                        Statement statement = connection.createStatement();
                        String query = "SELECT * FROM userinfo WHERE email = '" + email + "' AND password = '" + password + "'";
                        ResultSet resultSet = statement.executeQuery(query);

                        if (resultSet.next()) {
                            // Successful validation
                            Toast.makeText(Signin.this, "Signin successful", Toast.LENGTH_SHORT).show();

                            // Intent to switch to a new activity
                            //Intent intent = new Intent(Signin.this, NewActivity.class);
                            //startActivity(intent);
                        } else {
                            // Failed validation
                            Toast.makeText(Signin.this, "Account does not exist", Toast.LENGTH_SHORT).show();
                        }

                        resultSet.close();
                        statement.close();
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                } else {
                    Toast.makeText(Signin.this, "No internet connection available", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }
}

