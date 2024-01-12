import React, { useState } from 'react';
// import OneApp from './OneApp'; // default로 export한 경우
import {OneApp} from './OneApp'; // default 없이 export한 경우
import TwoApp from './TwoApp';
import ThreeApp from './ThreeApp';
import FourApp from './FourApp';
import FiveApp from './FiveApp';

function MainApp(props) {
    const [comp, setComp] = useState(5); // 컴포넌트 번호

    return (
        <div>
            <h2>2024-01-12 React 수업</h2>
            <hr/>
            <select className='form-select' style={{width: '400px'}}
            onChange={(e) => {
                setComp(Number(e.target.value));
            }}>
                <option value={1}>OneApp - 이미지, 스타일, 클래스</option>
                <option value={2}>TwoApp - 숫자 증가 및 감소 이벤트</option>
                <option value={3}>ThreeApp - 이름과 점수 입력 이벤트</option>
                <option value={4}>FourApp - radio input 이벤트</option>
                <option value={5} selected>FiveApp - checkbox & select 이미지 이벤트</option>
            </select>
            <br/><br/>
            <h5>당신은 {comp}번 컴포넌트를 선택했습니다.</h5>
            {
                (comp === 1)? <OneApp/> :
                (comp === 2)? <TwoApp/> :
                (comp === 3)? <ThreeApp/> :
                (comp === 4)? <FourApp/> : <FiveApp/>
            }
        </div>
    );
}

export default MainApp;