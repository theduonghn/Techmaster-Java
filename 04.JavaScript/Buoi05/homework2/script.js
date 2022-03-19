$(function () {
  const $inputAmount = $("#input-amount");
  const $inputGuests = $("#input-guests");
  const $inputQuality = $("#input-quality");
  const $tipEachPerson = $(".tip-each-person");
  const $btnCalculateTip = $(".btn-calculate-tip");

  $btnCalculateTip.on("click", tipEachPerson);

  function tipEachPerson() {
    let tipPercent = Number($inputQuality.val());
    let tipAmount = Number($inputAmount.val()) * (tipPercent / 100);
    let guests = Number($inputGuests.val());
    let tipEach = tipAmount / guests;
    $tipEachPerson.text(tipEach.toFixed(2));
  }
});
