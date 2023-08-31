package bit701.day0831;

import java.util.Scanner;

public class Ex4_Oper {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		/*
		 * 정수를 입력받아 90 이상은 "A", 80 이상은 "B", 70 이상은 "C", 60 이상은 "D", 나머지는 "F"
		 * 
		 * 99 입력시 99점은 A학점입니다
		 * 
		 * if문과 조건연산자 두가지 방법으로 학점을 구해서 출력해 보세요.
		 */
		
		System.out.println("점수를 입력하세요");
		int score = sc.nextInt();
		if (score > 100 || score <= 0) 
		{
			System.out.println("잘못된 값 입력으로 종료합니다.");
			// return은 원래 해당 메소드만 종료하는 명령어임.
			// 그렇지만 main 메소드 종료는 곧 프로그램 종료를 의미.
			return;
		}
		System.out.println("입력된 점수: " + score + "점");
		
		String grade = "";
		// 1. if문
		if (score >= 90) grade = "A";
		else if (score >= 80) grade = "B";
		else if (score >= 70) grade = "C";
		else if (score >= 60) grade = "D";
		else grade = "F";
		System.out.println(score + "점은 " + grade + "학점입니다. (if문의 결과)");
		
		// 2. 조건 연산자
		grade = (score >= 90)? "A" : (score >= 80)? "B" : (score >= 70)? "C" : (score >= 60)? "D" : "F";
		System.out.println(score + "점은 " + grade + "학점입니다. (조건 연산자의 결과)");
		
	}

}
