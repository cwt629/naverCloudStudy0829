import axios from 'axios';
import React, { useEffect, useState } from 'react';
import MemberCard from './MemberCard';

const MemberList = () => {
    // 멤버 정보들을 저장할 배열
    const [list, setList] = useState([]);
    const [count, setCount] = useState(0);

    const init = () => {
        axios.get("/member/list")
            .then(res => {
                setList(res.data.mlist);
                setCount(res.data.totalCount);
            })
    }

    useEffect(() => {
        init();
    }, []);

    // 삭제 이벤트
    const deleteMember = (num) => {
        const DELETE_URL = "/member/delete?num=" + num;
        if (!window.confirm("정말로 해당 멤버를 삭제하시겠습니까?")) return;

        axios.delete(DELETE_URL)
            .then(res => {
                // 삭제 성공 후 목록 재출력
                init();
            })
    }

    return (
        <div>
            <h4 className='alert alert-danger'>회원 목록(총 {list.length}명)</h4>
            {
                list &&
                list.map((member, idx) => (
                    <MemberCard key={idx} info={member} deleteMember={deleteMember} />
                ))
            }
        </div>
    );
};

export default MemberList;