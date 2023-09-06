package bit701.day0906;

import java.util.Random;

public class Ex16_Lotto {

	public static void main(String[] args) {
		/*
		 * [문제]
		 * 6개 할당된 로또 변수(lotto)에
		 * 1~45 사이의 난수를 발생하는데
		 * (중복된 경우 다시 발생)
		 * 오름차순 정렬로 출력하시오
		 */
		//Random r = new Random();
		int []lotto = new int[6];
		
		// 6개의 로또 숫자 받기
		for (int i = 0; i < lotto.length; i++)
		{
			//lotto[i] = r.nextInt(45) + 1;
			lotto[i] = (int)(Math.random() * 45) + 1;
			
			// 중복 확인
			for (int j = 0; j < i; j++)
			{
				if (lotto[i] == lotto[j]) {
					i--;
					break; // 현재 반복문을 빠져나간 후 i++로 이동
				}
			}
		}
		
		// 만들어진 로또 6개 정렬하기
		for (int i = 0; i < lotto.length - 1; i++)
		{
			for (int j = i + 1; j < lotto.length; j++)
			{
				if (lotto[i] > lotto[j]) {
					int temp = lotto[i];
					lotto[i] = lotto[j];
					lotto[j] = temp;
				}
			}
		}
		
		// 출력하기
		for (int num: lotto)
			System.out.printf("%4d", num);
		
	}

}
