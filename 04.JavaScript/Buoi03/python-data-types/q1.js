// Đảo ngược chuỗi
// Viết chương trình yêu cầu người dùng nhập một câu bất kỳ, đảo ngược thứ tự các từ trong câu, và đổi chữ hoa thành chữ thường, chữ thường thành chữ hoa.

// Ví dụ: Nhập vào: "tHE fOX iS cOMING fOR tHE cHICKEN" Kết quả: "Chicken The For Coming Is Fox The"

function reverseSentence(sentence) {
  let reversedCaseSentence = "";
  for (let char of sentence) {
    if (char == char.toUpperCase()) {
      reversedCaseSentence += char.toLowerCase();
    } else {
      reversedCaseSentence += char.toUpperCase();
    }
  }
  let words = reversedCaseSentence.split(" ");
  return words.reverse().join(" ");
}

console.log(reverseSentence("tHE fOX iS cOMING fOR tHE cHICKEN"));
