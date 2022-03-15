// Món salad trái cây ngon nhất khi trái cây được thái thành hạt lựu nhỏ và trộn đều! Viết hàm fruitSalad(fruits) nhận vào một mảng các loại trái cây (tên), cắt mỗi quả làm đôi (cắt chuỗi), sau đó sắp xếp các phần theo thứ tự abc và nối vào thành một chuỗi duy nhất.
// Ví dụ:

// fruitSalad(["apple", "pear", "grapes"]) // "apargrapepesple"

// // Cắt đôi ["ap", "ple", "pe", "ar", "gra", "pes"]
// // Sắp xếp: ["ap", "ar", "gra", "pe", "pes", "ple"]
// // Kết quả món salad: "apargrapepesple"

// function sliceFruit(fruit) {
//   let length = fruit.length;
//   let halfLength = Math.floor(length / 2);
//   return [fruit.slice(0, halfLength), fruit.slice(halfLength, length)];
// }

function fruitSalad(fruits) {
  let pieces = [];
  for (let fruit of fruits) {
    let length = fruit.length;
    let halfLength = Math.floor(length / 2);
    pieces.push(fruit.slice(0, halfLength));
    pieces.push(fruit.slice(halfLength));
  }
  return pieces.sort().join("");
}

console.log(fruitSalad(["apple", "pear", "grapes"]));
