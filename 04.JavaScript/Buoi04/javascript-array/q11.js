// Tạo một hàm nhận một mảng các đối tượng bao gồm tên và một mảng notes, tính và trả về một mảng các đối tượng tương ứng với giá trị avg là giá trị trung bình của mảng notes, nếu notes rỗng thì mặc định avg = 0
// Ví dụ:

// // Ví dụ một object
// { name: "John", notes: [3, 4] }

// const arr = [
// 	{ name: "John", notes: [3, 4] },
// 	{ name: "Ben", notes: [1, 2, 3, 4] },
// 	{ name: "Phoebe", notes: [] }
// ]

// calcAvgNotes(arr) // result [ { name: "John", avg: 3.5 }, { name: "Ben", avg: 2.5 }, { name: "Phoebe", avg: 0 } ]

function calcAvgNotes(arr) {
  let result = [];
  for (e of arr) {
    let newObj = {};
    newObj.name = e.name;
    if (e.notes.length == 0) {
      newObj.avg = 0;
    } else {
      let sumNotes = 0;
      for (let note of e.notes) {
        sumNotes += note;
      }
      let avgNotes = sumNotes / e.notes.length;
      newObj.avg = avgNotes;
    }
    result.push(newObj);
  }
  return result;
}

console.log(
  calcAvgNotes([
    { name: "John", notes: [3, 4] },
    { name: "Ben", notes: [1, 2, 3, 4] },
    { name: "Phoebe", notes: [] },
  ])
);
