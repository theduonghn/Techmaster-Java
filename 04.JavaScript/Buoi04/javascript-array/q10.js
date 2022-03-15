// Viết một hàm nhận một mảng các đối tượng (hàng tạp hóa) để tính tổng giá và trả về nó dưới dạng một số. Đối tượng tạp hóa có tên sản phẩm, số lượng và giá cả.
// Ví dụ:

// // Dữ liệu về một sản phẩm
// {
// 	"product": "Milk",
// 	"quantity": 1,
// 	"price": 1.50
// }

// // Danh sách sản phẩm
// const order = [
// 	{ product: "Milk", quantity: 1, price: 1.50 },
// 	{ product: "Eggs", quantity: 12, price: 0.10 },
// 	{ product: "Bread", quantity: 2, price: 1.60 },
// 	{ product: "Cheese", quantity: 1, price: 4.50 }
// ]

// getTotalPrice(order) // result 10.4

function getTotalPrice(order) {
  return order.reduce((sum, item) => sum + item.quantity * item.price, 0);
}

console.log(
  getTotalPrice([
    { product: "Milk", quantity: 1, price: 1.5 },
    { product: "Eggs", quantity: 12, price: 0.1 },
    { product: "Bread", quantity: 2, price: 1.6 },
    { product: "Cheese", quantity: 1, price: 4.5 },
  ])
);
