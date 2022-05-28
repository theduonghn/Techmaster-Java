const text = document.getElementById("text");
const btn1 = document.getElementById("btn-1");

btn1.addEventListener("click", function () {
  // B1: random quote
  let quotes = [
    "Quote 1",
    "Quote 2",
    "Quote 3",
    "Quote 4",
    "Quote 5",
    "Quote 6",
  ];

  let randomIndex = Math.floor(Math.random() * quotes.length);
  let randomQuote = quotes[randomIndex];

  // B2: Chèn lại nội dung cho thẻ p
  text.innerText = randomQuote;
});

function randomHex() {
  return "#" + ((Math.random() * 0xffffff) << 0).toString(16).padStart(6, "0");
}

const btn2 = document.getElementById("btn-2");
const para = document.querySelector("p");
btn2.addEventListener("click", function () {
  para.style.color = randomHex();
});

function randomRgb() {
  let o = Math.round,
    r = Math.random,
    s = 255;
  return "rgb(" + o(r() * s) + "," + o(r() * s) + "," + o(r() * s) + ")";
}
const btn3 = document.getElementById("btn-3");
btn3.addEventListener("click", function () {
  para.style.backgroundColor = randomRgb();
});
