const body = document.body;
const randomColorNameBtn = document.getElementById("random-color-name");
const randomHexColorBtn = document.getElementById("random-hex-color");
const randomRgbColorBtn = document.getElementById("random-rgb-color");
const bugBtn = document.getElementById("bug");

// Using axios
randomColorNameBtn.addEventListener("click", async () => {
  try {
    let res = await axios.get("http://localhost:8080/random-color?type=1");
    const color = res.data;
    body.style.backgroundColor = color;
  } catch (error) {
    const message = error.response.data.message;
    alert(message);
  }
});

// Using axios
randomHexColorBtn.addEventListener("click", async () => {
  try {
    let res = await axios.get("http://localhost:8080/random-color?type=2");
    const color = res.data;
    body.style.backgroundColor = color;
  } catch (error) {
    console.log(error);
  }
});

// Using jQuery
$("#random-rgb-color").click(() => {
  $.ajax({
    type: "GET",
    url: "http://localhost:8080/random-color?type=3",
    success: (response) => {
      const color = response;
      body.style.backgroundColor = color;
    },
    error: (error) => {
      console.log(error);
    },
  });
});

// Using axios
bugBtn.addEventListener("click", async () => {
  try {
    let res = await axios.get("http://localhost:8080/random-color?type=4");
    const color = res.data;
    body.style.backgroundColor = color;
  } catch (error) {
    const message = error.response.data.message;
    alert(message);
  }
});
