package bit701.day0912;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ex2_FileReader {
	static final String FILENAME = "D:\\naver0829/memo1.txt";
	
	public static void main(String[] args) throws IOException {
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			fr = new FileReader(FILENAME); // 줄단위로 읽는 멤버메소드가 없다... 그래서 2차 생성을 하겠다.
			br = new BufferedReader(fr);
			
			// br.readLine() : 한줄씩 읽는다. 더이상 읽을 내용이 없다면 null값 반환
			// 대부분 두줄 이상이고 몇줄이 저장되어 있는지 모르므로
			// while문으로 처리한다.
			while (true)
			{
				// 파일의 내용을 한줄씩 읽는다
				String line = br.readLine();
				// 더이상 읽을 내용이 없을 경우 while문 탈출
				if (line == null) 
					break;
				System.out.println(line);
			}
		} catch (FileNotFoundException e) {
			// 해당 파일이 없을 경우 예외가 발생하며 catch 영역이 실행된다
			System.out.println("해당 파일을 찾을 수 없어요. " + e.getMessage());
		}
		
		// 열려있는 자원들을 닫는다 (열려진 역순으로 닫는다.)
		br.close();
		fr.close();
	}

}
