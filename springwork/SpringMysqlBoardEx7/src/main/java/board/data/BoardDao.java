package board.data;

import java.util.List;

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
		// nameSpace 없어도 오류가 나진 않는데, 다른 곳에 실수로 같은 아이디 만들면 오류 발생
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
