import { Button } from '@mui/material';
import React from 'react';

const MemberCard = ({ info, deleteMember }) => {
    const IMAGE_URL = process.env.REACT_APP_STORAGE;

    return (
        <div className='memberCard'>
            <img alt='' src={IMAGE_URL + ((info.photo) ? info.photo : 'noimage.png')}
                style={{ width: '200px', height: '300px', float: 'left', marginRight: '30px' }} />
            <h5>이름 : {info.name}</h5>
            <h5>아이디 : {info.myid}</h5>
            <h5>핸드폰 : {info.hp}</h5>
            <h5>주소 : {info.addr}</h5>
            <h5>가입일 : {info.gaipday}</h5>
            <br />
            <Button variant='outlined' color='error'
                onClick={() => deleteMember(info.num)}>회원 삭제</Button>
        </div>
    );
};

export default MemberCard;