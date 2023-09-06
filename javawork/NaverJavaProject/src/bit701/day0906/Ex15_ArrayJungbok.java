package bit701.day0906;

import java.util.Random;

public class Ex15_ArrayJungbok {

	public static void main(String[] args) {
		// 크기 10의 배열 안에 1~20 사이의 난수를 구해서 저장후 출력해보자.
		Random r = new Random();
		int []data = new int[10];
		
		PickingRandom:
		for (int i = 0; i < data.length; i++)
		{
			data[i] = r.nextInt(20) + 1;
			// 중복 처리 - 같은 숫자가 있을 경우 다시 발생
			for (int j = 0; j < i; j++) {
				if (data[j] == data[i]) {
					i--;
					continue PickingRandom;
				}
			}
		}
		
		// 출력(한줄에 5개씩 출력)
		for (int i = 0; i < data.length; i++)
		{
			System.out.printf("%4d", data[i]);
			if ((i + 1) % 5 == 0) System.out.println();
		}
		
	}

}
