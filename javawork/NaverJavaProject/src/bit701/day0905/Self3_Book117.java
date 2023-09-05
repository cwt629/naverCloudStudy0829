package bit701.day0905;

public class Self3_Book117 {

	public static void main(String[] args) {
		int score = (int)(Math.random() * 20) + 81;
		System.out.println("점수: " + score);
		
		String grade;
		
		if (score >= 90)
		{
			if (score >= 95)
				grade = "A+";
			else
				grade = "A";
		} else {
			if (score >= 85)
				grade = "B+";
			else
				grade = "B";
		}
		
		System.out.println("학점: " + grade);
		
//		String str1 =
//		"{\n" +
//				"\t\"id\":\"winter\",\n" +
//		"\t\"name\":\"눈송이\"\n" +
//				"}";
//		
//		System.out.println(str1);
	}

}
