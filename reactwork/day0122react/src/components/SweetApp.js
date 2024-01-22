import React from 'react';

import img1 from '../image/dummy_tourphoto1.jpg'
import img2 from '../image/dummy_tourphoto2.jpg'
import img3 from '../image/dummy_tourphoto3.jpg'
import img4 from '../image/dummy_tourphoto4.jpg'
import img5 from '../image/dummy_tourphoto5.jpg'
import { Button } from '@mui/material';
import Swal from 'sweetalert2';

const SweetApp = () => {
    return (
        <div>
            <h3 className='alert alert-success'>SweetAlert 사용</h3>
            <hr />
            <Button variant='outlined' color='warning'
                onClick={() => {
                    Swal.fire('ㅎㅇ');
                }}>기본 Alert</Button>
            <br />
            <Button variant='outlined' color='error'
                onClick={() => {
                    Swal.fire({
                        title: 'BigMac Song',
                        html: "참깨빵 위에<br/>순쇠고기 패티 두장<br/>특별한 소스 양상추<br/>치즈 피클 양파까지",
                        icon: "warning",
                        confirmButtonText: "확인",
                        confirmButtonColor: "#3085d6",
                        cancelButtonText: "취소",
                        cancelButtonColor: 'pink',
                        showCancelButton: true
                    }).then(result => {
                        // 확인을 누른 경우
                        if (result.isConfirmed) {
                            Swal.fire("빅맥을 드릴게요 ^.^!");
                        } else {
                            Swal.fire("빅맥을 만들지 않았네요 ㅠㅠ")
                        }
                    })
                }}>확인,취소 Alert</Button>
            <br />
            <button type='button' className='btn btn-success'
                onClick={() => {
                    Swal.fire({
                        title: '사진 넣기',
                        html: `<h5>사진 넣으쉴?</h5>`,
                        imageUrl: img1,
                        imageWidth: 200,
                        imageHeight: 100,
                        showCancelButton: true,
                        confirmButtonText: "삭제",
                        cancelButtonText: "삭제 취소"
                    })
                }}>사진 넣기</button>
        </div>
    );
};

export default SweetApp;