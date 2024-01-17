import { Alert } from '@mui/material';
import axios from 'axios';
import React, { useEffect, useState } from 'react';
import ThreeCardApp from './ThreeCardApp';

const ThreeApp = () => {
    const [personList, setPersonList] = useState([]);

    const list = () => {
        // 백엔드로부터 데이터를 가져와 배열 변수에 넣기
        axios.get("/person/list")
            .then(res => {
                setPersonList(res.data);
            })
    }

    useEffect(() => {
        console.log("ㅎㅇ");
        list(); // 처음 시작 시 무조건 호출
    }, []); // 처음 시작 시 한번만 호출

    return (
        <div>
            <Alert variant='filled' severity='warning'>
                <h3>ThreeApp - MUI card를 이용한 목록 출력</h3>
            </Alert>
            {
                personList.map((item, idx) => (
                    <div key={idx}>
                        <ThreeCardApp item={item} />
                        <hr />
                    </div>
                ))
            }
        </div >
    );
};

export default ThreeApp;