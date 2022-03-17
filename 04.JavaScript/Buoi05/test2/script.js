const directions = [
  "to right",
  "to left",
  "to bottom",
  "to top",
  "to right bottom",
  "to right top",
  "to left bottom",
  "to left top",
];

function getRandomDirection() {
  // trả về một hương màu ngẫu nhiên
  let randomIndex = Math.floor(Math.random() * directions.length);
  return directions[randomIndex];
}

function getRandomHexColor() {
  // trả về một mã màu hex ngẫu nhiên
  return (randomColor = Math.floor(Math.random() * 16777215).toString(16));
}

$(function () {
  const $body = $("body");
  const $direction = $(".direction");
  const $from = $(".from");
  const $to = $(".to");
  const $btn = $(".btn-change");

  $body.css({
    backgroundImage: `linear-gradient(${getRandomDirection()}), #${getRandomHexColor()}, #${getRandomHexColor()}`,
  });

  $btn.on("click", function () {});
});
