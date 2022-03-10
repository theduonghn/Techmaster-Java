let ageChild = 4;
let ageParent = 30;
let count = 0;
while (true) {
  ageChild++;
  ageParent++;
  count++;
  if (ageChild * 2 == ageParent) {
    break;
  }
}
console.log(count);
