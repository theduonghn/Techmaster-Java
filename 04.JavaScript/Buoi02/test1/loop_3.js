// Viết chương trình kiểm tra xem một số nguyên dương n có phải số nguyên tố hay không

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
