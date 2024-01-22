import React, { useMemo } from 'react';

const getNumber = (number) => {
    console.log("숫자가 변동되었습니다");
    return number;
}

const getText = (text) => {
    console.log("문자가 변동되었습니다");
    return text;
}

const ShowState = ({ number, text }) => {
    /* 
    Problem: 
    숫자만 변경되면 숫자만 변경되었다고 나와야 되는데,
    전체가 다시 렌더링되면서, 두 가지 메세지가 같이 나온다.
    */
    // const showNumber = getNumber(number);
    // const showText = getText(text);

    // 그래서 useMemo를 활용한다.
    // 이는 렌더링을 최적화하기 위한 기능이다.
    const showNumber = useMemo(() => getNumber(number), [number]);
    const showText = useMemo(() => getText(text), [text]);

    return (
        <div>
            <h3>{showNumber}</h3>
            <h3>{showText}</h3>
        </div>
    );
};

export default ShowState;