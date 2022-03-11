// Tính lương cho nhân viên
// Viết hàm calcSalary(hoursWorked, hourlySalary), hàm nhận 2 tham số:

// hoursWorked là tổng số giờ làm việc trong tháng
// hourlySalary là lương mỗi giờ
// Tính và trả về lương ròng (số tiền lương thực sự nhận được) của nhân viên đó dựa trên tổng lương và thưởng/phạt theo số giờ làm việc trung bình mỗi ngày (1 tháng quy định 25 ngày làm việc)

// Công thức tính tổng lương:

// grossSalary = hoursWorked * hourlySalary
// Số giờ làm việc trung bình mỗi ngày:

// avgHours = hoursWorked / 25
// Nếu avgHours >= 8 thì thưởng thêm 500.000
// Nếu avgHours < 8 thì phạt 500.000
// Công thức tính lương ròng: Lương ròng (netSalary) = tổng lương +/- thưởng/phạt

function calcSalary(hoursWorked, hourlySalary) {
  let grossSalary = hoursWorked * hourlySalary;
  let avgHours = hoursWorked / 25;
  let bonus = 500000;
  let fine = -500000;
  let netSalary;
  if (avgHours >= 8) netSalary = grossSalary + bonus;
  else netSalary = grossSalary + fine;
  return netSalary;
}

console.log(calcSalary(200, 50000));
console.log(calcSalary(201, 20000));
console.log(calcSalary(183, 42000));
console.log(calcSalary(245, 115000));
console.log(calcSalary(157, 63000));
console.log(calcSalary(168, 45000));
