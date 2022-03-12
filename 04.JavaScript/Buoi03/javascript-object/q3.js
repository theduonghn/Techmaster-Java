// Tạo một hàm, nhận vào một chuỗi là tên của một người, kiểm tra xem tên của người đó có giá trị bao nhiêu theo theo từ điển được cung cấp bên dưới
// // Từ điển tra cứu điểm của các chữ cái
// // Cộng các chữ cái trong tên của bạn để nhận được tổng điểm
// const scores = {"A": 100, "B": 14, "C": 9, "D": 28, "E": 145, "F": 12, "G": 3, "H": 10, "I": 200, "J": 100, "K": 114, "L": 100, "M": 25, "N": 450, "O": 80, "P": 2, "Q": 12, "R": 400, "S": 113, "T": 405, "U": 11, "V": 10, "W": 10, "X": 3, "Y": 210, "Z": 23};

// // score <= 60: NOT TOO GOOD
// // 61 <= score <= 300: PRETTY GOOD
// // 301 <= score <= 599: VERY GOOD
// // score >= 600: THE BEST

// // Ví dụ
// nameScore("MUBASHIR") // "THE BEST"
// nameScore("YOU") // "VERY GOOD"
// nameScore("MATT") // "THE BEST"
// nameScore("PUBG") // "NOT TOO GOOD"

const scores = {
  A: 100,
  B: 14,
  C: 9,
  D: 28,
  E: 145,
  F: 12,
  G: 3,
  H: 10,
  I: 200,
  J: 100,
  K: 114,
  L: 100,
  M: 25,
  N: 450,
  O: 80,
  P: 2,
  Q: 12,
  R: 400,
  S: 113,
  T: 405,
  U: 11,
  V: 10,
  W: 10,
  X: 3,
  Y: 210,
  Z: 23,
};

function nameScore(name) {
  let score = 0;
  let uppercaseName = name.toUpperCase();
  for (let i = 0; i < uppercaseName.length; i++) {
    let char = uppercaseName[i];
    score += scores[char];
  }
  if (score <= 60) {
    console.log("NOT TOO GOOD");
  } else if (score <= 300) {
    console.log("PRETTY GOOD");
  } else if (score <= 599) {
    console.log("VERY GOOD");
  } else {
    console.log("THE BEST");
  }
}

nameScore("Duong");
