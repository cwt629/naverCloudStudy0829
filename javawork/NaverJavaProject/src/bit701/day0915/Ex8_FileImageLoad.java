package bit701.day0915;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.FileDialog;
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

public class Ex8_FileImageLoad extends JFrame{
	JButton btnImageFile;
	String initImage = "D:\\naver0829\\image\\연예인사진\\18.jpg";
	Image image;
	MyCanvas myCanvas = new MyCanvas();
	
	public Ex8_FileImageLoad(String title) {
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
		// 상단에는 패널 안에 버튼 추가 후, 프레임에 패널 추가
		JPanel p = new JPanel();
		btnImageFile = new JButton("이미지파일 가져오기");
		p.add(btnImageFile);
		this.add("North", p);
		
		// 사진을 Image로 변환
		image = new ImageIcon(initImage).getImage();
		
		this.add("Center", myCanvas);
		
		// 파일 버튼 이벤트
		btnImageFile.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 이미지파일 가져오기
				FileDialog dlg = new FileDialog(Ex8_FileImageLoad.this, "이미지열기", FileDialog.LOAD);
				dlg.setVisible(true);
				
				// 취소 시 종료
				if (dlg.getDirectory() == null)
					return;
				
				initImage = dlg.getDirectory() + dlg.getFile();
				
				// image 생성
				image = new ImageIcon(initImage).getImage();
				
				/*
				 * 캔버스의 paint 메소드는
				 * 버튼을 누른다고 자동호출되지 않는다.
				 * 
				 * 그러므로, 강제로 호출해줘야 한다.
				 */
				myCanvas.repaint();
			}
		});
	}

	public static void main(String[] args) {
		Ex8_FileImageLoad s = new Ex8_FileImageLoad("이미지 뷰어");
	}

}
