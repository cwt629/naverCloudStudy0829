<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>2. xml DB 읽기</title>
<link href="https://fonts.googleapis.com/css2?family=Gamja+Flower&family=Jua&family=Lobster&family=Nanum+Pen+Script&family=Permanent+Marker&family=Single+Day&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
<style>
    body * {
        font-family: 'Jua';
    }
    
    div.myshopicon {
    	margin: 30px 100px;
    }
    
    div.myshopicon * {
    	cursor: pointer;
    	margin-right: 30px;
    	font-size: 30px;
    }
    
    div.myshoplist {
    	margin: 30px 50px;
    }
    
    div.box {
    	width: 150px;
    	height: 200px;
    	text-align: center;
    	border: 5px solid gray;
    	border-radius: 20px;
    	float: left;
    	margin-right: 30px;
    	margin-bottom: 20px;
    }
    
    div.box figure img {
    	width: 130px;
    	height: 140px;
    }
    
    .day {
    	color: gray;
    	font-size: 0.8em;
    	margin-right: 20px;
    }
</style>
<script>
	$(function(){
		// 처음 시작 시 그리드 모양 이미지 형태로 출력
		grid();
		$(".myshopgrid").css("color", "red");
		
		$(".myshopgrid").click(function(){
			$(this).css("color", "red");
			$(".myshoplist").css("color", "black");
			grid();			
		});
	
		$(".myshoplist").click(function(){
			$(this).css("color", "red");
			$(".myshopgrid").css("color", "black");
			list();
		});
	});
	
	function grid()
	{
		$.ajax({
			type: "get",
			dataType: "xml",
			url: "myshoptoxml.jsp",
			success: function(res){
				let s = "";
				$(res).find("myshop").each(function(idx, item){
					let sangpum = $(item).find("sangpum").text();
					let price = $(item).find("price").text();
					let photo = $(item).find("photo").text();
					let color = $(item).find("color").text();
					let writeday = $(item).find("writeday").text();
					
					s += `
						<div class="box">
							<figure>
								<img src="../shop/\${photo}">
							</figure>
						</div>
						`;
				});
				
				$(".myshoplist").html(s);
			},
			statusCode: {
				404: function(){
					alert("json 파일을 찾을 수 없다.");
				},
				500: function(){
					alert("서버 오류다. 코드 확인해라.");
				}
			}
		});
	}
	
	function list()
	{
		
	}
</script>
</head>
<body>
	<div class="myshopicon">
		<i class="bi bi-grid myshopgrid"></i>
		<i class="bi bi-card-list myshoplist"></i>
	</div>
	
	<div class="myshoplist">
	
	</div>
</body>
</html>