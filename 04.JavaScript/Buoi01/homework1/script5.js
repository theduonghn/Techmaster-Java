function findArea(a, b, c) {
  // Calculate area of triangle known 3 sides
  let p = (a + b + c) / 2; // Half of perimeter
  return Math.sqrt(p * (p - a) * (p - b) * (p - c));
}

// Run
let a = Number(prompt("Nhập cạnh a"));
let b = Number(prompt("Nhập cạnh b"));
let c = Number(prompt("Nhập cạnh c"));
alert("Diện tích tam giác là: " + findArea(a, b, c));
