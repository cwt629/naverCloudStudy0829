import axios from 'axios';
import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';

const BoardForm = () => {
    const [preImg, setPreImg] = useState('');
    const [file, setFile] = useState('');
    const [subject, setSubject] = useState('');
    const [content, setContent] = useState('');

    const onUploadChange = (e) => {
        e.preventDefault();

        setFile(e.target.files[0]);

        // 미리보기를 위해 fileReader에 넣기
        const fileReader = new FileReader();

        if (e.target.files[0]) {
            fileReader.readAsDataURL(e.target.files[0]);
        }

        fileReader.onload = () => {
            setPreImg(fileReader.result);
        }
    }

    const navi = useNavigate();

    const onSubmitEvent = (e) => {
        e.preventDefault();

        const formData = new FormData();
        formData.append("upload", file);
        formData.append("token", sessionStorage.token);
        formData.append("subject", subject);
        formData.append("content", content);

        axios({
            method: 'post',
            url: "/board/insert",
            data: formData,
            headers: { 'Content-Type': 'multipart/form-data' }
        }).then(res => {
            // 추가 성공 후 목록으로 이동
            navi("/board/list");
        });
    }

    return (
        <div>
            {
                sessionStorage.token == null ?
                    <div>
                        <h4 className='alert alert-info'>회원 전용 글쓰기만 가능합니다</h4>
                    </div>
                    :
                    <div>
                        <h4 className='alert alert-info'>게시판 글쓰기</h4>
                        <form onSubmit={onSubmitEvent}>
                            <div className='input-group' style={{ width: '400px' }}>
                                <input type='text' className='form-control' required
                                    value={subject}
                                    style={{ marginLeft: '10px' }}
                                    placeholder='제목 입력...'
                                    onChange={(e) => setSubject(e.target.value)} />
                            </div>
                            <div className='input-group' style={{ width: '400px' }}>
                                <input type='file' className='form-control'
                                    name='file'
                                    onChange={onUploadChange} />
                                <img alt='' src={preImg} style={{ maxWidth: '100px', marginLeft: '20px' }} />
                            </div>
                            <div className='input-group' style={{ width: '400px' }}>
                                <textarea className='form-control' required
                                    value={content}
                                    style={{ height: '150px', marginTop: '10px' }}
                                    placeholder='내용 입력...'
                                    onChange={(e) => setContent(e.target.value)}></textarea>
                            </div>
                            <br />
                            <button type='submit' className='btn btn-outline-success'>글쓰기</button>
                        </form>
                    </div>
            }
        </div>
    );
};

export default BoardForm;