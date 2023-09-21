-- PL-SQL이란?
-- SQL 언어에 절차적 언어 요소를 추가해서 프로그래밍한 것을 PL_SQL이라고 한다.

-- 예제 1
declare
    -- 변수 선언하는 영역
    v_no number(4,1); -- 4자리에 소수점이하 1자리 값을 넣는 변수 선언
begin
    -- SQL 구문이나 PL-SQL문으로 코딩하는 영역 (:= 대입 / = 비교)
    v_no := 12.7; -- 대입 연산자
    dbms_output.put_line(v_no); -- 출력
end;
/
-- 실행 방법: slash 하고 Ctrl + Enter


-- 예제 2
declare
    vname varchar2(20);
    vban varchar2(20);
begin
    select
        name, ban
        into vname, vban -- 각 정보를 각 변수로 넣어준다
    from student where num = 6; -- 데이터 1개여야 오류가 안난다!
    dbms_output.put_line(vname||'님은 '||vban||'입니다');
end;
/

-- 예제 3
-- 주문자: 강호동
-- 메뉴명: 떡볶이
-- 가격: 2000원
-- person과 food 테이블을 조인하여 person_num이 10인 사람의 이름, 주문메뉴, 가격 출력하기
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
    dbms_output.put_line('주문자: '||vordered);
    dbms_output.put_line('메뉴명: '||vmenu);
    dbms_output.put_line('가  격: '||vprice||'원');
end;
/



-- 예제 4
-- 상품명을 변수에 지정한 후, 해당 상품명의 가격과 색상을 출력(중복되는 아이템은 제외)
declare
    vsangpum varchar2(20) := '청바지';
    vcolor varchar2(20);
    vprice number(7);
    vprice2 varchar2(20);
begin
    select sang_price, sang_color, ltrim(to_char(sang_price, 'L999,999')) -- 원45,000 표시인데, 왼쪽에 공백이 많으므로 ltrim으로 지워줌
    into vprice, vcolor, vprice2
    from shop
    where sang_name = vsangpum;
    
    dbms_output.put_line('상품명: '||vsangpum);
    dbms_output.put_line('색  상: '||vcolor);
    dbms_output.put_line('단  가: '||vprice);
    dbms_output.put_line('단  가: '||vprice2);
end;
/

/* 
[단일if문]
if 조건식 then
    문장1;
else
    문장2;
end if;

[다중if문]
if 조건식1 then
    문장1;
elsif 조건2 then
    문장2;
    ...
end if;
*/



-- 예제 5
-- 년도에 맞는 띠 구하기

-- 키보드로 년도를 입력받고자 할 경우
accept year prompt '태어난 년도를 입력하세요';
declare
    --v_year number(4) := 1996;
    v_year number(4) := '&year'; -- 입력한 값을 대입
    v_mod number(2) := mod(v_year, 12); -- 년도를 12로 나눈 나머지를 구한다
    v_ddi varchar2(10); -- 띠를 저장할 변수
begin
    if v_mod = 0 then v_ddi := '원숭이';
    elsif v_mod = 1 then v_ddi := '닭';
    elsif v_mod = 2 then v_ddi := '개';
    elsif v_mod = 3 then v_ddi := '돼지';
    elsif v_mod = 4 then v_ddi := '쥐';
    elsif v_mod = 5 then v_ddi := '소';
    elsif v_mod = 6 then v_ddi := '호랑이';
    elsif v_mod = 7 then v_ddi := '토끼';
    elsif v_mod = 8 then v_ddi := '용';
    elsif v_mod = 9 then v_ddi := '뱀';
    elsif v_mod = 10 then v_ddi := '말';
    elsif v_mod = 11 then v_ddi := '양';
    end if;
    
    dbms_output.put_line(v_year||'년생은 '||v_ddi||'띠입니다');
end;
/



-- 예제 6
-- db 컬럼의 타입을 가져오는 방법 : TYPE
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
    
    dbms_output.put_line('학생명: '||v_name);
    dbms_output.put_line('키: '||v_height);
    dbms_output.put_line('자바점수: '||v_java);
    dbms_output.put_line('스프링점수: '||v_spring);
    dbms_output.put_line('총점: '||(v_java + v_spring));
end;
/

/* 
  반복문 : loop
  loop
    문장들;
    exit when 조건;
  end loop;
*/

-- 예제 7
-- 1부터 10까지 반복해 출력하기
declare
    v_no number(2) := 0;
begin
    loop
        v_no := v_no + 1;
        dbms_output.put_line('no = '||v_no);
        exit when v_no = 10; -- 10일 경우 반복문을 빠져나간다
    end loop;
end;
/

-- 예제 8: 단을 입력하면, 해당 단을 출력하시오.
accept dan prompt '단은?';
declare
    v_dan number(2) := '&dan';
    v_inc number(2) := 1;
    v_result number(3);
begin
    dbms_output.put_line('** '||v_dan||'단 **');
    loop
        v_result := v_dan * v_inc;
        dbms_output.put_line(v_dan||' * '||v_inc||' = '||v_result);
        v_inc := v_inc + 1;
        exit when v_inc = 10;
    end loop;
    
end;
/


