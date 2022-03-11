// Tổng số nguyên tố
// Viết chương trình nhập vào 2 số a và b, kiểm tra và in ra dãy số nguyên tố trong khoảng từ a đến b, (lưu ý a có thể nhỏ hơn b)

function isPrime(n) {
  if (n < 2) return false;
  for (let i = 2; i <= Math.sqrt(n); i++) {
    if (n % i == 0) return false;
  }
  return true;
}

function showPrimeNumbersInRange(a, b) {
  for (let i = a; i <= b; i++) {
    if (isPrime(i)) console.log(i);
  }
}

showPrimeNumbersInRange(0, 100);
