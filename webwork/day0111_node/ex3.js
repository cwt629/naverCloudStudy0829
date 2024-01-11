// 객체, 객체를 함수의 인자로 넘기기
let obj1 = {"name": "lee", "addr": "seoul", "age": 20};
console.log(obj1.name);
console.log(obj1.addr);
console.log(obj1.age);

// ES6의 방식으로 이름과 주소를 얻어서 출력하고자 할 경우
let {name, age} = obj1; // {} 안의 변수명은 반드시 객체의 key값과 일치해야 함
console.log(name);
console.log(age);

// 인자에 객체의 일부 key 넣어보기
let f1 = ({name, addr}) => {
    console.log("이름 = " + name);
    console.log("주소 = " + addr);
}

// 호출
f1(obj1);