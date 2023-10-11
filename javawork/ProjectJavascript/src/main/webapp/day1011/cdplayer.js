$(function(){
	// h1.title을 클릭 시 .music-list를 slideDown한다.
	$("h1.title").click(function(){
		$("ul.music-list").slideDown('slow');
	});
	
	// 노래 제목을 클릭 시 클릭한 곳의 제목을 얻어서 h1.title에 넣은 후 slideUp한다.
	$("ul.music-list>li").click(function(){
		let musicTitle = $(this).text();
		$("h1.title").text(musicTitle);
		
		// class를 얻는다
		let selectClass = $(this).attr("class");
		
		// 적용 - animate
		$("#cd").animate({width: '0'}, 'slow', function(){
			// cd 변경
			$("#cd").attr("class", selectClass);
			// 너비를 다시 300으로 변경
			//$(this).animate({width: '300px'}, 'slow');
		}).animate({width: '300px'}, 'slow'); // Self: 연달아 사용도 가능
		
		$("ul.music-list").slideUp('slow');
	});
})