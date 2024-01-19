import { Alert, Button } from '@mui/material';
import React, { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';
import PersonRowItem from './PersonRowItem';

const PersonList = () => {
    const [list, setList] = useState([]);
    const nav = useNavigate();

    const getPersonList = () => {
        axios.get('/person/list')
            .then(res => {
                setList(res.data);
            })
    }

    // 회원 삭제
    const deletePerson = (pnum) => {
        if (!window.confirm("정말로 해당 회원 정보를 삭제하시겠습니까?"))
            return;

        axios.delete("/person/delete?pnum=" + pnum)
            .then(res => {
                getPersonList();
            })
    }

    useEffect(() => {
        getPersonList();
    }, []);

    return (
        <div className='mainbox'>
            <Button color='success' variant='outlined'
                onClick={() => nav("/writeform")}>멤버 추가</Button>
            <br /><br />
            <Alert variant='filled' severity='info'>
                Person 멤버 목록
            </Alert>
            <h5><b>총 {list.length}명의 회원 정보가 있습니다</b></h5>
            <table className='table table-bordered'>
                <thead>
                    <tr>
                        <th style={{ width: '80px', backgroundColor: 'orange' }}>번호</th>
                        <th style={{ width: '300px', backgroundColor: 'orange' }}>회원명</th>
                        <th style={{ width: '120px', backgroundColor: 'orange' }}>삭제</th>
                    </tr>
                </thead>
                <tbody>
                    {/* DetailPerson에서와 같은 이유로 list가 null이면 그리지 않게 처리 */}
                    {
                        list &&
                        list.map((row, idx) => (
                            <PersonRowItem key={idx} row={row} idx={idx}
                                onDelete={deletePerson} />
                        ))
                    }
                </tbody>
            </table>

        </div>
    );
};

export default PersonList;