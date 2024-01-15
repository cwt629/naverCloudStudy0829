import React, { useEffect, useState } from 'react';

function OneApp(props) {
    const [count, setCount] = useState(0);
    const [number, setNumber] = useState(0);
    const [message, setMessage] = useState("Input Message");

    // count만 증가하는 이벤트
    const incrementCount = () => {
        setCount(count + 1);
    }

    // number만 증가하는 이벤트
    const incrementNumber = () => {
        setNumber(number + 1);
    }

    // 모두 증가하는 이벤트
    const incrementBoth = () => {
        setCount(count + 1);
        setNumber(number + 1);
    }

    // useEffect
    // useEffect(() => {
    //     console.log("처음 시작 시, state 변수 변경 시마다 호출");
    // }); // 어떤 값을 변경하든 무조건 호출

    useEffect(() => {
        console.log("count 변경 시에만 호출 ㅋ");
    }, [count]); // count 변경 시에만 호출

    useEffect(() => {
        console.log("number 변경 시에만 호출 ㅎ");
    }, [number]); // number 변경 시에만 호출

    return (
        <div>
            <h3 className='alert alert-success'>OneApp - useEffect 공부</h3>

            <button type='button' className='btn btn-outline-secondary'
                onClick={incrementCount}>
                count만 증가
            </button>
            &nbsp;
            <button type='button' className='btn btn-outline-warning'
                onClick={incrementNumber}>
                number만 증가
            </button>
            &nbsp;
            <button type='button' className='btn btn-outline-primary'
                onClick={incrementBoth}>
                count, number 모두 증가
            </button>
            <br />
            <input type='text' value={message} onChange={(e) => setMessage(e.target.value)} />
            <br />
            <b style={{ fontSize: '2em' }}>count : {count}</b>
            <br />
            <b style={{ fontSize: '2em' }}>number : {number}</b>
            <br />
            <b style={{ fontSize: '20px' }}>{message}</b>
        </div>
    );
}

export default OneApp;