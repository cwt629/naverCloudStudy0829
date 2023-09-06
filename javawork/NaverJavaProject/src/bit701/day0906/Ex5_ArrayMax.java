package bit701.day0906;

public class Ex5_ArrayMax {

	public static void main(String[] args) {
		// 최대값, 최소값 구하기
		int []data;
		data = new int[] {5, -100, 67, 89, 345, -9, 123, 58, 110, 200};
		int max, min;
		//System.out.println(data.length);
		// 최대값과 최소값
		max = min = data[0]; // 첫번째 데이터를 최대값과 최소값에 저장
		// 2번째부터 끝까지 비교해서 더 큰 값이 나오면 max값 갱신
		// 2번째부터 끝까지 비교해서 더 작은 값이 나오면 min값 갱신
		for (int i = 1; i < data.length; i++) {
			if (max < data[i])
				max = data[i];
			if (min > data[i])
				min = data[i];
		}
		System.out.println("max = " + max);
		System.out.println("min = " + min);
	}

}
