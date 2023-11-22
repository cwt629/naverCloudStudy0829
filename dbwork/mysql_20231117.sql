create table memodb (
	num smallint auto_increment primary key,
	nickname varchar(30),
    photo varchar(100),
    memo varchar(1000),
    likes smallint default 0,
    writeday datetime);
    
create table photodb (
	num smallint auto_increment primary key,
    title varchar(30),
    photo varchar(200),
    photo80 varchar(200),
    photo150 varchar(200),
    writeday datetime
);

create table memberdb (
	num smallint auto_increment primary key,
    name varchar(20),
    pass varchar(20),
    photo varchar(100),
    hp varchar(30),
    email varchar(100),
    gaipday datetime
);

/* memberdb에 id 빠져서 이거 넣어줌 */
alter table memberdb add myid varchar(20);

create table boarddb (
	num smallint auto_increment primary key,
    writer varchar(20),
    myid varchar(20),
    subject varchar(1000),
    content varchar(2000),
    readcount smallint default 0,
    regroup smallint,
    restep smallint,
    relevel smallint,
    writeday datetime
);

create table board_file (
	idx smallint auto_increment primary key,
    num smallint,
    photoname varchar(100),
    constraint fk_board_num foreign key(num) references boarddb(num)
);