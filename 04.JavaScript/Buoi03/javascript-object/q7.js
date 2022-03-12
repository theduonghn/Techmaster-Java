// Cho một đối tượng chứa tên và tuổi của một nhóm người, hãy trả về tên của người lớn tuổi nhất.
// // Ví dụ
// oldest({
// 	Emma: 71,
// 	Jack: 45,
// 	Amy: 15,
// 	Ben: 29
// }) // "Emma"

function oldest(people) {
  let oldestPersonName;
  let oldestPersonAge = 0;
  for (personName in people) {
    let personAge = people[personName];
    if (personAge > oldestPersonAge) {
      oldestPersonAge = personAge;
      oldestPersonName = personName;
    }
  }
  return oldestPersonName;
}

console.log(
  oldest({
    Emma: 71,
    Jack: 45,
    Amy: 15,
    Ben: 100,
  })
);
