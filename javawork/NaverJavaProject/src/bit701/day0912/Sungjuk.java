package bit701.day0912;

public class Sungjuk {
	private String name;
	private int kor;
	private int eng;
	
	// Source > Generate Constructor using Fields 로 자동 생성됨
	public Sungjuk(String name, int kor, int eng) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
	}

	public String getName() {
		return name;
	}

	public int getKor() {
		return kor;
	}

	public int getEng() {
		return eng;
	}
}
