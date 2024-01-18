import { Alert } from '@mui/material';
import React from 'react';

const HomeSub2 = () => {
    return (
        <div>
            <Alert variant='filled' severity='warning'>
                우리 회사 구조도<br />
                사장 : 설석현<br />
                부장 : 이준일<br />
                차장 : 이승민
            </Alert>
        </div>
    );
};

export default HomeSub2;