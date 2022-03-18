$(function () {
  const $inputWeight = $("#input-weight");
  const $inputHeight = $("#input-height");
  const $bmi = $(".bmi");
  const $bmiDescription = $(".bmi-description");
  const $btnCalculateBmi = $(".btn-calculate-bmi");

  $btnCalculateBmi.on("click", getBmiResult);

  function getBmiResult() {
    let bmi = calculateBmi($inputWeight.val(), $inputHeight.val());
    let bmiDescription = getBmiDescription(bmi);
    $bmi.text(String(bmi.toFixed(2)));
    $bmiDescription.text(bmiDescription);
  }
});

function calculateBmi(weight, height) {
  return weight / height ** 2;
}

function getBmiDescription(bmi) {
  if (isNaN(bmi) || bmi == Infinity || bmi == 0) {
    return "Please enter correct weight and height first";
  } else if (bmi < 16) {
    return "Severe Thinness";
  } else if (bmi < 17) {
    return "Moderate Thinness";
  } else if (bmi < 18.5) {
    return "Mild Thinness";
  } else if (bmi < 25) {
    return "Normal";
  } else if (bmi < 30) {
    return "Overweight";
  } else if (bmi < 35) {
    return "Obese Class I";
  } else if (bmi < 40) {
    return "Obese Class II";
  } else {
    return "Obese Class III";
  }
}
