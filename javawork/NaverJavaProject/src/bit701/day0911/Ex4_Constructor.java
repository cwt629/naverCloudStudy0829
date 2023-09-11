package bit701.day0911;
/* 생성자의 규칙
 * 
 * 1. 반드시 클래스명과 같은 메소드명
 * 2. 리턴 타입이 없음 (void도 아니고 그냥 없다.)
 * 3. 오버로딩 가능
 * 4. 주로 멤버 변수의 초기화 담당
 * 
 */
class Car{
	private String carName;
	private int carPrice;
	
	// 디폴트 생성자
	Car()
	{
		System.out.println("디폴트 생성자 호출");
		carName = "그랜저";
		carPrice = 3500;
	}
	
	// 생성자를 통해서 외부에서 값을 받아서 초기화
	Car(String carName, int carPrice)
	{
		System.out.println("생성자 2 호출");
		this.carName = carName;
		this.carPrice = carPrice;
	}
	
	public void carShow()
	{
		System.out.println("자동차명: " + carName + ", 단가: " + carPrice);
	}
}

public class Ex4_Constructor {

	public static void main(String[] args) {
		Car car1 = new Car();
		car1.carShow(); // 기본값: null, 0
		
		Car car2 = new Car("아반떼", 2700);
		car2.carShow();
	}

}
