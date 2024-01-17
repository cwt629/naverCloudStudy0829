import * as React from 'react';
import { styled } from '@mui/material/styles';
import Card from '@mui/material/Card';
import CardHeader from '@mui/material/CardHeader';
import CardMedia from '@mui/material/CardMedia';
import CardContent from '@mui/material/CardContent';
import CardActions from '@mui/material/CardActions';
import Collapse from '@mui/material/Collapse';
import Avatar from '@mui/material/Avatar';
import IconButton, { IconButtonProps } from '@mui/material/IconButton';
import Typography from '@mui/material/Typography';
import { red } from '@mui/material/colors';
import FavoriteIcon from '@mui/icons-material/Favorite';
import ShareIcon from '@mui/icons-material/Share';
import ExpandMoreIcon from '@mui/icons-material/ExpandMore';
import MoreVertIcon from '@mui/icons-material/MoreVert';


const ExpandMore = styled((props) => {
    const { expand, ...other } = props;
    return <IconButton {...other} />;
})(({ theme, expand }) => ({
    transform: !expand ? 'rotate(0deg)' : 'rotate(180deg)',
    marginLeft: 'auto',
    transition: theme.transitions.create('transform', {
        duration: theme.transitions.duration.shortest,
    }),
}));

export default function ThreeCardApp({ item }) {
    const [expanded, setExpanded] = React.useState(false);
    const [heartColor, setHeartColor] = React.useState('gray');

    const handleExpandClick = () => {
        setExpanded(!expanded);
    };

    const handleHeartClick = () => {
        setHeartColor((heartColor === 'gray') ? 'hotpink' : 'gray');
    }

    return (
        <Card sx={{ maxWidth: 345 }}>
            <CardHeader
                avatar={
                    <Avatar sx={{ bgcolor: red[500] }} aria-label="recipe">
                        Bit
                    </Avatar>
                }
                action={
                    <IconButton aria-label="settings">
                        <MoreVertIcon />
                    </IconButton>
                }
                title={item.name}
                subheader={item.writeday}
            />
            <CardMedia
                component="img"
                height="400"
                image={require(`../images/${item.photo}`)}
                alt={item.name}
            />
            <CardContent>
                <Typography variant="body2" color="text.secondary">
                    <div style={{ color: '#222', fontSize: '30px' }}>이름 : {item.name}</div>
                    <div style={{ color: '#888', fontSize: '20px' }}>나이 : {item.age}세</div>
                </Typography>
            </CardContent>
            <CardActions disableSpacing>
                <IconButton aria-label="add to favorites" style={{ color: heartColor }}
                    onClick={handleHeartClick}>
                    <FavoriteIcon />
                </IconButton>
                <IconButton aria-label="share">
                    <ShareIcon />
                </IconButton>
                <ExpandMore
                    expand={expanded}
                    onClick={handleExpandClick}
                    aria-expanded={expanded}
                    aria-label="show more"
                >
                    <ExpandMoreIcon />
                </ExpandMore>
            </CardActions>
            <Collapse in={expanded} timeout="auto" unmountOnExit>
                <CardContent>
                    <Typography paragraph><b>회원 정보</b></Typography>
                    <Typography paragraph>
                        <div>혈액형 : {item.blood}형</div>
                    </Typography>
                </CardContent>
            </Collapse>
        </Card>
    );
}
