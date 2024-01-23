import { CameraAltOutlined } from '@mui/icons-material';
import axios from 'axios';
import React, { useState } from 'react';

const MemberForm = () => {
    const [photo, setPhoto] = useState('noimage.png');
    const [addr, setAddr] = useState('');

    // 네이버 스토리지의 이미지 폴더명
    const IMAGE_URL = process.env.REACT_APP_STORAGE;

    // 파일 업로드 이벤트
    const uploadPhoto = (e) => {
        const uploadFile = new FormData();
        uploadFile.append("upload", e.target.files[0]);
        axios({
            method: 'post',
            url: '/member/upload',
            data: uploadFile,
            headers: { 'Content-Type': 'multipart/form-data' }
        }).then(res => {
            setPhoto(res.data); // 사진 변경(스토리지에 업로드된 파일명을 서버가 반환한다)
        })
    }

    return (
        <div>
            <h4 className='alert alert-warning'>회원가입</h4>
            <table style={{ width: '600px' }} className='table table-bordered'>
                <tbody>
                    <tr>
                        <td rowSpan={4} width={200} align='center' valign='middle'>
                            <img alt='' src={IMAGE_URL + photo}
                                // noimage 띄우기
                                // 강사님 구현: onError 활용
                                // onError={(e) => e.target.src = errimg}
                                style={{ width: '150px', height: '150px' }} />
                            <br />
                            <input type='file' id='filephoto' style={{ display: 'none' }}
                                onChange={uploadPhoto} />
                            <CameraAltOutlined style={{ fontSize: '2em', cursor: 'pointer' }}
                                onClick={() => document.getElementById("filephoto").click()} />
                        </td>
                        <td width={100} style={{ backgroundColor: 'lightgray' }}>이름</td>
                        <td>
                            <input type='text' className='form-control' />
                        </td>
                    </tr>
                    <tr>
                        <td width={100} style={{ backgroundColor: 'lightgray' }}>ID</td>
                        <td className='input-group'>
                            <input type='text' className='form-control'
                                style={{ width: '120px' }} />
                            <button type='button' className='btn btn-sm btn-outline-secondary'>중복확인</button>
                        </td>
                    </tr>
                    <tr>
                        <td width={100} style={{ backgroundColor: 'lightgray' }}>비밀번호</td>
                        <td>
                            <input type='password' className='form-control' />
                        </td>
                    </tr>
                    <tr>
                        <td width={100} style={{ backgroundColor: 'lightgray' }}>핸드폰</td>
                        <td>
                            <input type='text' className='form-control' />
                        </td>
                    </tr>
                    <tr>
                        <td colSpan={3}>
                            <div className='input-group'>
                                <input type='text' className='form-control' />
                                <button type='button' className='btn btn-sm btn-primary'>주소 검색</button>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td colSpan={3} align='center'>
                            <button type='button' className='btn btn-outline-success'>회원 가입</button>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
    );
};

export default MemberForm;