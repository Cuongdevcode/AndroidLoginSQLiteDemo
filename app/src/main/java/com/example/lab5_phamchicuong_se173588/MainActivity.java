package com.example.lab5_phamchicuong_se173588;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText emailEditText, passwordEditText;
    private Button loginButton, signupButton;
    private TextView forgotPassword;
    private DatabaseHelper databaseHelper;
    private SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);

        databaseHelper = new DatabaseHelper(this);
        prefs = getSharedPreferences("UserPrefs", MODE_PRIVATE);

        // Nếu trước đó user đã login
        if (prefs.getBoolean("logged_in", false)) {
            startActivity(new Intent(this, WelcomeActivity.class));
            finish();
        }

        emailEditText = findViewById(R.id.log_username);
        passwordEditText = findViewById(R.id.Log_password);
        loginButton = findViewById(R.id.login);
        signupButton = findViewById(R.id.signin);
        forgotPassword = findViewById(R.id.forgot_password);

        // Enable nút login khi nhập đủ
        TextWatcher textWatcher = new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override public void onTextChanged(CharSequence s, int start, int before, int count) {
                String email = emailEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();
                loginButton.setEnabled(!email.isEmpty() && !password.isEmpty());
            }
            @Override public void afterTextChanged(Editable s) {}
        };
        emailEditText.addTextChangedListener(textWatcher);
        passwordEditText.addTextChangedListener(textWatcher);

        loginButton.setOnClickListener(v -> login());
        signupButton.setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, SignUpActivity.class)));

        forgotPassword.setOnClickListener(v -> {
            String email = emailEditText.getText().toString().trim();
            if (!databaseHelper.checkEmail(email)) {
                Toast.makeText(this, "Email not found", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Your password: " + databaseHelper.getPasswordByEmail(email),
                        Toast.LENGTH_LONG).show();
            }
        });
        forgotPassword.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, ForgotPasswordActivity.class));
        });
    }

    private void login() {
        String email = emailEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();

        if (databaseHelper.checkUser(email, password)) {
            Toast.makeText(this, "Login success", Toast.LENGTH_SHORT).show();
            prefs.edit().putBoolean("logged_in", true).apply();
            startActivity(new Intent(MainActivity.this, WelcomeActivity.class));
            finish();
        } else {
            Toast.makeText(this, "Invalid email or password", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (databaseHelper != null) databaseHelper.close();
    }
}
