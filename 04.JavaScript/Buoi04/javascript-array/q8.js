// Viết hàm perimeter(coordinates) nhận tọa độ ba điểm dưới dạng mảng 2 chiều [x, y] và trả về chu vi hình tam giác.
// Ví dụ:

// perimeter([[15, 7], [5, 22], [11, 1]]) // result 47.0

function calcDistance(p1, p2) {
  return Math.sqrt((p1[0] - p2[0]) ** 2 + (p1[1] - p2[1]) ** 2);
}

function perimeter(points) {
  let s1 = calcDistance(points[0], points[1]);
  let s2 = calcDistance(points[0], points[2]);
  let s3 = calcDistance(points[1], points[2]);
  return s1 + s2 + s3;
}

console.log(
  perimeter([
    [15, 7],
    [5, 22],
    [11, 1],
  ])
);
