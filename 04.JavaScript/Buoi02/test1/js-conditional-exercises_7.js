// Tính điểm tốt nghiệp
// Viết hàm calcGrade(p) tính và trả về xếp hạng tốt nghiệp cho sinh viên theo số điểm trung bình (p). Quy định như sau:

// p < 4.0: Xếp loại F
// 4.0 <= p < 5.5: Xếp loại D
// 5.5 <= p < 7.0: Xếp loại C
// 7.0 <= p < 8.5: Xếp loại B
// p >= 8.5: Xếp loại A

function calcGrade(averagePoint) {
  if (averagePoint < 4) return "F";
  else if (averagePoint < 5.5) return "D";
  else if (averagePoint < 7) return "C";
  else if (averagePoint < 8.5) return "B";
  else return "A";
}

console.log(3.9, calcGrade(3.9));
console.log(4, calcGrade(4));
console.log(5.4, calcGrade(5.4));
console.log(5.5, calcGrade(5.5));
console.log(5.6, calcGrade(5.6));
console.log(6.9, calcGrade(6.9));
console.log(7, calcGrade(7));
console.log(7.1, calcGrade(7.1));
console.log(8.4, calcGrade(8.4));
console.log(8.5, calcGrade(8.5));
console.log(8.6, calcGrade(8.6));
