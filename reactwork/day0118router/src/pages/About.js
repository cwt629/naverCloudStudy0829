import React from 'react';
import { Alert } from '@mui/material';
import { useParams } from 'react-router-dom';
import simg from '../image/세이버pro.webp';
import gimg from '../image/연습카트.webp';


const About = () => {
    const { emp } = useParams(); // emp라는 변수 읽기
    // console.log(emp); // Google
    // console.log({ emp }); // {'emp': 'Google'}
    // console.log({ emp }.emp); // Google

    return (
        <div>
            <Alert variant='filled' severity='success'>
                About 컴포넌트임 ㅋ
            </Alert>
            {
                emp == null ?
                    // emp값이 넘어오지 않은 경우(정확히는 undefined긴 함) 실행할 영역
                    <div>
                        <h1>저는 취업준비생입니다 ㅠㅠ</h1>
                        <img alt='' src={require(`../image/stopmylittlekitty.jpeg`)} />
                    </div>
                    :
                    // emp값이 있는 경우 실행할 영역
                    <div>

                        <h1>저는 {emp}에 다니고 있음 ㅋㅋ라고 할뻔</h1>
                        <img alt='' src={(emp === 'Samsung') ? simg : gimg} />
                    </div>
            }
        </div>
    );
};

export default About;