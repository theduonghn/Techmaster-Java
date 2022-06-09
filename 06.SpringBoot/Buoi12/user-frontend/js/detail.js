const URL_API = "http://localhost:8080/api/v1";

// Lấy thông tin id trên url
let params = new URLSearchParams(window.location.search);
let id = params.get("id");

// Elements
const nameElement = document.getElementById("name");
const emailElement = document.getElementById("email");
const phoneElement = document.getElementById("phone");
const addressElement = document.getElementById("address");

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
