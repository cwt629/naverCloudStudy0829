package bit701.day0914;

public class Ex1_Exception {

	public static void main(String[] args) {
		int []arr = {10, 20, 30};
		for (int i = 0; i <= arr.length; i++)
		{
			try {
				System.out.println(arr[i]);
			} catch(ArrayIndexOutOfBoundsException e) {
				System.out.println("배열 번지를 벗어났음 : " + e.getMessage()); // getMessage: 실제 예외 메시지(Index 3 out of bounds for length 3)
				e.printStackTrace(); // 에러메세지를 추적해서 출력(빨간줄 나오지만 정상종료)
			}
			
		}
		
		System.out.println("정상 종료");
	}

}
