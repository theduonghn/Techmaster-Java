const btn = document.getElementById("btn");
const btnBreed = document.getElementById("btn-breed");
const img = document.getElementById("image");
const selectBreed = document.getElementById("breed-list");

btn.addEventListener("click", () => getRandomImage());

const getRandomImage = async () => {
  try {
    let res = await axios.get("https://dog.ceo/api/breeds/image/random");
    img.src = res.data.message;
  } catch (error) {
    console.log(error);
  }
};

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

btnBreed.addEventListener("click", () => getRandomImageByBreed());

const getRandomImageByBreed = async () => {
  try {
    let res = await axios.get(
      `https://dog.ceo/api/breed/${selectBreed.value}/images/random`
    );
    img.src = res.data.message;
  } catch (error) {
    console.log(error);
  }
};

window.onload = getBreedList();
