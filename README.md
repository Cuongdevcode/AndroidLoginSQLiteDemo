📱 Android Login & User Management App – SQLite Demo

Ứng dụng Android mẫu được xây dựng nhằm minh họa quy trình đăng nhập/đăng ký người dùng và quản lý tài khoản bằng SQLite Database nội bộ.
Phù hợp để học tập, demo hoặc làm bài tập môn Lập Trình Ứng Dụng Di Động.

✨ Tính năng chính

🔑 Đăng nhập (Login)

Kiểm tra tài khoản từ cơ sở dữ liệu SQLite.

Lưu trạng thái đăng nhập bằng SharedPreferences (Remember Login).

📝 Đăng ký tài khoản (Sign Up)

Người dùng mới có thể tạo tài khoản.

Lưu email & mật khẩu vào database nội bộ.

👋 Màn hình chào mừng (Welcome Screen)

Hiển thị email của user đang đăng nhập.

Nút Logout: đăng xuất và quay về màn hình Login.

Nút Delete Account: xóa tài khoản hiện tại khỏi database và quay về Login.

🔐 Quên mật khẩu (Forgot Password)

Người dùng có thể bấm "Forgot password" để hiển thị mật khẩu đã đăng ký (demo).

💾 Quản lý dữ liệu với SQLite

Tự tạo bảng Tbl_user với các cột: Email, pass, repass.

CRUD cơ bản: Insert / Check / Delete / Get password by email.

🎨 UI/UX cải tiến

Giao diện đơn giản, dễ sử dụng.

Nút được disable khi chưa nhập đủ thông tin.

Thông báo Toast rõ ràng với từng thao tác.

🏗️ Cấu trúc thư mục & code chính
app/
├── java/
│   └── com.example.lab5_phamchicuong_se173588/
│       ├── MainActivity.java          # Màn hình Login
│       ├── SignUpActivity.java        # Màn hình Đăng ký
│       ├── WelcomeActivity.java       # Màn hình chào mừng + Logout + Delete account
│       ├── DatabaseHelper.java        # Xử lý SQLite (CRUD user)
│       └── ForgotPasswordActivity.java# Màn hình quên mật khẩu
│
└── res/
    ├── layout/
    │   ├── login_layout.xml           # Giao diện Login
    │   ├── signup_layout.xml          # Giao diện Sign Up
    │   └── wellcome_layout.xml        # Giao diện Welcome
    └── values/
        └── colors.xml, strings.xml...

⚙️ Công nghệ sử dụng

🟢 Ngôn ngữ: Java (Android)

🗄️ Cơ sở dữ liệu: SQLite (qua SQLiteOpenHelper)

💡 Quản lý trạng thái đăng nhập: SharedPreferences

🎨 Giao diện: XML Layout + Material Components (Button, EditText, TextView)

🧪 Chức năng chi tiết trong code
DatabaseHelper.java

Tạo database SE173588.db và bảng Tbl_user.

Các hàm chính:

insertUser(email, pass, repass)

checkUser(email, pass)

checkEmail(email)

deleteUser(email)

getPasswordByEmail(email)

MainActivity.java

Màn hình đăng nhập.

Kiểm tra trạng thái login (SharedPreferences).

Xử lý nút Login, Sign Up, Forgot Password.

SignUpActivity.java

Form đăng ký tài khoản.

Kiểm tra email đã tồn tại trước khi thêm mới.

Lưu dữ liệu vào SQLite.

WelcomeActivity.java

Hiển thị email của user đang đăng nhập.

Logout: xóa trạng thái đăng nhập và quay về MainActivity.

Delete Account: xóa user trong DB → logout → quay về MainActivity.

🚀 Cách chạy ứng dụng

Clone repo:

git clone https://github.com/Cuongdevcode/AndroidLoginSQLiteDemo.git



Mở dự án bằng Android Studio.

Kết nối thiết bị ảo (AVD) hoặc điện thoại thật.

Nhấn Run ▶ để cài và chạy app.

🧹 Quản lý Database thủ công (nếu cần demo)

Sử dụng Device File Explorer trong Android Studio:

data/data/com.example.lab5_phamchicuong_se173588/databases/SE173588.db


Có thể tải file DB về máy, mở bằng công cụ SQLite Viewer (DB Browser for SQLite) để xem hoặc xóa tài khoản.
