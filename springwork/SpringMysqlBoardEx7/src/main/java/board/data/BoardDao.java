package board.data;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository // bean�� �ڵ� ������ִ� ������̼� : dao�� ���δ�
public class BoardDao {
	
	@Autowired
	private SqlSession session;
	
	// �Ź� board.data.BoardDao.totalCountOfBoard ó�� �ҷ����� ���ŷο�Ƿ�, �պκ��� �̸� ������
	private String nameSpace = "board.data.BoardDao.";
	
	// ��ü ���� ��ȯ�ϴ� �޼ҵ�
	public int getTotalCount()
	{
		// nameSpace ��� ������ ���� �ʴµ�, �ٸ� ���� �Ǽ��� ���� ���̵� ����� ���� �߻�
		return session.selectOne(nameSpace + "totalCountOfBoard");
	}
	
	public void insertBoard(BoardDto dto)
	{
		session.insert(nameSpace + "insertBoard", dto);
	}
	
	public List<BoardDto> getAllDatas()
	{
		return session.selectList(nameSpace + "selectAllBoard");
	}
	
	public void updateReadcount(int num)
	{
		session.update(nameSpace + "updateReadcount", num);
	}
	
	public BoardDto getData(int num)
	{
		return session.selectOne(nameSpace + "selectOneData", num);
	}
	
	// TODO : delete
	public void deleteBoard(int num)
	{
		session.delete(nameSpace + "deleteOneData", num);
	}
	
	public void updateBoard(BoardDto dto)
	{
		session.update(nameSpace + "updateBoard", dto);
	}
}
