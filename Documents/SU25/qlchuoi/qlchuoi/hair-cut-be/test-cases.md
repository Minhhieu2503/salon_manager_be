# Test Cases - Hệ Thống Quản Lý Tiệm Cắt Tóc

## Test Case ID: TC001
### Mô tả Test Case
Kiểm tra chức năng đăng nhập vào hệ thống

### Quy trình Test
1. Truy cập trang đăng nhập
2. Nhập thông tin đăng nhập
3. Nhấn nút "Đăng nhập"

### Kết quả mong đợi
- Đăng nhập thành công và chuyển hướng đến trang chủ
- Hiển thị thông báo lỗi nếu thông tin đăng nhập không chính xác

### Điều kiện tiên quyết
- Hệ thống đang hoạt động
- Tài khoản đã được tạo trong hệ thống

### Vòng 1
- Ngày test: [Ngày]
- Người test: [Tên]
- Kết quả: [Pass/Fail]

### Vòng 2
- Ngày test: [Ngày]
- Người test: [Tên]
- Kết quả: [Pass/Fail]

### Dữ liệu test
- Username: admin
- Password: admin123

---

## Test Case ID: TC002
### Mô tả Test Case
Kiểm tra chức năng thêm lịch hẹn mới

### Quy trình Test
1. Đăng nhập vào hệ thống
2. Chọn menu "Quản lý lịch hẹn"
3. Nhấn nút "Thêm lịch hẹn mới"
4. Điền thông tin lịch hẹn
5. Nhấn nút "Lưu"

### Kết quả mong đợi
- Lịch hẹn được tạo thành công
- Hiển thị thông báo thành công
- Lịch hẹn mới xuất hiện trong danh sách

### Điều kiện tiên quyết
- Đã đăng nhập vào hệ thống
- Có quyền thêm lịch hẹn

### Vòng 1
- Ngày test: [Ngày]
- Người test: [Tên]
- Kết quả: [Pass/Fail]

### Vòng 2
- Ngày test: [Ngày]
- Người test: [Tên]
- Kết quả: [Pass/Fail]

### Dữ liệu test
- Tên khách hàng: Nguyễn Văn A
- Số điện thoại: 0123456789
- Ngày hẹn: [Ngày hiện tại]
- Giờ hẹn: 14:00
- Dịch vụ: Cắt tóc nam

---

## Test Case ID: TC003
### Mô tả Test Case
Kiểm tra chức năng quản lý nhân viên

### Quy trình Test
1. Đăng nhập với tài khoản admin
2. Chọn menu "Quản lý nhân viên"
3. Thực hiện các thao tác CRUD với nhân viên

### Kết quả mong đợi
- Có thể thêm, sửa, xóa thông tin nhân viên
- Hiển thị danh sách nhân viên đầy đủ
- Validate dữ liệu nhập vào

### Điều kiện tiên quyết
- Đã đăng nhập với tài khoản có quyền admin
- Hệ thống đang hoạt động bình thường

### Vòng 1
- Ngày test: [Ngày]
- Người test: [Tên]
- Kết quả: [Pass/Fail]

### Vòng 2
- Ngày test: [Ngày]
- Người test: [Tên]
- Kết quả: [Pass/Fail]

### Dữ liệu test
- Tên nhân viên: Trần Thị B
- Số điện thoại: 0987654321
- Chức vụ: Nhân viên cắt tóc
- Lương cơ bản: 5,000,000 VNĐ 