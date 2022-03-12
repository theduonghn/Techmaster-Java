// Tìm số lớn thứ 3
// Tạo một dãy số chưa được sắp xếp (1, 3, 6, 4, 2, 6, 7), tìm số lớn thứ 3 trong dãy số đó (lưu ý trường hợp các số trùng nhau)

// Ví dụ: Dãy số: (1, 3, 6, 4, 2, 6, 7) Số lớn thứ 3: 4

function createUniqueArray(array) {
  let result = [];
  let inArray = {};
  for (let item of array) {
    if (item in inArray) {
      continue;
    } else {
      result.push(item);
      inArray[item] = true;
    }
  }
  return result;
}

function findThirdMax(numbers) {
  let uniqueNumbers = createUniqueArray(numbers);
  uniqueNumbers = uniqueNumbers.sort((a, b) => {
    if (a > b) return -1;
    else return 1;
  });
  console.log(uniqueNumbers);
  return uniqueNumbers[2];
}

let sequence = [1, 3, 6, 4, 2, 6, 7];
console.log(createUniqueArray(sequence));
console.log(findThirdMax(sequence));
