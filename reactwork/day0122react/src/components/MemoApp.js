import React, { useState } from 'react';
import ShowState from './ShowState';

const MemoApp = () => {
    const [number, setNumber] = useState(0);
    const [text, setText] = useState('');

    const incrementNumber = () => {
        setNumber(number + 1);
    }

    const decrementNumber = () => {
        setNumber(number - 1);
    }

    const handleTextChange = (e) => {
        setText(e.target.value);
    }

    return (
        <div>
            <button className='btn btn-danger btn-sm'
                onClick={incrementNumber}>증가</button>
            <br /><br />
            <button className='btn btn-danger btn-sm'
                onClick={decrementNumber}>감소</button>
            <br /><br />
            <input type='text' placeholder='input name...'
                onChange={handleTextChange} />

            <hr />
            <ShowState number={number} text={text} />
        </div>
    );
};

export default MemoApp;