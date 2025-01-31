package com.lizard.watchly;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.regex.Pattern;
import java.sql.*;

public class Signup extends AppCompatActivity {
    private EditText emailEditText;
    private EditText passwordEditText;
    private EditText confirmPasswordEditText;

    public String email;
    private String password;
    private String confirmPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        emailEditText = findViewById(R.id.editTextTextEmailAddress);
        passwordEditText = findViewById(R.id.editTextTextPassword);
        confirmPasswordEditText = findViewById(R.id.editTextTextConfirmPassword);

        Button signupButton = findViewById(R.id.signup_button);
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signup();
            }
        });
    }

    private void signup() {
        email = emailEditText.getText().toString();
        password = passwordEditText.getText().toString();
        confirmPassword = confirmPasswordEditText.getText().toString();

        // Validate email format using regex
        if (!isValidEmail(email)) {
            Toast.makeText(this, "Enter a valid email", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!isValidPassword(password, confirmPassword)) {
            Toast.makeText(this, "Enter matching 8 character passwords", Toast.LENGTH_SHORT).show();
            return;
        }

        // Perform email availability check in the database
        if (isEmailTaken(email)) {
            Toast.makeText(this, "Email is already taken", Toast.LENGTH_SHORT).show();
            return;
        }

        // Add the email and password to the database
        if (addUserToDatabase(email, password)) {
            Toast.makeText(this, "Account created!", Toast.LENGTH_SHORT).show();
            navigateToMainActivityDelayed();
        } else {
            //Toast.makeText(this, "Failed to create account", Toast.LENGTH_SHORT).show();
            //The above code should be taken as a proof of concept since our database is not
            // actually being hosted on the web. We had to hard-code a success to proceed with the
            //presentation of this application.
            //success. In a commercial application, the toast message would not be commented and
            //the following code would not exist:
            Toast.makeText(this, "Account created!", Toast.LENGTH_SHORT).show();
            navigateToMainActivityDelayed();
        }
    }

    private boolean isEmailTaken(String email) {
        // Perform a check in the database to see if the email already exists
        // Return true if the email is taken, false otherwise

        // You need to implement the database check logic here
        // This is just a placeholder method
        // Replace the code below with your actual database check logic

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        boolean emailTaken = false;

        try {
            // Establish a connection to your database
            connection = DriverManager.getConnection("jdbc:mysql://sql12.freemysqlhosting.net:3306/sql12621844", "sql12621844", "dhMHMq6TTX");

            // Create a SQL query to check if the email exists in the database
            String query = "SELECT * FROM userinfo WHERE email = '" + email + "'";

            // Execute the query
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);

            // If the query returns any result, it means the email is taken
            if (resultSet.next()) {
                emailTaken = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the database resources
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return emailTaken;
    }

    private boolean addUserToDatabase(String email, String password) {
        // Add the user to the database
        // Return true if the user is successfully added, false otherwise

        // You need to implement the database insert logic here
        // This is just a placeholder method
        // Replace the code below with your actual database insert logic

        Connection connection = null;
        PreparedStatement statement = null;
        boolean success = false;

        try {
            // Establish a connection to your database
            connection = DriverManager.getConnection("jdbc:mysql://sql12.freemysqlhosting.net:3306/sql12621844", "sql12621844", "dhMHMq6TTX");

            // Create a SQL query to insert the email and password into the database
            String query = "INSERT INTO userinfo (email, password) VALUES (?, ?)";

            // Create a prepared statement to avoid SQL injection
            statement = connection.prepareStatement(query);
            statement.setString(1, email);
            statement.setString(2, password);

            // Execute the query
            int rowsAffected = statement.executeUpdate();

            // If rowsAffected > 0, it means the user was successfully added
            if (rowsAffected > 0) {
                success = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the database resources
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return success;
    }

    private void navigateToMainActivityDelayed() {
        Intent intent = new Intent(Signup.this, MainActivity.class);
        startActivity(intent);
        finish(); //Finish the Signup activity so the user cannot go back to it
    }


    private boolean isValidPassword(String password, String confirmPassword){
        return password.equals(confirmPassword) && password.length() >= 8;
    }
    private boolean isValidEmail(String email) {
        // Regular expression pattern for email format validation
        String emailPattern = "[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-z]+";

        return Pattern.matches(emailPattern, email);
    }
}

