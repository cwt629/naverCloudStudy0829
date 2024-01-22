import React, { useReducer, useState } from 'react';

/*
useReducer: state 관리가 용이하며, 유지 및 보수가 편함

호출: dispatch(type, action)-->reducer(state, action)

기능
reducer: state를 업데이트하는 역할(은행)
dispatch - state 업데이트를 요구
action - 요구의 내용
*/

// Reducer를 이용해서 입출금 관리하는 간단한 예제

// action.type을 미리 상수화해서 정해놓고자 할 경우
const ACTION_TYPES = {
    add: 'addmoney',
    sub: 'submoney'
}

const reducer = (state, action) => {
    console.log("reducer는 뚠뚠 오늘도 일을 하네 뚠뚠", state, action);

    switch (action.type) {
        //case 'addmoney': 
        case ACTION_TYPES.add:
            return state + Number(action.payload);

        case ACTION_TYPES.sub:
            return state - Number(action.payload);

        default:
            return state;
    }
}

const ReducerTest1 = () => {
    const [number, setNumber] = useState(0); // 입출금 입력값

    const [money, dispatch] = useReducer(reducer, 0); // 인자: 이벤트를 처리할 기관(reducer), money의 초기값

    return (
        <div>
            <h5 className='alert alert-info'>Reducer 예제 #1</h5>
            <h2>Welcome to useReducer Bank ^_^</h2>
            <h3><b>잔고 : {money}</b></h3>

            <input type='text' placeholder='입금/출금액 입력...'
                onChange={(e) => setNumber(e.target.value)} /> &nbsp;{number}
            <br />
            <button type='button' className='btn btn-info btn-sm'
                onClick={() => dispatch({ 'type': ACTION_TYPES.add, payload: number })}>입금</button>
            &nbsp;&nbsp;
            <button type='button' className='btn btn-danger btn-sm'
                onClick={() => dispatch({ type: ACTION_TYPES.sub, payload: number })}>출금</button>
        </div>
    );
};

export default ReducerTest1;