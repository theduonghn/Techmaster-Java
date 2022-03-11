// Kiểm tra số lớn nhất
// Viết hàm findMax(a, b, c), hàm nhận 3 tham số a, b, c là 3 số bất kỳ. Kiểm tra và trả về kết quả số lớn nhất trong 3 số

function findMax(a, b, c) {
  let max = a;
  if (b > max) max = b;
  if (c > max) max = c;
  return max;
}

console.log(findMax(1, 5, 6));
console.log(findMax(29, 3, 5));
console.log(findMax(-8, 7, 0));
console.log(findMax(4, 1, 2.5));
console.log(findMax(99, 99.01, 3));
