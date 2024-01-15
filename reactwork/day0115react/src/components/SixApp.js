import React, { useState } from 'react';

function SixApp(props) {
    const [mycar, setMycar] = useState(["2", "7"]);
    const [carno, setCarno] = useState('');

    return (
        <div>
            <h3 className='alert alert-dark'>SixApp - 문제</h3>
            <input type='text' placeholder='자동차 번호 입력 후 엔터'
                className='form-control'
                style={{ width: '300px' }}
                value={carno}
                onChange={(e) => setCarno(e.target.value)}
                onKeyUp={(e) => {
                    if (e.key === 'Enter') {
                        // 입력값이 유효하지 않은 경우 return
                        // 자바스크립트 특성상 그냥 <1 || >15 도 되는듯?
                        if (isNaN(e.target.value) || parseInt(e.target.value) < 1 || parseInt(e.target.value) > 15) {
                            alert("1~15 사이의 숫자를 입력하쇼");
                            return;
                        }

                        // 배열 mycar에 carno 값 추가
                        setMycar([...mycar, e.target.value]);

                        // carno 값 초기화
                        setCarno('');
                    }
                }} />

            {/* 1~15 사이 번호 입력 후 엔터를 누르면 해당 자동차 이미지로 출력하기
            해당 자동차 이미지에서 더블클릭하면 자동차 삭제하기 */}
            {
                mycar.map((car, idx) => (
                    <img alt='' key={idx}
                        src={require(`../images/mycar${car}.png`)}
                        style={{ width: '100px', margin: '10px', cursor: 'pointer' }}
                        onDoubleClick={(e) => {
                            alert(`인덱스 ${idx}의 자동차를 삭제하겠다.\n자동차는 mycar${car}였다.`);
                            setMycar([...mycar.slice(0, idx), ...mycar.slice(idx + 1)]);
                        }} />
                ))
            }
        </div>
    );
}

export default SixApp;