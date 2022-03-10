function fibonacci(n) {
  if (n == 1) {
    return 0;
  } else if (n == 2) {
    return 1;
  } else {
    let a = 0;
    let b = 1;
    let c;
    for (let i = 3; i <= n; i++) {
      c = a + b;
      a = b;
      b = c;
    }
    return c;
  }
}

console.log(fibonacci(10));