import React, { useState } from 'react';
import './MyStyle.css';

function SecondApp(props) {
    //let msg = "I will find you."; // 단순 출력만 가능. 변경은 불가능 (변경하려면 state로 줘야 한다!)

    // 변경이 가능한 변수: state
    // [변수명, 해당 변수의 setter명]
    const [msg, setMsg] = useState("Pen Pineapple Apple Pen");

    return (
        <div className='box2'>
            <h5 className='alert alert-success'>
                SecondApp 컴포넌트
            </h5>
            <h6>메세지를 입력하세요</h6>
            <input type='text' className='form-control' 
            value={msg} onChange={(e) => {
                // setter 함수를 통해서 입력값을 msg에 넣는다
                setMsg(e.target.value);
            }}/>
            <h1>{msg}</h1>
        </div>
    );

}

export default SecondApp;