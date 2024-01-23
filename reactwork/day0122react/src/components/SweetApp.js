import React, { useState } from 'react';

import img1 from '../image/dummy_tourphoto1.jpg'
import img2 from '../image/dummy_tourphoto2.jpg'
import img3 from '../image/dummy_tourphoto3.jpg'
import img4 from '../image/dummy_tourphoto4.jpg'
import img5 from '../image/dummy_tourphoto5.jpg'
import { Button } from '@mui/material';
import Swal from 'sweetalert2';

const SweetApp = () => {
    const [product, setProduct] = useState('체크자켓');

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
            <br />
            <button type='button' className='btn btn-info btn-sm'
                onClick={() => {
                    Swal.fire({
                        title: "Input Your Email",
                        input: "email",
                        inputLabel: "Your Email Address",
                        inputPlaceholder: "Enter your email address..."
                    }).then(result => {
                        Swal.fire(`당신의 이메일 주소는 [${result.value}]`);
                    })
                }}>이메일</button>
            <br />
            <button type='button' className='btn btn-success'
                onClick={() => {
                    Swal.fire({
                        icon: "question",
                        title: "상품 삭제",
                        text: `${product} 상품을 삭제하시겠습니까?`,
                        showCancelButton: true,
                        confirmButtonText: "삭제",
                        cancelButtonText: "취소"
                    }).then(result => {
                        if (result.isConfirmed) {
                            Swal.fire({
                                icon: "success",
                                title: `${product} 상품이 삭제되었습니다.`
                            })
                        } else {
                            Swal.fire({
                                icon: "error",
                                title: `${product} 상품 삭제를 취소했습니다.`
                            })
                        }
                    })
                }}>상품 삭제</button>
            <br />
            <button type='button' className='btn btn-warning'
                onClick={() => {
                    let arr = [
                        { photo: img1, msg: "드라이아이스 스카이" },
                        { photo: img2, msg: "카트라이더도 가능할 것 같은 산책길" },
                        { photo: img3, msg: "저녁놀 지는 멋진 항구" },
                        { photo: img4, msg: "새해복 많이 받을 것 같은 산 정상" },
                        { photo: img5, msg: "시원한 바다빛으로 물든 등대" }
                    ]

                    let s = "";
                    for (let m of arr) {
                        s +=
                            `<img alt='' src=${m.photo} width=160/>&nbsp;&nbsp;<b>${m.msg}</b><br/>`;
                    }

                    Swal.fire({
                        icon: "info",
                        title: "여행지 목록",
                        html: s
                    });
                }}>배열 출력</button>
        </div>
    );
};

export default SweetApp;