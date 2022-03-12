// Bạn đi chơi về phát hiện nhà bạn có dấu hiệu đột nhập! Đưa ra một đối tượng trong số các đồ bị đánh cắp, viết hàm tính tổng số tiền (số) đồ bị trộm. Nếu không có gì bị mất, trả lại chuỗi "Lucky you!".
// // Ví dụ
// const stolenItems = {
// 	tv: 30,
// 	skate: 20,
// 	stereo: 50,
// }

// totalAmountLost(stolenitems) / 100

// const stolenItems = {
// 	painting: 20000,
// }

// totalAmountLost(stolenitems) // 20000

// const stolenItems = { }

// totalAmountLost(stolenItems) // "Lucky You!"

function totalAmountLost(stolenItems) {
  let totalAmount = 0;
  for (itemName in stolenItems) {
    totalAmount += stolenItems[itemName];
  }
  if (totalAmount == 0) {
    return "Lucky You!";
  } else {
    return totalAmount;
  }
}

console.log(
  totalAmountLost({
    tv: 30,
    skate: 20,
    stereo: 50,
  })
);
console.log(
  totalAmountLost({
    painting: 20000,
  })
);
console.log(totalAmountLost({}));
