import { DeleteForeverOutlined } from '@mui/icons-material';
import { Alert, Button } from '@mui/material';
import React, { useState } from 'react';

function ThreeApp(props) {
    const [inputArray, setInputArray] = useState([]);
    const [inputs, setInputs] = useState({
        name: '손흥민',
        nickname: '슈퍼쏜',
        hp: '010',
        addr: 'Seoul'
    });

    // 입력 시 inputs의 해당 멤버 변수로 값이 들어가게 하기 위한 이벤트
    const inputChangeEvent = (e) => {
        const { name, value } = e.target; // 이벤트가 발생하는 태그의 name과 입력값 받아오기
        setInputs({
            ...inputs, // 기존의 값을 펼침 연산자로 넣음
            [name]: value // 입력한 태그의 name에 값 변경
        })
    }

    // 배열 추가 이벤트
    const addArrayEvent = () => {
        // 기본 배열 데이터에 묶음변수인 inputs 추가
        setInputArray(inputArray.concat(inputs));
    }

    // 입력값 초기화 이벤트
    const clearButtonEvent = () => {
        setInputs({
            name: '',
            nickname: '',
            hp: '',
            addr: ''
        });
    }

    // 삭제 이벤트에서 호출해야 함
    const deleteData = (idx) => {
        setInputArray(inputArray.filter((a, i) => (idx !== i)));
    }

    return (
        <div style={{ width: '600px' }}>
            <Alert severity='error'>
                <h3>ThreeApp - 하나의 변수에 여러 값 저장하기</h3>
            </Alert>
            <table className='table table-bordered'>
                <tbody>
                    <tr>
                        <th style={{ width: '100px' }}>이름</th>
                        <td>
                            <input type='text' className='form-control'
                                value={inputs.name} name='name'
                                onChange={inputChangeEvent} />
                        </td>
                    </tr>
                    <tr>
                        <th style={{ width: '100px' }}>닉네임</th>
                        <td>
                            <input type='text' className='form-control'
                                value={inputs.nickname} name='nickname'
                                onChange={inputChangeEvent} />
                        </td>
                    </tr>
                    <tr>
                        <th style={{ width: '100px' }}>핸드폰</th>
                        <td>
                            <input type='text' className='form-control'
                                value={inputs.hp} name='hp'
                                onChange={inputChangeEvent} />
                        </td>
                    </tr>
                    <tr>
                        <th style={{ width: '100px' }}>주소</th>
                        <td>
                            <input type='text' className='form-control'
                                value={inputs.addr} name='addr'
                                onChange={inputChangeEvent} />
                        </td>
                    </tr>
                    <tr>
                        <td colSpan={2}>
                            <h5>
                                name: {inputs.name}<br />
                                nickname: {inputs.nickname}<br />
                                hp: {inputs.hp}<br />
                                addr: {inputs.addr}
                            </h5>
                        </td>
                    </tr>
                    <tr>
                        <td colSpan={2} align='center'>
                            <Button variant='outlined' color='info'
                                onClick={addArrayEvent}>배열에 추가</Button>
                            <Button variant='outlined' color='error'
                                onClick={clearButtonEvent}>입력값 초기화</Button>
                        </td>
                    </tr>
                </tbody>
            </table>
            <hr />
            {/* 배열값 출력 */}
            <table className='table table-bordered'>
                <caption align='top'>배열 개수: {inputArray.length}</caption>
                <thead>
                    <tr>
                        <th>이름</th><th>닉네임</th><th>핸드폰</th><th>주소</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        inputArray.map((item, idx) =>
                            <tr key={idx}>
                                <td>
                                    {item.name}
                                    &nbsp;&nbsp;
                                    <DeleteForeverOutlined style={{ cursor: 'pointer' }}
                                        onClick={(e) => deleteData(idx)} />
                                </td>
                                <td>{item.nickname}</td>
                                <td>{item.hp}</td>
                                <td>{item.addr}</td>
                            </tr>
                        )
                    }
                </tbody>
            </table>
        </div>
    );
}

export default ThreeApp;