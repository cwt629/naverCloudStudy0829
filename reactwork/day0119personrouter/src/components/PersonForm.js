import { Add, ArrowBackRounded, ArtTrack } from '@mui/icons-material';
import { Alert, Button } from '@mui/material';
import axios from 'axios';
import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';

const PersonForm = () => {
    const [name, setName] = useState('');
    const [age, setAge] = useState('');
    const [blood, setBlood] = useState('A');
    const [photo, setPhoto] = useState('1.jpg');

    const nav = useNavigate();

    // 추가 버튼 이벤트
    const addDataEvent = () => {
        // axios를 이용해 데이터 전송 후, 목록으로 이동(nav 통해)

        // 강사님 구현
        // axios.post("/person/add", {name, age, photo, blood})
        // .then(res => {
        //     nav("/");
        // })

        // 내 구현: FormData로 넣어주면, 따로 Content-Type을 넣어줘야 하는듯.
        let data = new FormData();
        data.append("name", name);
        data.append("age", age);
        data.append("blood", blood);
        data.append("photo", photo);

        axios.post("/person/add", data, {
            headers: {
                'Content-Type': 'application/json'
            }
        })
            .then(() => {
                nav("/");
            })
    }

    return (
        <div className='mainbox'>
            <Alert variant='filled' severity='warning'>
                Person 멤버 등록
            </Alert>
            <div style={{ marginTop: '20px' }}>
                <table className='table table-bordered'>
                    <tbody>
                        <tr>
                            <th style={{ width: '100px', backgroundColor: '#ccc' }}>
                                이름
                            </th>
                            <td>
                                <input type='text' value={name}
                                    style={{ width: '150px' }}
                                    className='form-control'
                                    onChange={(e) => setName(e.target.value)} />
                            </td>
                        </tr>
                        <tr>
                            <th style={{ width: '100px', backgroundColor: '#ccc' }}>
                                나이
                            </th>
                            <td>
                                <input type='text' value={age}
                                    style={{ width: '150px' }}
                                    placeholder='숫자로만 입력'
                                    className='form-control'
                                    onChange={(e) => setAge(e.target.value)} />
                            </td>
                        </tr>
                        <tr>
                            <th style={{ width: '100px', backgroundColor: '#ccc' }}>
                                혈액형
                            </th>
                            <td>
                                <select className='form-select' style={{ width: '150px' }}
                                    onChange={(e) => setBlood(e.target.value)}>
                                    <option>A</option>
                                    <option>B</option>
                                    <option>O</option>
                                    <option>AB</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <th style={{ width: '100px', backgroundColor: '#ccc' }}>
                                사진
                            </th>
                            <td className='input-group'>
                                <img alt='' src={require(`../images/${photo}`)}
                                    style={{ width: '80px', marginRight: '10px' }} />
                                <select className='form-select' style={{ width: '150px', height: '40px' }}
                                    onChange={(e) => setPhoto(e.target.value)}>
                                    {
                                        [...new Array(30)].map((a, idx) => (
                                            <option>{idx + 1}.{(idx === 21 || idx === 24) ? 'webp' : 'jpg'}</option>
                                        ))
                                    }
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td colSpan={2} align='center'>
                                <Button color='success' variant='contained'
                                    onClick={addDataEvent}>
                                    <Add />
                                    <span style={{ marginLeft: '10px' }}>추가</span>
                                </Button>

                                <Button color='secondary' variant='outlined'
                                    style={{ marginLeft: '10px' }}
                                    onClick={() => nav(-1)}>
                                    <ArrowBackRounded />
                                    <span style={{ marginLeft: '10px' }}>이전</span>
                                </Button>

                                <Button color='info' variant='outlined'
                                    style={{ marginLeft: '10px' }}
                                    onClick={() => nav("/")}>
                                    <ArtTrack />
                                    <span style={{ marginLeft: '10px' }}>목록</span>
                                </Button>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    );
};

export default PersonForm;