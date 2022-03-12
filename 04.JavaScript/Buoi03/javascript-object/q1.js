// Khai báo một object với key là tên và value là tuổi tương ứng của các thành viên trong một gia đình, viết hàm afterNYears(obj, n) nhận vào object và số năm n, tính và trả về kết quả là một object mới thể hiện sau n năm thì những người đó bao nhiêu tuổi
// // Ví dụ
// const myFamily = {
// 	Joel: 32,
// 	Fred: 44,
// 	Reginald: 65,
// 	Susan: 33,
// 	Julian: 13
// }

// afterNYears(myFamily, 1);

// // Kết quả
// {
// 	Joel: 33,
// 	Fred: 45,
// 	Reginald: 66,
// 	Susan: 34,
// 	Julian: 14
// }

const myFamily = {
  Joel: 32,
  Fred: 44,
  Reginald: 65,
  Susan: 33,
  Julian: 13,
};

function afterNYears(family, years) {
  result = {};
  for (memberName in family) {
    result[memberName] = family[memberName] + years;
  }
  return result;
}

console.log(myFamily);
console.log(afterNYears(myFamily, 5));
