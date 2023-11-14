package board.data;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository // bean을 자동 등록해주는 어노테이션 : dao에 붙인다
public class BoardDao {
	
	@Autowired
	private SqlSession session;
	
	// 매번 board.data.BoardDao.totalCountOfBoard 처럼 불러오기 번거로우므로, 앞부분은 미리 가져옴
	private String nameSpace = "board.data.BoardDao.";
	
	// 전체 갯수 반환하는 메소드
	public int getTotalCount()
	{
		return session.selectOne(nameSpace + "totalCountOfBoard");
	}
}
