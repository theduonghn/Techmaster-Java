// Tính tiền taxi
// Viết hàm calcTaxiFee(km) tính và trả về số tiền phải trả cho khách đi taxi theo số kilomet (km) đã di chuyển. Quy định như sau:

// Phí mở cửa 10.000
// Dưới 30km: 11.000đ/km
// Từ km thứ 31: 9.500đ/km
// Công thức tính tiền: Tổng bill = phí mở cửa + tổng tiền trên số km

const OPEN_FEE = 10000;
const RATES = {
  1: 11000,
  2: 9500,
};
const LOWER_BOUNDS = {
  1: 0,
  2: 30,
};

function calcTaxiFee(km) {
  let money = 0;
  let remainingKm = km;
  for (let i = Object.keys(RATES).length; i >= 1; i--) {
    if (remainingKm > LOWER_BOUNDS[i]) {
      let billedKm = remainingKm - LOWER_BOUNDS[i];
      remainingKm -= billedKm;
      money += billedKm * RATES[i];
    }
  }
  money += OPEN_FEE;
  return money;
}

console.log(0, calcTaxiFee(0));
console.log(29.5, calcTaxiFee(29.5));
console.log(30, calcTaxiFee(30));
console.log(30.5, calcTaxiFee(30.5));
