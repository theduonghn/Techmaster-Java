// 16. Write a JavaScript function to count the number of days passed since beginning of the year. Go to the editor

// Test Data :
// console.log(days_passed(new Date(2015, 0, 15)));
// 15
// console.log(days_passed(new Date(2015, 11, 14)));
// 348

function days_passed(date) {
  let firstDayOfYear = new Date(date.getFullYear(), 0, 1);
  return Math.floor((date - firstDayOfYear) / 86400000) + 1;
}

console.log(days_passed(new Date(2015, 0, 1)));
console.log(days_passed(new Date(2015, 0, 15)));
console.log(days_passed(new Date(2015, 11, 14)));
