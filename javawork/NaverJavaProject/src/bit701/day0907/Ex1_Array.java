package bit701.day0907;

public class Ex1_Array {

	public static void main(String[] args) {
		System.out.println("배열 복습 예제");
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 29; j++) {
				char ch = (j >= 14 - i && j <= 14 + i)? '*' : ' ';
				System.out.print(ch);
			}
			System.out.println();
		}
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 29; j++) {
				char ch = (j >= 10 - i && j <= 18 + i)? '*' : ' ';
				System.out.print(ch);
			}
			System.out.println();
		}
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 29; j++) {
				char ch = (j >= 12 && j <= 16)? '|' : ' ';
				System.out.print(ch);
			}
			System.out.println();
		}
	}
}
