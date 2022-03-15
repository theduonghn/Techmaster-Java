// Tí và Tèo đang chơi chơi oẳn tù tì. Trò chơi oẳn tù tì có các kiểu búa(cả bàn tay nắm), kéo(ngón trỏ và giữa thành chữ V), giấy(bàn tay xòe). Mỗi trò chơi được thể hiện bằng một mảng 2 phần tử, trong đó phần tử đầu tiên đại diện cho những gì Tí đã chơi và phần tử thứ hai đại diện cho những gì Tèo đã chơi. Cho một chuỗi các trò chơi, hãy xác định xem ai là người thắng nhiều trận nhất. Nếu hòa, trả về Tie.
// Ví dụ:

// // H viết tắt của búa
// // P viết tắt của giấy
// // S viết tắt của kéo

// calculateScore([["H", "P"], ["H", "S"], ["S", "P"]]) // "Tí"
// // Tèo (giấy thắng búa).
// // Tí thắng ván thứ hai (Búa thắng kéo).
// // Tí thắng ván ba (Kéo thắng giấy).
// // Tí thắng 2/3 -> Tí thắng.

function calcResult(match) {
  if (match[0] == match[1]) {
    return 0;
  } else if (match[0] == "H" && match[1] == "P") {
    return -1;
  } else if (match[0] == "H" && match[1] == "S") {
    return 1;
  } else if (match[0] == "P" && match[1] == "H") {
    return 1;
  } else if (match[0] == "P" && match[1] == "S") {
    return -1;
  } else if (match[0] == "S" && match[1] == "H") {
    return -1;
  } else if (match[0] == "S" && match[1] == "P") {
    return 1;
  }
}

function calculateScore(arr) {
  let score = 0;
  for (match of arr) {
    score += calcResult(match);
  }
  if (score == 0) {
    return "Tie";
  } else if (score > 0) {
    return "Tí";
  } else {
    return "Tèo";
  }
}

console.log(
  calculateScore([
    ["H", "P"],
    ["H", "S"],
    ["S", "P"],
  ])
);
console.log(calculateScore([["H", "S"]]));
console.log(calculateScore([["S", "H"]]));
console.log(calculateScore([["H", "H"]]));
console.log(
  calculateScore([
    ["H", "H"],
    ["H", "S"],
    ["P", "S"],
  ])
);
