-- 2023.09.21 DB ����ȭ

-- DB ����ȭ(Normalization)
-- ����ȭ : �Ѹ���� DB ������ �޸𸮸� �������� �ʱ� ����,
--         � ���̺��� �ĺ��ڸ� ������ �������� ���̺�� ������ ����
-- ����ȭ�� �����ͺ��̽��� �ߺ��� �ּ�ȭ�ǵ��� ����� �����ͺ��̽��̴�.
--
-- ����: �޸� ����, ����ȭ�� �ý������� ���� ���� ����
-- ����: ��ȸ ������ �ſ� ���� �ý��ۿ����� ���̺� join ������ �ݺ� -> ���� ���� �ӵ� ��¦ �ʾ���

-- student�� num�� �ܺ�Ű�� ���� ���ο� ���̺� stuinfo �� ������
-- �ܺ�Ű(foreign key)�� ���̺� ���� �ÿ� �����ص� �ǰ�, ���߿� �����ص� �ȴ�.

create table stuinfo (
    idx number(5) constraint stuinfo_pk_idx primary key,
    num number(5),
    addr varchar2(20),
    hp varchar2(20)
);

-- student�� num�� �ܺ�Ű�� ����(ppt 29p)
-- ����: student�� num�� �ݵ�� primary key���� �Ѵ�.
-- (�ٸ� ���̺��� �ܺ�Ű�� ������ �� �÷��� primary key���� �Ѵ�)
alter table stuinfo add constraint stuinfo_fk_num foreign key(num) references student(num);

-- stuinfo�� ������ �߰��غ��� (���� ��ȣ�� 9������ insert �� � ������ ������ Ȯ�� �ʿ�
-- ���� �޼���: ���Ἲ ��������(ANGEL.STUINFO_FK_NUM)�� ����Ǿ����ϴ�- �θ� Ű�� �����ϴ�
-- student ���̺��� �θ����̺�: �ű⿡ num 9�� ��� ����
insert into stuinfo values (seq_stu.nextval, 9, '����� ������', '010-2323-4545');
-- ���� �踻���� �����ϰ�� �踻���� num�� 3�̹Ƿ� 3���� �߰��ؾ߸� �Ѵ�
insert into stuinfo values (seq_stu.nextval, 3, '����� ������', '010-2323-4545'); -- �̽±�
insert into stuinfo values (seq_stu.nextval, 6, '���ֵ�', '010-1234-1234'); -- ����
insert into stuinfo values (seq_stu.nextval, 8, '�λ�', '010-8989-7878'); -- ����

-- stuinfo �� ��ȸ
select * from stuinfo;

-- student �� ��ȸ
select * from student;

-- ���������� ��ϵ� �л��� ���ؼ� ��� ������ ����غ���(inner join, equi join)
select
    stu.name, stu.java, stu.spring, stu.ban, info.addr, info.hp
from student stu, stuinfo info
where stu.num = info.num;

-- �÷��� �տ� ������ ��� ���̺� �Ҽ����� �ٿ��µ�,
-- ���� �÷����� ���� ��� �ִ°� �ƴ϶�� �����ص� ��
select
    stu.num, name, java, spring, ban, addr, hp
from student stu, stuinfo info
where stu.num = info.num;

-- ���������� ��ϵǾ� ���� ���� �л����� ����غ��� (outer join)
-- sub table dp (+) : ��� �ȵ� �÷��� null������ ��� << ���⼭ sub table�� stuinfo��!
select
    stu.name, stu.java, stu.spring, stu.ban, info.addr, info.hp
from student stu, stuinfo info
where stu.num = info.num(+);

-- ���� ����� null�� �л��� ���
select
    stu.name, stu.java, stu.spring, stu.ban, info.addr, info.hp
from student stu, stuinfo info
where stu.num = info.num(+) and info.addr is null;

-- sub���̺�(stuinfo)�� ����� �����Ͱ� �ִµ� �θ����̺�(student)�� �ش� �����͸� �����ϰ��� �ϸ�?
-- error: ���Ἲ ��������(ANGEL.STUINFO_FK_NUM)�� ����Ǿ����ϴ�- �ڽ� ���ڵ尡 �߰ߵǾ����ϴ�
delete from student where num = 3; -- ����
delete from student where num = 7; -- stuinfo�� �����Ͱ� �����Ƿ� �� ������

-- �׷��� student�� 3�� �����͸� �������?
-- �ڽ� ���̺�(stuinfo)�� 3�� ������(num = 3) ���� ���� ��, student���� �����ϸ� �ȴ�.
delete from stuinfo where num = 3; -- �ڽ����̺� ���� ����
delete from student where num = 3; -- ���� �θ����̺� ����

-- �θ� ���̺� drop
-- error: �ܷ� Ű�� ���� �����Ǵ� ����/�⺻ Ű�� ���̺� �ֽ��ϴ�
drop table student;

-- �ڽ� ���̺��� ���� ��? -> ����
drop table stuinfo;

-------------------------------------------------------------------------------------------
-- 1) ��ǰ ������ ���� shop ���̺�
-- 2) ��ٱ��Ͽ� ���� cart ���̺�
-- �� �� ���̺��� ����µ�, ��ǰ���� ������ ���ؼ� shop�� num�� �ܺ�Ű�� ����
-- ��ǰ�� �����ϸ� ��ٱ����� �ش� �����Ͱ� �ڵ����� �����ǰ� �ϰ� �ʹٸ�?
-- on delete cascade �����غ���.

