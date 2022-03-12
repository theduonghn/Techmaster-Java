// Cho một danh sách sinh viên và quốc gia của họ, được lưu trữ dưới dạng các cặp key: value trong một object. Viết một hàm nhận vào một tên, nếu tên có trong object , trả về chuỗi dạng: "Hi! I'm [name], and I'm from [country]." Nếu tên không có trong object, hãy trả về: "Hi! I'm a guest."
// // Ví dụ
// const GUEST_LIST = {
// 	Randy: "Germany",
// 	Karla: "France",
// 	Wendy: "Japan",
// 	Norman: "England",
// 	Sam: "Argentina"
// }

// greeting("Randy") // "Hi! I'm Randy, and I'm from Germany."
// greeting("Sam") // "Hi! I'm Sam, and I'm from Argentina."
// greeting("Monti") // "Hi! I'm a guest."

function greeting(name) {
  if (name in GUEST_LIST) {
    console.log("Hi! I'm " + name + ", and I'm from " + GUEST_LIST[name] + ".");
  } else {
    console.log("Hi! I'm a guest.");
  }
}

const GUEST_LIST = {
  Randy: "Germany",
  Karla: "France",
  Wendy: "Japan",
  Norman: "England",
  Sam: "Argentina",
};

greeting("Randy");
greeting("Sam");
greeting("Monti");
