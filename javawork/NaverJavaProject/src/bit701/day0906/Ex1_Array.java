package bit701.day0906;

public class Ex1_Array {

	public static void main(String[] args) {
		// 교재는 165p부터 시작
		/* 배열: 연속된 형태로 데이터가 저장되는 형태
		 * 		배열에는 같은 타입의 데이터만 저장이 가능하다
		 * 		일괄적으로 처리하기 위해서 배열 사용
		 * 		자바에서 하나의 배열은 하나의 객체로 인식됨
		 */
		
		// 배열 선언 방법 1 (특정 크기만큼 할당할 수 있음)
		// (참고: 동적 배열은 Collection이라는 형태로 구현되어 있다!)
		int []arr1 = new int[5]; // 5개의 정수타입을 저장할 공간 확보, 0으로 자동 초기화
		
		// arr의 크기: length (String은 메소드인 반면, array에서는 속성이므로 괄호 없음에 주의)
		System.out.println("arr1의 할당 갯수: " + arr1.length);
		
		// 배열의 특정 번지에 값을 넣는 방법
		arr1[1] = 10;
		arr1[4] = 50;
		
		// 배열 요소 출력방법 1 : length만큼 for문 굴리기
		for (int i = 0; i < arr1.length; i++)
		{
			System.out.println(arr1[i]);
		}
		
		System.out.println();
		
		// 배열 요소 출력방법 2 : 각 요소 불러오기(js에서의 for-of 스타일)
		for (int n:arr1) // arr1의 개수만큼 자동으로 반복되면서 하나하나의 값을 n으로 보냄
		{
			System.out.println(n);
		}
	}

}
