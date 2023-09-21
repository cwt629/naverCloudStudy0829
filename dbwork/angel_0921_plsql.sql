-- PL-SQL�̶�?
-- SQL �� ������ ��� ��Ҹ� �߰��ؼ� ���α׷����� ���� PL_SQL�̶�� �Ѵ�.

-- ���� 1
declare
    -- ���� �����ϴ� ����
    v_no number(4,1); -- 4�ڸ��� �Ҽ������� 1�ڸ� ���� �ִ� ���� ����
begin
    -- SQL �����̳� PL-SQL������ �ڵ��ϴ� ���� (:= ���� / = ��)
    v_no := 12.7; -- ���� ������
    dbms_output.put_line(v_no); -- ���
end;
/
-- ���� ���: slash �ϰ� Ctrl + Enter


-- ���� 2
declare
    vname varchar2(20);
    vban varchar2(20);
begin
    select
        name, ban
        into vname, vban -- �� ������ �� ������ �־��ش�
    from student where num = 6; -- ������ 1������ ������ �ȳ���!
    dbms_output.put_line(vname||'���� '||vban||'�Դϴ�');
end;
/

-- ���� 3
-- �ֹ���: ��ȣ��
-- �޴���: ������
-- ����: 2000��
-- person�� food ���̺��� �����Ͽ� person_num�� 10�� ����� �̸�, �ֹ��޴�, ���� ����ϱ�
declare
    vordered varchar2(10);
    vmenu varchar2(20);
    vprice number(7);
begin
    select
        person_name, fname, fprice
        into vordered, vmenu, vprice
    from food f, person p
    where f.food_num = p.food_num
    and person_num = 10;
    dbms_output.put_line('�ֹ���: '||vordered);
    dbms_output.put_line('�޴���: '||vmenu);
    dbms_output.put_line('��  ��: '||vprice||'��');
end;
/



-- ���� 4
-- ��ǰ���� ������ ������ ��, �ش� ��ǰ���� ���ݰ� ������ ���(�ߺ��Ǵ� �������� ����)
declare
    vsangpum varchar2(20) := 'û����';
    vcolor varchar2(20);
    vprice number(7);
    vprice2 varchar2(20);
begin
    select sang_price, sang_color, ltrim(to_char(sang_price, 'L999,999')) -- ��45,000 ǥ���ε�, ���ʿ� ������ �����Ƿ� ltrim���� ������
    into vprice, vcolor, vprice2
    from shop
    where sang_name = vsangpum;
    
    dbms_output.put_line('��ǰ��: '||vsangpum);
    dbms_output.put_line('��  ��: '||vcolor);
    dbms_output.put_line('��  ��: '||vprice);
    dbms_output.put_line('��  ��: '||vprice2);
end;
/

/* 
[����if��]
if ���ǽ� then
    ����1;
else
    ����2;
end if;

[����if��]
if ���ǽ�1 then
    ����1;
elsif ����2 then
    ����2;
    ...
end if;
*/



-- ���� 5
-- �⵵�� �´� �� ���ϱ�

-- Ű����� �⵵�� �Է¹ް��� �� ���
accept year prompt '�¾ �⵵�� �Է��ϼ���';
declare
    --v_year number(4) := 1996;
    v_year number(4) := '&year'; -- �Է��� ���� ����
    v_mod number(2) := mod(v_year, 12); -- �⵵�� 12�� ���� �������� ���Ѵ�
    v_ddi varchar2(10); -- �츦 ������ ����
begin
    if v_mod = 0 then v_ddi := '������';
    elsif v_mod = 1 then v_ddi := '��';
    elsif v_mod = 2 then v_ddi := '��';
    elsif v_mod = 3 then v_ddi := '����';
    elsif v_mod = 4 then v_ddi := '��';
    elsif v_mod = 5 then v_ddi := '��';
    elsif v_mod = 6 then v_ddi := 'ȣ����';
    elsif v_mod = 7 then v_ddi := '�䳢';
    elsif v_mod = 8 then v_ddi := '��';
    elsif v_mod = 9 then v_ddi := '��';
    elsif v_mod = 10 then v_ddi := '��';
    elsif v_mod = 11 then v_ddi := '��';
    end if;
    
    dbms_output.put_line(v_year||'����� '||v_ddi||'���Դϴ�');
