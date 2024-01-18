import React from 'react';
import { DeleteForeverOutlined } from '@mui/icons-material';

const FourGuestRowItem = ({ info, onDelete }) => {
    // .env (공통된 환경변수 등록) - 가져오는 방법
    const imageStorage = process.env.REACT_APP_STORAGE;

    return (
        <div className='guestCard'>
            <div style={{ padding: '10px 0' }}>
                <b style={{ fontSize: '30px' }}>{info.nickname}</b>
                <DeleteForeverOutlined
                    style={{ marginLeft: '20px', cursor: 'pointer' }}
                    onClick={(e) => {
                        if (window.confirm("정말로 삭제하시겠습니까?")) {
                            onDelete(info.gnum);
                        }
                    }} />
                <b style={{ float: 'right', padding: '5px 30px 0 0', color: '#888', fontSize: '0.9em' }}>{info.writeday}</b>
            </div>
            <img alt='' src={imageStorage + info.photo}
                style={{ width: '200px', height: '250px', clear: 'both', margin: '20px' }} />
            <div style={{ whiteSpace: 'pre-line', width: '200px', float: 'right', fontSize: '20px' }}>
                {info.content}
            </div>
        </div>
    );
};

export default FourGuestRowItem;