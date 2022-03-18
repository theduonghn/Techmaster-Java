// Tính tuổi cha con
// Viết chương trình nhập vào tuổi của cha và con hiện tại, tính và in ra xem bao nhiêu năm nữa thì tuổi cha gấp 2 lần tuổi con

let ageChild = 4;
let ageParent = 30;
let years = 0;
while (ageChild * 2 != ageParent) {
  ageChild++;
  ageParent++;
  years++;
}
console.log(years);
