const img = document.getElementById("image");
const selectBreed = document.getElementById("breed-list");

const getBreedList = async () => {
  try {
    let res = await axios.get("https://dog.ceo/api/breeds/list/all");
    let breeds = res.data.message;
    console.log(breeds);
    showBreedList(breeds);
  } catch (error) {
    console.log(error);
  }
};

const showBreedList = (obj) => {
  //   const option = document.createElement("option");
  //   Object.keys(obj).forEach((breed) => {
  // const breedOption = option.cloneNode(true);
  // breedOption.innerText = breed;
  // breedOption.value = breed;
  // selectBreed.append(breedOption);

  //   });

  let keys = Object.keys(obj);
  let html = "";
  for (let i = 0; i < keys.length; i++) {
    const breed = keys[i];
    html += `<option value = ${breed}>${breed}</option>`;
  }
  selectBreed.innerHTML = html;
};

window.onload = getBreedList();
