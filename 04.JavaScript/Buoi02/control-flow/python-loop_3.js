// Bài toán gà và chó
// Vừa gà vừa chó Bó lại cho tròn Ba mươi sáu con Một trăm chân chẵn

// Tính và in ra số chân gà và chó

const TOTAL_ANIMALS = 36;
const TOTAL_LEGS = 100;
const LEGS_OF_CHICKEN = 2;
const LEGS_OF_DOG = 4;

let numChicken, numDog, numChickenLeg, numDogLeg;

for (numChicken = 0; numChicken <= TOTAL_ANIMALS; numChicken++) {
  numDog = TOTAL_ANIMALS - numChicken;
  numChickenLeg = numChicken * LEGS_OF_CHICKEN;
  numDogLeg = numDog * LEGS_OF_DOG;
  if (numChickenLeg + numDogLeg == TOTAL_LEGS) break;
}

console.log("Gà", numChicken);
console.log("Chó", numDog);
console.log("Chân gà", numChickenLeg);
console.log("Chân chó", numDogLeg);
