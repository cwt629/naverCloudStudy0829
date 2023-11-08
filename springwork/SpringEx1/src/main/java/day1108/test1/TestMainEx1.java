package day1108.test1;

public class TestMainEx1 {

	public static void main(String[] args) {
		TestDto dto = new TestDto();
		dto.setName("장원태");
		dto.setAddr("강남");
		dto.setAge(28);
		
		System.out.println("이름: " + dto.getName());
		System.out.println("주소: " + dto.getAddr());
		System.out.println("나이: " + dto.getAge());
		
		System.out.println("toString() 호출");
		// dto 클래스 위에 @ToString 붙여주면, toString 안붙여도 자동 호출된다 ㄷㄷ
		System.out.println(dto); // 원래는 dto.toString()인데, 안써도 자동호출됨
		
		TestDto dto2 = new TestDto("이승민", "남양주", 24);
		System.out.println(dto2);
		
		TestDto dto3 = new TestDto("이준일");
		System.out.println(dto3);
	}

}
