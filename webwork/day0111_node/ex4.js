// map 반복문, slice, filter
let array = ['red', 'green', 'blue', 'pink', 'orange', 'gray', 'magenta', 'caramel'];

// map을 이용해서 출력하기
array.map((color, idx) => console.log(idx + " : " + color));

console.log("--------------------------------");
// 배열의 데이터 잘라내기(slice) & 걸러내기(filter)
// blue 삭제 후 다시 출력 : 0~1번과 3~끝 붙이기
// array = [...array.slice(0, 2), ...array.slice(3, array.length)];
// array.map((color, idx) => console.log(idx + " : " + color));

console.log("--------------------------------");

// filter로 blue 걸러내기
let array2 = array.filter((color, idx) => idx !== 2); // idx가 2가 아닌 것만 return
array2.map((color, idx) => console.log(idx + " : " + color));