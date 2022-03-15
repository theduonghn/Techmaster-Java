// Viết hàm secondLargest(numbers) nhận một mảng các số bất kỳ, tìm và trả về số lớn thứ hai trong mảng (lưu ý trường hợp có nhiều giá trị trùng nhau)
// Ví dụ:

// secondLargest([10, 50, 40, 30, 20, 40, 50]) // result 40

function secondLargest(numbers) {
  let max = numbers[0];
  let secondMax;
  for (let num of numbers) {
    if (num > max) {
      secondMax = max;
      max = num;
    } else if (secondMax && num != max && num > secondMax) {
      secondMax = num;
    } else if (isNaN(secondMax) && num != max) {
      secondMax = num;
    }
  }
  return secondMax;
}

console.log(
  secondLargest([90, 99, -3, 4, 5, 99, 90, 10, 50, 40, 30, 20, 40, 50])
);
console.log(secondLargest([5, 4, 3, 2, 1]));

console.log(secondLargest([5, 5, 4, 4, 4, 5, 3, 2, 1]));
