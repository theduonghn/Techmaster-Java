// 3. Write a JavaScript function to get the number of days in a month. Go to the editor

// Test Data :
// console.log(getDaysInMonth(1, 2012));
// console.log(getDaysInMonth(2, 2012));
// console.log(getDaysInMonth(9, 2012));
// console.log(getDaysInMonth(12, 2012));
// Output :
// 31
// 29
// 30
// 31

function getDaysInMonth(month, year) {
  let lastDayInMonth = new Date(year, month, 0);
  return lastDayInMonth.getDate();
}

console.log(getDaysInMonth(1, 2012));
console.log(getDaysInMonth(2, 2012));
console.log(getDaysInMonth(9, 2012));
console.log(getDaysInMonth(12, 2012));
