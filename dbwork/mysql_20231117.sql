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
    constraint fk_board_num foreign key(num) references boarddb(num) on delete cascade
);

drop table board_file;

select ifnull(max(num), 0) as num from boarddb;

select * from memberdb order by num desc;
/* 0번 인덱스부터 3개(여기서의 경우 정렬된 순서 기준) */
select * from memberdb order by num desc limit 2,3;

create table board_answer (
	ansidx smallint auto_increment primary key,
    ansname varchar(20),
    ansid varchar(20),
    ansphoto varchar(100),
    ansmsg varchar(1000),
    writeday datetime,
    num smallint,
    constraint fk_answer_num foreign key(num) references boarddb(num) on delete cascade
);