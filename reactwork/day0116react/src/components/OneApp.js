import { Alert, Button } from '@mui/material';
import React, { useRef, useState } from 'react';

function OneApp(props) {
    // count 증가: 하나는 state, 하나는 ref
    const [count, setCount] = useState(0);
    const countRef = useRef(0);

    console.log("렌더링 중...");

    return (
        <div>
            <Alert severity='success'>
                {/* 입력 시마다 렌더링이 되는 것이 필요하지 않으면, state 대신 ref 써보자. */}
                <h3>OneApp - useRef : 값이 변경되어도 화면이 다시 렌더링되지 않는다</h3>
            </Alert>
            <h1>state : {count}</h1>
            {/* ref는 바로 불러오는 것이 아니라, current로 불러와준다 */}
            <h1>ref : {countRef.current}</h1>
            <hr />
            <Button variant='outlined' color='success'
                onClick={() => setCount(count + 1)}>count 변수 증가</Button>
            <br />
            <Button variant='outlined' color='primary' size='small'
                onClick={() => {
                    // 버튼을 클릭해도 렌더링이 일어나지 않고, 값만 변경되게 된다
                    countRef.current = countRef.current + 1; // ref값 증가시키기
                    console.log("countRef.current = " + countRef.current);
                }}>countRef 변수 증가</Button>
        </div>
    );
}

export default OneApp;