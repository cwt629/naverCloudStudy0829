package bit701.day0912;

class SuperD
{
	private String carName;
	private String carColor;
	
	SuperD()
	{
		System.out.println("부모의 디폴트 생성자 호출");
		carName = "소나타";
		carColor = "노랑색";
	}
	
	SuperD(String carName, String carColor)
	{
		System.out.println("부모의 두번째 생성자 호출");
		this.carName = carName;
		this.carColor = carColor;
	}
	
	public void carInfo()
	{
		System.out.println("자동차명: " + carName);
		System.out.println("자동차색상: " + carColor);
	}
}

class SubD extends SuperD
{
	private int carPrice;
	
	SubD()
	{
		System.out.println("sub 디폴트 생성자 호출");
		this.carPrice = 3500;
	}
	
	SubD(String carName, String carColor, int carPrice)
	{
		super(carName, carColor);
		System.out.println("sub의 두번째 생성자 호출");
		this.carPrice = carPrice;
	}
	
	@Override
	public void carInfo() {
		// TODO Auto-generated method stub
		super.carInfo(); // 부모의 멤버 변수가 private이라 부모가 출력 후 메소드로 호출
		System.out.println("차량 가격: " + this.carPrice);
		System.out.println("=======================");
	}
}

////////////////////////////////////////////////
public class Ex9_InheritConst {

	public static void main(String[] args) {
		SubD sub1 = new SubD();
		sub1.carInfo();
		
		SubD sub2 = new SubD("벤츠", "검정색", 6700);
		sub2.carInfo();
	}

}

// 교재 284~ : 상속

// p290
// 눈으로만 쭉 읽어보면서 오버라이딩(p297)까지 공부해보기 (p290 ~ p297) 
