// Đảo ngược chuỗi
// Viết chương trình yêu cầu người dùng nhập một câu bất kỳ, đảo ngược thứ tự các từ trong câu, và đổi chữ hoa thành chữ thường, chữ thường thành chữ hoa.

// Ví dụ: Nhập vào: "tHE fOX iS cOMING fOR tHE cHICKEN" Kết quả: "Chicken The For Coming Is Fox The"

function reverseSentence(sentence) {
  let reversedCaseSentence = "";
  for (let i = 0; i < sentence.length; i++) {
    let char = sentence[i];
    if (char == char.toUpperCase()) {
      reversedCaseSentence += char.toLowerCase();
    } else {
      reversedCaseSentence += char.toUpperCase();
    }
  }
  let words = reversedCaseSentence.split(" ");
  //   let reversedSentence = "";
  //   for (i = words.length - 1; i > 0; i--) {
  //     reversedSentence += words[i] + " ";
  //   }
  //   reversedSentence += words[0];
  return words.reverse().join(" ");
}

console.log(reverseSentence("tHE fOX iS cOMING fOR tHE cHICKEN"));
