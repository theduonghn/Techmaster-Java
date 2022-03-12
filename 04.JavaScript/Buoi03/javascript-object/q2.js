// Tạo một hàm xác định xem đơn đặt hàng có đủ điều kiện để được miễn phí giao hàng hay không. Đơn đặt hàng đủ điều kiện để được giao hàng miễn phí nếu tổng chi phí của các mặt hàng đã mua vượt quá $50,00.
// // Ví dụ
// const order = { "Shampoo": 5.99, "Rubber Ducks": 15.99 }
// freeShipping(order) // false

// const order = { "Flatscreen TV": 399.99 }
// freeShipping({ "Flatscreen TV": 399.99 }) // true

function calcTotalCost(order) {
  let totalCost = 0;
  for (let productName in order) {
    totalCost += order[productName];
  }
  return totalCost;
}

function freeShipping(order) {
  return calcTotalCost(order) > 50;
}

const order = { Shampoo: 5.99, "Rubber Ducks": 15.99 };
console.log(calcTotalCost(order));
console.log(freeShipping(order));

const order2 = { "Flatscreen TV": 399.99 };
console.log(calcTotalCost(order2));
console.log(freeShipping(order2));
