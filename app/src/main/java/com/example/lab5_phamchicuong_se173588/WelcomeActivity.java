package com.example.lab5_phamchicuong_se173588;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class WelcomeActivity extends AppCompatActivity {
    private DatabaseHelper databaseHelper;
    private String currentEmail; // Email của user đang đăng nhập
    private Button logoutButton, deleteButton;
    private TextView welcomeText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wellcome_layout);

        databaseHelper = new DatabaseHelper(this);

        // Nhận email từ Intent khi login thành công
        currentEmail = getIntent().getStringExtra("email");

        welcomeText = findViewById(R.id.welcome_text);
        logoutButton = findViewById(R.id.logout_button);
//        deleteButton = findViewById(R.id.delete_button);

        // Hiển thị chào mừng
        if (currentEmail != null) {
            welcomeText.setText("Welcome, " + currentEmail + "!");
        }

        // Nút logout
        logoutButton.setOnClickListener(v -> {
            Toast.makeText(this, "Đã đăng xuất", Toast.LENGTH_SHORT).show();

            // Xoá dữ liệu Remember login
            getSharedPreferences("UserPrefs", MODE_PRIVATE)
                    .edit()
                    .clear()
                    .apply();

            Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
        });


        // Nút delete account
        deleteButton.setOnClickListener(v -> {
            new AlertDialog.Builder(this)
                    .setTitle("Xóa tài khoản")
                    .setMessage("Bạn có chắc chắn muốn xóa tài khoản này không?")
                    .setPositiveButton("Xóa", (dialog, which) -> {
                        boolean deleted = databaseHelper.deleteUser(currentEmail);
                        if (deleted) {
                            Toast.makeText(this, "Tài khoản đã bị xóa", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                            finish();
                        } else {
                            Toast.makeText(this, "Không thể xóa tài khoản", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .setNegativeButton("Hủy", null)
                    .show();
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (databaseHelper != null) {
            databaseHelper.close();
        }
    }
}
