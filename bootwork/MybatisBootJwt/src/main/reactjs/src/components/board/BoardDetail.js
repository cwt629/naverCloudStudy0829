import { Button } from '@mui/material';
import axios from 'axios';
import React, { useEffect, useState } from 'react';
import { useNavigate, useParams } from 'react-router-dom';

const BoardDetail = () => {
    const STORAGE_URL = process.env.REACT_APP_STORAGE;
    const { num } = useParams();
    const navi = useNavigate();

    const [data, setData] = useState('');

    useEffect(() => {
        axios.get(`/board/detail?num=${num}`)
            .then(res => {
                setData(res.data);
            })
    }, []);

    return (
        <div style={{ padding: '30px' }}>
            {
                data &&
                <div>
                    <h2>{data.subject}</h2>
                    <h5 style={{ float: 'left' }}>{data.writer}({data.myid})</h5>
                    <h6 style={{ float: 'left', color: '#555' }}>&nbsp;&nbsp;조회 {data.readcount}</h6>
                    <h6 style={{ textAlign: 'right', color: '#777' }}>{data.writeday}</h6>
                    <hr style={{ clear: 'both' }} />
                    {
                        data.photo.length > 0 ?
                            <div>
                                <img alt='' src={STORAGE_URL + data.photo}
                                    style={{ maxWidth: '400px' }} />
                                <br />
                            </div> : ''
                    }
                    <div style={{ fontSize: '18px', fontFamily: 'Jua', whiteSpace: 'pre-line' }}>{data.content}</div>
                </div>
            }
            <br /><br />
            <hr />
            <Button variant='outlined' color='info'
                onClick={() => navi("/board/list")}>목록</Button>
            &nbsp;&nbsp;
            <Button variant='contained' color='secondary'
                onClick={() => navi("/board/form")}>글쓰기</Button>
        </div>
    );
};

export default BoardDetail;