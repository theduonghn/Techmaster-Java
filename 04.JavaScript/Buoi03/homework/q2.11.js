// 11. Write a JavaScript function to get the maximum date from an array of dates. Go to the editor

// Test Data :
// console.log(max_date(['2015/02/01', '2015/02/02', '2015/01/03']));
// Output :
// "2015/02/02"

function min_date(dateStrings) {
  let maxDate = new Date(dateStrings[0]);
  for (let i = 1; i < dateStrings.length; i++) {
    let date = new Date(dateStrings[i]);
    if (date - maxDate > 0) {
      maxDate = date;
    }
  }
  return [
    maxDate.getFullYear(),
    String(maxDate.getMonth() + 1).padStart(2, "0"),
    String(maxDate.getDate()).padStart(2, "0"),
  ].join("/");
}

console.log(min_date(["2015/02/01", "2015/02/02", "2015/01/03"]));
