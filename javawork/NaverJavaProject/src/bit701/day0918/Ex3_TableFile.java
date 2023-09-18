package bit701.day0918;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Ex3_TableFile extends JFrame{
	JTable table;
	DefaultTableModel model;
	JTextField tfName, tfAge, tfAddr;
	JButton btnAdd;
	// 파일 이름
	final static String FILENAME = "D:\\naver0829\\member.txt";
	
	public Ex3_TableFile(String title) {
		super(title); // JFrame의 문자열을 받는 생성자 호출: default가 아니므로 생략 불가능
		this.setLocation(300, 100); // 프레임의 시작 위치
		this.setSize(400, 300); // 프레임의 너비와 높이
		
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
				// 종료 전에 테이블의 내용을 member.txt에 추가
				FileWriter fw = null;
				try {
					fw = new FileWriter(FILENAME, true); // 기존파일에 추가, 없으면 새로생성
					// 행 갯수
					int row = table.getRowCount();
					
					for (int i = 0; i < row; i++)
					{
						String name = (String)model.getValueAt(i, 0);
						String age = (String)model.getValueAt(i, 1);
						String addr = (String)model.getValueAt(i, 2);
						
						fw.write(name + "," + age + "," + addr + "\n");
					}
					
				} catch (IOException e1) {
					e1.printStackTrace();
				} finally {
					try {
						fw.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
				
				// 실제 종료
				System.exit(0); // 정상 종료: 0
				super.windowClosing(e);
			}
		});
	}
	
	private void setDesign() {
		JPanel p = new JPanel();
		tfName = new JTextField(4);
		tfAge = new JTextField(3);
		tfAddr = new JTextField(5);
		
		btnAdd = new JButton("추가");
		p.add(new JLabel("이름"));
		p.add(tfName);
		p.add(new JLabel("나이"));
		p.add(tfAge);
		p.add(new JLabel("주소"));
		p.add(tfAddr);
		p.add(btnAdd);
		
		this.add("North", p);
		
		// table 생성
		model = new DefaultTableModel(new String[] {"이름", "나이", "주소"}, 0); // 행 개수는 일단 0개로 설정
		table = new JTable(model);
		this.add("Center", new JScrollPane(table));
		
		// 버튼 이벤트
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 1. 입력값을 Vector에 넣는다
				Vector<String> data = new Vector<String>();
				data.add(tfName.getText());
				data.add(tfAge.getText());
				data.add(tfAddr.getText());
				
				// 2. addRow 메소드로 행을 추가한다
				model.addRow(data);
				
				// 3. 입력한 값들을 지운다
				tfName.setText("");
				tfAge.setText("");
				tfAddr.setText("");
			}
		});
	}

	public static void main(String[] args) {
		Ex3_TableFile s = new Ex3_TableFile("Table-File");
	}


}
