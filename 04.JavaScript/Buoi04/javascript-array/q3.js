// Viết hàm chatroomStatus(users) nhận một mảng chứa tên users trả về text cho biết số lượng users trong phòng trò chuyện dựa trên các quy tắc sau:
// Nếu không có ai thì kết quả là No one online
// Nếu có 1 người thì kết quả là user1 online
// Nếu có 2 người thì kết quả là user1 and user2 online
// Nếu có nhiều hơn 2 người thì kết quả là hai tên đầu tiên và thêm vào and n-2 more online.
// Ví dụ:

// chatroomStatus([]) // result "No one online"
// chatroomStatus(["paRIE"]) // result "paRIE online"
// chatroomStatus(["s234f", "mailbox2"]) // result "s234f and mailbox2 online"
// chatroomStatus(["pap_ier44", "townieBOY", "panda321", "motor_bike5", "sandwichmaker833", "violinist91"]) // result "pap_ier44, townieBOY and 4 more online"

function chatroomStatus(users) {
  let numUsers = users.length;
  if (numUsers == 0) {
    return "No one online";
  } else if (numUsers == 1) {
    return users[0] + " online";
  } else if (numUsers == 2) {
    return users[0] + " and " + users[1] + " online";
  } else {
    return (
      users[0] + ", " + users[1] + " and " + (numUsers - 2) + " more online"
    );
  }
}

console.log(chatroomStatus([]));
console.log(chatroomStatus(["paRIE"]));
console.log(chatroomStatus(["s234f", "mailbox2"]));
console.log(
  chatroomStatus([
    "pap_ier44",
    "townieBOY",
    "panda321",
    "motor_bike5",
    "sandwichmaker833",
    "violinist91",
  ])
);
console.log(
  chatroomStatus([
    "dog22",
    "cat123",
    "chicken132",
    "melon1029",
    "koow1",
    "1231dd20",
    "441231",
    "88hhhg",
  ])
);
