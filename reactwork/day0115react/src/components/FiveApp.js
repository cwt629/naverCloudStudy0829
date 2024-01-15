import React, { useState } from 'react';

function FiveApp(props) {
    const [msg, setMsg] = useState(['Say yes', 'No', '뭐라는거야']);

    return (
        <div>
            <h3 className='alert alert-info'>FiveApp - 배열 : 추가/삭제</h3>
            <input type='text' className='form-control'
                style={{ width: '400px' }} placeholder='메세지 입력...'
                onKeyUp={(e) => {
                    // 엔터 칠 때마다 이벤트 발생
                    if (e.key === 'Enter') {
                        // 배열에 바로 push할 수 없음
                        // setMsg(msg.push(e.target.value));

                        // 리액트에서는 배열에 데이터 추가 시, push 말고 concat으로 추가한다
                        // setMsg(msg.concat(e.target.value));

                        // 개인적으로는 이게 더 깨끗해보임
                        setMsg([...msg, e.target.value]);
                    }
                }} />
            <hr />
            <h6 className='alert alert-success'>
                총 {msg.length}개의 메세지가 있음 ㅋ<br />
                (더블클릭하면 삭제된다)
            </h6>
            <br />
            {
                msg.map((m, i) => (<h6 key={i} className='select'
                    onDoubleClick={(e) => {
                        // 방법 1 : slice
                        // setMsg([...msg.slice(0, i), ...msg.slice(i + 1)]);

                        // 방법 2 : filter
                        setMsg(msg.filter((item, idx) => (idx !== i)));
                    }}>{i + 1} : {m}</h6>))
            }

        </div>
    );
}

export default FiveApp;