import React, { useState } from 'react';
import winter from '../images/aespawinter.jpg';

function ThreeApp(props) {
    const [username, setUsername] = useState('장원태');
    const [spring, setSpring] = useState(80);
    const [react, setReact] = useState(77);

    const inputStyle = {
        marginLeft: '10px'
    }

    const resultStyle = {
        position: 'absolute',
        left: '260px',
        top: '95px'
    }

    return (
        <div className='box' style={{position: 'absolute'}}>
            <h3 className='alert alert-info'>
                ThreeApp
                <img alt="" src={winter}
                style={{width: '60px', float: 'right'}}/>
            </h3>
            <div style={{width: '200px'}}>
                <div className='input-group'>
                    <h4>이름 </h4>
                    <input type='text' className='form-control' style={inputStyle}
                    value={username}
                    onChange={(e) => {
                        setUsername(e.target.value);
                    }}/>
                </div>
                <div className='input-group'>
                    <h4>스프링 점수 </h4>
                    <input type='text' className='form-control' style={inputStyle}
                    value={spring}
                    onChange={(e) => {
                        setSpring(Number(e.target.value));
                    }}/>
                </div>
                <div className='input-group'>
                    <h4>리액트 점수 </h4>
                    <input type='text' className='form-control' style={inputStyle}
                    value={react}
                    onChange={(e) => {
                        setReact(Number(e.target.value));
                    }}/>
                </div>
            </div>

            <div style={resultStyle}>
                이 름 : {username}<br/>
                스프링 점수 : {spring}점<br/>
                리액트 점수 : {react}점<br/>
                총 점 : {spring + react}점<br/>
                평 균 : {(spring + react) / 2}점<br/>
                {/* 평균 90 이상은 '장학생', 80 이상은 '우등생',
                나머지는 '노오력' */}
                등 급 : {(spring + react) / 2 >= 90? '장학생' : ((spring + react) / 2 >= 80? '우등생' : '노오력')}
            </div>
        </div>
    );
}

export default ThreeApp;