// Đổi vị trí
// Cho một list bất kỳ, viết chương trình hoán đổi vị trí phần tử đầu và cuối của list

function swapFirstLast(list) {
  let temp = list[0];
  list[0] = list[list.length - 1];
  list[list.length - 1] = temp;
}

let list = [9, 5, 6, 7, 8, 0, 1, 2, 3];
swapFirstLast(list);
console.log(list);
