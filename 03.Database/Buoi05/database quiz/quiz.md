# Database quiz

## Tạo database
```sql
CREATE DATABASE quiz;
```

## Tạo bảng question
```sql
CREATE TABLE question(
	id INT PRIMARY KEY AUTO_INCREMENT,
	question TEXT NOT NULL,
	image TEXT,
	`type` ENUM('single choice', 'multiple choice') NOT NULL
);
```

## Tạo bảng answer
```sql
CREATE TABLE answer(
	id INT PRIMARY KEY AUTO_INCREMENT,
	id_question INT NOT NULL,
	answer TEXT NOT NULL,
	`check` BIT NOT NULL, -- 1: right answer, 0: wrong answer
	FOREIGN KEY(id_question) REFERENCES question(id)
);
```

## Diagram
![image](https://user-images.githubusercontent.com/95962543/155826410-fa0ba7f6-6a6f-4461-b629-78724fdc0aae.png)

## Thêm dữ liệu vào bảng question
```sql
INSERT INTO question(id, question, image, `type`)
VALUES
(1, 'Để khởi động lại máy tính, phát biểu nào dưới đây là sai', NULL, 'single choice'),
(2, 'Theo bạn, đây là thiết bị gì?', 'http://www.baitap123.com/editor/fileman/Uploads/tracnghiemtonghop/Tinhoc/mach.jpg', 'single choice'),
(3, 'Để mở rộng một cửa sổ chương trình phóng to hết màn hình', NULL, 'multiple choice'),
(4, 'Để nhìn thấy các máy tính trong mạng nội bộ thì nhắp chọn biểu tượng có tên', NULL, 'single choice'),
(5, 'Để tắt máy tính đúng cách ta chọn', NULL, 'single choice'),
(6, 'Để xóa bỏ tệp tin trên đĩa mềm, người sử dụng', NULL, 'single choice'),
(7, 'Bạn đang ở cửa sổ My Computer, theo hình minh hoạ, phát biểu nào dưới đây là sai:', 'http://www.baitap123.com/editor/fileman/Uploads/tracnghiemtonghop/Tinhoc/cuaso.jpg', 'single choice'),
(8, 'Bạn mở Notepad và gõ thử vào đó một vài chữ, sau đó bạn nhấn chuột vào biểu tượng (x) ở góc phải trên của cửa sổ. Điều gì sẽ xảy ra', NULL, 'single choice'),
(9, 'Biểu tượng nào dưới đây là biểu tượng có sẵn của hệ thống MS-Windows', NULL, 'multiple choice'),
(10, 'Các chức năng của menu theo hình minh hoạ cho phép:', 'http://www.baitap123.com/editor/fileman/Uploads/tracnghiemtonghop/Tinhoc/window1.jpg', 'single choice')
```
![image](https://user-images.githubusercontent.com/95962543/155826506-7efa2d71-323d-4566-aa58-5bc134ddcec2.png)

## Thêm dữ liệu vào bảng answer
```sql
INSERT INTO answer(id_question, answer, `check`)
VALUES
(1, 'Nhấn tổ hợp phím Ctrl - Alt - Del, chọn mục Restart', 0),
(1, 'Từ cửa sổ màn hình nền nhấn nút Start - Shutdown, sau đó chọn mục Restart', 0),
(1, 'Bấm nút Power trên hộp máy', 1),
(1, 'Bấm nút Reset trên hộp máy', 0),
(2, 'Bo mạch chủ', 1),
(2, 'RAM', 0),
(2, 'Ổ đĩa cứng máy tính', 0),
(2, 'Bộ vi xử lý ', 0),
(3, 'Nhắp vào biểu tượng Restore Down', 0),
(3, 'Nhắp vào biểu tượng Maximize', 1),
(3, 'Nhắp đúp vào thanh tiêu đề (Title Bar) khi cửa sổ đang thu vừa', 1),
(4, 'My Documents', 0),
(4, 'My Computer', 1),
(4, 'My Network Places', 0),
(4, 'My Network', 0),
(5, 'Nhấn nút Start ở góc dưới bên trái màn hình nền, chọn mục Shutdown', 1),
(5, 'Tắt nguồn điện', 0),
(5, 'Bấm nút Power trên hộp máy', 0),
(5, 'Bấm nút Reset trên hộp máy', 0),
(6, 'Nhắp chọn Internet Explorer', 0),
(6, 'Mở cửa sổ My Computer', 1),
(6, 'Mở cửa sổ tìm kiếm tệp tin Search', 0),
(6, 'Mở cửa sổ Files Manager', 0),
(7, 'Nhấn nút số 1 để nhanh chóng trở về màn hình nền Desktop', 0),
(7, 'Nhấn nút số 2 để mở chương trình duyệt Web', 0),
(7, 'Nhấn nút số 3 để mở My Documents', 1),
(7, 'Nhấn nút số 4 để mở chương trình MS-Word', 0),
(8, 'Cửa sổ trên được thu nhỏ lại thành một biểu tượng', 0),
(8, 'Một hộp thoại sẽ bật ra', 1),
(8, 'Cửa sổ trên được đóng lại', 0),
(8, 'Cửa sổ trên được phóng to ra', 0),
(9, 'My Computer', 1),
(9, 'Internet Explorer', 1),
(9, 'My Documents', 1),
(10, 'Muốn đặt tên mới thì chọn mục Rename', 0),
(10, 'Muốn biết đĩa còn dung lượng trống là bao nhiêu thì chọn mục Properties', 0),
(10, 'Muốn định dạng rãnh từ của đĩa thì chọn mục Format', 0),
(10, 'Windows hỗ trợ thực hiện cả 3 mục trên', 1)
```
![image](https://user-images.githubusercontent.com/95962543/155826529-92fd8bef-686e-4fd0-b324-28741db541ee.png)
