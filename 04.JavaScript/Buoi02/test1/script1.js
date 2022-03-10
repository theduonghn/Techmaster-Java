function findMax(a, b, c) {
  if (a > b) {
    if (a > c) return a;
    else return c;
  } else {
    if (b > c) return b;
    else return c;
  }
}

a = prompt("Nhập a");
b = prompt("Nhập b");
c = prompt("Nhập c");
alert("Số lớn nhất: " + findMax(a, b, c));
