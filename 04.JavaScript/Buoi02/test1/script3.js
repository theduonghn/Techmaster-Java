let n = 1891390112;
let lastDigit = n % 10;
let firstDigit;
while (true) {
  if (Math.floor(n / 10) == 0) {
    firstDigit = n;
    break;
  } else {
    n = Math.floor(n / 10);
  }
}
console.log(firstDigit * 10 + lastDigit);
