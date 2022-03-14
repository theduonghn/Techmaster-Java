// 7. Write a JavaScript function to test whether a date is a weekend. Go to the editor

// Note : Use standard Saturday/Sunday definition of a weekend.
// Test Data :
// console.log(is_weekend('Nov 15, 2014'));
// console.log(is_weekend('Nov 16, 2014'));
// console.log(is_weekend('Nov 17, 2014'));
// Output :
// "weekend"
// "weekend"
// undefined

function is_weekend(dateString) {
  let date = new Date(dateString);
  let dayInWeek = date.getDay();
  if (dayInWeek == 6 || dayInWeek == 0) return "weekend";
  else return "not weekend";
}

console.log(is_weekend("Mar 17, 2022"));
console.log(is_weekend("Mar 18, 2022"));
console.log(is_weekend("Mar 19, 2022"));
console.log(is_weekend("Mar 20, 2022"));
console.log(is_weekend("Mar 21, 2022"));
