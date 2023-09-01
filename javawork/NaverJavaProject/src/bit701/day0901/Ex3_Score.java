package bit701.day0901;

import java.text.NumberFormat;
import java.util.Scanner;

public class Ex3_Score {

	public static void main(String[] args) {
		/*
		 * [문제]
		 * 이름, 3과목의 점수(kor, eng, mat)를 입력받은 후
		 * 총점과 평균(소수점 1자리까지 NumberFormat으로)
		 * 그리고 등급 출력
		 * (등급은 grade : 
		 * 평균 90이상이면 "Excellent!"
		 * 평균 80이상이면 "Good!!"
		 * 나머지는 "Try!"
		 * )
		 * 
		 * [조건]
		 * if~else문 사용해서 구해보세요
		 */
		
		// 선언
		Scanner sc = new Scanner(System.in);
		String name, grade; int kor, eng, mat, totalScore; double averageScore;
		NumberFormat avgFormat = NumberFormat.getInstance();
		avgFormat.setMaximumFractionDigits(1);
		
		// 입력
		System.out.println("당신의 이름은?");
		name = sc.nextLine();
		
		System.out.println("국어, 영어, 수학 점수를 차례대로 입력해주세요.");
		kor = sc.nextInt();
		eng = sc.nextInt();
		mat = sc.nextInt();
		
		// 계산
		totalScore = kor + eng + mat;
		averageScore = (double)totalScore / 3; // totalScore / 3.0 으로도 가능
		// grade 배정
		if (averageScore >= 90) grade = "Excellent!";
		else if (averageScore >= 80) grade = "Good!!";
		else grade = "Try!";
		
		// 출력
		System.out.println(name + " 님의 성적입니다.");
		System.out.println("국어 점수: " + kor + "점");
		System.out.println("영어 점수: " + eng + "점");
		System.out.println("수학 점수: " + mat + "점");
		System.out.println("총점: " + totalScore + "점");
		System.out.println("평균: " + avgFormat.format(averageScore) + "점");
		System.out.println("등급: " + grade);
	}

}
