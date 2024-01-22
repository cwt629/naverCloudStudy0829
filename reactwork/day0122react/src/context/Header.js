import React, { useContext } from 'react';
import { ThemeContext } from './ThemeContext';
import { UserContext } from './UserContext';

const Header = () => {
    const { isDark, img } = useContext(ThemeContext);
    const user = useContext(UserContext);

    return (
        <header className='header' style={{ backgroundColor: isDark ? 'black' : 'lightgray' }}>
            <h1>{user} 어서 오고</h1>
            <img alt='' src={require(`../image/${img}`)}
                style={{ width: '50px', height: '50px' }} />
        </header>
    );
};

export default Header;