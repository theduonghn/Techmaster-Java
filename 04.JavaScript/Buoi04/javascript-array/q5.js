// Cho một danh sách 2D gồm mảng các chữ cái và một danh sách chỉ mục, hãy tìm các chữ cái trên các chỉ mục đã cho và trả về dưới dạng một chuỗi
// Ví dụ:

// const arr = [
// 	["m", "u", "b"],
// 	["a", "s", "h"],
// 	["i", "r", "1"]
// ]

// // Chỉ mục tương ứng là
// [
// 	[1, 2, 3],
// 	[4, 5, 6],
// 	[7, 8, 9],
// ]

// const idx = [1, 3, 5, 8]

// findByIndex(arr, idx) // result "mbsr"

function findByIndex(arr, idx) {
  let result = "";
  idx.forEach((i) => {
    let rowColumn = findRowColumn(i);
    let row = rowColumn[0];
    let column = rowColumn[1];
    result += arr[row][column];
  });
  return result;
}

function findRowColumn(idx) {
  for (let i = 0; i < INDEXES.length; i++) {
    for (let j = 0; j < INDEXES[i].length; j++) {
      if (INDEXES[i][j] == idx) return [i, j];
    }
  }
  return null;
}

const arr = [
  ["m", "u", "b"],
  ["a", "s", "h"],
  ["i", "r", "1"],
];

const INDEXES = [
  [1, 2, 3],
  [4, 5, 6],
  [7, 8, 9],
];

console.log(findByIndex(arr, [1, 3, 5, 8]));
console.log(findByIndex(arr, [1, 3, 2]));
console.log(findByIndex(arr, [9, 1, 5, 3]));
