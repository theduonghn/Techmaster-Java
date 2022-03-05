# Cơ sở dữ liệu cho nền tảng thương mại điện tử

## Thiết kế sơ bộ

![image](ProjectEcommerce_Design-Primarily%20design.png)

## Thiết kế cơ bản

![image](ProjectEcommerce_Design-Basic%20design.png)

## Xuất diagram từ DBeaver

![image](ecommerce_diagram_dbeaver.png)

## Bảng `address` - địa chỉ

```sql
CREATE TABLE `address` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_users` int NOT NULL,
  `address` text NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_users` (`id_users`),
  CONSTRAINT `address_ibfk_1` FOREIGN KEY (`id_users`) REFERENCES `users` (`id`) ON DELETE CASCADE
)
```

![image](https://user-images.githubusercontent.com/95962543/156890518-4fe4ac75-5a29-421d-9a13-b8ae5e50d96b.png)

## Bảng `cart`- giỏ hàng

```sql
CREATE TABLE `cart` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_users` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_users` (`id_users`),
  CONSTRAINT `cart_ibfk_1` FOREIGN KEY (`id_users`) REFERENCES `users` (`id`) ON DELETE CASCADE
)
```

![image](https://user-images.githubusercontent.com/95962543/156890601-b91f87a0-2e59-4509-84bc-fc9d9f5234b1.png)

## Bảng `cart_product`

```sql
CREATE TABLE `cart_product` (
  `id_cart` int NOT NULL,
  `id_product` int NOT NULL,
  PRIMARY KEY (`id_cart`,`id_product`),
  KEY `id_product` (`id_product`),
  CONSTRAINT `cart_product_ibfk_1` FOREIGN KEY (`id_cart`) REFERENCES `cart` (`id`) ON DELETE CASCADE,
  CONSTRAINT `cart_product_ibfk_2` FOREIGN KEY (`id_product`) REFERENCES `product` (`id`)
)
```

![image](https://user-images.githubusercontent.com/95962543/156890643-34071ead-beda-4fa1-9314-a259ea121d7f.png)

## Bảng `category` - danh mục sản phẩm

```sql
CREATE TABLE `category` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` text NOT NULL,
  PRIMARY KEY (`id`)
)
```

![image](https://user-images.githubusercontent.com/95962543/156890762-90b8f275-f687-4fb9-9888-9679614478c0.png)

## Bảng `country` - quốc gia

```sql
CREATE TABLE `country` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` text NOT NULL,
  PRIMARY KEY (`id`)
)
```

![image](https://user-images.githubusercontent.com/95962543/156890785-f111fc7f-4bed-494d-8021-1a3037729e2e.png)

## Bảng `discuss` - thảo luận

```sql
CREATE TABLE `discuss` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_users` int NOT NULL,
  `id_product` int NOT NULL,
  `discuss` text NOT NULL,
  `create_at` date NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_users` (`id_users`),
  KEY `id_product` (`id_product`),
  CONSTRAINT `discuss_ibfk_1` FOREIGN KEY (`id_users`) REFERENCES `users` (`id`),
  CONSTRAINT `discuss_ibfk_2` FOREIGN KEY (`id_product`) REFERENCES `product` (`id`) ON DELETE CASCADE
)
```

![image](https://user-images.githubusercontent.com/95962543/156890814-bd57d15a-cb0e-4528-8a3d-ef3f12592643.png)

## Bảng `manufacturer` - nhà sản xuất

```sql
CREATE TABLE `manufacturer` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` text NOT NULL,
  PRIMARY KEY (`id`)
)
```

![image](https://user-images.githubusercontent.com/95962543/156890846-c87a20b3-27cc-4ffb-8e81-a20e009bfd9f.png)

## Bảng `orders` - đơn hàng

```sql
CREATE TABLE `orders` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_users` int NOT NULL,
  `date` date DEFAULT NULL,
  `payment_method` enum('debit/credit','cod') NOT NULL,
  `status` text,
  PRIMARY KEY (`id`),
  KEY `id_users` (`id_users`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`id_users`) REFERENCES `users` (`id`)
)
```

![image](https://user-images.githubusercontent.com/95962543/156890887-fea430f4-3c0b-4736-8e93-b6d6d252a236.png)

## Bảng `orders_shipper`

```sql
CREATE TABLE `orders_shipper` (
  `id_orders` int NOT NULL,
  `id_shipper` int NOT NULL,
  PRIMARY KEY (`id_orders`,`id_shipper`),
  KEY `id_shipper` (`id_shipper`),
  CONSTRAINT `orders_shipper_ibfk_1` FOREIGN KEY (`id_orders`) REFERENCES `orders` (`id`) ON DELETE CASCADE,
  CONSTRAINT `orders_shipper_ibfk_2` FOREIGN KEY (`id_shipper`) REFERENCES `shipper` (`id`)
)
```

![image](https://user-images.githubusercontent.com/95962543/156890944-9ee04571-ecbc-4e23-9e6e-144144730682.png)

## Bảng `orders_voucher`

```sql
CREATE TABLE `orders_voucher` (
  `id_orders` int NOT NULL,
  `id_voucher` int NOT NULL,
  PRIMARY KEY (`id_orders`,`id_voucher`),
  KEY `id_voucher` (`id_voucher`),
  CONSTRAINT `orders_voucher_ibfk_1` FOREIGN KEY (`id_orders`) REFERENCES `orders` (`id`) ON DELETE CASCADE,
  CONSTRAINT `orders_voucher_ibfk_2` FOREIGN KEY (`id_voucher`) REFERENCES `voucher` (`id`)
)
```

![image](https://user-images.githubusercontent.com/95962543/156890967-136a703a-b576-4eb5-a7b8-b8d282071a9b.png)

## Bảng `price` - giá

```sql
CREATE TABLE `price` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_product` int DEFAULT NULL,
  `price` bigint NOT NULL,
  `start_date` date NOT NULL,
  `end_date` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_product` (`id_product`),
  CONSTRAINT `price_ibfk_1` FOREIGN KEY (`id_product`) REFERENCES `product` (`id`) ON DELETE CASCADE
)
```

![image](https://user-images.githubusercontent.com/95962543/156890983-cb9375f5-12f4-42b3-8944-b63d3b57dceb.png)

## Bảng `product` - sản phẩm

```sql
CREATE TABLE `product` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `image` text,
  `description` text NOT NULL,
  `quantity` bigint DEFAULT NULL,
  `sold_quantity` bigint NOT NULL,
  `id_shop` int NOT NULL,
  `id_category` int NOT NULL,
  `id_manufacturer` int NOT NULL,
  `id_country` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_shop` (`id_shop`),
  KEY `id_category` (`id_category`),
  KEY `id_manufacturer` (`id_manufacturer`),
  KEY `id_country` (`id_country`),
  CONSTRAINT `product_ibfk_1` FOREIGN KEY (`id_shop`) REFERENCES `shop` (`id`),
  CONSTRAINT `product_ibfk_2` FOREIGN KEY (`id_category`) REFERENCES `category` (`id`),
  CONSTRAINT `product_ibfk_3` FOREIGN KEY (`id_manufacturer`) REFERENCES `manufacturer` (`id`),
  CONSTRAINT `product_ibfk_4` FOREIGN KEY (`id_country`) REFERENCES `country` (`id`)
)
```

![image](https://user-images.githubusercontent.com/95962543/156891030-4f17b3f0-1cb7-4b57-be8f-980e4be1a9cc.png)

## Bảng `product_orders`

```sql
CREATE TABLE `product_orders` (
  `id_product` int NOT NULL,
  `id_orders` int NOT NULL,
  `quantity` int NOT NULL,
  PRIMARY KEY (`id_product`,`id_orders`),
  KEY `id_orders` (`id_orders`),
  CONSTRAINT `product_orders_ibfk_1` FOREIGN KEY (`id_product`) REFERENCES `product` (`id`),
  CONSTRAINT `product_orders_ibfk_2` FOREIGN KEY (`id_orders`) REFERENCES `orders` (`id`)
)
```

![image](https://user-images.githubusercontent.com/95962543/156891047-63b416d6-0d18-497f-957f-36e8ad89d131.png)

## Bảng `product_tag`

```sql
CREATE TABLE `product_tag` (
  `id_product` int NOT NULL,
  `id_tag` int NOT NULL,
  PRIMARY KEY (`id_product`,`id_tag`),
  KEY `id_tag` (`id_tag`),
  CONSTRAINT `product_tag_ibfk_1` FOREIGN KEY (`id_product`) REFERENCES `product` (`id`) ON DELETE CASCADE,
  CONSTRAINT `product_tag_ibfk_2` FOREIGN KEY (`id_tag`) REFERENCES `tag` (`id`) ON DELETE CASCADE
)
```

![image](https://user-images.githubusercontent.com/95962543/156891370-f1e71b0e-46a1-4fd3-a7ec-e9cd67d5e483.png)

## Bảng `rating` - đánh giá

```sql
CREATE TABLE `rating` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_users` int NOT NULL,
  `id_product` int NOT NULL,
  `rating` int NOT NULL,
  `create_at` date NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_users` (`id_users`),
  KEY `id_product` (`id_product`),
  CONSTRAINT `rating_ibfk_1` FOREIGN KEY (`id_users`) REFERENCES `users` (`id`),
  CONSTRAINT `rating_ibfk_2` FOREIGN KEY (`id_product`) REFERENCES `product` (`id`) ON DELETE CASCADE
)
```

![image](https://user-images.githubusercontent.com/95962543/156891119-ba963c29-eda0-4fd9-8c67-d37528a56122.png)

## Bảng `role` - vai trò

```sql
CREATE TABLE `role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `role` int NOT NULL,
  PRIMARY KEY (`id`)
)
```

![image](https://user-images.githubusercontent.com/95962543/156891141-5bc9f51a-614b-4211-bdce-5b37ef9a9379.png)

## Bảng `shipper` - đơn vị vận chuyển

```sql
CREATE TABLE `shipper` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` text NOT NULL,
  PRIMARY KEY (`id`)
)
```

![image](https://user-images.githubusercontent.com/95962543/156891163-af9df082-e2cd-4e3f-a1d7-6fe8ad9878be.png)

## Bảng `shop` - cửa hàng

```sql
CREATE TABLE `shop` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_owner` int NOT NULL,
  `name` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `create_at` date DEFAULT NULL,
  `status` enum('normal','locked') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `address` text NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_owner` (`id_owner`),
  CONSTRAINT `shop_ibfk_1` FOREIGN KEY (`id_owner`) REFERENCES `users` (`id`)
)
```

![image](https://user-images.githubusercontent.com/95962543/156891175-25f2a677-9740-476e-bc4d-2dd6b3661cfa.png)

## Bảng `tag` - thẻ

```sql
CREATE TABLE `tag` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` text NOT NULL,
  PRIMARY KEY (`id`)
)
```

![image](https://user-images.githubusercontent.com/95962543/156891186-f4e39e7c-feac-40d3-a3a0-ef0a1407a54d.png)

## Bảng `users` - người dùng

```sql
CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` text NOT NULL,
  `email` text,
  `mobile` text,
  `password` text NOT NULL,
  `full_name` text NOT NULL,
  `gender` enum('male','female') DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `create_at` date DEFAULT NULL,
  `status` enum('normal','locked') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`)
)
```

![image](https://user-images.githubusercontent.com/95962543/156891210-806ce0e7-b17c-4d54-869d-79b8d161f54c.png)

## Bảng `users_role`

```sql
CREATE TABLE `users_role` (
  `id_users` int NOT NULL,
  `id_role` int NOT NULL,
  PRIMARY KEY (`id_users`,`id_role`),
  KEY `id_role` (`id_role`),
  CONSTRAINT `users_role_ibfk_1` FOREIGN KEY (`id_users`) REFERENCES `users` (`id`) ON DELETE CASCADE,
  CONSTRAINT `users_role_ibfk_2` FOREIGN KEY (`id_role`) REFERENCES `role` (`id`) ON DELETE CASCADE
)
```

![image](https://user-images.githubusercontent.com/95962543/156891227-a4101dbf-ab7f-4041-9de7-8778f700f57d.png)

## Bảng `voucher` - mã giảm giá

```sql
CREATE TABLE `voucher` (
  `id` int NOT NULL AUTO_INCREMENT,
  `percent` int NOT NULL,
  `min_price` bigint DEFAULT NULL,
  `start_date` date NOT NULL,
  `end_date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
)
```

![image](https://user-images.githubusercontent.com/95962543/156891244-9403cfc2-6545-44e7-ae7f-a30dc1195550.png)
