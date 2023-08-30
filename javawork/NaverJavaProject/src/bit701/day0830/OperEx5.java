package bit701.day0830;

public class OperEx5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 증감연산자: ++(1씩 증가), --(1씩 감소)
		// 변수 앞에 붙일 경우(전치) 1순위
		// 변수 뒤에 붙일 경우(후치) 끝순위
		// 단, 단항으로 사용할경우는 상관 없음
		
		int a = 5;
		int b = 5;
		// 단항으로 연산할 경우 : 상관 없이 같은 결과
		System.out.println("=====단항 연산=====");
		++a; // 1 증가
		System.out.println(a); // 6
		b++; // 1 증가
		System.out.println(b); // 6
		
		System.out.println("=====출력 내 연산=====");
		System.out.println(++a); // 7 (먼저 증가 후 출력)
		System.out.println(b++); // 6 (먼저 출력 후 증가)
		System.out.println("a="+a+",b="+b); // 7,7 (해당 수행을 지나고나면 똑같이 1 증가해있음)
		
		System.out.println("=====연산과 할당=====");
		a = b = 5;
		int m = ++a; // 6 (증가 후 대입)
		int n = b++; // 5 (대입 후 증가)
		System.out.printf("a=%d,b=%d,m=%d,n=%d\n", a, b, m, n); // 6, 6, 6, 5
		
	}

}
