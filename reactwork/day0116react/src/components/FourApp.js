import { Alert } from '@mui/material';
import React, { useState } from 'react';
import FourChildApp from './FourChildApp';

/*
[부모, 자식간의 통신]
1. 부모 컴포넌트에서 자식 컴포넌트로 props를 통해서
값이나 이벤트를 전달할 수 있다.
2. 자식 컴포넌트에서는 부모 컴포넌트의 값을 props로 받아
출력은 가능하지만 직접 변경은 불가능하다.
3. 만약 변경하려면 부모의 이벤트를 props를 통해 호출을 하여
그 이벤트함수에서 변경을 하면 된다.

props는 부모 컴포넌트가 설정하며,
컴포넌트 자신은 해당 props를 읽기 전용으로만 사용할 수 있다.

컴포넌트 내부에서 읽고 또 업데이트하려면 state를 써야 한다.
*/

function FourApp(props) {
    const [count, setCount] = useState(0);

    // count를 증가하는 함수
    const changeCount = () => {
        setCount(count + 1);
    }

    return (
        <div>
            <Alert variant='filled' severity='success'>
                <h3>FourApp - 부모,자식간 통신</h3>
            </Alert>
            <h4><b>방문 횟수 : {count}회</b></h4>
            <FourChildApp name={"장원태"} age={"29세"} addr={"서울"} incre={changeCount} />
            <FourChildApp name={"박찬호"} age={"54세"} addr={"LA"} incre={changeCount} />
            <FourChildApp name={"손흥민"} age={"34세"} addr={"영국"} incre={changeCount} />
        </div>
    );
}

export default FourApp;