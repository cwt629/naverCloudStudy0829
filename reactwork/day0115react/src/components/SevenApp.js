import React, { useState } from 'react';

function SevenApp(props) {
    const [array, setArray] = useState([
        { title: "세이버 프로", price: '23000', color: 'blue', photo: '세이버pro.webp' },
        { title: "연습카트", price: '12000', color: 'red', photo: '연습카트.webp' },
        { title: "타요", price: '35000', color: 'skyblue', photo: '타요.gif' },
        { title: "토마스", price: '27000', color: 'black', photo: '토마스기차.jpg' }
    ]);

    const [data, setData] = useState('');

    return (
        <div>
            <h3 className='alert alert-warning'>SevenApp - 배열 출력</h3>
            <table className='table table-bordered' style={{ width: '400px' }}>
                <tbody>
                    {
                        array.map((item, idx) => (
                            <tr key={idx}>
                                <td style={{ width: '150px' }}>
                                    <img alt='' width={130}
                                        src={require(`../images/${item.photo}`)} />
                                </td>
                                <td>
                                    제목 : {item.title}<br />
                                    가격 : {item.price}<br />
                                    색상 : <b style={{ backgroundColor: item.color }}>{item.color}</b><br />
                                    <button type='button' className='btn btn-danger btn-sm'
                                        onClick={() => setArray([...array.slice(0, idx), ...array.slice(idx + 1)])}>Delete</button>

                                </td>
                            </tr>
                        ))
                    }
                </tbody>
            </table>
        </div>
    );
}

export default SevenApp;