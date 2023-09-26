package bit701.day0926;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import db.DbConnect;

public class Ex2_SawonSwingCRUD extends JFrame {
	JTextField tfName, tfScore;
	JComboBox<String> cbGender, cbBuseo;
	JTable table;
	DefaultTableModel tableModel;
	JButton btnAdd, btnDel, btnSearch, btnAll;

	DbConnect db = new DbConnect();

	public Ex2_SawonSwingCRUD() {
		super("사원관리");
		this.setBounds(1000, 100, 550, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setDesign();
		this.setVisible(true);
	}

	private void setDesign() {
		// 상단: 이름, 점수, 성별, 부서
		tfName = new JTextField(4);
		tfScore = new JTextField(4);
		String []genders = {"남자", "여자"};
		String []depts = {"홍보부", "인사부", "교육부", "사업부", "총무부", "체육부"};
		cbGender = new JComboBox<String>(genders);
		cbBuseo = new JComboBox<String>(depts);

		JPanel pTop = new JPanel();
		pTop.add(new JLabel("이름"));
		pTop.add(tfName);
		pTop.add(new JLabel("점수"));
		pTop.add(tfScore);
		pTop.add(new JLabel("성별"));
		pTop.add(cbGender);
		pTop.add(new JLabel("부서"));
		pTop.add(cbBuseo);

		this.add("North", pTop);

		// 하단
		btnAdd = new JButton("추가");
		btnDel = new JButton("삭제");
		btnSearch = new JButton("검색");
		btnAll = new JButton("전체조회");

		JPanel pBottom = new JPanel();
		pBottom.add(btnAdd);
		pBottom.add(btnDel);
		pBottom.add(btnSearch);
		pBottom.add(btnAll);

		// 버튼 이벤트
		btnAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 데이터 가져오기
				String name = tfName.getText();
				
				// 이름이나 점수를 입력하지 않은 경우, 아무 것도 하지 않는다
				if (name.length() == 0) {
					JOptionPane.showMessageDialog(Ex2_SawonSwingCRUD.this, "이름과 점수를 모두 입력해주세요");
					return;
				}
					
				
				int score = 0;
				try {
					score = Integer.parseInt(tfScore.getText());
				} catch (NumberFormatException e1) {
					score = 0;
				}
				String gender = (String)cbGender.getSelectedItem();
				String buseo = (String)cbBuseo.getSelectedItem();

				if (score < 0 || score > 100) {
					JOptionPane.showMessageDialog(Ex2_SawonSwingCRUD.this, "점수는 0-100 사이값으로 입력해주세요");
					return;
				}

				// db에 insert
				insertSawon(name, score, gender, buseo);
				// db로부터 다시 데이터 가져와 출력
				sawonSelectAll();

				// 입력값 초기화시켜줌
				tfName.setText("");
				tfScore.setText("");
			}
		});

		btnDel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 선택한 행의 번호 읽기
				int row = table.getSelectedRow();
				if (row == -1)
					JOptionPane.showMessageDialog(Ex2_SawonSwingCRUD.this, "삭제할 행을 선택해주세요");
				else {
					String num = table.getValueAt(row, 0).toString();
					deleteSawon(num);
					// 삭제 후 데이터 다시 불러오기
					sawonSelectAll();
				}
			}
		});

		btnSearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 검색할 이름 입력받기
				String searchName = JOptionPane.showInputDialog("검색할 부서 이름을 입력해주세요");
				if (searchName == null) return;

				searchSawon(searchName);
			}
		});

		btnAll.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				sawonSelectAll();
			}
		});

		this.add("South", pBottom);

		// Center : Table
		String []title = {"번호", "이름", "점수", "성별", "부서"};
		tableModel = new DefaultTableModel(title, 0);
		table = new JTable(tableModel);
		this.add("Center", new JScrollPane(table));

		// 초기 db 데이터 가져오기
		sawonSelectAll();
	}

	public static void main(String[] args) {
		Ex2_SawonSwingCRUD ex = new Ex2_SawonSwingCRUD();
	}

	// db methods

	// db에서 전체 데이터 가져와서 테이블에 출력하는 메소드
	public void sawonSelectAll()
	{
		// 기존 테이블 데이터 지우기
		tableModel.setRowCount(0);

		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from sawon order by num desc";

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();


			while (rs.next())
			{
				Vector<String> data = new Vector<String>();
				String num = rs.getString("num");
				String name = rs.getString("name");
				String score = rs.getString("score");
				String gender = rs.getString("gender");
				String buseo = rs.getString("buseo");

				// Vector에 순서대로 추가
				data.add(num);
				data.add(name);
				data.add(score);
				data.add(gender);
				data.add(buseo);

				// 테이블에 추가
				tableModel.addRow(data);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}
	}

	// db에 데이터 추가하는 메소드
	public void insertSawon(String name, int score, String gender, String buseo)
	{
		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;

		String sql = "insert into sawon values (null, ?, ?, ?, ?)";

		try {
			pstmt = conn.prepareStatement(sql);
			// ? 4개 바인딩
			pstmt.setString(1, name);
			pstmt.setInt(2, score);
			pstmt.setString(3, gender);
			pstmt.setString(4, buseo);

			// 실행
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}

	// db에서 데이터 삭제하는 메소드
	public void deleteSawon(String num)
	{
		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;

		String sql = "delete from sawon where num = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);

			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}

	private void searchSawon(String searchName) {
		// 기존 테이블 데이터 지우기
		tableModel.setRowCount(0);

		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from sawon where buseo like ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, searchName);
			rs = pstmt.executeQuery();


			while (rs.next())
			{
				Vector<String> data = new Vector<String>();
				String num = rs.getString("num");
				String name = rs.getString("name");
				String score = rs.getString("score");
				String gender = rs.getString("gender");
				String buseo = rs.getString("buseo");

				// Vector에 순서대로 추가
				data.add(num);
				data.add(name);
				data.add(score);
				data.add(gender);
				data.add(buseo);

				// 테이블에 추가
				tableModel.addRow(data);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}
	}
}
