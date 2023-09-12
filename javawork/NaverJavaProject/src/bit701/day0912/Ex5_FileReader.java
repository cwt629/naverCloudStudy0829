package bit701.day0912;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Ex5_FileReader {

	static final String SUNGJUK_FILE = "D:/naver0829/sungjuk.txt";
	Sungjuk []sung = new Sungjuk[20];
	int count;
	
	public Ex5_FileReader() throws IOException {
		// 파일 읽어서 sung 배열에 담기(줄단위로 읽은후 ,로 분리해서 넣기)
		// 나는 이렇게 작성했지만, 이 부분에서 try-catch 로 감싸는 게 더 나을 것 같다.
		FileReader fr = new FileReader(SUNGJUK_FILE);
		BufferedReader br = new BufferedReader(fr);
		
		// 파일 읽고, 그 안에서 split 후 담기
		String data;
		while (true) {
			data = br.readLine();
			if (data == null) break;
			
			// ,로 분리하기
			StringTokenizer st = new StringTokenizer(data, ",");
			// token은 이름, 국어, 영어 순이다
			String name = st.nextToken();
			int kor = Integer.parseInt(st.nextToken());
			int eng = Integer.parseInt(st.nextToken());
			
			// 클래스 객체 생성
			sung[count++] = new Sungjuk(name, kor, eng);
		}
		br.close();
		fr.close();
	}
	
	public void dataList() {
		// 출력(총점, 평균은 메소드 없이 여기서 바로바로 해보기)
		// 이름  국어  영어  총점  평균
		System.out.println("총 " + count + "명");
		System.out.println("이름\t국어\t영어\t총점\t평균");
		System.out.println("=".repeat(40));
		for (int i = 0; i < count; i++) {
			int total = sung[i].getKor() + sung[i].getEng();
			double avg = total / 2.0;
			System.out.println(sung[i].getName() + "\t"
					+ sung[i].getKor() + "\t" + sung[i].getEng() + "\t"
					+ total + "\t" + avg);
		}
	}
	
	public static void main(String[] args) throws IOException {
		Ex5_FileReader ex = new Ex5_FileReader();
		ex.dataList();
	}

}
