# Truy vấn database library

### Lấy ra các quyển sách được xuất trước năm 1900
```sql
SELECT title, year_of_publication
FROM book
WHERE year_of_publication < 1900;
```
![image](https://user-images.githubusercontent.com/95962543/155345712-5a3f2998-9c95-4484-a489-c7a1f17c75cc.png)

### Lấy ra các quyển sách có số lượng trang dưới 100
```sql
SELECT title, page_number
FROM book
WHERE page_number < 100;
```
![image](https://user-images.githubusercontent.com/95962543/155346436-399e07d2-5b77-431d-882d-ade7494e0259.png)

### Liệt kê các quyển sách có id_publisher = 1 và sắp xếp theo thứ tự tăng dần của số trang
```sql
SELECT title, page_number, id_publisher
FROM book
WHERE id_publisher = 1
ORDER BY page_number;
```
![image](https://user-images.githubusercontent.com/95962543/155346817-3a928a82-7ea7-4bfc-b85d-ebb2ccf4a352.png)

# Truy vấn database sakila

### Tính trung bình cộng rental_rate của các bộ phim có rating là R
```sql
SELECT AVG(rental_rate) AS r_avg_rental_rate
FROM film
WHERE rating = 'R';
```
![image](https://user-images.githubusercontent.com/95962543/155349112-e2fabe24-3cc7-4bc8-865d-5ce901326db3.png)

### Đếm các bộ phim có special_features là Deleted Scenes
```sql
SELECT COUNT(film_id) AS num_deleted_scenes
FROM film
WHERE special_features = 'Deleted Scenes';
```
![image](https://user-images.githubusercontent.com/95962543/155349250-932a69e8-0171-4010-a3a1-00048c863a4c.png)

### Tìm các bộ phim theo tên có chứa ‘ACADEMY’
```sql
SELECT title, description
FROM film
WHERE title LIKE '%ACADEMY%';
```
![image](https://user-images.githubusercontent.com/95962543/155349603-912f25f1-f70c-4207-b833-cc5028878afe.png)
