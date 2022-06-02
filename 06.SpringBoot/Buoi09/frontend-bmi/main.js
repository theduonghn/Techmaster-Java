const weightInputElement = document.getElementById("weight");
const heightInputElement = document.getElementById("height");
const bmiGetBtnElement = document.getElementById("bmi-get");
const bmiPostBtnElement = document.getElementById("bmi-post");

bmiGetBtnElement.addEventListener("click", async () => {
  try {
    const res = await axios.get(
      `http://localhost:8080/bmi?weight=${weightInputElement.value}&height=${heightInputElement.value}`
    );
    const bmi = res.data;
    alert(
      `Chỉ số BMI của bạn là: ${bmi.toFixed(2)}\n${getBmiDescription(bmi)}`
    );
  } catch (error) {
    const message = error.response.data.message;
    alert(message);
  }
});

bmiPostBtnElement.addEventListener("click", async () => {
  try {
    const res = await axios.post(`http://localhost:8080/bmi`, {
      weight: weightInputElement.value,
      height: heightInputElement.value,
    });
    const bmi = res.data;
    alert(
      `Chỉ số BMI của bạn là: ${bmi.toFixed(2)}\n${getBmiDescription(bmi)}`
    );
  } catch (error) {
    const message = error.response.data.message;
    alert(message);
  }
});

function getBmiDescription(bmi) {
  if (bmi < 18.5) {
    return "Thiếu cân";
  } else if (bmi <= 24.5) {
    return "Bình thường";
  } else if (bmi <= 29.9) {
    return "Thừa cân";
  } else {
    return "Béo phì";
  }
}
