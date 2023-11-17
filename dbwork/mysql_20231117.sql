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