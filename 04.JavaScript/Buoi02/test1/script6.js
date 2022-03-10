let numChicken = 0;
let numDog = 0;
let numChickenLeg = 0;
let numDogLeg = 0;

while (true) {
  numDog = 36 - numChicken;
  numChickenLeg = numChicken * 2;
  numDogLeg = numDog * 4;
  if (numChickenLeg + numDogLeg == 100) {
    break;
  } else {
    numChicken++;
  }
}
console.log("Gà", numChicken);
console.log("Chó", numDog);
console.log("Chân gà", numChickenLeg);
console.log("Chân chó", numDogLeg);
