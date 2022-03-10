// function isLeafYear(y) {
//   return y % 400 == 0 || (y % 4 == 0 && y % 100 != 0);
// }

// console.log(1975, isLeafYear(1975));
// console.log(2002, isLeafYear(2002));
// console.log(2011, isLeafYear(2011));
// console.log(1996, isLeafYear(1996));
// console.log(1000, isLeafYear(1000));
// console.log(400, isLeafYear(400));
// console.log(2012, isLeafYear(2012));
// console.log(2020, isLeafYear(2020));
// console.log(2000, isLeafYear(2000));

// for (let i = 1; i <= 10; i++) {
//   if (i % 2 == 0) {
//     console.log(i, "chẵn");
//   } else {
//     console.log(i, "lẻ");
//   }
// }

// for (let i = 1; i <= 15; i++) {
//   if (i % 3 == 0 && i % 5 == 0) {
//     console.log(i, "FizzBuzz");
//   } else if (i % 3 == 0) {
//     console.log(i, "Fizz");
//   } else if (i % 5 == 0) {
//     console.log(i, "Buzz");
//   }
// }

function isPrime(n) {
  if (n < 2) {
    return false;
  }
  for (i = 2; i <= n / 2; i++) {
    if (n % i == 0) {
      return false;
    }
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
