// 2. Write a JavaScript function to get the current date. Go to the editor

// Note : Pass a separator as an argument.
// Test Data :
// console.log(curday('/'));
// console.log(curday('-'));
// Output :
// "11/13/2014"
// "11-13-2014"

function curday(separator) {
  let today = new Date();
  let dd = String(today.getDate()).padStart(2, "0");
  let mm = String(today.getMonth() + 1).padStart(2, "0");
  let yyyy = today.getFullYear();
  return [mm, dd, yyyy].join(separator);
}

console.log(curday("/"));
console.log(curday("-"));
