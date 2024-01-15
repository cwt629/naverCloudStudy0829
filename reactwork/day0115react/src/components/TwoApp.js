import React, { useEffect, useState } from 'react';
import c1 from "../images/세이버pro.webp";
import c2 from "../images/연습카트.webp";

function TwoApp(props) {
    const [show, setShow] = useState(true);
    const [count, setCount] = useState(1);

    const clickButtonEvent = () => {
        setCount(count + 1);
        // Problem: 비동기 처리이므로, 아래 코드가 먼저 호출될 수도 있음
        // setShow(count % 3 === 0);

        // setCount((prev) => {
        //     let nextCount = prev + 1;
        //     setShow(nextCount % 3 === 0);

        //     return nextCount;
        // })
    }

    useEffect(() => {
        setShow(count % 3 === 0);
    }, [count]); // count 변경 시 자동 호출

    return (
        <div>
            <h3 className='alert alert-danger'>TwoApp - 3의 배수마다 이미지 보이기/숨기기</h3>
            <button type='button' className='btn btn-danger'
                onClick={clickButtonEvent}>숫자증가</button>
            <b style={{ fontSize: '4em', color: 'red', marginLeft: '50px' }}>{count}</b>
            <br /><br />
            {
                // show가 true일 때 보이는 이미지
                show &&
                <img alt='' src={c1} />
            }

            {
                // show가 false일 때 보이는 이미지
                !show &&
                <img alt='' src={c2} />
            }

            {/* src의 이미지를 import 없이 출력하는 방법 */}
            <img alt='' src={require('../images/ohmysemicolon.jpg')} />
        </div>
    );
}

export default TwoApp;