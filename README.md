# Android Login & User Management – SQLite Demo

Ứng dụng Android minh họa đăng nhập, đăng ký và quản lý người dùng bằng SQLite.

## Tính năng
- 🔑 Đăng nhập / lưu trạng thái bằng SharedPreferences
- 📝 Đăng ký tài khoản mới
- 👋 Màn hình Welcome với Logout / Delete account
- 🔐 Quên mật khẩu (hiển thị password demo)
- 💾 Quản lý dữ liệu SQLite (Tbl_user)

## Cấu trúc chính
- MainActivity.java – Login
- SignUpActivity.java – Đăng ký
- WelcomeActivity.java – Welcome + Logout/Delete
- DatabaseHelper.java – SQLite CRUD
- res/layout – giao diện XML

## Chạy ứng dụng
1. Clone repo
   ```bash
   git clone https://github.com/Cuongdevcode/AndroidLoginSQLiteDemo.git
  
2. Mở Android Studio → Open Project
3. Kết nối AVD hoặc thiết bị thật
4 . Run ▶

## Công nghệ

- Java, Android

- SQLite (SQLiteOpenHelper)

- SharedPreferences

- Material Components (Button, EditText, TextView)
