const selectProvince = document.getElementById("province");
const selectDistrict = document.getElementById("district");
const selectWard = document.getElementById("commune");

selectProvince.addEventListener("change", () => {
  selectWard.innerHTML = `<option value="" hidden>---</option>`;
  getDistricts();
});
selectDistrict.addEventListener("change", () => getWards());

const getProvinces = async () => {
  try {
    let res = await axios.get("https://provinces.open-api.vn/api/p/");
    let provinces = res.data;
    showProvinces(provinces);
  } catch (error) {
    console.log(error);
  }
};

const showProvinces = (provinces) => {
  let html = `<option value="" hidden>---</option>`;
  for (let i = 0; i < provinces.length; i++) {
    let province = provinces[i];
    html += `<option value=${province.code}>${province.name}</option>`;
  }
  selectProvince.innerHTML = html;
};

const getDistricts = async () => {
  try {
    let res = await axios.get(
      `https://provinces.open-api.vn/api/p/${selectProvince.value}?depth=2`
    );
    let districts = res.data.districts;
    showDistricts(districts);
  } catch (error) {
    console.log(error);
  }
};

const showDistricts = (districts) => {
  let html = `<option value="" hidden>---</option>`;
  for (let i = 0; i < districts.length; i++) {
    let district = districts[i];
    html += `<option value=${district.code}>${district.name}</option>`;
  }
  selectDistrict.innerHTML = html;
};

const getWards = async () => {
  try {
    let res = await axios.get(
      `https://provinces.open-api.vn/api/d/${selectDistrict.value}?depth=2`
    );
    let wards = res.data.wards;
    showWards(wards);
  } catch (error) {
    console.log(error);
  }
};

const showWards = (wards) => {
  let html = `<option value="" hidden>---</option>`;
  for (let i = 0; i < wards.length; i++) {
    let ward = wards[i];
    html += `<option value=${ward.code}>${ward.name}</option>`;
  }
  selectWard.innerHTML = html;
};

window.onload = getProvinces();
