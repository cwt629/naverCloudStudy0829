import React from 'react';
import img1 from '../images/hongsnowhi.jpg';
import img2 from '../images/sleepingcat.jpg';
import img3 from '../images/넙치.webp';
import img4 from '../images/타요.gif';
import './MyStyle.css';


function FourApp(props) {
    const myImage = [img1, img2, img3, img4]; // 4개의 import된 이미지를 배열에 저장
    const data = [
        { "name": "강호동", "addr": "서울", "hp": "010-2222-3333", "photo": "mario.jpg" },
        { "name": "장원태", "addr": "제주", "hp": "010-1234-1234", "photo": "감귤.png" },
        { "name": "이승민", "addr": "대구", "hp": "010-9999-8888", "photo": "뿔버섯2.jpg" },
        { "name": "이준일", "addr": "인천", "hp": "010-4444-8282", "photo": "토마스기차.jpg" }
    ];

    return (
        <div>
            <h3 className='alert alert-secondary'>FourApp - map으로 이미지 배열 출력</h3>
            {
                myImage.map((img, idx) => (<img alt='' src={img} key={idx} width='200' />))
            }
            <hr />
            {
                data.map((ele, i) => (
                    <div className='box' key={i}>
                        <h5>이름: {ele.name}</h5>
                        <h5>주소: {ele.addr}</h5>
                        <h5>핸드폰: {ele.hp}</h5>
                        <img alt='프로필사진' src={require(`../images/${ele.photo}`)} width='120' />
                    </div>
                ))
            }
            <hr style={{ clear: 'both' }} />
            <table className='table table-bordered' style={{ width: '600px' }}>
                <thead>
                    <tr>
                        <th width={50}>번호</th>
                        <th width={120}>사진</th>
                        <th width={60}>이름</th>
                        <th width={100}>핸드폰</th>
                        <th width={70}>주소</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        data.map((ele, i) => (
                            <tr key={i}>
                                <td>{i + 1}</td>
                                <td><img alt='' src={require(`../images/${ele.photo}`)} width='120' /></td>
                                <td>{ele.name}</td>
                                <td>{ele.hp}</td>
                                <td>{ele.addr}</td>
                            </tr>
                        ))
                    }
                </tbody>
            </table>
        </div>
    );
}

export default FourApp;