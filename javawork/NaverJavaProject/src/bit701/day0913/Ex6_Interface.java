package bit701.day0913;

interface InterJobA
{
	public void insertDb();
	public void deleteDb();
}

// interface끼리의 상속은 extends 이용
interface InterJobB extends InterJobA
{
	public void selectJob();
	public void updateJob();
}

class JobOne implements InterJobA
{

	@Override
	public void insertDb() {
		// TODO Auto-generated method stub
		System.out.println("학생 추가 DB 작업을 수행함!");
	}

	@Override
	public void deleteDb() {
		// TODO Auto-generated method stub
		System.out.println("학생 제거 DB 작업을 수행함!");
	}
	
}

// (선생님은 extends JobOne 안하고 그냥 바로 implements InterJobB 해서, 4개 모두 받아 기능 구현하셨음)
class JobTwo extends JobOne implements InterJobB
{

	@Override
	public void selectJob() {
		// TODO Auto-generated method stub
		System.out.println("학생 정보 선택 작업을 수행함!");
	}

	@Override
	public void updateJob() {
		// TODO Auto-generated method stub
		System.out.println("학생 정보 수정 작업을 수행함!");
	}
	
}

public class Ex6_Interface {

	public static void main(String[] args) {
		InterJobA a = new JobOne();
		a.insertDb();
		a.deleteDb();
		System.out.println("-----------------------------");
		
		InterJobB b = new JobTwo();
		b.insertDb();
		b.deleteDb();
		b.selectJob();
		b.updateJob();
	}

}
