import { Alert, Button } from '@mui/material';
import React, { useRef, useState } from 'react';

function TwoApp(props) {
    const [msg, setMsg] = useState('');
    const nameRef = useRef('');
    const korRef = useRef(0);
    const engRef = useRef(0);

    // 결과 확인 버튼 이벤트
    const buttonResult = () => {
        // 값들 받아오기
        let name = nameRef.current.value;
        let kor = korRef.current.value;
        let eng = engRef.current.value;

        // 숫자인지 확인 후 경고
        if (isNaN(kor)) {
            alert("국어 점수가 숫자가 아니야 인마");
            return;
        }
        if (isNaN(eng)) {
            alert("영어 점수가 숫자가 아니야 인마");
            return;
        }

        // 총점, 평균
        let total = Number(kor) + Number(eng);
        let avg = total / 2;

        let s =
            `
        이름 : ${name}
        국어점수 : ${kor}
        영어점수 : ${eng}
        총점 : ${total}
        평균 : ${avg}
        `;

        setMsg(s); // state 변수 msg에 값 넣기

        // 입력값 초기화
        nameRef.current.value = '';
        korRef.current.value = '';
        engRef.current.value = '';
        nameRef.current.focus();
    }

    return (
        <div>
            <Alert severity='info'>
                <h3>TwoApp - useRef 이용해 값 입력하기</h3>
            </Alert>
            <table className='table table-bordered'>
                <tbody>
                    <tr>
                        <th style={{ width: '100px' }}>이름</th>
                        <td>
                            <input type='text' className='form-control'
                                ref={nameRef} />
                        </td>
                    </tr>
                    <tr>
                        <th style={{ width: '100px' }}>국어 점수</th>
                        <td>
                            <input type='text' className='form-control'
                                ref={korRef} />
                        </td>
                    </tr>
                    <tr>
                        <th style={{ width: '100px' }}>영어 점수</th>
                        <td>
                            <input type='text' className='form-control'
                                ref={engRef} />
                        </td>
                    </tr>
                    <tr>
                        <td colSpan={2} align='center'>
                            <Button color='info' variant='outlined'
                                onClick={buttonResult}>
                                결과 확인
                            </Button>
                        </td>
                    </tr>
                    <tr style={{ height: '100px' }}>
                        <td colSpan={2} style={{ backgroundColor: '#ffc', whiteSpace: 'pre-line' }}>
                            <h4>{msg}</h4>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
    );
}

export default TwoApp;