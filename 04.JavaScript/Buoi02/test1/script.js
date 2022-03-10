function findBMI(w, h) {
  let bmi = w / h ** 2;
  if (bmi <= 16) {
    console.log("Gầy độ III");
  } else if (bmi <= 17.5) {
    console.log("Gầy độ II");
  } else if (bmi <= 18.5) {
    console.log("Gầy độ I");
  } else if (bmi <= 25) {
    console.log("Bình thường");
  } else if (bmi <= 30) {
    console.log("Hơi béo");
  } else if (bmi <= 35) {
    console.log("Béo phì độ I");
  } else if (bmi <= 40) {
    console.log("Béo phì độ II");
  } else if (bmi < 40) {
    console.log("Béo phì độ III");
  }
}

let w = prompt("Nhập cân nặng (kg)");
let h = prompt("Nhập chiều cao (m)");

findBMI(w, h);
