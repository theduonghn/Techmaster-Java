// Viết hàm minmax(arr) nhận vào một mảng các số bất kỳ, tìm và trả về một mảng mới chứa cả số nhỏ nhất và số lớn nhất, theo đúng thứ tự đó.
// Ví dụ:

// minmax([1, 2, 3, 4, 5]) // result [1, 5]

function minmax(arr) {
  let min = arr[0];
  let max = arr[0];
  arr.forEach((e) => {
    if (e < min) min = e;
    if (e > max) max = e;
  });
  return [min, max];
}

console.log(minmax([1, 4, 6, 3, 2, 7, 0, 5, 1]));
