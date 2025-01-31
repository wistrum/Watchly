package com.lizard.watchly;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.widget.Toast;
import android.view.View;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.content.Intent;
import java.lang.String;
import java.util.Random;

public class Login extends AppCompatActivity {
    private String username;
    private String password;

    //private int auth;
    //Random rand = new Random();
    //auth = rand.nextInt(900000) + 100000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button loginButton = findViewById(R.id.login_button);
        Button signupButton = findViewById(R.id.signup_button);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isNetworkAvailable()) {

                    // Internet is available,
                    // validate user input, make API calls

                    Toast.makeText(Login.this, "Enter Login Credentials", Toast.LENGTH_SHORT).show();

                    // After successful login, navigate to the next screen
                    Intent intent = new Intent(Login.this, Signin.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(Login.this, "Network Unavailable", Toast.LENGTH_SHORT).show();
                }
            }
        });

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View w) {
                if (isNetworkAvailable()) {

                    // Internet is available, perform your login logic here
                    // You can validate user input, make API calls, etc.
                    // Example: Show a toast message when the button is clicked
                    Toast.makeText(Login.this, "Welcome to Watchly", Toast.LENGTH_SHORT).show();

                    // After successful press, navigate to the next screen
                    Intent intent = new Intent(Login.this, Signup.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(Login.this, "Network Unavailable", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Add your login logic here
        setTitle("Login");
        // You can access UI elements using findViewById() and set listeners for login actions
        // Perform authentication and navigate to the main app screen upon successful login
    }
    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        if (connectivityManager != null) {
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            return networkInfo != null && networkInfo.isConnected();
        }
        return false;
    }
}
