package bit701.day0919;

// 리턴 타입이 있는 람다식
@FunctionalInterface
interface CalcInter{
	double calc(double x, double y);
}

class Person{
	public void action(CalcInter cal) {
		double result = cal.calc(10, 4);
		System.out.println("결과 = " + result);
	}
}

public class Ex2_Book704_Lambda {

	public static void main(String[] args) {
		Person person = new Person();
		// 실행문이 두개인 경우
		person.action((x, y) -> {
			double result = x + y;
			return result;
		});
		
		// 위 호출문과 같은 로직 처리
		/*
		 * 리턴 코드가 한 줄인 경우,
		 * return을 생략할 수 있다.
		 * (자바스크립트에서 화살표 함수와 같은 형식)
		 */
		person.action((x, y) -> (x + y));
	}

}
