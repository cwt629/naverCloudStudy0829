import { Alert } from '@mui/material';
import React, { useEffect, useState } from 'react';
import FourGuestForm from './FourGuestForm';
import axios from 'axios';
import FourGuestRowItem from './FourGuestRowItem';

const FourApp = () => {
    const [guestList, setGuestList] = useState([]);

    // 저장 함수
    const onGuestSave = (data) => { // data에는 닉네임과 글이 들어있음
        axios.post("/guest/insert", data)
            .then(res => {
                // 추가 성공 후 목록 다시 출력
                list();
            })
    }

    // 목록 출력 함수
    const list = () => {
        axios.get("/guest/list")
            .then(res => {
                setGuestList(res.data);
            })
    }

    // 삭제 함수
    const onDelete = (gnum) => {
        axios.delete("/guest/delete?gnum=" + gnum)
            .then(res => {
                list();
            })
    }

    // 처음 시작 시 목록 출력
    useEffect(() => {
        list();
    }, []);

    return (
        <div>
            <Alert severity='error' variant='filled'>
                <h3>FourApp - guest DB</h3>
            </Alert>
            <FourGuestForm onSave={onGuestSave} />
            <hr />
            <h6><b>총 {guestList.length}개의 방명록 글이 있습니다.</b></h6>
            {
                guestList.map((item, idx) => (
                    <FourGuestRowItem key={idx} info={item}
                        onDelete={onDelete} />
                ))
            }
        </div>
    );
};

export default FourApp;