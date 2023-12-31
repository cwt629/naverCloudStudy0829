<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>기사 : 1번째</title>
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
			
‘라스’ 류승수, 떴다 하면 레전드 5.7%[종합]

류승수, 에릭남, 딘딘, 유정, 원지가 선을 넘는 활약과 아슬아슬 토크 폭주로 수요일 밤 시청자들의 배꼽을 빼놓으며 동시간대 시청률 1위를 기록했다.

1일 방송된 MBC ‘라디오스타’는 류승수, 에릭남, 딘딘, 유정, 원지가 출연한 ‘선남선녀’ 특집으로 꾸며졌다. 선 없는 활약을 펼치고 있는 게스트들의 에피소드가 방송 내내 웃음을 선사했다.

2일 시청률 조사회사 닐슨코리아에 따르면 전날 방송된 ‘라디오스타’는 수도권 가구 기준(이하 동일) 4.8%의 시청률을 기록하며 동시간대 1위를 기록했다. 최고의 1분은 류승수가 ‘끌어올려’ 비중에 집착하는 장면으로 최고 시청률 5.7%를 기록했다.

지난해 ‘라스’ 출연이 화제가 되어 건강 프로그램 MC까지 꿰찬 류승수가 1년여 만에 ‘라스’에 출연했다. ‘안 유명한 부자가 꿈’이라며 ‘저텐션’을 보여줬던 그는 1년여 만에 몰라보게 달라진 텐션으로 웃음을 안겼다. 특히 지난 ‘라스’ 출연에서 김호영과 뜻밖의 콤비로 화제가 된 ‘끌어올려’의 비중에 집착하는 모습으로 예능 욕망을 입증했다.

그런가 하면, 류승수는 김호영과 ‘라스’ 동반 출연 후 ‘호영라이팅(김호영+가스라이팅)’을 당하고 있다면서 “다른 데선 제가 기죽는 편은 아닌데, 욘사마(배용준) 이후 김호영이 유일하다”라고 밝혀 웃음을 자아냈다. 그는 또 남 좋은 일만 끌어올려 주는 팔자라는 이야기에 수상까지 기대한 영화 ‘고지전’ 이후 배우 은퇴를 결심하고 한 달간 칩거했는데, 차태현이 용기를 줘 세상 밖으로 나올 수 있었다면서 고마워했다.

제주도에 거주 중인 류승수는 연기 생활 최초 커피차가 동네 이웃들에게 받은 거라고 자랑했다. 많은 배우의 연기 선생으로 정평이 난 그는 동네에서도 여전히 연기 스승으로 맹활약 중이며, 정원에서 동네 아이들을 위한 작은 영화관을 운영 중인 소소한 행복도 공개했다. 그런가 하면, 학창 시절 ‘빨간 바지’로 부산을 주름잡았던 브레이크 댄스 실력을 공개했는데, “느리다”라는 평가를 받고 씁쓸해하는 류승수의 반응이 폭소를 선사했다.

이날 방송은 류승수의 활약뿐 아니라 모든 이들의 티키타카가 큰 웃음을 안겼다. 진정한 연예인의 삶을 살고 있는 에릭남은 딘딘 덕에 ‘스섹가이’라는 쌈박한 별명을 얻었고, 딘딘은 교양 예찬을 펼치면서 교양이 부족한 멘트로 김구라의 저격을 당했다. 유정은 이규한과의 열애 소감과 함께 입술로 가오리춤을 추며 신곡의 역주행을 위해 몸을 불살랐다. ‘김태호 픽’ 원지는 어떤 방해에도 아랑곳하지 않는 뚝심 토크로 김구라의 엄지척을 받았다.

6년 만에 ‘라스’에 출연한 에릭남은 오직 ‘라스’ 출연을 위해 귀국했고, 녹화 후 한국을 떠난다고 밝혀 놀라움을 자아냈다. 그는 미국과 한국에 집이 3채나 있지만 비행기에서 사는 월드 스타의 클래스를 보여줬다. 김구라는 “진정한 연예인의 삶이네”라며 감탄했다. 에릭남의 ‘프로 N잡러’ 근황도 공개됐다.

