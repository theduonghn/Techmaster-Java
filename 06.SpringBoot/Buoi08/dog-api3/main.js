const imgElement = document.getElementById("image");
const breedSelectElement = document.getElementById("breed-list");
const getSubBreedsBtnElement = document.getElementById("btn-get-sub-breeds");
const subBreedsListElement = document.getElementById("sub-breeds");

// Handle events
getSubBreedsBtnElement.addEventListener("click", () => showSubBreeds());

const showBreeds = async () => {
  try {
    const res = await axios.get("https://dog.ceo/api/breeds/list/all");
    const breeds = Object.keys(res.data.message);
    fillBreedsData(breeds);
  } catch (error) {
    console.log(error);
  }
};

const fillBreedsData = (breeds) => {
  let html = "";
  for (const breed of breeds) {
    html += `<option value=${breed}>${breed}</option>`;
  }
  breedSelectElement.innerHTML = html;
};

const showSubBreeds = async () => {
  try {
    const breed = breedSelectElement.value;
    const res = await axios.get(`https://dog.ceo/api/breed/${breed}/list`);
    const subBreeds = res.data.message;
    fillSubBreedsData(breed, subBreeds);
  } catch (error) {
    console.log(error);
  }
};

const fillSubBreedsData = (breed, subBreeds) => {
  if (Array.isArray(subBreeds) && subBreeds.length) {
    let html = "";
    for (const subBreed of subBreeds) {
      html += `<li><a href="#" onclick="showRandomImageBySubBreed('${breed}', '${subBreed}')">${subBreed}</a></li>`;
    }
    subBreedsListElement.innerHTML = html;
  } else {
    subBreedsListElement.innerHTML = `<li>Không có sub breed</li>`;
  }
};

const showRandomImageBySubBreed = async (breed, subBreed) => {
  try {
    const res = await axios.get(
      `https://dog.ceo/api/breed/${breed}/${subBreed}/images/random`
    );
    imgElement.src = res.data.message;
  } catch (error) {
    console.log(error);
  }
};

window.onload = showBreeds();
