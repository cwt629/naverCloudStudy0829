import React, { useContext } from 'react';
import { ThemeContext } from './ThemeContext';
import { UserContext } from './UserContext';

const Content = () => {
    const { isDark, img } = useContext(ThemeContext);
    const user = useContext(UserContext);

    return (
        <div className='content' style={{ backgroundColor: isDark ? 'gray' : 'white' }}>
            <p>{user} 처신 잘하라고 ㅋㅋ</p>
            <img alt='' src={require(`../image/${img}`)}
                style={{ width: '150px', height: '150px' }} />
        </div>
    );
};

export default Content;