에릭남은 미국 ‘타임지’에서 선정하는 ‘타임 100임팩트 어워즈’에 이름을 올렸는데, 그 이유가 정신 건강 관련 콘텐츠를 제작해 애플리케이션까지 만들어 운영했기 때문이었다. 가수, 스타트업 대표, 배우, 제작자, 에이전시까지 직업이 여러 개인 에릭남에게 김구라는 혀를 내둘렀고, 류승수는 글로벌 대열에 끼고 싶은 욕심을 드러내 폭소를 자아냈다.

반듯한 ‘엄친아(엄마 친구 아들)’ 이미지가 강한 에릭남의 반전 매력도 공개됐다. 콘서트에서 19금 섹시 댄스로 팬들을 사로잡는 증거 영상이 공개되자, 모두가 깜짝 놀란 것. 스위트한 것과 섹시한 것 둘 중 어떤 게 더 좋냐는 질문에 에릭남이 섹시 쪽을 선택하자, 딘딘은 ‘스섹(스위트하고 섹시한)가이’ 작명을 선물하며 자기 지분을 강조해 웃음을 자아냈다.

이 밖에 가수로서 고민에 빠져 있을 당시 BTS 슈가로부터 용기를 얻어 해외에서 대박이 난 일화, 류승수와 몽골에서 예능 촬영을 하다 야생 쥐를 잡아먹었는데, 그 맛에 대해 “치킨 같다”라고 밝혀 눈길을 끌었다.

최근 시사-교양 프로그램인 ‘순간포착 세상에 이런일이’에 고정 MC로 합류하며 많은 예능인의 부러움을 한 몸에 받은 래퍼 딘딘은 ‘세상에 이런일이’ MC 임성훈과 공통점을 열거하며 “내가 바로 포스트 임성훈”이라고 주장해 웃음을 자아냈다. 딘딘은 ‘좀비버스’ 속 덱스의 명장면으로 남은 장면에 자신의 오지랖이 영향을 줬다고 주장하는가 하면, 다른 데서 자신을 언급하지 않는 덱스에게 서운한 마음을 털어놔 웃음을 자아냈다.

브레이브걸스에서 브브걸(BBGIRLS)로 새롭게 컴백한 유정은 전 소속사 대표인 용감한형제(용형)에게 서운했던 점을 고백하는 것을 시작으로 거침없는 활약을 예고했다. 그는 브브걸로 그룹명 세탁(?)을 하게 된 사연과 신곡 ‘원 모어 타임(ONE MORE TIME)’의 원제목이 ‘Give it to me baby(기브 잇 투 미 베이비)’였지만, 쓸 수 없게 된 이유 등을 밝히며 역주행 기원 댄스를 추기도 했다.

무엇보다 유정에게 관심이 쏠린 화제는 11살 연상 배우 이규한과의 열애였다. 유정은 수줍어하면서도 지난 2월 방송된 ‘촌스럽게 여기도 안 와봤어?’에서 처음 만난 이규한과 썸을 거쳐 열애를 인정하기까지의 과정을 솔직하게 밝혔다.

마지막으로, 구독자 80만 명에 육박하는 ‘여행 너튜버’ 원지는 ‘지구마불 세계여행’ 우승 이후 달라진 인생을 묻는 질문에 “짱짱한 광고 3개를 찍었다”라고 답해 부러움을 자아냈다. 그는 ‘무한도전’을 보고 자란 ‘무도 키즈’로, 지나가는 시민으로라도 출연하고 싶은 꿈을 갖고 있었는데, ‘무도’가 폐지돼서 꿈이 사라졌다고 생각했을 때 김태호 PD의 연락을 받았다며 진정한 ‘성덕’임을 자랑했다.

원지는 빠니보틀, 곽튜브와 다른 원지만의 여행 콘텐츠 차별점에 대해 “여행지에 차별화를 주기 위해 아프리카에 많이 갔다”라고 밝혔다. 그는 37개국을 여행하며 가장 기억에 남은 여행지로 에티오피아를 꼽았는데, 김구라가 커피 지식을 뽐내려 하자, 들어주면서도 자기 이야기를 끝마치려는 뚝심으로 통쾌함을 선사했다. 수줍어하면서도 시키면 또 하는 ‘예능 신생아’ 원지에게 김구라는 “김태호가 발굴한 예능 원석”이라며 극찬을 아끼지 않았다.
			</pre>
			<br><br>
			<a href="loginmain.jsp">메인 페이지로 이동</a>
		<%}
	%>
</body>
</html>