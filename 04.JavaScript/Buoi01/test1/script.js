// alert("Hello World");

// let greeting = "hello";
// console.log(greeting);

// let a = 1;
// let b = 2;
// console.log(a + b);

// let a = 5;

// const PI = 3.14;
// const PI = 3.5;

// let name = "Duong";
// console.log("My name is", name);

// let age = 25;
// console.log("age =", age);

// v = 10;

// let a();

// let dog = {
//   name: "Milu",
//   age: 2,
//   legs: 4,
//   colors: ["vàng", "trắng"],
//   bark() {
//     console.log("Gâu gâu");
//   },
// };
// console.log(dog.name);
// dog.bark();

// function display(obj, key) {
//   if (typeof obj[key] == "function") {
//     obj[key]();
//   } else {
//     console.log(obj[key]);
//   }
// }
// display(dog, "legs");
// display(dog, "colors");
// display(dog, "bark");

let a = 1,
  b = (a * 2) / 2,
  c = a-- + b++,
  d = "-0";

console.log(a - b - c - d);
console.log(a + b - c + d);
console.log(a++ - (b++ / c) * d);
console.log(--a + -b / c - d);
console.log(d - --a - ++b * c);
