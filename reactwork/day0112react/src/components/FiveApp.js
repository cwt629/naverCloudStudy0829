import React, { useState } from 'react';
import tangerine from '../images/감귤.png';
import photo1 from '../images/dummy_tourphoto1.jpg';
import photo2 from '../images/dummy_tourphoto2.jpg';
import photo3 from '../images/dummy_tourphoto3.jpg';
import photo4 from '../images/dummy_tourphoto4.jpg';
import photo5 from '../images/dummy_tourphoto5.jpg';

function FiveApp(props) {
    const [show, setShow] = useState(true); // 보여줄지 말지 여부
    const [photo, setPhoto] = useState(photo1);
    const [border, setBorder] = useState('inset');

    return (
        <div className='box'>
            <h3 className='alert alert-warning'>
                FiveApp
                <img alt='' src={tangerine}
                style={{width: '60px', float: 'right'}}/>
            </h3>
            <div>
                <label>
                    <input type='checkbox' defaultChecked
                    onClick={(e) => {
                        setShow(e.target.checked);
                    }} />
                    이미지 보이기/숨기기
                </label>
                <br/><br/>
                <select className='form-select' style={{width: '200px'}}
                onChange={(e) => {
                    setPhoto(e.target.value);
                }}>
                    <option value={photo1}>몽환적인 구름 위</option>
                    <option value={photo2}>산뜻한 산책길</option>
                    <option value={photo3}>어느 저녁의 항구</option>
                    <option value={photo4}>석양이 지는 산</option>
                    <option value={photo5}>바다 가운데 선 등대</option>
                </select>
                <br/><br/>
                <select className='form-select' style={{width: '200px'}}
                onChange={(e) => {
                    setBorder(e.target.value);
                }}>
                    <option>inset</option>
                    <option>dotted</option>
                    <option>solid</option>
                    <option>dashed</option>
                    <option>double</option>
                    <option>groove</option>
                </select>
                <br/><br/>

                {
                    // show값이 true이면 이미지가 보이고, false이면 보이지 않음
                    show &&
                    <img alt="" src={photo} style={{width: '400px', marginTop:'30px', border: `10px ${border} gray`}} />
                }
            </div>
        </div>
    );
}

export default FiveApp;