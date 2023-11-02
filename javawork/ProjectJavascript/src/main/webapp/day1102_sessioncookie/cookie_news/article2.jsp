<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>기사 : 2번째</title>
<link href="https://fonts.googleapis.com/css2?family=Gamja+Flower&family=Jua&family=Lobster&family=Nanum+Pen+Script&family=Permanent+Marker&family=Single+Day&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<style>
    body * {
        font-family: 'Jua';
    }
</style>
</head>
<%
	Cookie []cookies = request.getCookies();
	boolean find = false;
	if (cookies != null) 
	{
		for (Cookie ck: cookies)
		{
			// 저장된 쿠키 이름을 얻는다
			String name = ck.getName();
			if (name.equals("loginok")){
				find = true; // 해당 쿠키가 존재하면 true
			}
		}
	}
%>
<body>
	<%
		if (!find){%>
			<script>
				alert("먼저 로그인을 해주세요");
				history.back();
			</script>
		<%} else {%>
			<pre style="width: 400px;">
			
홍현석·오현규 결승골 작렬…김민재의 뮌헨, 3부 팀에 덜미

홍현석(KAA헨트)과 오현규(셀틱FC)가 나란히 결승골을 터트려 팀 승리를 이끌었다. 김민재의 바이에른 뮌헨은 3부리그 팀에 덜미를 잡혀 독일축구협회(DFB)포칼에서 조기 탈락했다.

홍현석은 2일(한국시간) 벨기에 림뷔르흐주 마스메헬런에서 열린 2023-2024 벨기에축구협회(FA)컵 7라운드 파트로 아이스덴 마스메헬런과의 원정 경기에서 후반 32분 득점포를 가동했다.

헨트는 벨기에 2부리그 팀인 파트로 아이스덴을 상대로 1-1 동점인 상황에서 홍현석은 후반 32분 결승골을 작렬했다. 헨트는 3-1로 이겨 FA컵 16강에 진출했다.

지난달 항저우 아시안게임 대표팀에 차출돼 금메달을 딴 홍현석이 소속팀에서 골을 넣은 건 지난 9월 초 클뤼프 브뤼허전 2골 이후 2개월 만이다. 이번 시즌 리그에서 2골 2도움을 작성한 홍현석은 유럽축구연맹(UEFA) 유로파 콘퍼런스리그 1골, FA컵 1골을 포함해 공식전 4골 3도움을 기록하게 됐다.

같은 날 셀틱의 오현규는 스코틀랜드 글래스고의 셀틱 파크에서 열린 스코틀랜드 프로축구 프리미어십 11라운드 세인트 미렌과의 홈경기에서 1-1로 팽팽하던 후반 38분 결승골을 쏘았다. 오현규의 골에 힘입어 2-1로 이긴 셀틱은 개막 11경기 무패(9승 2무·승점 29) 행진을 이어가며 리그 1위 자리를 지켰다.

전반 7분 만에 세인트 미렌에 선제골을 내준 셀틱은 전반 18분 동점에 성공했다. 1-1 상황에서 오현규는 후반 29분 교체 투입된 지 9분 만에 오른발 슈팅으로 역전골을 터트렸다. 오현규의 올 시즌 마수걸이 득점. 시즌 첫 골이 결정적인 순간에 터지며 오현규는 팀 승리의 일등공신이 됐다.

반면 김민재의 소속팀 뮌헨은 3부리그 팀에 일격을 당했다. 독일 자르브뤼켄의 루트비히스파르크 스타디온에 열린 DFB포칼 2라운드에서 뮌헨은 FC자르브뤼켄에 1-2로 졌다.

전반 16분 토마스 뮐러의 중거리포로 앞서간 뮌헨은 전반 추가시간 동점골을 내줬다. 후반 들어 일방적인 공세를 펼쳤지만 상대 골문을 열지 못하더니, 후반 추가시간 마르셀 가우스에게 역전골을 얻어 맞았다.

이날도 어김없이 풀타임을 뛴 김민재도 팀 패배를 막진 못했다. 김민재는 최근 공식전 11경기 연속 풀타임(정규리그 7경기·유럽클럽대항전 3경기·포칼 1경기) 출전 중이다.

이재성의 마인츠05도 2부리그 팀인 헤르타 베를린에 0-3으로 완패해 DFB포칼 2라운드에서 탈락했다.
			</pre>
			<br><br>
			<a href="loginmain.jsp">메인 페이지로 이동</a>
		<%}
	%>
</body>
</html>