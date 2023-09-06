package bit701.day0906;

public class Ex13_ArraySort {

	public static void main(String[] args) {
		int []data = {5, 3, 2, 4, 1};
		
		// Selection Sort
		/*
		 * (오름차순 기준)
		 * (현재 인덱스 뒤부터 보면서 더 작은 값을 만나면 swap)
		 * 기준값(i번지)이 비교되는 값(j번지)보다 크면 바꿈  
		 */
		for (int i = 0; i < data.length - 1; i++)
		{
			for (int j = i + 1; j < data.length; j++)
			{
//				if (data[i] > data[j]) // 오름차순 정렬
				if (data[i] < data[j]) // 내림차순 정렬
				{
					// swap
					int temp = data[i];
					data[i] = data[j];
					data[j] = temp;
				}
			}
		}
		
		// 출력
		for (int n:data)
			System.out.println(n);
	}

}
