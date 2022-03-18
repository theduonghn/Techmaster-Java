$(function () {
  const $inputAmount = $("#input-amount");
  const $inputGuests = $("#input-guests");
  const $inputQuality = $("#input-quality");
  const $tipEachPerson = $(".tip-each-person");
  const $btnCalculateTip = $(".btn-calculate-tip");

  $btnCalculateTip.on("click", tipEachPerson);

  function tipEachPerson() {
    let tipPercent = Number($inputQuality.val());
    console.log("🚀 ~ file: script.js ~ line 12 ~ tipEachPerson ~ tipPercent", tipPercent)
    let tipAmount = Number($inputAmount.val()) * (tipPercent / 100);
    console.log("🚀 ~ file: script.js ~ line 14 ~ tipEachPerson ~ tipAmount", tipAmount)
    let guests = Number($inputGuests.val());
    console.log("🚀 ~ file: script.js ~ line 16 ~ tipEachPerson ~ guests", guests)
    let tipEach = tipAmount / guests;
    console.log("🚀 ~ file: script.js ~ line 18 ~ tipEachPerson ~ tipEach", tipEach)
    $tipEachPerson.text(tipEach);
  }
});
