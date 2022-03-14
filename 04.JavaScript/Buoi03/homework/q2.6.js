// 6. Write a JavaScript function to add specified minutes to a Date object. Go to the editor

// Test Data :
// console.log(add_minutes(new Date(2014,10,2), 30).toString());
// Output :
// "Sun Nov 02 2014 00:30:00 GMT+0530 (India Standard Time)"

function add_minutes(date, minutes) {
  date.setMinutes(date.getMinutes() + minutes);
  return date;
}

console.log(add_minutes(new Date(2014, 10, 2), 30).toString());
console.log(add_minutes(new Date(2022, 3, 14, 8, 17), 30).toString());
console.log(add_minutes(new Date(2022, 3, 14, 8, 50), 30).toString());
