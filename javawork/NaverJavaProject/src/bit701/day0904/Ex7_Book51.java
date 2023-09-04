package bit701.day0904;

public class Ex7_Book51 {

	public static void main(String[] args) {
		// json 데이터 {"키": "값"}
		String jdata = "{\"name\":\"장원태\"}";
		System.out.println(jdata);
		
		// jdk13에서 추가된 텍스트 블록 문법 : """
		// (자바스크립트의 템플릿 리터럴 느낌이라고 보면 될 듯.)
		// 공백까지도 그대로 출력한다고 하니 유의하기.
		String jdata2 = 
				"""
{"name": "캔디","address": "역삼동"}
				""";
		System.out.println(jdata2);
		
		String name = "마이클잭슨";
		int age = 32;
		
		// 변수를 json데이터 내에 어떻게 담을까?
		// 구식 방법 : 일일이 다 더해줘...
		String jdata3 = "{\"name\":\"" + name + "\",\"age\":" + age + "}";
		System.out.println(jdata3);
		
		// jdk13 이후 : 텍스트 블록 문법에 변수값 넣기(printf처럼 넣기)
		String jdata4 = """
	{"name":"%s","age":%d}
				""".formatted(name, age);
		System.out.println(jdata4);
		
		// 블록 문법의 장점: 줄바꿈의 편의성
		String str1 = "red\nblue\ngreen\n";
		System.out.println(str1);
		
		String str2 = """
				red
				blue
				green
				pink
				""";
		System.out.println(str2);
	}

}
