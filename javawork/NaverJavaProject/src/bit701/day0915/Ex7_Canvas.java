package bit701.day0915;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Ex7_Canvas  extends JFrame{
	// 캔버스 멤버 변수로 선언
	MyCanvas myCanvas = new MyCanvas();

	public Ex7_Canvas(String title) {
		super(title); // JFrame의 문자열을 받는 생성자 호출: default가 아니므로 생략 불가능
		this.setLocation(300, 100); // 프레임의 시작 위치
		this.setSize(500, 500); // 프레임의 너비와 높이
		//this.getContentPane().setBackground(Color.green); // Color 상수 이용해서 변경. 근데 그냥 하면 실제 요소가 바뀌지 않으므로 ContentPane으로 받아옴
		//this.getContentPane().setBackground(new Color(200, 255, 180)); // 0~255의 rgb

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

	// 캔버스 내부 클래스
	class MyCanvas extends Canvas{
		String imageIcon1 = "D:\\naver0829\\image\\이쁜동물이미지\\C7.png";
		
		@Override
		public void paint(Graphics g) {
			super.paint(g);
			// 원 그리기
			g.setColor(new Color(255, 100, 255)); // 선색
			g.drawOval(50, 50, 100, 100); // 테두리선만 있는 원
			
			// 채워진 원
			g.setColor(Color.orange);
			g.fillOval(200,  50, 100, 100);
			
			// 테두리만 있는 사각형
			g.setColor(Color.green);
			g.drawRect(50, 200, 100, 100);
			
			// 채워진 사각형
			g.setColor(Color.pink);
			g.fillRect(200, 200, 100, 100);
			
			Image image1 = new ImageIcon(imageIcon1).getImage();
			// 이미지 그리기
			g.drawImage(image1, 300, 220, this);
			
			// 크기 변경해서 출력
			g.drawImage(image1, 300, 30, 100, 100, this);
		}
	}

	private void setDesign() {
		this.add(myCanvas, "Center");
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
		Ex7_Canvas s = new Ex7_Canvas("캔버스");
	}

}
