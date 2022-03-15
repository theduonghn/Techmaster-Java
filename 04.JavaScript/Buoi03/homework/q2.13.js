// 13. Write a JavaScript function that will return the number of minutes in hours and minutes. Go to the editor

// Test Data :
// console.log(timeConvert(200));
// Output :
// "200 minutes = 3 hour(s) and 20 minute(s)."

function timeConvert(minutes) {
  let numHours = Math.floor(minutes / 60);
  let numMinutes = minutes - numHours * 60;
  return `${minutes} = ${numHours} hour(s) and ${numMinutes} minute(s).`;
}

console.log(timeConvert(200));
