// Một nhóm bạn đã quyết định thành lập một nhóm kín và tên của nhóm sẽ là chữ cái đầu tiên trong tên mỗi thành viên, được sắp xếp theo thứ tự bảng chữ cái. Viết hàm societyName(names) nhận một mảng chứa tên các thành viên và trả về tên của hội kín.
// Ví dụ:

// societyName(["Adam", "Sarah", "Malcolm"]) // result "AMS"

function societyName(names) {
  let sortedNames = [...names].sort();
  return sortedNames.reduce(
    (result, name) => result + name[0].toUpperCase(),
    ""
  );
}

console.log(societyName(["Adam", "Sarah", "Malcolm"]));
