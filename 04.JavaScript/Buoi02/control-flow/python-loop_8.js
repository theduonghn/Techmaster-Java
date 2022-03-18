// Ký tự xuất hiện nhiều nhất
// Cho chuỗi sau

// sentence = "This is a common interview question"
// Viết chương trình tìm ký tự xuất hiện nhiều nhất trong chuỗi, không tính khoảng trắng

function findMostFrequentlyChar(sentence) {
  let charCounter = {};
  for (let i in sentence) {
    let char = sentence[i];
    if (char == " ") continue;
    else if (char in charCounter) charCounter[char]++;
    else charCounter[char] = 1;
  }
  let max = 0;
  let mostFrequentlyChar;
  for (let char in charCounter) {
    if (charCounter[char] > max) {
      max = charCounter[char];
      mostFrequentlyChar = char;
    }
  }
  return mostFrequentlyChar;
}

console.log(
  findMostFrequentlyChar(
    "    This   is  a    common    interview   question   "
  )
);
console.log(findMostFrequentlyChar("opqpowpqwpopppppppp1"));
