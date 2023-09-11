package bit701.day0911;

import java.util.Scanner;

//교재 p281(클래스 문제부분) 20번 문제
public class Book_BankApplication {

	// 명령어 대기 메뉴를 출력해주는 함수
	public static void printMenu() {
		System.out.println("-".repeat(50));
		System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료");
		System.out.println("-".repeat(50));
		System.out.print("선택> ");
	}
	
	// 어떤 작업 선택했는지 출력해주는 함수
	public static void printCurrentTask(String task) {
		System.out.println("-".repeat(15));
		System.out.println(task);
		System.out.println("-".repeat(15));
	}
	
	public static void main(String[] args) {
		Account []accounts = new Account[10];
		Scanner sc = new Scanner(System.in);
		int totalAccounts = 0;
		
		// 추가: 배열(10개)이 꽉차면 "더이상 계좌 생성이 안됩니다" 출력
		BankApp:
		while (true)
		{
			String accountNo, accountName;
			int money;
			
			// 메뉴 출력
			printMenu();
			// 입력받기
			int command = Integer.parseInt(sc.nextLine());
			
			/*
			 * tip: switch문 내 case에서 변수를 선언할 때
			 * case를 벗어나면 그 변수가 소멸되게 하고싶다면
			 * case 부분을 {} 블록으로 감싸주면 된다.
			 * 예를 들어,
			 * case 1:{
			 * 	어쩌구저쩌구...
			 * }
			 * 와 같이 말이다.
			 */
			
			// 커맨드별 작업
			switch(command) {
			// 1. 계좌 생성하기
			case 1:
				// 배열이 꽉찬 경우
				if (totalAccounts >= accounts.length) {
					System.out.println("더이상 계좌를 생성할 수 없습니다.");
					break;
				}
				
				// 계좌 생성하기
				printCurrentTask("계좌생성");
				System.out.print("계좌번호: ");
				accountNo = sc.nextLine();
				System.out.print("계좌주: ");
				accountName = sc.nextLine();
				System.out.print("초기입금액: ");
				money = Integer.parseInt(sc.nextLine());
				
				accounts[totalAccounts++] = new Account(accountNo, accountName, money);
				System.out.println("결과: 계좌가 생성되었습니다.");
				break;
				
			// 2. 계좌목록 보여주기
			case 2:
				printCurrentTask("계좌목록");
				for (int i = 0; i < totalAccounts; i++)
					accounts[i].accountWrite();
				break;
				
			// 3. 예금
			case 3:
				printCurrentTask("예금");
				System.out.print("계좌번호: ");
				accountNo = sc.nextLine();
				System.out.print("예금액: ");
				money = Integer.parseInt(sc.nextLine());
				// 해당 계좌 찾아보기
				int addIndex = 0;
				for (addIndex = 0; addIndex < totalAccounts; addIndex++) {
					// 해당 계좌를 찾았다면, 인덱스를 저장한 채 탈출한다
					if (accounts[addIndex].isAccount(accountNo))
						break;
				}
				
				// 인덱스가 계좌개수 이내에 있다면 탐색성공, 그렇지 않다면 탐색실패
				if (addIndex < totalAccounts) {
					accounts[addIndex].addMoney(money);
					System.out.println("결과: 예금이 성공되었습니다.");
				}
				else {
					System.out.println("해당 계좌번호가 존재하지 않습니다.");
				}
				break;
				
			// 4. 출금
			case 4:
				printCurrentTask("출금");
				System.out.print("계좌번호: ");
				accountNo = sc.nextLine();
				System.out.print("출금액: ");
				money = Integer.parseInt(sc.nextLine());
				// 해당 계좌 찾아보기
				int subIndex = 0;
				for (subIndex = 0; subIndex < totalAccounts; subIndex++) {
					// 해당 계좌를 찾았다면, 인덱스를 저장한 채 탈출한다
					if (accounts[subIndex].isAccount(accountNo))
						break;
				}
				
				// 인덱스가 계좌개수 이내에 있다면 탐색성공, 그렇지 않다면 탐색실패
				if (subIndex < totalAccounts) {
					accounts[subIndex].subMoney(money);
					System.out.println("결과: 출금이 성공되었습니다.");
				}
				else {
					System.out.println("해당 계좌번호가 존재하지 않습니다.");
				}
				break;
				
			// 5. 종료
			case 5:
				break BankApp;
				
			// 그 외
			default:
				System.out.println("올바른 명령어를 입력해주세요.");
			} // switch
			System.out.println();
		} // while
		
		sc.close();
		System.out.println("프로그램 종료");
	} // main

} // class
