package bit701.day0915;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Ex5_ArrayButton  extends JFrame{
	JButton []btn = new JButton[6];
	String []buttonTitle = {"노랑", "오렌지", "분홍", "핫핑크", "초록", "빨강"};
	Color []buttonColor = {Color.yellow, Color.orange, Color.pink, Color.magenta, Color.green, Color.red};
	
	public Ex5_ArrayButton(String title) {
		super(title); // JFrame의 문자열을 받는 생성자 호출: default가 아니므로 생략 불가능
		this.setLocation(300, 100); // 프레임의 시작 위치
		this.setSize(300, 300); // 프레임의 너비와 높이
		//this.getContentPane().setBackground(Color.green); // Color 상수 이용해서 변경. 근데 그냥 하면 실제 요소가 바뀌지 않으므로 ContentPane으로 받아옴
		this.getContentPane().setBackground(new Color(200, 255, 180)); // 0~255의 rgb
		
		// 디자인이나 이벤트를 구현할 메소드 호출
		this.setDesign();
		
		this.setVisible(true); // true: 프레임 보이게 하기 / false: 프레임 숨기기
		
		// 윈도우 이벤트 발생 - 익명 내부 클래스 형태로 이벤트 구현
		/*
		 * 인자는 WindowListener 타입이지만, 이 타입은
		 * 오버라이드해야하는 메소드가 매우 많으므로
		 * 원하는 메소드만 오버라이드할 수도 있는
		 * WindowAdapter 클래스를 활용한다.
		 */
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) { // x버튼 클릭시 호출되는 메소드
				//JOptionPane.showMessageDialog(SwingGibon.this, "프레임을 종료합니다"); // 자바스크립트의 alert 느낌
				// 실제 종료
				System.exit(0); // 정상 종료: 0
				super.windowClosing(e);
			}
		});
	}
	
	private void setDesign() {
		// 레이아웃 변경
		this.setLayout(new FlowLayout()); // 순서대로 나열
		
		for (int i = 0; i < btn.length; i++)
		{
			btn[i] = new JButton(buttonTitle[i]);
			btn[i].setBackground(buttonColor[i]);
			this.add(btn[i]);
		}
	}

	/*
	 * 주의할 점:
	 * 뜨는 윈도우창에 x를 누른다 해서
	 * 프로그램이 완전히 종료되는 것이 아니다.
	 * 그러므로, 콘솔에서 terminate을 시켜주거나
	 * 작업관리자에서 실행파일을 꺼줘야 한다.
	 * (작업관리자-자세히 에서 보면 javaw.exe 로 실행파일이 쌓임)
	 */
	public static void main(String[] args) {
		Ex5_ArrayButton s = new Ex5_ArrayButton("배열 버튼");
	}


}
