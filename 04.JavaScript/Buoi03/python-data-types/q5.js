// Kết hợp 2 dictionary
// Cho 2 dictionary bất kỳ, viết chương trình kết hợp 2 dictionary thành 1

// Ví dụ:

// dict1 = {1: 'a', 2: 'b'}
// dict2 = {2: 'c', 4: 'd'}
// Kết quả

// dict3 = {1: 'a', 2: 'c', 4: 'd'}

function joinObjects(obj1, obj2) {
  let newObj = {};
  for (let key in obj1) {
    newObj[key] = obj1[key];
  }
  for (let key in obj2) {
    newObj[key] = obj2[key];
  }
  return newObj;
}

let dict1 = { 1: "a", 2: "b" },
  dict2 = { 2: "c", 4: "d" };

console.log(joinObjects(dict1, dict2));
