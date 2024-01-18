import { Alert } from '@mui/material';
import axios from 'axios';
import React, { useEffect, useState } from 'react';
import FourGuestRowItem from './FourGuestRowItem';

const FiveApp = () => {
    const CARDS_PER_PAGE = 2;

    const [guestList, setGuestList] = useState([]);
    const [page, setPage] = useState(1);
    const [offset, setOffset] = useState(0);

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

    // 페이지 변경 시마다 offset 변경
    useEffect(() => {
        setOffset((page - 1) * CARDS_PER_PAGE);
    }, [page]);

    return (
        <div>
            <Alert severity='success'>
                <h3>FiveApp - guest DB</h3>
            </Alert>
            <hr />
            <h6><b>총 {guestList.length}개의 방명록 글이 있습니다.</b></h6>
            <div style={{ fontSize: '30px', width: '500px', textAlign: 'center' }}>
                {
                    (page > 1) ?
                        <span className='page'
                            onClick={() => setPage(page - 1)}>◁ 이전 &nbsp;&nbsp;&nbsp;&nbsp;</span> : ''
                }
                {page}
                {
                    (offset + CARDS_PER_PAGE < guestList.length) ?
                        <span className='page'
                            onClick={() => setPage(page + 1)}>&nbsp;&nbsp;&nbsp;&nbsp;다음 ▷</span> : ''
                }
                {
                    guestList.slice(offset, offset + CARDS_PER_PAGE).map((item, idx) => (
                        <FourGuestRowItem key={idx} info={item}
                            onDelete={onDelete} />
                    ))
                }
            </div>
        </div>
    );
};

export default FiveApp;