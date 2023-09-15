package bit701.day0915;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SelfAssignment extends JFrame{
	JButton btnCar, btnShop, btnCeleb, btnAnimal; 
	Image image;
	MyCanvas myCanvas = new MyCanvas();
	static String CAR_URL = "D:\\naver0829\\image\\mycar\\mycar2.png";
	static String SHOP_URL_BASE = "D:\\naver0829\\image\\shop\\";
	static String CELEB_URL = "D:\\naver0829\\image\\연예인사진\\4.jpg";
	static String ANIMAL_URL_BASE = "D:\\naver0829\\image\\이쁜동물이미지\\";
	String shopURL, animalURL;

	public SelfAssignment(String title) {
		super(title); // JFrame의 문자열을 받는 생성자 호출: default가 아니므로 생략 불가능
		this.setLocation(300, 100); // 프레임의 시작 위치
		this.setSize(500, 600); // 프레임의 너비와 높이
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
		// 처음 시작시 자동호출, 그리고 프레임 크기 변경 시에도 자동호출
		@Override
		public void paint(Graphics g) {
			super.paint(g);
			//System.out.println(image.getWidth(this));
			if (image.getWidth(this) >= 300)
				g.drawImage(image, 60, 10, 370, 450, this);
			else // 300 미만 너비를 가진 이미지는 원래 사이즈대로 출력
				g.drawImage(image, 60, 10, this);
		}
	}

	private void setDesign() {
		JPanel panel = new JPanel();
		// 패널에 버튼 추가
		btnCar = new JButton("자동차");
		btnShop = new JButton("랜덤 쇼핑 아이템");
		btnCeleb = new JButton("연예인");
		btnAnimal = new JButton("귀여운 동물 뽑기!");
		panel.add(btnCar);
		panel.add(btnShop);
		panel.add(btnCeleb);
		panel.add(btnAnimal);

		// 패널을 캔버스에 추가
		this.add(panel, "North");
		
		// 초기 이미지는 car로 해주자.
		image = new ImageIcon(CAR_URL).getImage();
		
		this.add("Center", myCanvas);
		
		// 버튼 클릭 이벤트들
		// 1. 자동차 버튼
		btnCar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				image = new ImageIcon(CAR_URL).getImage();
				myCanvas.repaint();
			}
		});
		
		// 2. 쇼핑몰 버튼(랜덤으로 나오게)
		btnShop.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 1~34까지 난수 생성
				int randNum = (int)(Math.random() * 34) + 1;
				String end = (randNum == 24)? ".gif" : ".jpg";
				String randomShopURL = randNum + end;
				shopURL = SHOP_URL_BASE + randomShopURL;
				
				image = new ImageIcon(shopURL).getImage();
				myCanvas.repaint();
			}
		});
		
		// 3. 연예인 버튼
		btnCeleb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				image = new ImageIcon(CELEB_URL).getImage();
				myCanvas.repaint();
			}
		});
		
		// 4. 귀여운동물 버튼(랜덤으로 나오게)
		btnAnimal.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 1~8까지 난수 생성
				int randNum = (int)(Math.random() * 8) + 1;
				String randomPhotoURL = "C" + randNum + ".png";
				animalURL = ANIMAL_URL_BASE + randomPhotoURL;
				
				image = new ImageIcon(animalURL).getImage();
				myCanvas.repaint();
			}
		});
		
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
		SelfAssignment s = new SelfAssignment("마음대로 전시회");
	}


}
