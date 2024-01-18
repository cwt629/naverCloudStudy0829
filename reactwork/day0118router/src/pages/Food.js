import { Alert } from '@mui/material';
import React from 'react';
import { useParams } from 'react-router-dom';

const Food = () => {
    const { food1, food2 } = useParams();

    return (
        <div>
            <Alert variant='filled' severity='info'>
                Food 컴포넌트임 ㅋ
            </Alert>
            {
                !food1 ?
                    <div>
                        <h1>오늘은 다이어트다</h1>
                        <img alt='' src={require(`../image/mario.webp`)} />
                    </div>
                    :
                    !food2 ?
                        <div>
                            <h1>오늘 밥은 이거 ㄱㄱ 디저트 먹을 생각은 하지 마라</h1>
                            <img alt='' src={require(`../image/${food1}.jpg`)} />
                        </div>
                        :
                        <div>
                            <h1>오늘 밥은 이거 먹고</h1>
                            <img alt='' src={require(`../image/${food1}.jpg`)} />
                            <h1>디저트는 이거 드셈</h1>
                            <img alt='' src={require(`../image/${food2}.jpg`)} />
                        </div>
            }
        </div>
    );
};

export default Food;