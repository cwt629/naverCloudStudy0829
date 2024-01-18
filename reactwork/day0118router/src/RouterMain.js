import React from 'react';
import Menu from './components/Menu';
import { Route, Routes } from 'react-router-dom';
// './pages'를 통해 자동으로 index.js가 호출되고, 그 안에서 import한다
import { About, Food, Home } from './pages';
// index.js 만들기 전에는 아래와 같이 import됨
// import Home from './pages/Home';
// import About from './pages/About';
// import Food from './pages/Food';

const RouterMain = () => {
    return (
        <div>
            <Menu />
            <hr style={{ clear: 'both' }} />
            <Routes>
                {/* <Route path='/home' element={<Home />} /> */}

                {/* home에 서브메뉴를 만들고자 할 경우 */}
                <Route path='/home/*' element={<Home />} />

                {/* <Route path='/about' element={<About />} /> */}

                {/* 파라미터 보내기 1 */}
                {/* :emp : emp라는 변수 사용 */}
                {/* <Route path='/about/:emp' element={<About />} /> */}

                {/* 파라미터 보내기 2 */}
                <Route path='/about' element={<About />}>
                    <Route path=':emp' element={<About />} />
                </Route>

                <Route path='/food' element={<Food />}>
                    <Route path=':food1' element={<Food />} />
                    <Route path=':food1/:food2' element={<Food />} />
                </Route>

                {/* 그 이외의 매핑 주소로 되어있을 경우 */}
                <Route path='*' element={
                    <div>
                        <h1>잘못된 URL 주소야...</h1>
                        <br /><br />
                        <img alt='' src={require(`./image/토마스기차.jpg`)} />
                    </div>
                } />
            </Routes>
        </div>
    );
};

export default RouterMain;