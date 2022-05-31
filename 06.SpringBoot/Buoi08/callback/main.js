// // Công việc 3 : Giả sử sau 3s thì thực hiện xong
// function funcC() {
//   setTimeout(function () {
//     console.log("three");
//   }, 3000);
// }

// // Công việc 4 : Giả sử sau 4s thì thực hiện xong
// function funcD() {
//   setTimeout(function () {
//     console.log("four");
//   }, 4000);
// }

// // Tổng thời gian thực hiện hết 2 cv3 và cv4 là 4s
// // Thực hiện công việc
// funcC();
// funcD();

function doFirstTask(taskName, time, callback) {
  console.log("Bắt đầu công việc");
  console.log(`Thực hiện công việc ${taskName}`);
  setTimeout(function () {
    callback();
  }, time);
}

function doTask(taskName, time, callback) {
  console.log(`Thực hiện công việc ${taskName}`);
  setTimeout(function () {
    callback();
  }, time);
}

function finish() {
  console.log("Kết thúc công việc");
}

// doFirstTask("Đi làm", 3000, function () {
//   doTask("Nghỉ trưa", 4000, function () {
//     doTask("Tập thể dục", 2000, finish);
//   });
// });

doTask("Đi làm", 3000, function () {
  console.log("Thực hiện xong công việc đi làm");
});
doTask("Nghỉ trưa", 4000, function () {
  console.log("Thực hiện xong công việc nghỉ trưa");
});
doTask("Tập thể dục", 2000, function () {
  console.log("Thực hiện xong công việc tập thể dục");
});

// Gọi API lấy danh sách user
// Lấy thông tin của user theo id
// Lấy danh sách bài viết
// Lấy chi tiết bài viết
// Lấy danh sách comment
// Lấy chi tiết comment
