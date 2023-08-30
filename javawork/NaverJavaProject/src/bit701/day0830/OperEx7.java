package bit701.day0830;

public class OperEx7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 비교 연산자와 논리 연산자, 결과값은 무조건 참(true) 또는 거짓(false)
		int kor = 100, eng = 90, mat = 100;
		System.out.println(kor >= 80); // true
		System.out.println(kor >= 80 || kor != mat); // true - 앞에만 보고 이미 참이니까, 뒤의 수식을 비교하지 않음
		System.out.println(kor < 80 || kor != mat); // false - 앞에가 거짓이므로, 뒤까지 비교가 필요함
		System.out.println(kor >= 80 && kor != mat); // false
		System.out.println(kor < 80 && kor != mat); // false - 앞에만 보고 이미 거짓이니까, 뒤의 수식을 비교하지 않음
		System.out.println(!(kor == mat)); // false - 원래는 true이지만, !에 의해 부정된다
		System.out.println(kor >= 95 && eng >= 95 && mat >= 95); // false - 하나라도 안맞으면
		System.out.println(kor >= 95 && eng >= 95 || mat >= 95); // true - 앞에서부터 연산하면 false, 근데 뒤에는 true
		System.out.println(kor >= 95 || eng >= 95 && mat >= 95); // true
		
		int year = 2030;
		// 위의 년도가 윤년인지 아닌지 알아보자(4년마다 돌아오지만, 100년마다는 빼준다. 근데 400년마다 돌아온다)
		System.out.println("======윤년 파악하기======");
		System.out.println(year%4 == 0 && year % 100 != 0 || year % 400 == 0);
	}

}
