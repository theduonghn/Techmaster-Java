// 8. Write a JavaScript function to get difference between two dates in days. Go to the editor

// Test Data :
// console.log(date_diff_indays('04/02/2014', '11/04/2014'));
// console.log(date_diff_indays('12/02/2014', '11/04/2014'));
// Output :
// 216
// -28

function date_diff_indays(dateString1, dateString2) {
  let date1 = new Date(dateString1);
  let date2 = new Date(dateString2);
  return (date1 - date2) / 1000 / 86400;
}

console.log(date_diff_indays("04/02/2014", "11/04/2014"));
console.log(date_diff_indays("12/02/2014", "11/04/2014"));
