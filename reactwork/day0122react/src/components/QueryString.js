import React from 'react';
import { useLocation, useSearchParams } from 'react-router-dom';

function useQuery() {
    return new URLSearchParams(useLocation().search);
}

const QueryString = () => {
    // url의 쿼리스트링 값을 얻는 두가지 방법
    // 1번째 방법: useQuery 활용
    // useParams처럼 라우트에 등록하지 않아도 됨
    let query = useQuery();
    const color = query.get("color");
    const name = query.get("name");
    const addr = query.get("addr");

    // 2번째 방법: useSearchParams
    let [query2, setQuery2] = useSearchParams();
    const color2 = query2.get("color");
    const name2 = query2.get("name");
    const addr2 = query2.get("addr");

    return (
        <div>
            <h3 className='alert alert-primary'>Query String 읽기</h3>
            <div style={{ backgroundColor: color }}>
                이 름 : {name}<br />
                주 소 : {addr}<br />
                배경색 : {color}
            </div>
            <br />
            <div style={{ backgroundColor: color2 }}>
                이 름 : {name2}<br />
                주 소 : {addr2}<br />
                배경색 : {color2}
            </div>
        </div>
    );
};

export default QueryString;