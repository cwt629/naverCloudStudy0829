import React, { useReducer, useState } from 'react';
import Student from './Student';

/*
useReducer: state 관리가 용이하며, 유지 및 보수가 편함

호출: dispatch(type, action)-->reducer(state, action)

기능
reducer: state를 업데이트하는 역할(은행)
dispatch - state 업데이트를 요구
action - 요구의 내용
*/

// reducer 설정 시 초기값으로 미리 지정
const initialState = {
    count: 2,
    students: [
        {
            id: new Date(),
            name: '장원태',
            isHere: false
        },
        {
            id: new Date(),
            name: '이승민',
            isHere: true
        }
    ]
}

const reducer = (state, action) => {
    switch (action.type) {
        case 'add-student':
            // payload를 통해서 name을 전달받을 것
            const name = action.payload.name;
            // 추가할 학생 정보 구성
            const studentToAdd = {
                id: new Date(), // 초값으로 들어가며, 매번 다르게 들어갈 거임
                //name: name,
                name, // 같은 이름이므로 생략 가능
                isHere: false
            }

            const data = {
                count: state.count + 1,
                students: [
                    ...state.students,
                    studentToAdd
                ]
            }
            return data;

        case 'delete-student':
            return {
                count: state.count - 1,
                students: state.students.filter((s) => (s.id !== action.payload.id))
            };

        case 'mark-student':
            return {
                count: state.count,
                students: state.students.map((s) => {
                    if (s.id === action.payload.id) {
                        return {
                            ...s,
                            isHere: !s.isHere
                        }
                    }
                    return s;
                })
            };

        default:
            return state;
    }
}

const ReducerTest2 = () => {
    const [name, setName] = useState('');
    const [studentInfo, dispatch] = useReducer(reducer, initialState);

    return (
        <div>
            <h5 className='alert alert-secondary'>Reducer 예제 #2</h5>
            <h4 style={{ color: 'blue' }}><b>Reducer Student Management System</b></h4>
            <h6>총 학생 수 : {studentInfo.count}</h6>
            <div className='input-group' style={{ width: '200px' }}>
                <input type='text' className='form-control'
                    value={name} onChange={(e) => setName(e.target.value)} />
                &nbsp;&nbsp;
                <button type="button"
                    className='btn btn-outline-success btn-sm'
                    onClick={() => dispatch({ type: 'add-student', payload: { name } })}>추가</button>
                <hr />
                {
                    studentInfo.students.map((stu, idx) => <Student key={idx} stu={stu} dispatch={dispatch} />)
                }
            </div>
        </div>
    );
};

export default ReducerTest2;