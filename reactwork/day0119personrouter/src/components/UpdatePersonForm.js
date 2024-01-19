import { Add, ArrowBackRounded, ArtTrack } from '@mui/icons-material';
import { Alert, Button } from '@mui/material';
import axios from 'axios';
import React, { useEffect, useState } from 'react';
import { useNavigate, useParams } from 'react-router-dom';

const UpdatePersonForm = () => {
    const [name, setName] = useState('');
    const [age, setAge] = useState('');
    const [blood, setBlood] = useState('A');
    const [photo, setPhoto] = useState('1.jpg');

    const { pnum } = useParams();

    const nav = useNavigate();

    // 데이터 불러오기
    const getCurrentData = () => {
        const url = "/person/select?pnum=" + pnum;

        axios.get(url)
            .then(res => {
                setName(res.data.name);
                setAge(res.data.age);
                setBlood(res.data.blood);
                setPhoto(res.data.photo);
            })
    }

    // 강사님 구현: state를 dto 형태로 정의하고, change를 다음과 같이 정의
    // 이렇게 하면 pnum은 어차피 들어있으므로, update도 똑같이 해주면 된다.
    // const changeData = (e) => {
    //     const {name, value} = e.target;
    //     setSelectData({
    //         ...selectData,
    //         [name]: value // 이거 하려면, input마다 name 줘야 함.
    //     })
    // }

    // 데이터 수정 후 디테일로 이동하기
    const handleFormUpdate = () => {
        // 주의: pnum을 꼭 같이 넘겨주도록 하자
        axios.post("/person/update", { pnum, name, age, photo, blood })
            .then(res => {
                nav(`/detail/${pnum}`);
            })
    }

    useEffect(() => {
        getCurrentData();
    }, []);

    return (
        <div className='mainbox'>
            <Alert variant='filled' severity='warning'>
                Person 멤버 수정
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
                                <select className='form-select' style={{ width: '150px' }} value={blood}
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
                                {
                                    photo &&
                                    <img alt='' src={require(`../images/${photo}`)}
                                        style={{ width: '80px', marginRight: '10px' }} />
                                }

                                <select className='form-select' style={{ width: '150px', height: '40px' }} value={photo}
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
                                    onClick={handleFormUpdate}>
                                    <Add />
                                    <span style={{ marginLeft: '10px' }}>수정</span>
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

export default UpdatePersonForm;