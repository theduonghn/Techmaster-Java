function findArea(a, b) {
  // Calculate area of rectangle with side a and side b
  return a * b;
}

// Run
let a = Number(prompt("Nhập cạnh a"));
let b = Number(prompt("Nhập cạnh b"));
alert("Diện tích hình chữ nhật là: " + findArea(a, b));
