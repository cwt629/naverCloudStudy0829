package bit701.day0911;

import java.util.Scanner;

public class Ex9_SawonInput {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Sawon []sa = new Sawon[3];
		
		// 3명의 사원에 대한 정보 입력 후 배열 생성하기
		for (int i = 0; i < sa.length; i++) {
			System.out.print(i + "번째 사원의 이름은? ");
			String name = sc.nextLine();
			System.out.print(i + "번째 사원의 기본급은? ");
			int gibon = Integer.parseInt(sc.nextLine());
			System.out.print(i + "번째 사원의 수당은? ");
			int sudang = Integer.parseInt(sc.nextLine());
			System.out.print(i + "번째 사원의 가족수는? ");
			int familySu = Integer.parseInt(sc.nextLine());
			
			sa[i] = new Sawon(name, gibon, sudang, familySu);
		}
		
		// 출력
		System.out.println("이름\t기본급\t수당\t가족수\t가족수당\t세금\t실수령액");
		System.out.println("=".repeat(65));
		for (Sawon person: sa)
		{
			System.out.println(person.getName() + "\t" + person.getGibon() + "\t"
					+ person.getSudang() + "\t" + person.getFamilySu() + "\t"
					+ person.getFamilySudang() + "\t" + person.getTax() + "\t"
					+ person.getNetPay());
		}
	}

}
