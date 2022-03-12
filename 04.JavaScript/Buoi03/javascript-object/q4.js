// Viết một hàm đảo ngược các khóa và giá trị của một đối tượng, kết quả trả về là một đối tượng mới
// // Ví dụ
// const obj = { a: 1, b: 2, c: 3 };

// invert(obj) // { 1: "a", 2: "b", 3: "c" }

function invert(obj) {
  let newObj = {};
  for (let key in obj) {
    let value = obj[key];
    newObj[value] = key;
  }
  return newObj;
}

console.log(invert({ a: 1, b: 2, c: 3 }));
