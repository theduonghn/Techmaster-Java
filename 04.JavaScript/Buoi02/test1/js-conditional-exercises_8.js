// Kiểm tra năm nhuận
// Viết hàm isLeafYear(y) kiểm tra một năm (y) có phải năm nhuận hay không và trả về kết quả là true hoặc false

// 💡 Năm nhuận là năm có số năm chia hết cho 400, hoặc chia hết cho 4 nhưng không chia hết cho 100

function isLeafYear(y) {
  return y % 400 == 0 || (y % 4 == 0 && y % 100 != 0);
}

console.log(1975, isLeafYear(1975));
console.log(2002, isLeafYear(2002));
console.log(2011, isLeafYear(2011));
console.log(1996, isLeafYear(1996));
console.log(1000, isLeafYear(1000));
console.log(400, isLeafYear(400));
console.log(2012, isLeafYear(2012));
console.log(2020, isLeafYear(2020));
console.log(2000, isLeafYear(2000));
