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
(1, '?? kh?i ??ng l?i m�y t�nh, ph�t bi?u n�o d??i ?�y l� sai', NULL, 'single choice'),
(2, 'Theo b?n, ?�y l� thi?t b? g�?', 'http://www.baitap123.com/editor/fileman/Uploads/tracnghiemtonghop/Tinhoc/mach.jpg', 'single choice'),
(3, '?? m? r?ng m?t c?a s? ch??ng tr�nh ph�ng to h?t m�n h�nh', NULL, 'multiple choice'),
(4, '?? nh�n th?y c�c m�y t�nh trong m?ng n?i b? th� nh?p ch?n bi?u t??ng c� t�n', NULL, 'single choice'),
(5, '?? t?t m�y t�nh ?�ng c�ch ta ch?n', NULL, 'single choice'),
(6, '?? x�a b? t?p tin tr�n ??a m?m, ng??i s? d?ng', NULL, 'single choice'),
(7, 'B?n ?ang ? c?a s? My Computer, theo h�nh minh ho?, ph�t bi?u n�o d??i ?�y l� sai:', 'http://www.baitap123.com/editor/fileman/Uploads/tracnghiemtonghop/Tinhoc/cuaso.jpg', 'single choice'),
(8, 'B?n m? Notepad v� g� th? v�o ?� m?t v�i ch?, sau ?� b?n nh?n chu?t v�o bi?u t??ng (x) ? g�c ph?i tr�n c?a c?a s?. ?i?u g� s? x?y ra', NULL, 'single choice'),
(9, 'Bi?u t??ng n�o d??i ?�y l� bi?u t??ng c� s?n c?a h? th?ng MS-Windows', NULL, 'multiple choice'),
(10, 'C�c ch?c n?ng c?a menu theo h�nh minh ho? cho ph�p:', 'http://www.baitap123.com/editor/fileman/Uploads/tracnghiemtonghop/Tinhoc/window1.jpg', 'single choice')

INSERT INTO answer(id_question, answer, `check`)
VALUES
(1, 'Nh?n t? h?p ph�m Ctrl - Alt - Del, ch?n m?c Restart', 0),
(1, 'T? c?a s? m�n h�nh n?n nh?n n�t Start - Shutdown, sau ?� ch?n m?c Restart', 0),
(1, 'B?m n�t Power tr�n h?p m�y', 1),
(1, 'B?m n�t Reset tr�n h?p m�y', 0),
(2, 'Bo m?ch ch?', 1),
(2, 'RAM', 0),
(2, '? ??a c?ng m�y t�nh', 0),
(2, 'B? vi x? l� ', 0),
(3, 'Nh?p v�o bi?u t??ng Restore Down', 0),
(3, 'Nh?p v�o bi?u t??ng Maximize', 1),
(3, 'Nh?p ?�p v�o thanh ti�u ?? (Title Bar) khi c?a s? ?ang thu v?a', 1),
(4, 'My Documents', 0),
(4, 'My Computer', 1),
(4, 'My Network Places', 0),
(4, 'My Network', 0),
(5, 'Nh?n n�t Start ? g�c d??i b�n tr�i m�n h�nh n?n, ch?n m?c Shutdown', 1),
(5, 'T?t ngu?n ?i?n', 0),
(5, 'B?m n�t Power tr�n h?p m�y', 0),
(5, 'B?m n�t Reset tr�n h?p m�y', 0),
(6, 'Nh?p ch?n Internet Explorer', 0),
(6, 'M? c?a s? My Computer', 1),
(6, 'M? c?a s? t�m ki?m t?p tin Search', 0),
(6, 'M? c?a s? Files Manager', 0),
(7, 'Nh?n n�t s? 1 ?? nhanh ch�ng tr? v? m�n h�nh n?n Desktop', 0),
(7, 'Nh?n n�t s? 2 ?? m? ch??ng tr�nh duy?t Web', 0),
(7, 'Nh?n n�t s? 3 ?? m? My Documents', 1),
(7, 'Nh?n n�t s? 4 ?? m? ch??ng tr�nh MS-Word', 0),
(8, 'C?a s? tr�n ???c thu nh? l?i th�nh m?t bi?u t??ng', 0),
(8, 'M?t h?p tho?i s? b?t ra', 1),
(8, 'C?a s? tr�n ???c ?�ng l?i', 0),
(8, 'C?a s? tr�n ???c ph�ng to ra', 0),
(9, 'My Computer', 1),
(9, 'Internet Explorer', 1),
(9, 'My Documents', 1),
(10, 'Mu?n ??t t�n m?i th� ch?n m?c Rename', 0),
(10, 'Mu?n bi?t ??a c�n dung l??ng tr?ng l� bao nhi�u th� ch?n m?c Properties', 0),
(10, 'Mu?n ??nh d?ng r�nh t? c?a ??a th� ch?n m?c Format', 0),
(10, 'Windows h? tr? th?c hi?n c? 3 m?c tr�n', 1)