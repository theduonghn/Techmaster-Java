function USD2VND(n) {
  // Convert USD to VND
  return n * 23500;
}

// Run
let usd = Number(prompt("Nhập số tiền USD"));
alert(usd + " USD tương đương với " + USD2VND(usd) + " VND");