end;
/



-- ���� 6
-- db �÷��� Ÿ���� �������� ��� : TYPE
accept iname prompt 'name?';
declare
    v_name student.name%TYPE := '&iname';
    v_height student.height%TYPE;
    v_java student.java%TYPE;
    v_spring student.spring%TYPE;
begin
    select height, java, spring
    into v_height, v_java, v_spring
    from student where name = v_name;
    
    dbms_output.put_line('�л���: '||v_name);
    dbms_output.put_line('Ű: '||v_height);
    dbms_output.put_line('�ڹ�����: '||v_java);
    dbms_output.put_line('����������: '||v_spring);
    dbms_output.put_line('����: '||(v_java + v_spring));
end;
/

/* 
  �ݺ��� : loop
  loop
    �����;
    exit when ����;
  end loop;
*/

-- ���� 7
-- 1���� 10���� �ݺ��� ����ϱ�
declare
    v_no number(2) := 0;
begin
    loop
        v_no := v_no + 1;
        dbms_output.put_line('no = '||v_no);
        exit when v_no = 10; -- 10�� ��� �ݺ����� ����������
    end loop;
end;
/

-- ���� 8: ���� �Է��ϸ�, �ش� ���� ����Ͻÿ�.
accept dan prompt '����?';
declare
    v_dan number(2) := '&dan';
    v_inc number(2) := 1;
    v_result number(3);
begin
    dbms_output.put_line('** '||v_dan||'�� **');
    loop
        v_result := v_dan * v_inc;
        dbms_output.put_line(v_dan||' * '||v_inc||' = '||v_result);
        v_inc := v_inc + 1;
        exit when v_inc = 10;
    end loop;
    
end;
/


-- ���� 9 - Exception ó��(���� 4 ������)
-- ��ǰ���� ������ ������ ��, �ش� ��ǰ���� ���ݰ� ������ ���(�ߺ��Ǵ� �������� ����)
accept sangpum prompt '��ǰ��?';
declare
    vsangpum varchar2(20) := '&sangpum';
    vcolor varchar2(20);
    vprice number(7);
    vprice2 varchar2(20);
begin
    select sang_price, sang_color, ltrim(to_char(sang_price, 'L999,999')) -- ��45,000 ǥ���ε�, ���ʿ� ������ �����Ƿ� ltrim���� ������
    into vprice, vcolor, vprice2
    from shop
    where sang_name = vsangpum;
    
    dbms_output.put_line('��ǰ��: '||vsangpum);
    dbms_output.put_line('��  ��: '||vcolor);
    dbms_output.put_line('��  ��: '||vprice);
    dbms_output.put_line('��  ��: '||vprice2);
    
    -- ����� 2�� �̻��̰ų� ������ ���� �߻�
    -- Oracle���� ����ó���ϴ� ���
    exception
        when NO_DATA_FOUND then
            dbms_output.put_line(vsangpum||' ��ǰ�� DB�� �����ϴ�');
        when TOO_MANY_ROWS then
            dbms_output.put_line(vsangpum||' ��ǰ�� DB�� �� �� �̻� �����մϴ�');
        when OTHERS then
            dbms_output.put_line(vsangpum||' ��ǰ�� ���� ���� �߻�...���� �𸧤�');
end;
/


/*
    �ݺ���
    for ���� in [reverse]���۰�..������ loop
        �����;
    end loop;
*/

-- ���� 10 : ���� 8 ������ ���� �� for������ �����ϱ�
accept dan prompt '����?';
declare
    v_dan number(2) := '&dan';
    v_inc number(2);
    v_result number(3);
begin
    dbms_output.put_line('** '||v_dan||'�� **');
    
    for v_inc in 1..9 loop
        v_result := v_dan * v_inc;
        dbms_output.put_line(v_dan||' * '||v_inc||' = '||v_result);
    end loop;
end;
/

-- ���� 11:
-- ���ڵ� ������ ������ ��������
declare
    v_num student.num%TYPE := 6;
    v_stu angel.student%rowtype; -- ���ڵ� ������ �о�� ���
