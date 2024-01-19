import axios from 'axios';
import React, { useEffect, useState } from 'react';
import { useNavigate, useParams } from 'react-router-dom';
import { ArrowBack, EditNote } from '@mui/icons-material';

const DetailPerson = () => {
    const { pnum } = useParams();
    const nav = useNavigate();
    const [selectData, setSelectData] = useState('');

    // pnum에 대한 dto를 얻어 selectData에 넣는다
    const getSelectedData = () => {
        const url = "/person/select?pnum=" + pnum;
        axios.get(url)
            .then(res => {
                setSelectData(res.data);
            })
    }

    // 처음 로딩 시 딱 한 번 호출
    useEffect(() => {
        getSelectedData();
    }, []);

    return (
        <div className='mainbox'>
            <h2><b>{selectData.name}님의 개인 정보</b></h2>
            {/* useEffect가 DB 탐색하기도 전에 발생할 수 있어서, 오류가 남.
            그래서, 다음과 같이 && 연산자를 준다 */}
            {
                selectData.photo &&
                <img alt='' src={require(`../images/${selectData.photo}`)}
                    style={{ maxWidth: '300px' }} />
            }
            <hr />
            <h6>
                혈액형 : {selectData.blood}형

                <EditNote style={{ fontSize: '2em', float: 'right', cursor: 'pointer' }}
                    onClick={() => nav(`/updateform/${selectData.pnum}`)} />
            </h6>
            <h6>나  이 : {selectData.age}세</h6>
            <h6>
                가입일 : {selectData.writeday}
                <ArrowBack style={{ fontSize: '2em', float: 'right', cursor: 'pointer' }}
                    // -1 : 이전 페이지로 이동
                    onClick={() => nav(-1)} />
            </h6>
        </div>
    );
};

export default DetailPerson;