// Tính tổng
// Cho dãy số (1, 3, 6, 4, 2, 6, 7), tính tổng dãy số đó (không tính các số trùng lặp)

// Ví dụ: Dãy số: (1, 3, 6, 4, 2, 6, 7) Dãy số duy nhất: 1, 3, 6, 4, 2, 7 Tổng: 23

function sumUnique(sequence) {
  let sum = 0;
  let uniqueSequence = new Set(sequence);
  for (number of uniqueSequence) {
    sum += number;
  }
  return sum;
}

let sequence = [1, 3, 6, 4, 2, 6, 7];
console.log(sumUnique(sequence));
