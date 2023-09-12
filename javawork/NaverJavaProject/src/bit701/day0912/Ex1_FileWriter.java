package bit701.day0912;

import java.io.FileWriter;
import java.io.IOException;

public class Ex1_FileWriter {
	static final String FILENAME = "D:\\naver0829/memo1.txt";
	
	public static void main(String[] args) throws IOException {
		// 파일에 개인정보 저장하기
		FileWriter fw = null; // 무조건 exception이 발생하므로 초기값은 null로 주고 이후에 생성하자
		
		/*
		 * tip:
		 * error 나는 부분에서 왼쪽줄의 전구표시를 확인해도 되지만,
		 * Ctrl + 1 누르면 에러 해결 옵션을 보여준다.
		 */
		// 생성 1
//		fw = new FileWriter(FILENAME); // 파일이 없으면 새로 생성하고, 있으면 덮어씀
		// 생성 2: 처음부터 덮어쓰는게 아니라 마지막부터 이어쓰고 싶다면? append boolean 활용
		fw = new FileWriter(FILENAME, true);
		// 파일에 내용 저장하기
		fw.write("이름: 유재석\n");
		fw.write("핸드폰: 010-5656-4545\n");
		fw.write("-------------------\n");
		
		// 파일 닫기
		fw.close();
		System.out.println("탐색기를 열고 memo1.txt 파일을 확인하세요");
	}

}
