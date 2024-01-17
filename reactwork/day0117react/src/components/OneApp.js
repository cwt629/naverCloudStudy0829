import React, { useEffect, useState } from 'react';
import { Alert } from '@mui/material';
import PersonForm from './PersonForm';
import axios from 'axios'; // axios 가져오기
import PersonRowItem from './PersonRowItem';

const OneApp = () => {
    const [personList, setPersonList] = useState([]);

    // 저장 이벤트
    const personInsert = (data) => {
        console.log(data);

        // 스프링부트 서버로 데이터 보내서 DB 저장
        //axios.post("localhost:9091/person/add") // proxy 없을때 주는 방식
        axios.post("/person/add", data)
            .then((res) => {
                // 추가 성공 후 목록 다시 출력
                list();
            }).catch(error => {
                console.log("추가 과정에서 에러가 발생했습니다. : " + error);
            })
    }

    const list = () => {
        // 백엔드로부터 데이터를 가져와 배열 변수에 넣기
        axios.get("/person/list")
            .then(res => {
                setPersonList(res.data);
            })
    }

    const deletePerson = (num) => {
        let url = "/person/delete?pnum=" + num;
        axios.delete(url)
            .then(res => {
                // 삭제 성공 후, 목록 다시 출력
                alert("삭제가 완료되었습니다.");
                list();
            })
    }

    useEffect(() => {
        console.log("ㅋㅋ");
        list(); // 처음 시작 시 무조건 호출
    }, []); // 처음 시작 시 한번만 호출

    return (
        <div>
            <Alert variant='filled' severity='success'>
                <h3>OneApp - person DB 추가/목록</h3>
            </Alert>
            <PersonForm onSave={personInsert} />
            <hr />
            <h5>총 {personList.length}명의 회원이 등록되어 있습니다.</h5>
            <table className='table table-bordered' style={{ width: '500px' }}>
                <tbody>
                    {
                        personList.map((rowData, idx) =>
                            <PersonRowItem key={idx} row={rowData} idx={idx}
                                onDelete={deletePerson} />
                        )
                    }
                </tbody>
            </table>
        </div>
    );
};

export default OneApp;