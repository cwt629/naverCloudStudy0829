// 펼침 연산자(스프레드 연산자) : ...
let arr1 = [3, 4, 5];
let arr2 = [6, 7, 8];

// arr3에 arr1와 arr2 값을 모두 넣어보자
let arr3 = [...arr1, ...arr2, 30, 40];

console.log("arr3의 길이: " + arr3.length);
console.log(arr3);

let sum1 = (a, b, c) => a + b + c;

console.log(sum1(3, 5, 7));
console.log(sum1(...arr2));
console.log(sum1(...arr3)); // 3개 넘게 들어가도 error는 안남. 근데 앞에 3개만 읽음.