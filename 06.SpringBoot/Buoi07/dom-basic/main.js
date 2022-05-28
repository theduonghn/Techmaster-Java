const heading = document.getElementById("heading");
console.log(heading);

const para2 = document.querySelector(".para");
console.log(para2);

// const para3 = document.querySelector(".para:nth-child(4)");
// console.log(para3);

// const para3 = para2.nextElementSibling;
// console.log(para3);

const para3 = document.querySelector(".para + .para");
console.log(para3);

const ul1 = document.querySelector(".box > ul");
console.log(ul1);

const ul2 = document.querySelector("body > ul");
console.log(ul2);

const paras = document.querySelectorAll("p");
console.log(paras);

// Sử dụng for qua NodeList
// for (let i = 0; i < paras.length; i++) {
//   paras[i].style.color = "blue";
//   paras[i].style.backgroundColor = "pink";
// }

Array.from(paras).map((e) => {
  e.style.color = "red";
  e.style.backgroundColor = "green";
});

// Lấy ra nội dung của phần tử
console.log(heading.innerHTML);
console.log(heading.innerText);
console.log(heading.textContent);

console.log(ul1.innerHTML);
console.log(ul1.innerText);
console.log(ul1.textContent);

heading.innerHTML = "Xin chào";
heading.innerHTML = "<span>Xin chào các bạn</span>";

// Tạo ra phần tử DOM
const newPara = document.createElement("p");
newPara.innerText = "New para";
console.log(newPara);

// document.body.prepend(newPara);
// document.body.appendChild(newPara);

// document.body.insertBefore(newPara, para2);

const box = document.querySelector(".box");

// document.body.insertBefore(newPara, box);

// targetElement.insertAdjacentElement
// para3.insertAdjacentElement("afterend", newPara);
// box.insertAdjacentElement("beforebegin", newPara);

box.insertAdjacentHTML("beforebegin", "<p>Thẻ para mới</p>");

// Xoá phần tử
// document.body.removeChild(heading);
heading.parentElement.removeChild(heading);

// Thay thế
// Thay thế thẻ para2 bằng thẻ a
const link = document.createElement("a");
link.innerText = "Link google";
link.href = "https://google.com";
link.setAttribute("target", "_blank");
document.body.replaceChild(link, para2);

const boxCopy1 = box.cloneNode(true);
const boxCopy2 = box.cloneNode(false);

console.log(boxCopy1);
console.log(boxCopy2);

document.body.appendChild(boxCopy1);

// ClassList
console.log(box.classList);

// Thêm class
box.classList.add("text-big", "text-bold");

// Xoá class
box.classList.remove("text-big");

console.log(box.classList.contains("box"));
console.log(box.classList.contains("text-big"));

// Toggle class
setInterval(function () {
  box.classList.toggle("text-big");
}, 1500);
