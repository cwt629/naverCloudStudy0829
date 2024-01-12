import React, { useState } from 'react';
import thomas from '../images/토마스기차.jpg';

function FourApp(props) {
    const [fname, setFname] = useState('Single Day');
    const [fsize, setFsize] = useState('20px');
    const [fcolor, setFcolor] = useState('blue');

    // 이벤트들 정의
    // 이벤트 1: 글자색 변경
    const changeFontColor = (e) => {
        setFcolor(e.target.value);
    }

    // 이벤트 2: 글자 폰트 변경
    const changeFontFamily = (e) => {
        setFname(e.target.value);
    }

    // 이벤트 3: 글자 크기 변경
    const changeFontSize = (e) => {
        setFsize(e.target.value);
    }

    return (
        <div className='box'>
            <h3 className='alert alert-secondary'>
                FourApp
                <img alt="토마스" src={thomas}
                style={{width: '60px', float: 'right'}} />
            </h3>
            <div style={{fontFamily: fname, fontSize: fsize, color: fcolor}}>
                집에 내 컴퓨터 도착했다!!!! 우아아아아아아아아아아아!!!!
            </div>
            <div style={{marginTop: '10px'}}>
                <label>
                    <input type='radio' name='fcolor' defaultValue={'red'}
                    onClick={changeFontColor}/>빨강
                </label>
                <label style={{marginLeft: '10px'}}>
                    <input type='radio' name='fcolor' defaultValue={'blue'} defaultChecked
                    onClick={changeFontColor}/>파랑
                </label>
                <label style={{marginLeft: '10px'}}>
                    <input type='radio' name='fcolor' defaultValue={'green'}
                    onClick={changeFontColor}/>초록
                </label>
                <label style={{marginLeft: '10px'}}>
                    <input type='radio' name='fcolor' defaultValue={'magenta'}
                    onClick={changeFontColor}/>분홍
                </label>
            </div>

            <div style={{marginTop: '10px'}}>
                <label>
                    <input type='radio' name='fname' defaultValue={'Gamja Flower'}
                    onClick={changeFontFamily}/>Gamja Flower
                </label>
                <label style={{marginLeft: '10px'}}>
                    <input type='radio' name='fname' defaultValue={'Single Day'} defaultChecked
                    onClick={changeFontFamily}/>Single Day
                </label>
                <label style={{marginLeft: '10px'}}>
                    <input type='radio' name='fname' defaultValue={'Jua'}
                    onClick={changeFontFamily}/>Jua
                </label>
                <label style={{marginLeft: '10px'}}>
                    <input type='radio' name='fname' defaultValue={'Nanum Pen Script'}
                    onClick={changeFontFamily}/>Nanum Pen Script
                </label>
            </div>

            <div style={{marginTop: '10px'}}>
                <label>
                    <input type='radio' name='fsize' defaultValue={'13px'}
                    onClick={changeFontSize}/>아주 작게
                </label>
                <label style={{marginLeft: '10px'}}>
                    <input type='radio' name='fsize' defaultValue={'20px'} defaultChecked
                    onClick={changeFontSize}/>작게
                </label>
                <label style={{marginLeft: '10px'}}>
                    <input type='radio' name='fsize' defaultValue={'30px'}
                    onClick={changeFontSize}/>크게
                </label>
                <label style={{marginLeft: '10px'}}>
                    <input type='radio' name='fsize' defaultValue={'40px'}
                    onClick={changeFontSize}/>아주 크게
                </label>
            </div>
        </div>
    );
}

export default FourApp;