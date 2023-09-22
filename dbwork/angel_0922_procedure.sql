-- 2023-09-22 ���ν���

/*
���ν���(procedure)
:���ν����� Ư�� �۾��� �����ϴ� ������ ���� ���α׷�����
����Ÿ���̽��� ����Ǵ� ��ü�̴�
�ݺ��Ǵ� �ڵ尰�� ��� ���ν����� �����صξ��ٰ� ȣ���ؼ�
���ุ �ϸ� �ǹǷ� ���뼺�� ����
 
create : ���� ���� (���� ���ν����� �ִٸ� ���� �߻�)
create or replace : ���� �����ϵ�, ���� ���ν����� �ִٸ� ���

����
 
create [or replace] procedure ���ν�����
   [�Ķ���� ��� ������Ÿ��,....]
is
       	���� ����
begin
            	�ڵ�;
end;
/
 
ȣ��:   exec ���ν�����
        exec ���ν�����(��..)

*/

-- ���� 1

-- �ʰ��� ���ν��� �����غ���
create or replace procedure mytest
is
begin
    dbms_output.put_line('ù ���ν����� ��������!');
end;
/

-- mytest ���ν��� ȣ��
exec mytest;



-- ���� 2 : ���ڸ� ���ڷ� ������ ������ ���
create or replace procedure gugu(dan number)
is
begin
    if dan < 2 or dan > 9 then
        dbms_output.put_line('�߸��� �����Դϴ�. 2~9 ���̰� �䱸!');
    else
        dbms_output.put_line(' **'||dan||'�� **');
        for a in 1..9 loop
            dbms_output.put_line(dan||' x '||a||' = '||dan*a);
        end loop;
    end if;
end;
/

-- ����
exec gugu(11);
exec gugu(5);

-- shop�� ������ �� �߰��ϱ�(���������� ����...)
insert into shop values (seq_shop.nextval, '���̽����콺', 23000, 'white');

-- shop�� sang_color�� Ÿ�� ���̸� �����Ϸ���?
alter table shop modify sang_color varchar2(30);
insert into shop values (seq_shop.nextval, '���̽�����', 19000, 'red');
insert into shop values (seq_shop.nextval, 'üũ����', 39000, 'rainbow');
insert into shop values (seq_shop.nextval, 'ĥ��û����', 56000, 'blue');
commit;



-- ���� 3: ��ǰ���� ���ڷ� ������, �� �ܾ ���Ե� ��� ��ǰ�� ����ϱ�
create or replace procedure sangpum(sang varchar2)
is
    v_cnt number(2);
    Cursor s1
    is
    select * from shop where sang_name like '%'||sang||'%';
begin
    select count(*) into v_cnt from shop where sang_name like '%'||sang||'%';
    if v_cnt > 0 then
        dbms_output.put_line(sang||'��ǰ ��ȸ�ϱ�');
        dbms_output.put_line('�� '||v_cnt||'�� ��ȸ');
        dbms_output.put_line('��ǰ��ȣ  ��ǰ��  ����  ����');
        dbms_output.put_line('-----------------------------');
        for s in s1 loop
            dbms_output.put_line(s.sang_no||'  '||s.sang_name||'  '||
                s.sang_price||'  '||s.sang_color);
            exit when s1%notfound;
        end loop;
    else
        dbms_output.put_line(sang||'��ǰ�� ����Ʈ�� �����ϴ�.');
    end if;
end;
/

-- ����
exec sangpum('����');
exec sangpum('û����');
exec sangpum('�Ѻ�');



-- ���� 4
/*
    exec addupdate('���̽�����', 45000, 'black');
    ��ǰ�� �ߺ��� ���ٰ� �����Ѵ�.
    - �ش� ��ǰ(���̽�����)�� ������ �߰�
    - �ش� ��ǰ(���̽�����)�� ������ ���ݰ� ���� ����
*/

create or replace procedure addupdate(sang varchar2, price number, color varchar2)
is
    v_cnt number(2);
begin
    select count(*) into v_cnt from shop where sang_name = sang;
    -- ��ǰ�� ���� ���: �߰�
    if v_cnt = 0 then
        insert into shop values (seq_shop.nextval, sang, price, color);
        dbms_output.put_line(color||' ������ '||sang||' ��ǰ�� ��Ͽ� �߰��߽��ϴ�. (����: '||price||'��)');
    -- ��ǰ�� �ִ� ���: ���� ����
    else
        update shop set sang_price = price, sang_color = color where sang_name = sang;
        dbms_output.put_line(sang||' ��ǰ ������ �����߽��ϴ�. (����: '||color||', ����: '||price||'��)');
    end if;
    
end;
/

exec addupdate('����', 56000, 'white');
exec addupdate('�纹����', 150000, 'blue');
