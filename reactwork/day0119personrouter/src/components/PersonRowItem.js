import { Button } from '@mui/material';
import React from 'react';
import { useNavigate } from 'react-router-dom';

const PersonRowItem = (props) => {
    const { idx, row, onDelete } = props;

    const nav = useNavigate();

    return (
        <tr>
            <td align='center'>{idx + 1}</td>
            <td>
                <div style={{ cursor: 'pointer' }}
                    onClick={() => nav(`/detail/${row.pnum}`)}>
                    {
                        row.photo &&
                        <img alt='' src={require(`../images/` + row.photo)}
                            style={{ width: '30px', height: '30px', border: '1px solid gray' }} />
                    }

                    <b style={{ marginLeft: '10px' }}>{row.name}</b>
                </div>
            </td>
            <td align='center'>
                <Button color='error' variant='outlined'
                    onClick={() => {
                        onDelete(row.pnum);
                    }}>Delete</Button>
            </td>
        </tr>
    );
};

export default PersonRowItem;