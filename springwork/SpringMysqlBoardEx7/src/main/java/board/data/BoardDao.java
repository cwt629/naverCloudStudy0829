package board.data;

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
		return session.selectOne(nameSpace + "totalCountOfBoard");
	}
}
