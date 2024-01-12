import React, {Component} from 'react';
import './MyStyle.css';
import mario from '../images/mario.jpg';
import gom from '../images/gombangwa.jpg';

/*
초기 리액트는 컴포넌트가 클래스로 구현되어 있다.
*/

//class OneApp extends React.Component {
class OneApp extends Component {
    // class 내에서 state 변수를 선언해보자
    // ES6에서 생성자 선언: constructor
    constructor(){
        super(); // 생략 시 오류남
        this.state = {
            number: 0
        }
    }

    render(){
        // style을 변수로 지정한 후 적용하기
        const imgStyle = {
            border: '2px solid green',
            width: '390px',
            boxShadow: '3px 3px 3px gray'
        };

        const fontStyle = {
            color: 'red',
            fontFamily: 'Single Day',
            marginTop: '20px'
        };

        const message = "I will find you."; // 변경 필요 없는 메세지 변수 선언

        return (
            <div className='box' style={{backgroundColor: 'beige'}}>
                <h3 className='alert alert-danger'>OneApp
                    <img alt='마리오' src={mario}
                    style={{width: '60px', float: 'right'}}/>
                </h3>
                <img alt="곰방와" src={gom} style={imgStyle}/>
                <h2 style={fontStyle}>{message}</h2>

                <div style={{fontSize: '40px', color: 'magenta', marginLeft: '30px'}}>
                    {/* class일 경우에 state 변수 출력 방법 */}
                    너의 목숨은 {this.state.number}개 남았어.
                </div>
                <button type="button" className='btn btn-outline-danger'
                onClick={() => {
                    // number값 1씩 증가
                    this.setState({
                        number: this.state.number + 1
                    })
                }}>
                    Add Life
                </button>
            </div>
        )
    }
}

//export default OneApp; // default는 단 한번만 가능하며, import 시에 이름을 임의로 변경 가능
export {OneApp}; // 여러번 export 가능하지만, import 시 {OneApp}으로 받아, 이름 변경 안됨