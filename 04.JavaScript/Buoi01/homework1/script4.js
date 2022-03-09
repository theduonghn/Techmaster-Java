function compoundInterest(P, R, n, t) {
  return P * (1 + R / 100 / n) ** (n * t);
}

// Run
let P = Number(prompt("Nhập số tiền gốc ban đầu"));
let R = Number(prompt("Nhập lãi suất hàng năm (%)"));
let n = Number(prompt("Nhập số lần ghép lãi 1 năm"));
let t = Number(prompt("Nhập số năm gửi ngân hàng"));
alert(
  "Tổng số tiền của bạn (cả gốc và lãi) là: " + compoundInterest(P, R, n, t)
);
