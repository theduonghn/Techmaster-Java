// Viết hàm spelling(word) nhận vào một từ và đánh vần nó, bằng cách nối liên tiếp các chữ cái cho đến khi hoàn thành từ đầy đủ, kết quả trả về là một mảng
// Ví dụ:

// spelling("happy") -> ["h", "ha", "hap", "happ", "happy"]

function spelling(word) {
  let result = [];
  let currentSpelling = "";
  for (let char of word) {
    currentSpelling += char;
    result.push(currentSpelling);
  }
  return result;
}

console.log(spelling("happy"));
