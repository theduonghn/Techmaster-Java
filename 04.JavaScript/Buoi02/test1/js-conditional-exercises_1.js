// Tính chỉ số BMI
// Viết hàm findBMI(w, h), hàm nhận 2 tham số:

// w là số cân nặng (kg)
// h là chiều cao (m)
// Tính chỉ số BMI (Body Mass Index) và trả về kết quả, quy định như sau:

// BMI = w / (h**2)
// BMI <= 16: Gầy độ III
// 16 < BMI <= 17.5: Gầy độ II
// 17.5 < BMI <= 18.5: Gầy độ I
// 18.5 < BMI <= 25: Bình thường
// 25 < BMI <= 30: Hơi béo
// 30 < BMI <= 35: Béo phì độ I
// 35 < BMI <= 40: Béo phì độ II
// 40 < BMI: Béo phì độ III

function findBMI(w, h) {
  let bmi = w / h ** 2;
  console.log(bmi);
  if (bmi <= 16) console.log("Gầy độ III");
  else if (bmi <= 17.5) console.log("Gầy độ II");
  else if (bmi <= 18.5) console.log("Gầy độ I");
  else if (bmi <= 25) console.log("Bình thường");
  else if (bmi <= 30) console.log("Hơi béo");
  else if (bmi <= 35) console.log("Béo phì độ I");
  else if (bmi <= 40) console.log("Béo phì độ II");
  else if (bmi < 40) console.log("Béo phì độ III");
}

findBMI(70, 1.7);
findBMI(65, 1.6);
findBMI(45, 1.5);
findBMI(80, 1.9);
findBMI(105, 1.65);
