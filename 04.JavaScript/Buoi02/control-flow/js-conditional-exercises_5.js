// Tính hóa đơn điện
// Viết hàm calcElectricBill(kw) tính và trả về số tiền phải trả cho hoá đơn điện của một hộ gia đình theo số điện (kw) đã sử dụng. Quy định như sau:

// Bậc 1: Dưới 50kw thì giá 1500đ/kw
// Bậc 2: Từ kw thứ 51 đến 100 thì giá 2000đ/kw
// Bậc 3: Từ kw thứ 101 đến 200 thì giá 2500đ/kw
// Bậc 4: Từ kw thứ 201 đến 400 thì giá 3000đ/kw
// Bậc 5: Từ kw thứ 401 trở lên thì giá là 4000đ/kw
// Công thức tính số tiền: Tổng tiền = bậc 1 + bậc 2 + bậc 3 + bậc 4 + bậc 5

const RATES = {
  1: 1500,
  2: 2000,
  3: 2500,
  4: 3000,
  5: 4000,
};
const LOWER_BOUNDS = {
  1: 0,
  2: 50,
  3: 100,
  4: 200,
  5: 400,
};

function calcElectricBill(kw) {
  let money = 0;
  let remainingKw = kw;
  for (let i = Object.keys(RATES).length; i >= 1; i--) {
    if (remainingKw > LOWER_BOUNDS[i]) {
      let billedKw = remainingKw - LOWER_BOUNDS[i];
      remainingKw -= billedKw;
      money += billedKw * RATES[i];
    }
  }
  return money;
}

console.log(0, calcElectricBill(0));
console.log(49, calcElectricBill(49));
console.log(50, calcElectricBill(50));
console.log(51, calcElectricBill(51));
console.log(99, calcElectricBill(99));
console.log(100, calcElectricBill(100));
console.log(101, calcElectricBill(101));
console.log(99, calcElectricBill(99));
console.log(100, calcElectricBill(100));
console.log(101, calcElectricBill(101));
console.log(199, calcElectricBill(199));
console.log(200, calcElectricBill(200));
console.log(201, calcElectricBill(201));
console.log(399, calcElectricBill(399));
console.log(400, calcElectricBill(400));
console.log(401, calcElectricBill(401));
