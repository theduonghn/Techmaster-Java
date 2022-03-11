// Tính hóa đơn nước
// Viết hàm calcWaterBill(m3) tính và trả về số tiền phải trả cho hóa đơn nước của một hộ gia đình theo số mét khối (m3) nước đã sử dụng. Quy định như sau:

// Dưới 5m3 thì giá cố định 45000đ
// Bậc 1: 10m3 thì giá 9000đ/m3
// Bậc 2: Từ m3 thứ 10 đến m3 thứ 20 thì giá 11000đ/m3
// Bậc 3: Từ m3 thứ 20 đến m3 thứ 30 thì giá 13000đ/m3
// Bậc 4: Từ m3 thứ 31 trở lên thì giá 15000đ/m3
// Công thức tính số tiền: Tổng tiền = bậc 1 + bậc 2 + bậc 3 + bậc 4

const STAGE_0_PRICE = 45000;
const RATES = {
  1: 9000,
  2: 11000,
  3: 13000,
  4: 15000,
};
const LOWER_BOUNDS = {
  1: 5,
  2: 10,
  3: 20,
  4: 30,
};

function calcElectricBill(m3) {
  if (m3 < LOWER_BOUNDS[1]) {
    return STAGE_0_PRICE;
  } else {
    let money = 0;
    let remainingM3 = m3;
    for (let i = Object.keys(RATES).length; i > 1; i--) {
      if (remainingM3 > LOWER_BOUNDS[i]) {
        let billedM3 = remainingM3 - LOWER_BOUNDS[i];
        remainingM3 -= billedM3;
        money += billedM3 * RATES[i];
      }
    }
    money += remainingM3 * RATES[1];
    return money;
  }
}

console.log(0, calcElectricBill(0));
console.log(0.5, calcElectricBill(0.5));
console.log(4.5, calcElectricBill(4.5));
console.log(5, calcElectricBill(5));
console.log(5.5, calcElectricBill(5.5));
console.log(9.5, calcElectricBill(9.5));
console.log(10, calcElectricBill(10));
console.log(10.5, calcElectricBill(10.5));
console.log(19.5, calcElectricBill(19.5));
console.log(20, calcElectricBill(20));
console.log(20.5, calcElectricBill(20.5));
console.log(29.5, calcElectricBill(29.5));
console.log(30, calcElectricBill(30));
console.log(30.5, calcElectricBill(30.5));
