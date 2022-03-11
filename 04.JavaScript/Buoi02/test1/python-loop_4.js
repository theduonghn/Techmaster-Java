// Số Fibonacci
// Viết chương trình nhập vào một số n. Tính và in ra số fibonacci thứ n

// (*) Dãy Fibonacci là dãy số bắt đầu bằng 0 và 1, các số sau bằng tổng 2 số trước đó cộng lại (0 1 1 2 3 5 ...)

// (*) n = 3 => Số thứ 3 trong dãy fibonacci là số 1

function fibonacciAt(n) {
  if (n == 1) return 0;
  else if (n == 2) return 1;
  else {
    let previousFibo1 = 0;
    let previousFibo2 = 1;
    let currentFibo;
    for (let i = 3; i <= n; i++) {
      currentFibo = previousFibo1 + previousFibo2;
      previousFibo1 = previousFibo2;
      previousFibo2 = currentFibo;
    }
    return currentFibo;
  }
}

console.log(fibonacciAt(10));
