package bit701.day0906;

public class Ex2_Array {

	public static void main(String[] args) {
		// 배열 선언 방법 2 : 배열 선언 시 초기값 지정
		int []arr = {5, 8, 10, 4, 20}; // 5개로 배열 자동 할당
		// 할당 개수 출력
		System.out.println("arr의 할당 개수: " + arr.length);
		System.out.println("** 출력 1 **");
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		System.out.println();
		System.out.println("** 출력 2 **");
		for (int num: arr) {
			System.out.println(num);
		}
		
		System.out.println("=".repeat(30));
		int []arr2;
		// 선언 이후 값 여러개를 나중에 주고 싶을 때?
		//arr2 = {3, 6, 8, 10, 30}; // error
		arr2 = new int[] {3, 6, 8, 10, 30}; // 선언을 한후 값을 나중에 한꺼번에 지정할 경우
		
		for (int i = 0; i < arr2.length; i++)
		{
			System.out.printf("[%2d:%2d]", i, arr2[i]);
		}
		System.out.println();
		for (int n:arr2)
		{
			System.out.printf("%3d", n);
		}
		System.out.println();
	}

}
