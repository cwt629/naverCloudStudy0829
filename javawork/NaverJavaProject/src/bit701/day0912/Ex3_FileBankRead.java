package bit701.day0912;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import bit701.day0911.Account;

public class Ex3_FileBankRead {
	// 파일은 (default대로) UTF-8로 저장해야 한글이 안 깨지고 잘 나온다!
	public static final String BANK_FILE = "D:/naver0829/Bank.txt";
	Account []account = new Account[30];
	int count;
	
	public Ex3_FileBankRead() throws IOException {
		// 파일에서 데이터를 읽어서 배열 account에 넣기
		count = 0; // 초기값 - 데이터를 담을 배열 번지
		
		// 참고: 지역 변수라 어차피 구역을 벗어나면 소멸됨...close 안해줘도 괜찮다.
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			fr = new FileReader(BANK_FILE);
			br = new BufferedReader(fr);
			
			while(true)
			{
				String accountNo = br.readLine();
				if (accountNo == null)
					break;
				String accountName = br.readLine();
				int money = Integer.parseInt(br.readLine());
				
				// 배열의 count번지에 담는다
				account[count] = new Account(accountNo, accountName, money);
				count++;
			}
			System.out.println("총 " + count + "개의 계좌를 읽음!");
		} catch (FileNotFoundException e) {
			// 해당 파일이 없을 경우 실행하는 영역
			System.out.println("파일이 없네요 ㅋㅋ");
		}
		
	}
	
	public static void showTitle()
	{
		System.out.println("-".repeat(20));
		System.out.println("  계좌 목록  ");
		System.out.println("-".repeat(20));
		System.out.println();
		System.out.println("계좌번호\t계좌명\t잔액");
		System.out.println("-".repeat(30));
	}
	
	// account 목록 출력(count 개수만큼)
	public void accountList()
	{
		/*
		 * 일반 메소드에서는 static 메소드 호출 가능.
		 * 하지만 static 메소드에서는 일반 메소드 호출 불가.
		 * 같은 static만 호출할 수 있다.
		 * 이것은 this가 없기 때문이다.
		 */
		showTitle(); // 제목 출력
		for (int i = 0; i < count; i++)
		{
			account[i].accountWrite();
		}
	}
	
	// 입금시 호출될 메소드
	public void depositMoney(String accountNo, int money)
	{
		boolean find = false;
		// 같은 계좌번호를 찾아서 입금을 한다
		for (int i = 0; i < count; i++)
		{
			if (account[i].isAccount(accountNo)) {
				find = true;
				account[i].addMoney(money);
				break;
			}
		}
		if (find)
			System.out.println(accountNo + " 계좌에 " + money + " 원을 입금했어요");
		else
			System.out.println(accountNo + " 계좌가 없네요!!!!");
	}
	
	// 출금시 호출될 메소드
	public void withdrawMoney(String accountNo, int money)
	{
		boolean find = false;
		
		for (int i = 0; i < count; i++)
		{
			if (account[i].isAccount(accountNo)) {
				find = true;
				account[i].subMoney(money);
				break;
			}
		}
		if (find)
			System.out.println(accountNo + " 계좌에서 " + money + " 원을 출금했어요");
		else
			System.out.println(accountNo + " 계좌가 없네요!!!!");
	}
	
	// 계좌 추가 시 호출될 메소드
	public void addAccount(String accountNo, String accountName, int money)
	{
		if (count == account.length) {
			System.out.println("이미 계좌가 다 찼어요. 삭제후 다시 추가하세요.");
			return; // 메소드가 여기서 종료
		}
		
		// 같은 계좌가 있는지 일단 파악하기
		boolean find = false;
		for (int i = 0; i < count; i++)
		{
			if (account[i].isAccount(accountNo)) {
				find = true;
				break;
			}
		}
		
		if (find)
			System.out.println(accountNo + " 계좌는 이미 존재합니다");
		else {
			// count번지에 생성자를 통해서 데이터 전달
			account[count] = new Account(accountNo, accountName, money);
			count++;
			System.out.println(accountNo + " 계좌를 추가했습니다");
		}
	}
	
	// 종료 시 배열의 내용을 파일에 저장할 메소드
	public void accountFileSave() throws IOException
	{
		FileWriter fw = null;
		fw = new FileWriter(BANK_FILE);
		for (int i = 0; i < count; i++)
		{
			fw.write(account[i].getAccountNo() + "\n");
			fw.write(account[i].getAccountName() + "\n");
			fw.write(account[i].getMoney() + "\n");
		}
		System.out.println("배열의 계좌정보를 파일에 저장했습니다!");
		fw.close(); // 지역변수더라도 이거 안닫아주니까 파일 저장이 안된다...
	}
	
	public static void main(String[] args) throws IOException {
		Ex3_FileBankRead ex = new Ex3_FileBankRead(); // 생성자 호출 - 파일 읽기
//		showTitle();
//		ex.accountList(); // 계좌 목록 출력
		
		Scanner sc = new Scanner(System.in);
		Exit:
		while (true)
		{
			System.out.println("1.계좌추가  2.입금  3.출금  4.저장&종료");
			System.out.print("선택> ");
			int num = Integer.parseInt(sc.nextLine());
			
			switch(num) {
			case 1:{
				// 추가할 계좌 정보 입력하기
				System.out.print("추가할 계좌번호는? ");
				String accountNo = sc.nextLine();
				System.out.print("예금주는? ");
				String accountName = sc.nextLine();
				System.out.print("초기 입금액은? ");
				int money = Integer.parseInt(sc.nextLine());
				
				// 추가할 메소드 호출
				ex.addAccount(accountNo, accountName, money);
				// 목록 다시한번 호출
				ex.accountList();
				break;
			}
			case 2:{ // 입금
				System.out.print("입금할 계좌번호는? ");
				String accountNo = sc.nextLine();
				System.out.print("입금할 금액은? ");
				int money = Integer.parseInt(sc.nextLine());
				// 입금처리할 멤버 메소드 호출
				ex.depositMoney(accountNo, money);
				// 계좌 목록 출력
				ex.accountList();
				break;
			}
			case 3:{ // 출금
				System.out.print("출금할 계좌번호는? ");
				String accountNo = sc.nextLine();
				System.out.print("출금할 금액은? ");
				int money = Integer.parseInt(sc.nextLine());
				// 출금처리할 멤버 메소드 호출
				ex.withdrawMoney(accountNo, money);
				// 계좌 목록 출력
				ex.accountList();
				break;
			}
			default:
				ex.accountFileSave(); // 배열 내용을 파일에 저장하기
				System.out.println("파일 저장후 종료합니다");
				break Exit; // while문을 빠져나간다
			} // switch
		} // while
	} // main

} // class
