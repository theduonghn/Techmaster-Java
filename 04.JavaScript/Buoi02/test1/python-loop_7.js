// Nhóm kín
// Một nhóm bạn muốn thành lập một hội kín, tên hội sẽ là tên viết tắt của mỗi người sắp xếp theo bảng chữ cái

// Viết chương trình nhập vào một loạt tên phân tách bởi dấu cách, in ra tên nhóm kín

// Ví dụ: Nhập vào: "Ba Phoebe Vân Anh" Kết quả: "ABPV"

function createGroupName(memberNames) {
  let nameList = memberNames.split(" ");
  let firstCharList = nameList.map((name) => name[0]);
  firstCharList.sort();
  return firstCharList.reduce(
    (groupName, firstChar) => (groupName += firstChar),
    ""
  );
}

let memberNames = "Ba Phoebe Vân Anh";
console.log(createGroupName(memberNames));
