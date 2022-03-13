// Cho một đoạn văn bản mẫu như sau:
// const str = `Những suy đOán xung quanh TƯƠNG lai của cầu THỦ 37 tuổi và những lời chỉ trích Anh phải nhận đã liên tục NỔ ra trong vài tuần gần đây. Nhưng Neville tin rằng vấn đề lớn nhất của Man United là hàng phòng ngự kém và thiếu nhất quán của họ: “Hàng thủ Manchester United không tốt lắm, tôi phải nói thẳng; Họ quá mâu thuẫn và không đáng tin cậy! Bạn không thể thực sự tin tưởng họ? BạN không biết điều gì sẽ xảy ra khi hỌ chơi quá lỏng lẻo`;

// Viết hàm getFirstSentenceContains(str, word) nhận vào một từ bất kỳ, tìm và in ra CÂU ĐẦU TIÊN trong đoạn văn chứa từ đó (chỉ tính một từ riêng biệt, không phân biệt chữ hoa chữ thường).

// GỢI Ý:

// Thêm khoảng trắng ở đầu và cuối từ (word) cần tìm, đảm bảo chỉ tìm từ đứng riêng
// Loại bỏ các từ tiếng Việt (chuyển thành không dấu, bao gồm cả word và str)
// Chuyển đổi các dấu câu thành một dạng chung, các dấu tính kết thúc một câu bao gồm .!;?:
// Thay thế các ký tự đặc biệt như " thành dấu khoảng trắng
// Chuyển đổi tất cả thành chữ thường (bao gồm cả word và str)
// Lưu các giá trị vào các biến khác nhau

const PUNCTUATIONS = [". ", "! ", "; ", "? ", ": "];
const QUOTATION_MARKS = ['"', "“"];

function standardizePunctuationsOfString(str) {
  return str.replace(/\. |! |; |\? |: /g, ". ");
}

function getSentencesFromString(str) {
  return standardizePunctuationsOfString(str.trim()).split(". ");
}

function removeQuotationMarks(str) {
  let result = str;
  for (let quotationMark of QUOTATION_MARKS) {
    result = result.replace(quotationMark, "");
  }
  return result;
}

function removeAccents(str) {
  let result = str;
  result = result.toLowerCase();
  result = result.replace(/à|á|ạ|ả|ã|â|ầ|ấ|ậ|ẩ|ẫ|ă|ằ|ắ|ặ|ẳ|ẵ/g, "a");
  result = result.replace(/è|é|ẹ|ẻ|ẽ|ê|ề|ế|ệ|ể|ễ/g, "e");
  result = result.replace(/ì|í|ị|ỉ|ĩ/g, "i");
  result = result.replace(/ò|ó|ọ|ỏ|õ|ô|ồ|ố|ộ|ổ|ỗ|ơ|ờ|ớ|ợ|ở|ỡ/g, "o");
  result = result.replace(/ù|ú|ụ|ủ|ũ|ư|ừ|ứ|ự|ử|ữ/g, "u");
  result = result.replace(/ỳ|ý|ỵ|ỷ|ỹ/g, "y");
  result = result.replace(/đ/g, "d");
  return result;
}

function getStandardString(str) {
  let result = str;
  result = removeQuotationMarks(result);
  result = result.toLowerCase();
  result = removeAccents(result);
  result = " " + result + " ";
  return result;
}

function getStandardSentences(sentences) {
  let result = [];
  for (let sentence of sentences) {
    result.push(sentence);
  }
  for (let i = 0; i < result.length; i++) {
    result[i] = getStandardString(result[i]);
  }
  return result;
}

function getFirstSentenceContains(str, word) {
  let sentences = getSentencesFromString(str);
  let standardSentences = getStandardSentences(sentences);
  let standardWord = getStandardString(word);
  for (let i = 0; i < standardSentences.length; i++) {
    if (standardSentences[i].includes(standardWord)) {
      return sentences[i];
    }
  }
}

const str =
  "Những suy đOán xung quanh TƯƠNG lai của cầu THỦ 37 tuổi và những lời chỉ trích Anh phải nhận đã liên tục NỔ ra trong vài tuần gần đây. Nhưng Neville tin rằng vấn đề lớn nhất của Man United là hàng phòng ngự kém và thiếu nhất quán của họ: “Hàng thủ Manchester United không tốt lắm, tôi phải nói thẳng; Họ quá mâu thuẫn và không đáng tin cậy! Bạn không thể thực sự tin tưởng họ? BạN không biết điều gì sẽ xảy ra khi hỌ chơi quá lỏng lẻo";

console.log(
  "Câu đầu tiên xuất hiện từ 'họ':",
  getFirstSentenceContains(str, "họ")
);
console.log(
  "Câu đầu tiên xuất hiện từ 'tốt':",
  getFirstSentenceContains(str, "tốt")
);
console.log(
  "Câu đầu tiên xuất hiện từ 'ngài':",
  getFirstSentenceContains(str, "ngài")
);
console.log(
  "Câu đầu tiên xuất hiện từ 'mày':",
  getFirstSentenceContains(str, "mày")
);
console.log(
  "Câu đầu tiên xuất hiện từ 'học':",
  getFirstSentenceContains(str, "học")
);
console.log(
  "Câu đầu tiên xuất hiện từ 'tin':",
  getFirstSentenceContains(str, "tin")
);
console.log(
  "Câu đầu tiên xuất hiện từ 'lỏng':",
  getFirstSentenceContains(str, "lỏng")
);
console.log(
  "Câu đầu tiên xuất hiện từ 'long':",
  getFirstSentenceContains(str, "long")
);
console.log(
  "Câu đầu tiên xuất hiện từ 'lòng':",
  getFirstSentenceContains(str, "lòng")
);
