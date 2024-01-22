import React, { useState } from 'react';
import Page from './Page';
import { ThemeContext } from './ThemeContext';
import './ContextStyle.css';
import { UserContext } from './UserContext';

const ContextApp = () => {
    const [isDark, setIsDark] = useState(false);
    return (
        <div>
            {/* 이 경우는, Page를 거쳐 Header, Content, Footer 컴포넌트로
            각 값이나 이벤트를 전달하여야만 한다. */}
            {/* <Page isDark={isDark} setIsDark={setIsDark} /> */}

            {/* 위를 Context를 이용해 
            모든 하위 컴포넌트에서 값을 공유할 수 있다! */}
            <UserContext.Provider value={"네이버클라우드"}>
                <ThemeContext.Provider value={{ isDark, setIsDark, img: 'welcomedooly.jpg' }}>
                    <Page />
                </ThemeContext.Provider>
            </UserContext.Provider>
        </div>
    );
};

export default ContextApp;