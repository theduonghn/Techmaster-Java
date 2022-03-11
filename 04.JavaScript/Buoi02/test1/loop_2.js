// Viết chương trình lặp giá trị i từ 1 đến 10, với mỗi giá trị i, kiểm tra xem:
// Nếu i chia hết cho 3 thì in ra console “Fizz”
// Nếu i chia hết cho 5 thì in ra console “Buzz”
// Nếu i chia hết cho cả 3 và 5 thì in ra “FizzBuzz”

for (let i = 1; i <= 30; i++) {
  if (i % 3 == 0 && i % 5 == 0) console.log(i, "FizzBuzz");
  else if (i % 3 == 0) console.log(i, "Fizz");
  else if (i % 5 == 0) console.log(i, "Buzz");
}
