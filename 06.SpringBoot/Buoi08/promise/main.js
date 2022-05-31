// Promise : Lời hứa

// HỨA : Nếu có trên 33 triệu, sẽ mua iphone 13 pro max

// let promise = new Promise(function (resolve, reject) {
//   resolve("Thực hiện thành công");
//   reject("Thực hiện thất bại");
// });
// console.log(promise);

let money = 35;

const buyIphone = () => {
  return new Promise((resolve, reject) => {
    if (money >= 33) {
      resolve("Mua iphone thành công");
    } else {
      reject("Không mua được iphone");
    }
  });
};

const buyAirpod = () => {
  return new Promise((resolve, reject) => {
    if (money >= 33 + 5) {
      resolve("Mua thêm Airpod");
    } else {
      reject("Hết tiền mua Airpod");
    }
  });
};

// console.log(buyIphone());

// buyIphone()
//   .then((res) => {
//     console.log(res);
//     return buyAirpod();
//   })
//   .then((res) => console.log(res))
//   .catch((error) => console.log(error))
//   .finally(() => {
//     console.log("Về nhà");
//   });

Promise.all([buyIphone(), buyAirpod()])
  .then((res) => console.log(res))
  .catch((error) => console.log(error));
