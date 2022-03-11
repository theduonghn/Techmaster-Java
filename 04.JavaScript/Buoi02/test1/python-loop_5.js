// Số nguyên tố
// Viết chương trình nhập vào một số n nguyên dương bất kỳ. Kiểm tra và in ra xem n có phải cố nguyên tố hay không?

// (*) Số nguyên tố là số chỉ chia hết cho 1 và chính nó, không chia hết cho bất kỳ số nào khác

function isPrime(n) {
  if (n < 2) return false;
  for (let i = 2; i <= Math.sqrt(n); i++) {
    if (n % i == 0) return false;
  }
  return true;
}

console.log(1, isPrime(1));
console.log(2, isPrime(2));
console.log(0, isPrime(0));
console.log(5, isPrime(5));
console.log(3, isPrime(3));
console.log(65, isPrime(65));
console.log(13, isPrime(13));
console.log(27, isPrime(27));
console.log(41, isPrime(41));
