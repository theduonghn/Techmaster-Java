const URL_API = "http://localhost:8080/api/v1";

// Lấy thông tin id trên url
let params = new URLSearchParams(window.location.search);
let id = params.get("id");

// BEGIN Elements
const nameElement = document.getElementById("name");
const emailElement = document.getElementById("email");
const phoneElement = document.getElementById("phone");
const addressElement = document.getElementById("address");
const btnSaveElement = document.getElementById("btn-save");

const oldPasswordElement = document.getElementById("old-password");
const newPasswordElement = document.getElementById("new-password");
const btnChangePasswordElement = document.getElementById("btn-change-password");

const btnForgotPasswordElement = document.getElementById("btn-forgot-password");
// END Elements

// BEGIN Handle events
btnSaveElement.addEventListener("click", async function () {
  try {
    let res = await axios.put(`${URL_API}/users/${id}`, {
      name: nameElement.value,
      phone: phoneElement.value,
      address: addressElement.value,
    });
    if (res.data) {
      window.location.href = "/";
    }
  } catch (error) {
    console.log(error);
  }
});

btnChangePasswordElement.addEventListener("click", async function () {
  try {
    await axios.put(`${URL_API}/users/${id}/update-password`, {
      oldPassword: oldPasswordElement.value,
      newPassword: newPasswordElement.value,
    });
    alert("Đổi mật khẩu thành công");
  } catch (error) {
    let message = error.response.data.message;
    alert(message);
  } finally {
    oldPasswordElement.value = "";
    newPasswordElement.value = "";
  }
});

btnForgotPasswordElement.addEventListener("click", async function () {
  try {
    let res = await axios.put(`${URL_API}/users/${id}/forgot-password`);
    alert(`Mật khẩu mới là: ${res.data}`);
  } catch (error) {
    console.log(error);
  }
});
// END Handle events

// Lấy thông tin user
const getUser = async (id) => {
  try {
    let res = await axios.get(`${URL_API}/users/${id}`);
    let user = res.data;
    renderUser(user);
  } catch (error) {
    console.log(error);
  }
};

// Hiển thị thông tin user
const renderUser = (user) => {
  nameElement.value = user.name;
  emailElement.value = user.email;
  phoneElement.value = user.phone;
  addressElement.value = user.address;
};

const getProvinces = async () => {
  try {
    let res = await axios.get("https://provinces.open-api.vn/api/p");
    let provinces = res.data;
    renderProvinces(provinces);
  } catch (error) {
    console.log(error);
  }
};

const renderProvinces = (arr) => {
  let html = "";
  arr.forEach((province) => {
    html += `<option value="${province.name}">${province.name}</option>`;
  });
  addressElement.innerHTML = html;
};

const init = async () => {
  await getProvinces();
  await getUser(id);
};

init();
