const heading = document.getElementById("heading");
// heading.style.color = "red";
// heading.style.textTransform = "uppercase";
heading.classList.add("color-red", "text-upper");

const paras = document.querySelectorAll(".para");
Array.from(paras).forEach((para) => {
  para.classList.add("color-blue");
  para.style.fontSize = "20px";
});

const para3 = document.querySelector(".para-3");
const link = document.createElement("a");
link.innerText = "facebook";
link.href = "https://www.facebook.com";
para3.insertAdjacentElement("afterend", link);

const title = document.getElementById("title");
title.innerText = "Đây là thẻ tiêu đề";

const description = document.querySelector(".description");
description.classList.add("text-bold");

const button = document.createElement("button");
button.innerText = "Click me";
para3.parentElement.replaceChild(button, para3);

const para2 = document.querySelector(".para-2");
const para2Copy = para2.cloneNode(true);
para2.insertAdjacentElement("afterend", para2Copy);

const para1 = document.querySelector(".para-1");
para1.parentElement.removeChild(para1);
