import { CameraAltOutlined } from '@mui/icons-material';
import axios from 'axios';
import React, { useState } from 'react';
import Button from '@mui/material/Button';
import Dialog from '@mui/material/Dialog';
import DialogActions from '@mui/material/DialogActions';
import DialogContent from '@mui/material/DialogContent';
import DialogContentText from '@mui/material/DialogContentText';
import DialogTitle from '@mui/material/DialogTitle';
import DaumPostcodeEmbed from 'react-daum-postcode';
import { useNavigate } from 'react-router-dom';

const MemberForm = () => {
    const [photo, setPhoto] = useState('noimage.png');
    const [addr, setAddr] = useState('');
    const [open, setOpen] = useState(false); // 다이얼로그 open/close
    const [openPostcode, setOpenPostcode] = useState(false); // 카카오 주소록 open/close
    const [idCheck, setIdCheck] = useState(false); // 아이디 중복확인을 했는지 체크하기 위한 변수
    const [myid, setMyid] = useState('');
    const [name, setName] = useState('');
    const [pass, setPass] = useState('');
    const [hp, setHp] = useState('');

    const navi = useNavigate();

    const handleClickOpen = () => {
        setOpen(true);
        setOpenPostcode(true);
    };

    const handleClose = () => {
        setOpen(false);
        setOpenPostcode(false);
    };

    // 주소 선택 완료 시 호출될 이벤트
    const selectAddress = (data) => {
        console.dir(data);
        setAddr(`(${data.zonecode}) ${data.address} ${data.buildingName} `);

        // 주소 선택시, 출력 후 카카오 주소록과 다이얼로그를 닫는다
        setOpen(false);
        setOpenPostcode(false);
    }

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

    // 중복확인 버튼 이벤트
    const buttonIdCheck = () => {
        const url = "/member/idcheck?myid=" + myid;
        axios.get(url)
            .then(res => {
                if (Number(res.data) === 0) {
                    alert("사용 가능한 아이디입니다.");
                    setIdCheck(true);
                } else {
                    alert("이미 사용중인 아이디입니다.");
                    setMyid("");
                    setIdCheck(false);
                }
            })
    }

    // 데이터 저장 이벤트
    const saveMemberEvent = () => {
        if (myid.length === 0) {
            alert("아이디를 입력하신 후, 중복확인해주세요.");
            return;
        }

        if (!idCheck) {
            alert("아이디 중복 확인을 진행해주세요.");
            return;
        }

        if (name.length === 0) {
            alert("이름을 입력해주세요.");
            return;
        }
        if (pass.length === 0) {
            alert("비밀번호를 입력해주세요.");
            return;
        }

        // DB 저장
        axios.post("/member/insert", { name, myid, pass, hp, addr })
            .then(res => {
                // 멤버 추가 후, 멤버 리스트로 가기
                navi("/member/list");
            })
    }

    return (
        <div>
            {/* 카카오 주소록을 보기 위한 다이얼로그 */}
            <Dialog
                open={open}
                onClose={handleClose}
                aria-labelledby="alert-dialog-title"
                aria-describedby="alert-dialog-description"
            >
                <DialogTitle id="alert-dialog-title">
                    {"카카오 주소록"}
                </DialogTitle>
                <DialogContent>
                    <DialogContentText id="alert-dialog-description">
                        {
                            // 카카오 주소창
                            openPostcode &&
                            <DaumPostcodeEmbed
                                onComplete={selectAddress} // 값을 선택할 경우 실행되는 이벤트
                                autoClose={false} // 값을 선택할 경우 사용되는 DOM을 제거하여 자동 닫힘 설정
                                defaultQuery='강남대로 24길' // 팝업을 열 때 검색창의 기본 주소
                            />
                        }
                    </DialogContentText>
                </DialogContent>
                <DialogActions>
                    <Button onClick={handleClose} autoFocus>
                        Close
                    </Button>
                </DialogActions>
            </Dialog>
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
                            <input type='text' className='form-control'
                                value={name} onChange={(e) => setName(e.target.value)} />
                        </td>
                    </tr>
                    <tr>
                        <td width={100} style={{ backgroundColor: 'lightgray' }}>ID</td>
                        <td className='input-group'>
                            <input type='text' className='form-control'
                                style={{ width: '120px' }} value={myid}
                                onChange={(e) => {
                                    setIdCheck(false); // 아이디 입력 시 중복체크 버튼 다시 눌러야함
                                    setMyid(e.target.value);
                                }} />
                            <button type='button' className='btn btn-sm btn-outline-secondary'
                                onClick={buttonIdCheck}>중복확인</button>
                        </td>
                    </tr>
                    <tr>
                        <td width={100} style={{ backgroundColor: 'lightgray' }}>비밀번호</td>
                        <td>
                            <input type='password' className='form-control'
                                value={pass} onChange={(e) => setPass(e.target.value)} />
                        </td>
                    </tr>
                    <tr>
                        <td width={100} style={{ backgroundColor: 'lightgray' }}>핸드폰</td>
                        <td>
                            <input type='text' className='form-control'
                                value={hp} onChange={(e) => setHp(e.target.value)} />
                        </td>
                    </tr>
                    <tr>
                        <td colSpan={3}>
                            <div className='input-group'>
                                <input type='text' className='form-control'
                                    style={{ width: '400px' }} value={addr}
                                    onChange={(e) => setAddr(e.target.value)} />
                                <button type='button' className='btn btn-sm btn-primary'
                                    onClick={handleClickOpen}>주소 검색</button>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td colSpan={3} align='center'>
                            <button type='button' className='btn btn-outline-success'
                                onClick={saveMemberEvent}>회원 가입</button>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
    );
};

export default MemberForm;