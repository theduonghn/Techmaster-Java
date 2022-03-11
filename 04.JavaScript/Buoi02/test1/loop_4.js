// Viết chương trình in ra chữ số đầu và cuối của một số n (VD: 12345 -> 15)

function firstLast(n) {
  let lastDigit = n % 10;
  let firstDigit;
  while (Math.floor(n / 10) != 0) {
    n = Math.floor(n / 10);
  }
  firstDigit = n;
  return firstDigit * 10 + lastDigit;
}

let n;
n = 1891390112;
console.log(n, firstLast(n));
n = 165151123;
console.log(n, firstLast(n));
n = 56416;
console.log(n, firstLast(n));
n = 10646;
console.log(n, firstLast(n));
n = 4240;
console.log(n, firstLast(n));
n = 45645;
console.log(n, firstLast(n));
n = 22222;
console.log(n, firstLast(n));
n = 45645425;
console.log(n, firstLast(n));
n = 4564;
console.log(n, firstLast(n));
n = 456787;
console.log(n, firstLast(n));
