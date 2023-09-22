-- 2023-09-22 프로시져

/*
프로시져(procedure)
:프로시져는 특정 작업을 수행하는 일종의 서브 프로그램으로
데이타베이스에 저장되는 객체이다
반복되는 코드같은 경우 프로시져에 저장해두었다가 호출해서
실행만 하면 되므로 재사용성이 높다
 
create : 새로 생성 (기존 프로시져가 있다면 오류 발생)
create or replace : 새로 생성하되, 기존 프로시져가 있다면 덮어씀

형식
 
create [or replace] procedure 프로시져명
   [파라미터 모드 데이터타입,....]
is
       	변수 선언
begin
            	코드;
end;
/
 
호출:   exec 프로시져명
        exec 프로시져명(값..)

*/

-- 예제 1

-- 초간단 프로시져 생성해보기
create or replace procedure mytest
is
begin
    dbms_output.put_line('첫 프로시져를 만들었어요!');
end;
/

-- mytest 프로시져 호출
exec mytest;



-- 예제 2 : 숫자를 인자로 보내면 구구단 출력
create or replace procedure gugu(dan number)
is
begin
    if dan < 2 or dan > 9 then
        dbms_output.put_line('잘못된 숫자입니다. 2~9 사이값 요구!');
    else
        dbms_output.put_line(' **'||dan||'단 **');
        for a in 1..9 loop
            dbms_output.put_line(dan||' x '||a||' = '||dan*a);
        end loop;
    end if;
end;
/

-- 실행
exec gugu(11);
exec gugu(5);

-- shop에 데이터 좀 추가하기(연습용으로 쓰게...)
insert into shop values (seq_shop.nextval, '레이스블라우스', 23000, 'white');

-- shop의 sang_color의 타입 길이를 변경하려면?
alter table shop modify sang_color varchar2(30);
insert into shop values (seq_shop.nextval, '레이스조끼', 19000, 'red');
insert into shop values (seq_shop.nextval, '체크조끼', 39000, 'rainbow');
insert into shop values (seq_shop.nextval, '칠부청바지', 56000, 'blue');
commit;



-- 예제 3: 상품명을 인자로 보내면, 그 단어가 포함된 모든 상품들 출력하기
create or replace procedure sangpum(sang varchar2)
is
    v_cnt number(2);
    Cursor s1
    is
    select * from shop where sang_name like '%'||sang||'%';
begin
    select count(*) into v_cnt from shop where sang_name like '%'||sang||'%';
    if v_cnt > 0 then
        dbms_output.put_line(sang||'상품 조회하기');
        dbms_output.put_line('총 '||v_cnt||'개 조회');
        dbms_output.put_line('상품번호  상품명  가격  색상');
        dbms_output.put_line('-----------------------------');
        for s in s1 loop
            dbms_output.put_line(s.sang_no||'  '||s.sang_name||'  '||
                s.sang_price||'  '||s.sang_color);
            exit when s1%notfound;
        end loop;
    else
        dbms_output.put_line(sang||'상품은 리스트에 없습니다.');
    end if;
end;
/

-- 실행
exec sangpum('조끼');
exec sangpum('청바지');
exec sangpum('한복');



-- 예제 4
/*
    exec addupdate('레이스조끼', 45000, 'black');
    상품명 중복이 없다고 가정한다.
    - 해당 상품(레이스조끼)이 없으면 추가
    - 해당 상품(레이스조끼)이 있으면 가격과 색상 수정
*/

create or replace procedure addupdate(sang varchar2, price number, color varchar2)
is
    v_cnt number(2);
begin
    select count(*) into v_cnt from shop where sang_name = sang;
    -- 상품이 없는 경우: 추가
    if v_cnt = 0 then
        insert into shop values (seq_shop.nextval, sang, price, color);
        dbms_output.put_line(color||' 색상의 '||sang||' 상품을 목록에 추가했습니다. (가격: '||price||'원)');
    -- 상품이 있는 경우: 색상 수정
    else
        update shop set sang_price = price, sang_color = color where sang_name = sang;
        dbms_output.put_line(sang||' 상품 정보를 갱신했습니다. (색상: '||color||', 가격: '||price||'원)');
    end if;
    
end;
/

exec addupdate('조끼', 56000, 'white');
exec addupdate('양복정장', 150000, 'blue');
