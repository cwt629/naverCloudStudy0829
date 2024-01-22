import React, { useCallback, useState } from 'react';
import Light from './Light';

const SweetHome = () => {
    const [masterOn, setMasterOn] = useState(false);
    const [kitchenOn, setKitchenOn] = useState(false);
    const [bathOn, setBathOn] = useState(false);

    // 각 room의 불을 키고 끄는 이벤트들
    // 이 부분이 기존 방식이지만, 매번 모든 요소들이 다시 렌더링됨
    // const toggleMaster = () => {
    //     setMasterOn(!masterOn);
    // }

    // const toggleKitchen = () => {
    //     setKitchenOn(!kitchenOn);
    // }

    // const toggleBath = () => {
    //     setBathOn(!bathOn);
    // }

    // 위 방식을 수정한 방식
    // useCallback을 적용하면 해당 변수가 바뀔 경우에, 그 부분만 렌더링 일어남
    const toggleMaster = useCallback(() => {
        setMasterOn(!masterOn);
    }, [masterOn]); // masterOn이 변경될 때만 호출

    const toggleKitchen = useCallback(() => {
        setKitchenOn(!kitchenOn);
    }, [kitchenOn]);

    const toggleBath = useCallback(() => {
        setBathOn(!bathOn);
    }, [bathOn]);

    return (
        <div>
            <Light room={'침실'} on={masterOn} toggle={toggleMaster} />
            <Light room={'주방'} on={kitchenOn} toggle={toggleKitchen} />
            <Light room={'욕실'} on={bathOn} toggle={toggleBath} />
        </div>
    );
};

export default SweetHome;