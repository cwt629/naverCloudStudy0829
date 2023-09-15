package bit701.day0915;

import java.awt.Color;
import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Ex6_FileMemoFrame extends JFrame{
	JTextArea memoArea;
	JButton btnSave, btnOpen, btnClear;

	public Ex6_FileMemoFrame(String title) {
		super(title); // JFrame의 문자열을 받는 생성자 호출: default가 아니므로 생략 불가능
		this.setLocation(300, 100); // 프레임의 시작 위치
		this.setSize(500, 600); // 프레임의 너비와 높이
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
		btnSave = new JButton("파일저장");
		btnOpen = new JButton("파일열기");
		btnClear = new JButton("내용지우기");

		JPanel p = new JPanel();
		p.add(btnSave);
		p.add(btnOpen);
		p.add(btnClear);

		// Panel을 North에 추가
		this.add(p, "North");

		memoArea = new JTextArea("내용을 입력해보세요");
		//this.add(memoArea, "Center"); // 데이터가 길면 스크롤바가 안생겨서 아래가 안보인다

		// 스크롤바가 생기게 하려면 JScrollPane 활용
		this.add(new JScrollPane(memoArea), "Center"); // 스크롤바가 생김

		// 버튼: 내용지우기
		btnClear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				memoArea.setText("");
			}
		});

		// 버튼: 파일저장
		btnSave.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FileDialog dlg = new FileDialog(Ex6_FileMemoFrame.this, "메모장저장", FileDialog.SAVE);
				dlg.setVisible(true);
				//				System.out.println("디렉토리: " + dlg.getDirectory());
				//				System.out.println("파일명: " + dlg.getFile());

				// 취소 시 메소드 종료(디렉토리와 파일명 모두 null)
				if (dlg.getDirectory() == null)
					return;

				String fileName = dlg.getDirectory() + dlg.getFile() + ".txt";
				String memoText = memoArea.getText(); // 저장할 내용

				FileWriter fw = null;
				try {
					fw = new FileWriter(fileName);
					// 내용 저장
					fw.write(memoText);
					// 메모장에 메세지 넣기
					memoArea.setText("저장되었습니다");
				} catch (IOException e1) {
					System.out.println("메모장 저장하다가 오류가 났습니다. " + e1.getMessage());
				} finally {
					try {
						fw.close();
					} catch (NullPointerException|IOException e1) {
						// close 시 나올만한 Exception 두개 나열
					}
				}
			}
		});

		// 버튼: 파일열기
		btnOpen.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FileReader fr = null;
				BufferedReader br = null;
				FileDialog dlg = new FileDialog(Ex6_FileMemoFrame.this, "메모장열기", FileDialog.LOAD);
				dlg.setVisible(true);

				// 취소 시 메소드 종료(디렉토리와 파일명 모두 null)
				if (dlg.getDirectory() == null)
					return;

				String fileName = dlg.getDirectory() + dlg.getFile();



				// 파일로부터 한줄한줄 읽어서 덧붙여줌
				try {
					fr = new FileReader(fileName); // 줄단위로 읽는 멤버메소드가 없다... 그래서 2차 생성을 하겠다.
					br = new BufferedReader(fr);

					// 불러온 경우 기존 내용 삭제
					memoArea.setText("");
					
					// br.readLine() : 한줄씩 읽는다. 더이상 읽을 내용이 없다면 null값 반환
					// 대부분 두줄 이상이고 몇줄이 저장되어 있는지 모르므로
					// while문으로 처리한다.
					while (true)
					{
						// 파일의 내용을 한줄씩 읽는다
						String line = br.readLine();
						// 더이상 읽을 내용이 없을 경우 while문 탈출
						if (line == null) 
							break;
						memoArea.append(line + "\n");
					}
				} catch (FileNotFoundException e2) {
					// 해당 파일이 없을 경우 예외가 발생하며 catch 영역이 실행된다
					System.out.println("해당 파일을 찾을 수 없어요. " + e2.getMessage());
				} catch (IOException e3) {
					System.out.println("입출력에 문제가 있네요. " + e3.getMessage());
				} finally {
					try {
						br.close();
						fr.close();
					} catch (NullPointerException|IOException e1) {
						// close 시 나올만한 Exception 두개 나열
					}
				}
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
		Ex6_FileMemoFrame s = new Ex6_FileMemoFrame("간단한 메모장");
	}


}