-- 예제 9 - Exception 처리(예제 4 복사함)
-- 상품명을 변수에 지정한 후, 해당 상품명의 가격과 색상을 출력(중복되는 아이템은 제외)
accept sangpum prompt '상품명?';
declare
    vsangpum varchar2(20) := '&sangpum';
    vcolor varchar2(20);
    vprice number(7);
    vprice2 varchar2(20);
begin
    select sang_price, sang_color, ltrim(to_char(sang_price, 'L999,999')) -- 원45,000 표시인데, 왼쪽에 공백이 많으므로 ltrim으로 지워줌
    into vprice, vcolor, vprice2
    from shop
    where sang_name = vsangpum;
    
    dbms_output.put_line('상품명: '||vsangpum);
    dbms_output.put_line('색  상: '||vcolor);
    dbms_output.put_line('단  가: '||vprice);
    dbms_output.put_line('단  가: '||vprice2);
    
    -- 결과가 2개 이상이거나 없으면 오류 발생
    -- Oracle에서 예외처리하는 방법
    exception
        when NO_DATA_FOUND then
            dbms_output.put_line(vsangpum||' 상품은 DB에 없습니다');
        when TOO_MANY_ROWS then
            dbms_output.put_line(vsangpum||' 상품이 DB에 두 개 이상 존재합니다');
        when OTHERS then
            dbms_output.put_line(vsangpum||' 상품에 대한 오류 발생...뭔지 모름ㅋ');
end;
/


/*
    반복문
    for 변수 in [reverse]시작값..최종값 loop
        문장들;
    end loop;
*/

-- 예제 10 : 예제 8 구구단 복사 후 for문으로 변경하기
accept dan prompt '단은?';
declare
    v_dan number(2) := '&dan';
    v_inc number(2);
    v_result number(3);
begin
    dbms_output.put_line('** '||v_dan||'단 **');
    
    for v_inc in 1..9 loop
        v_result := v_dan * v_inc;
        dbms_output.put_line(v_dan||' * '||v_inc||' = '||v_result);
    end loop;
end;
/

-- 예제 11:
-- 레코드 단위로 데이터 가져오기
declare
    v_num student.num%TYPE := 6;
    v_stu angel.student%rowtype; -- 레코드 단위로 읽어올 경우
begin
    select * into v_stu
    from student where num = v_num;
    
    dbms_output.put_line('이름: '||v_stu.name);
    dbms_output.put_line('키: '||v_stu.height);
    dbms_output.put_line('자바: '||v_stu.java);
    dbms_output.put_line('스프링: '||v_stu.spring);
    dbms_output.put_line('반: '||v_stu.ban);
end;
/

-- DB의 여러 데이터를 조회할 경우
/*
    Cursor : sql문을 실행할 때마다 명령이 분석되고 실행되어 결과를 보관하기 위한
    특별한 메모리 영역을 사용하는데, 이 영역을 참조하는 것이 커서이다.
    
    select문에서 여러 데이터 조회 시 사용하는 객체이다.
    
    커서 속성
    sql%rowcount : 실행된 개수 반환
    sql%found : 가장 최근의 sql문이 하나 이상의 행에 영향을 준 경우 true
    sql%notfound : 결과행이 없는 경우
    sql%isopen : 항상 false(항상 close를 하므로 항상 false)
*/

-- 예제 12
declare
    v_sno number(3) := 10;
    v_shop angel.shop%rowtype;
begin
    select * into v_shop
    from shop where sang_no = v_sno;
    
    dbms_output.put_line('상품명: '||v_shop.sang_name);
    dbms_output.put_line('조회된 실행 갯수: '||sql%rowcount); -- 1
    
    -- student의 java 점수 변경하기
    update student set java = 99;
    dbms_output.put_line('수정된 실행 갯수: '||sql%rowcount);
end;
/



-- 여러 레코드 조회
-- 예제 13
declare
    Cursor s1
    is
    select * from shop;
begin
    dbms_output.put_line('상품번호  상품명  색상  가격');
    dbms_output.put_line('-------------------------');
    
    for s in s1 loop
        exit when s1%notfound; -- 더 이상 데이터가 없으면 빠져나간다
        dbms_output.put_line(s.sang_no||'  '||s.sang_name||'  '||
            s.sang_color||'  '||s.sang_price);
    end loop;
end;
/

-- 예제 14
-- 상품명, 색상, 가격을 입력하면 shop db에 추가하기
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
    dbms_output.put_line('상품 정보를 추가했습니다.');
end;
/



-- 문제: food 테이블
/*
    fname, fprice, no 입력을 받아서
    no가 1이면 fname, fprice로 데이터 추가를 하고
    no가 2이면 food의 전체 데이터 출력
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
        -- 데이터 추가
        insert into food values (seq_food.nextval, v_name, v_price);
        commit;
        dbms_output.put_line('음식 정보를 추가했습니다.');
        
    elsif v_no = 2 then
        -- 데이터 출력
        dbms_output.put_line('음식번호  음식명  가격');
        dbms_output.put_line('--------------------');
    
        for s in datashower loop
            exit when datashower%notfound; -- 더 이상 데이터가 없으면 빠져나간다
            dbms_output.put_line(s.food_num||'  '||s.fname||'  '||s.fprice);
        end loop;
    end if;

end;
/