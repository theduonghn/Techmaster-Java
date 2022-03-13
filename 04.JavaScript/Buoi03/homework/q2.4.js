// 4. Write a JavaScript function to get the month name from a particular date. Go to the editor

// Test Data :
// console.log(month_name(new Date("10/11/2009")));
// console.log(month_name(new Date("11/13/2014")));
// Output :
// "October"
// "November"

function month_name(date) {
  let month = date.getMonth();
  let name;
  switch (month) {
    case 0:
      name = "January";
      break;
    case 1:
      name = "February";
      break;
    case 2:
      name = "March";
      break;
    case 3:
      name = "April";
      break;
    case 4:
      name = "May";
      break;
    case 5:
      name = "June";
      break;
    case 6:
      name = "July";
      break;
    case 7:
      name = "August";
      break;
    case 8:
      name = "September";
      break;
    case 9:
      name = "October";
      break;
    case 10:
      name = "November";
      break;
    case 11:
      name = "December";
      break;
  }
  return name;
}

console.log(month_name(new Date("10/11/2009")));
console.log(month_name(new Date("11/13/2014")));
