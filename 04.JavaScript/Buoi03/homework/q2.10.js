// 10. Write a JavaScript function to calculate 'yesterday day'. Go to the editor

// Test Data :
// console.log(yesterday('Nov 15, 2014'));
// console.log(yesterday('Nov 16, 2015'));
// console.log(yesterday('Nov 17, 2016'));
// Output :
// "Fri Nov 14 2014 00:00:00 GMT+0530 (India Standard Time)"
// "Sun Nov 15 2015 00:00:00 GMT+0530 (India Standard Time)"
// "Wed Nov 16 2016 00:00:00 GMT+0530 (India Standard Time)"

function yesterday(dateString) {
  let date = new Date(dateString);
  return Date(date.getFullYear(), date.getMonth(), date.getDate());
}

console.log(yesterday("Nov 15, 2014"));
console.log(yesterday("Nov 16, 2015"));
console.log(yesterday("Nov 17, 2016"));
