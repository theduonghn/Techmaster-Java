// Tính số lần gấp giấy
// Viết chương trình tính và in ra số lần tối thiểu để gấp một tờ giấy có độ dày 0.1mm để được độ dày 1m

let initialThickness = 0.1 / 1000;
let targetThickness = 1;
let numFold = 0;
while (initialThickness < targetThickness) {
  initialThickness *= 2;
  numFold++;
}
console.log(numFold);