begin
    select * into v_stu
    from student where num = v_num;
    
    dbms_output.put_line('�̸�: '||v_stu.name);
    dbms_output.put_line('Ű: '||v_stu.height);
    dbms_output.put_line('�ڹ�: '||v_stu.java);
    dbms_output.put_line('������: '||v_stu.spring);
    dbms_output.put_line('��: '||v_stu.ban);
end;
/

-- DB�� ���� �����͸� ��ȸ�� ���
/*
    Cursor : sql���� ������ ������ ����� �м��ǰ� ����Ǿ� ����� �����ϱ� ����
    Ư���� �޸� ������ ����ϴµ�, �� ������ �����ϴ� ���� Ŀ���̴�.
    
    select������ ���� ������ ��ȸ �� ����ϴ� ��ü�̴�.
    
    Ŀ�� �Ӽ�
    sql%rowcount : ����� ���� ��ȯ
    sql%found : ���� �ֱ��� sql���� �ϳ� �̻��� �࿡ ������ �� ��� true
    sql%notfound : ������� ���� ���
    sql%isopen : �׻� false(�׻� close�� �ϹǷ� �׻� false)
*/

-- ���� 12
declare
    v_sno number(3) := 10;
    v_shop angel.shop%rowtype;
begin
    select * into v_shop
    from shop where sang_no = v_sno;
    
    dbms_output.put_line('��ǰ��: '||v_shop.sang_name);
    dbms_output.put_line('��ȸ�� ���� ����: '||sql%rowcount); -- 1
    
    -- student�� java ���� �����ϱ�
    update student set java = 99;
    dbms_output.put_line('������ ���� ����: '||sql%rowcount);
end;
/



-- ���� ���ڵ� ��ȸ
-- ���� 13
declare
    Cursor s1
    is
    select * from shop;
begin
    dbms_output.put_line('��ǰ��ȣ  ��ǰ��  ����  ����');
    dbms_output.put_line('-------------------------');
    
    for s in s1 loop
        exit when s1%notfound; -- �� �̻� �����Ͱ� ������ ����������
        dbms_output.put_line(s.sang_no||'  '||s.sang_name||'  '||
            s.sang_color||'  '||s.sang_price);
    end loop;
end;
/

-- ���� 14
-- ��ǰ��, ����, ������ �Է��ϸ� shop db�� �߰��ϱ�
accept isang prompt 'sangpum?';
accept icolor prompt 'color?';
accept iprice prompt 'price?';
declare
    v_sang shop.sang_name%TYPE := '&isang';
    v_color shop.sang_color%TYPE := '&icolor';
    v_price shop.sang_price%TYPE := '&iprice';
begin
    insert into shop values (seq_shop.nextval, v_sang, v_price, v_color);
    commit;
    dbms_output.put_line('��ǰ ������ �߰��߽��ϴ�.');
end;
/



-- ����: food ���̺�
/*
    fname, fprice, no �Է��� �޾Ƽ�
    no�� 1�̸� fname, fprice�� ������ �߰��� �ϰ�
    no�� 2�̸� food�� ��ü ������ ���
*/
accept iname prompt 'name?';
accept iprice prompt 'price?';
accept ino prompt 'number?';
declare
    v_name food.fname%TYPE := '&iname';
    v_price food.fprice%TYPE := '&iprice';
    v_no number(1) := '&ino';
    Cursor datashower
    is
    select * from food;
begin
    if v_no = 1 then
        -- ������ �߰�
        insert into food values (seq_food.nextval, v_name, v_price);
        commit;
        dbms_output.put_line('���� ������ �߰��߽��ϴ�.');
        
    elsif v_no = 2 then
        -- ������ ���
        dbms_output.put_line('���Ĺ�ȣ  ���ĸ�  ����');
        dbms_output.put_line('--------------------');
    
        for s in datashower loop
            exit when datashower%notfound; -- �� �̻� �����Ͱ� ������ ����������
            dbms_output.put_line(s.food_num||'  '||s.fname||'  '||s.fprice);
        end loop;
    end if;

end;
/