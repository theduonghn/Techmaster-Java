CREATE TABLE question(
	id INT PRIMARY KEY AUTO_INCREMENT,
	question TEXT NOT NULL,
	image TEXT,
	`type` ENUM('single choice', 'multiple choice') NOT NULL
);

CREATE TABLE answer(
	id INT PRIMARY KEY AUTO_INCREMENT,
	id_question INT NOT NULL,
	answer TEXT NOT NULL,
	`check` BIT NOT NULL, -- 1: right answer, 0: wrong answer
	FOREIGN KEY(id_question) REFERENCES question(id)
);

INSERT INTO question(id, question, image, `type`)
VALUES
(1, '?? kh?i ??ng l?i máy tính, phát bi?u nào d??i ?ây là sai', NULL, 'single choice'),
(2, 'Theo b?n, ?ây là thi?t b? gì?', 'http://www.baitap123.com/editor/fileman/Uploads/tracnghiemtonghop/Tinhoc/mach.jpg', 'single choice'),
(3, '?? m? r?ng m?t c?a s? ch??ng trình phóng to h?t màn hình', NULL, 'multiple choice'),
(4, '?? nhìn th?y các máy tính trong m?ng n?i b? thì nh?p ch?n bi?u t??ng có tên', NULL, 'single choice'),
(5, '?? t?t máy tính ?úng cách ta ch?n', NULL, 'single choice'),
(6, '?? xóa b? t?p tin trên ??a m?m, ng??i s? d?ng', NULL, 'single choice'),
(7, 'B?n ?ang ? c?a s? My Computer, theo hình minh ho?, phát bi?u nào d??i ?ây là sai:', 'http://www.baitap123.com/editor/fileman/Uploads/tracnghiemtonghop/Tinhoc/cuaso.jpg', 'single choice'),
(8, 'B?n m? Notepad và gõ th? vào ?ó m?t vài ch?, sau ?ó b?n nh?n chu?t vào bi?u t??ng (x) ? góc ph?i trên c?a c?a s?. ?i?u gì s? x?y ra', NULL, 'single choice'),
(9, 'Bi?u t??ng nào d??i ?ây là bi?u t??ng có s?n c?a h? th?ng MS-Windows', NULL, 'multiple choice'),
(10, 'Các ch?c n?ng c?a menu theo hình minh ho? cho phép:', 'http://www.baitap123.com/editor/fileman/Uploads/tracnghiemtonghop/Tinhoc/window1.jpg', 'single choice')

INSERT INTO answer(id_question, answer, `check`)
VALUES
(1, 'Nh?n t? h?p phím Ctrl - Alt - Del, ch?n m?c Restart', 0),
(1, 'T? c?a s? màn hình n?n nh?n nút Start - Shutdown, sau ?ó ch?n m?c Restart', 0),
(1, 'B?m nút Power trên h?p máy', 1),
(1, 'B?m nút Reset trên h?p máy', 0),
(2, 'Bo m?ch ch?', 1),
(2, 'RAM', 0),
(2, '? ??a c?ng máy tính', 0),
(2, 'B? vi x? lý ', 0),
(3, 'Nh?p vào bi?u t??ng Restore Down', 0),
(3, 'Nh?p vào bi?u t??ng Maximize', 1),
(3, 'Nh?p ?úp vào thanh tiêu ?? (Title Bar) khi c?a s? ?ang thu v?a', 1),
(4, 'My Documents', 0),
(4, 'My Computer', 1),
(4, 'My Network Places', 0),
(4, 'My Network', 0),
(5, 'Nh?n nút Start ? góc d??i bên trái màn hình n?n, ch?n m?c Shutdown', 1),
(5, 'T?t ngu?n ?i?n', 0),
(5, 'B?m nút Power trên h?p máy', 0),
(5, 'B?m nút Reset trên h?p máy', 0),
(6, 'Nh?p ch?n Internet Explorer', 0),
(6, 'M? c?a s? My Computer', 1),
(6, 'M? c?a s? tìm ki?m t?p tin Search', 0),
(6, 'M? c?a s? Files Manager', 0),
(7, 'Nh?n nút s? 1 ?? nhanh chóng tr? v? màn hình n?n Desktop', 0),
(7, 'Nh?n nút s? 2 ?? m? ch??ng trình duy?t Web', 0),
(7, 'Nh?n nút s? 3 ?? m? My Documents', 1),
(7, 'Nh?n nút s? 4 ?? m? ch??ng trình MS-Word', 0),
(8, 'C?a s? trên ???c thu nh? l?i thành m?t bi?u t??ng', 0),
(8, 'M?t h?p tho?i s? b?t ra', 1),
(8, 'C?a s? trên ???c ?óng l?i', 0),
(8, 'C?a s? trên ???c phóng to ra', 0),
(9, 'My Computer', 1),
(9, 'Internet Explorer', 1),
(9, 'My Documents', 1),
(10, 'Mu?n ??t tên m?i thì ch?n m?c Rename', 0),
(10, 'Mu?n bi?t ??a còn dung l??ng tr?ng là bao nhiêu thì ch?n m?c Properties', 0),
(10, 'Mu?n ??nh d?ng rãnh t? c?a ??a thì ch?n m?c Format', 0),
(10, 'Windows h? tr? th?c hi?n c? 3 m?c trên', 1)