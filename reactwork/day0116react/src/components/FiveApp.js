import { Alert } from '@mui/material';
import React, { useState } from 'react';
import FiveRowItem from './FiveRowItem';
import FiveWriteForm from './FiveWriteForm';

function FiveApp(props) {
    const [foodArray, setFoodArray] = useState([
        {
            fname: '오렌지빙수',
            fphoto: '11.jpg',
            fprice: '12000',
            fdate: new Date()
        },
        {
            fname: '샌드위치',
            fphoto: '1.jpg',
            fprice: '9900',
            fdate: new Date()
        }
    ]);

    // 데이터 추가 이벤트
    const dataAdd = (data) => {
        setFoodArray(foodArray.concat({
            ...data,
            fdate: new Date()
        }));
    }

    // 데이터 삭제 이벤트
    const deleteData = (idx) => {
        setFoodArray(foodArray.filter((item, index) => (index !== idx)));
    }

    return (
        <div>
            <Alert variant='outlined' severity='info'>
                <h3>FiveApp - 부모,자식간 통신예제</h3>
            </Alert>
            {/* 입력폼 */}
            <FiveWriteForm onSave={dataAdd} />
            <hr />
            <table className='table table-bordered' style={{ width: '850px' }}>
                <thead>
                    <tr style={{ backgroundColor: 'palegoldenrod' }}>
                        <th>번호</th>
                        <th>메뉴명</th>
                        <th>가격</th>
                        <th>날짜</th>
                        <th>삭제</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        foodArray.map((data, idx) => (<FiveRowItem row={data} idx={idx} onDelete={deleteData} />))
                    }
                </tbody>
            </table>
        </div>
    );
}

export default FiveApp;