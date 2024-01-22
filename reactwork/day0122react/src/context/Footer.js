import React, { useContext } from 'react';
import { ThemeContext } from './ThemeContext';

const Footer = () => {
    // 여기서는 이벤트도 같이 가져와서 사용한다
    const { isDark, setIsDark, img } = useContext(ThemeContext);

    return (
        <footer className='footer' style={{ backgroundColor: isDark ? 'black' : 'lightgray' }}>
            <img alt='' src={require(`../image/${img}`)}
                style={{ width: '50px', height: '50px' }} />
            <button type='button' className='button'
                onClick={() => setIsDark(!isDark)}>Dark Mode</button>
        </footer>
    );
};

export default Footer;