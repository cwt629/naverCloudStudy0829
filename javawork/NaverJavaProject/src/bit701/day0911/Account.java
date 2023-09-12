package bit701.day0911;

// 교재 p281(클래스 문제부분) 20번 문제
public class Account {
	private String accountNo; // 계좌번호
	private String accountName; // 계좌주
	private int money; // 잔액

	// 3개의 값을 전달받는 생성자
	public Account(String accountNo, String accountName, int money) {
		this.accountNo = accountNo;
		this.accountName = accountName;
		this.money = money;
	}

	// 계좌번호가 맞을 경우 true를 반환해주는 메소드(isAccount(String accountNo))
	// 맞으면 true, 틀리면 false 반환
	public boolean isAccount(String accountNo) {
		return this.accountNo.equals(accountNo);
	}

	// 외부에서 입금시 money에 추가하는 메소드(addMoney)
	public void addMoney(int cash) {
		this.money += cash;
	}

	// 외부에서 출금시 money에서 빼는 메소드(subMoney)
	public void subMoney(int cash) {
		//		if (this.money < cash) {
		//			System.out.println("잔액보다 큰 금액을 출금할 수 없습니다.");
		//			return;
		//		}

		this.money -= cash;
	}

	// 출력해주는 메소드(accountWrite)
	// 계좌번호, 예금주, 잔액을 옆으로 나오게 출력
	public void accountWrite() {
		System.out.println(accountNo + "\t" + accountName + "\t" + money);
	}

	// getter methods

	public String getAccountNo() {
		return accountNo;
	}

	public String getAccountName() {
		return accountName;
	}

	public int getMoney() {
		return money;
	}


}
