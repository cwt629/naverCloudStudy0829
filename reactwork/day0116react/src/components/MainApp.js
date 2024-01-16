import React, { useState } from 'react';
import OneApp from './OneApp';
import TwoApp from './TwoApp';
import ThreeApp from './ThreeApp';
import FourApp from './FourApp';
import FiveApp from './FiveApp';
import SixApp from './SixApp';
import './MyStyle.css';
import SevenApp from './SevenApp';

function MainApp(props) {
    const [index, setIndex] = useState(1);

    const onChangeApp = (e) => {
        setIndex(Number(e.target.value));
    }

    return (
        <div style={{ margin: '30px' }}>
            <h3 className='alert alert-success'>2024-01-16 - React</h3>
            <label>
                <input type='radio' name='myapp'
                    defaultValue={1} defaultChecked
                    onClick={onChangeApp} />OneApp
            </label>
            <label style={{ marginLeft: '20px' }}>
                <input type='radio' name='myapp'
                    defaultValue={2}
                    onClick={onChangeApp} />TwoApp
            </label>
            <label style={{ marginLeft: '20px' }}>
                <input type='radio' name='myapp'
                    defaultValue={3}
                    onClick={onChangeApp} />ThreeApp
            </label>
            <br />
            <label>
                <input type='radio' name='myapp'
                    defaultValue={4}
                    onClick={onChangeApp} />FourApp
            </label>
            <label style={{ marginLeft: '20px' }}>
                <input type='radio' name='myapp'
                    defaultValue={5}
                    onClick={onChangeApp} />FiveApp
            </label>
            <label style={{ marginLeft: '20px' }}>
                <input type='radio' name='myapp'
                    defaultValue={6}
                    onClick={onChangeApp} />SixApp
            </label>
            <label style={{ marginLeft: '20px' }}>
                <input type='radio' name='myapp'
                    defaultValue={7}
                    onClick={onChangeApp} />SevenApp
            </label>
            <hr />
            {
                (index === 1) ? <OneApp />
                    : (index === 2) ? <TwoApp />
                        : (index === 3) ? <ThreeApp />
                            : (index === 4) ? <FourApp />
                                : (index === 5) ? <FiveApp />
                                    : (index === 6) ? <SixApp /> : <SevenApp />
            }
        </div>
    );
}

export default MainApp;