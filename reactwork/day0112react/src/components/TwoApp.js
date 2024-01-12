import React, { useState } from 'react';
import mush from '../images/뿔버섯2.jpg';

function TwoApp(props) {
    // 함수형에서 state 변수 선언하기
    const [number, setNumber] = useState(0);
    return (
        <div className='box'>
            <h3 className='alert alert-primary'>TwoApp
                <img alt="뿔버섯" src={mush} style={{width: '60px', float: 'right'}} />
            </h3>
            <div style={{fontSize: '40px', color: 'red', textAlign: 'center'}}>
                HP : {number}
            </div>
            <div style={{marginLeft: '165px'}}>
                <button type='button' className='btn btn-outline-danger'
                onClick={() => {
                    if (number === 0){
                        alert("이미 죽은 뿔버섯에게 딜할 수 없습니다...");
                        return;
                    }
                    setNumber(number - 1);
                }}>
                    Deal
                </button>
                <button type='button' className='btn btn-outline-success'
                style={{marginLeft: '10px'}}
                onClick={() => {
                    if (number === 10){
                        alert("뿔버섯의 최대 체력은 10입니다. 유감...");
                        return;
                    }
                    setNumber(number + 1);
                }}>
                    Heal
                </button>
            </div>
        </div>
    );
}

export default TwoApp;