-- �������� ���� �ϳ� ������.
create sequence seq_shop start with 10 nocache;

-- shop table ����
create table shop (
    sang_no number(5) constraint shop_pk_no primary key,
    sang_name varchar2(100),
    sang_price number(7),
    sang_color varchar2(20)
);

-- �ܺ�Ű�� ����� cart ���̺� ���� 
-- shop�� ��ǰ�� ����� ��ٱ��� ����� �ڵ����� ����������, cascade�� �����ؼ� �����غ���
create table cart (
    cart_no number(5) constraint cart_pk_no primary key,
    sang_no number(5),
    cnt number(5),
    cartday date
);

alter table cart add constraint cart_fk_shopno foreign key(sang_no) references shop(sang_no) on delete cascade;
-- model (ERD) Ȯ���غ���

-- 5���� ��ǰ ����غ���
insert into shop values (seq_shop.nextval, '���콺', 23000, 'yellow');
insert into shop values (seq_shop.nextval, 'û����', 45000, 'black');
insert into shop values (seq_shop.nextval, '���̳�Ƽ', 11000, 'white');
insert into shop values (seq_shop.nextval, '���̳�Ƽ', 23000, 'red');
insert into shop values (seq_shop.nextval, 'üũ����', 130000, 'gray');
commit;

-- cart�� ���콺, ��� ���̳�Ƽ, üũ���� �� 3�� �߰��غ���(��¥�� ���� ��¥ - sysdate)
insert into cart values (seq_shop.nextval, 10, 1, sysdate);
insert into cart values (seq_shop.nextval, 12, 1, sysdate);
insert into cart values (seq_shop.nextval, 14, 1, sysdate);
commit;
-- ��ȸ(inner join)
-- ��ǰ��, ����, ����, ����, ������(yyyy-mm-dd hh24:mi)
select sang_name ��ǰ��, sang_price ����, sang_color ����, cnt ����, to_char(cartday, 'yyyy-mm-dd hh24:mi') ������
from shop, cart
where shop.sang_no = cart.sang_no;

-- �ƹ��� cart�� ���� ���� ��ǰ�� ��ȸ
-- ��ǰ��, ����, ���� ���
select sang_name ��ǰ��, sang_price ����, sang_color ����
from shop, cart
where shop.sang_no = cart.sang_no(+) and cart.sang_no is null;

-- cascade�� ���������Ƿ� cart�� ��� ��ǰ�� ������ �ȴ�(�� �� cart�� �ڵ����� ������
delete from shop where sang_no = 10;

-- �θ� ���̺� drop�� �ǳ�? -> �ȵ�.
drop table shop; -- error

-- ���̺� ���� �ÿ��� sub���̺��� ���� ���� �� �θ� ���̺� ����
drop table cart;
drop table shop;

-- �������� ��������
drop sequence seq_shop;

-----------------------------------------------------------------------------
-- ����
-- ������ : seq_food ����
-- ��������� �޴� ���̺� (���̺��: food)
-- �÷�: food_num ����(5) �⺻Ű, fname ���ڿ�(20)(�޴���), fprice ����(7)(����)
create sequence seq_food start with 1 nocache;
create table food (
    food_num number(5) constraint food_pk_num primary key,
    fname varchar2(20),
    fprice number(7)
);

-- sub���̺� : �� ���̺�(person)
-- �÷�: person_num ����(5) �⺻Ű, food_num �ܺ�Ű ����(cascade ����), 
-- person_name ���ڿ�(10)(����) , bookingday dateŸ�� (������)
create table person(
    person_num number(5) constraint person_pk_num primary key,
    food_num number(5),
    person_name varchar2(10),
    bookingday date
);
alter table person add constraint person_fk_foodno foreign key(food_num) references food(food_num) on delete cascade;

-- food�� 5���� �޴� �������(���İ�Ƽ, ������ ���)
insert into food values (seq_food.nextval, '���İ�Ƽ', 9000);
insert into food values (seq_food.nextval, '������', 6000);
insert into food values (seq_food.nextval, '�Ի����', 8500);
insert into food values (seq_food.nextval, '���󼧱�', 15000);
insert into food values (seq_food.nextval, '���ʺ�����', 12000);
commit;

-- �ֹ��� �������� �߰��غ���(���� �޴��� �������� �ֹ��ϱ⵵ �Ѵ�)
insert into person values (seq_food.nextval, 1, '�����', sysdate);
insert into person values (seq_food.nextval, 2, '��¯��', '2023-08-30');
insert into person values (seq_food.nextval, 3, '¡¡��', sysdate - 1);
insert into person values (seq_food.nextval, 1, '������', '2023-09-15');
insert into person values (seq_food.nextval, 4, '�����', sysdate);
insert into person values (seq_food.nextval, 3, '����', '2023-06-29');

-- ��ȸ : ��������ȣ, �ֹ��ڸ�, ���ĸ�, ����, ������ (���� �ѱ۷� �߰�)
select f.food_num �޴���ȣ, person_num �ֹ���ȣ, person_name �ֹ��ڸ�, fname ���ĸ�, fprice ����, 
    to_char(bookingday, 'yyyy-mm-dd') ������
from food f, person p
where f.food_num = p.food_num;

-- �޴� �� ���İ�Ƽ�� ���� ��, �ֹ��� ���̺����� ���������� Ȯ��
select * from person;
delete from food where fname = '���İ�Ƽ';

