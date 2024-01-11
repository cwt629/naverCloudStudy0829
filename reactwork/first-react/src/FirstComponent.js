import React from "react";
import './MyStyle.css'; // style도 import할 수 있음
import gom from "./gomnijiwa.jpg"; // src에 있는 이미지는 이렇게 import함. 이름은 아무렇게나 가능
import seol from "./hongsnowhi.jpg";

let FirstComponent = () => {

    // alt는 보통은 안 넣어도 되지만, React에서는 넣는 거 권장. 없으면 warning 뜬다
    return (
        <div className="box">
            <h3 className="alert alert-info">FirstComponent 컴포넌트</h3>
            <h6>public에 있는 뿔버섯</h6>
            {/* public의 이미지는 직접 경로로 지정해야 함 - 권장 안함 */}
            {/* style은 {{}} 안에 줘야 하며, 스타일 값은 문자열 형태로 줘야 한다. 그리고, 세미콜론 쓰면 안 먹힘! */}
            <img alt="뿔버섯" src="./뿔버섯2.jpg" style={{border: '1px solid black', width: '100px'}}/>
            <h6>src에 있는 곰니찌와 & 설이</h6>
            {/* 이 안에 변수를 넣으려면 {} 안에 넣는다 */}
            <img alt="곰니찌와" src={gom} style={{border: '1px solid black', width: '300px'}}/>
            <img alt="설이" src={seol} style={{border: '1px solid black', width: '600px', marginLeft: '30px'}}/>
        </div>
    )
}

export default FirstComponent;