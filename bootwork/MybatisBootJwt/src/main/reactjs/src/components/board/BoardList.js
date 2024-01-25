import axios from 'axios';
import React, { useEffect, useState } from 'react';
import { useNavigate, useParams } from 'react-router-dom';
import BoardRowItem from './BoardRowItem';
import { Link } from 'react-router-dom';

const BoardList = () => {
    const [data, setData] = useState(''); // 서버에서 보낸 리스트 및 페이지 출력에 필요한 모든 데이터들
    const [search, setSearch] = useState('');

    const navi = useNavigate();
    const { currentPage } = useParams();
    console.log({ currentPage }); // 값이 안 넘어올 경우는 null

    // 처음 시작 시에는 1페이지 목록을 가져온다
    const boardList = (switchPage = false) => {
        const url = "/board/list?currentPage=" + (currentPage == null || switchPage ? 1 : currentPage) + "&search=" + search;
        axios.get(url)
            .then(res => {
                setData(res.data);
            })
    }

    useEffect(() => {
        console.log("boardList useEffect!");
        boardList();
    }, [currentPage]); // 페이지 번호가 바뀔 때마다 다시 호출

    return (
        <div>
            <h4 className='alert alert-info'>게시판 목록
                {
                    sessionStorage.token
                    &&
                    <button type='button' className='btn btn-primary'
                        style={{ float: 'right' }}
                        onClick={() => navi("/board/form")}>글쓰기</button>
                }
            </h4>
            <div className='input-group'>
                <input type='text' className='form-control'
                    value={search} onChange={(e) => setSearch(e.target.value)}
                    placeholder='검색할 제목을 입력해주세요' />
                &nbsp;
                <button type='button' className='btn btn-success btn-sm'
                    onClick={() => {
                        boardList(true);

                        // 승민좌의 해결법(강사님도 이 방법 반영하심)
                        // const url = `/board/list?currentPage=1&search=${search}`;
                        // axios.get(url)
                        // .then(res => {
                        //     setData(res.data);
                        // })
                    }}>검색</button>
            </div>
            <table className='table table-bordered' style={{ width: '700px' }}>
                <thead>
                    <tr>
                        <th style={{ width: '60px', backgroundColor: '#ddd' }}>번호</th>
                        <th style={{ width: '350px', backgroundColor: '#ddd' }}>제목</th>
                        <th style={{ width: '100px', backgroundColor: '#ddd' }}>작성자</th>
                        <th style={{ width: '60px', backgroundColor: '#ddd' }}>조회</th>
                        <th style={{ width: '130px', backgroundColor: '#ddd' }}>작성일</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        data.list &&
                        data.list.map((row, idx) => (
                            <BoardRowItem key={idx} row={row} idx={idx} no={data.no} />
                        ))
                    }
                </tbody>
            </table>
            <div style={{ width: '700px', textAlign: 'center' }}>
                {/* 이전으로 이동 */}
                {
                    data.startPage > 1 ?
                        <Link to={`/board/list/${data.startPage - 1}`} className='pagenum'>
                            <b style={{ color: 'black' }}>이전</b>
                        </Link> : ''
                }
                {
                    data.parr &&
                    data.parr.map((n, i) =>
                        <Link to={`/board/list/${n}`} className='pagenum'>
                            <b style={{ color: n == currentPage ? 'red' : 'black' }}>
                                {n}
                            </b>
                        </Link>)
                }
                {/* 다음으로 이동 */}
                {
                    data.endPage < data.totalPage ?
                        <Link to={`/board/list/${data.endPage + 1}`} className='pagenum'>
                            <b style={{ color: 'black' }}>다음</b>
                        </Link> : ''
                }
            </div>
        </div>
    );
};

export default BoardList;