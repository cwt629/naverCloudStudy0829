package mini.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import mini.dao.BoardDao;
import mini.dto.BoardDto;

@Service
@AllArgsConstructor
public class BoardService {
	
	private BoardDao boardDao;
	
	public int getTotalCount()
	{
		return boardDao.getTotalCount();
	}
	
	public List<BoardDto> getList(int start, int perpage)
	{
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("start", start);
		map.put("perpage", perpage);
		
		return boardDao.getList(map);
	}
	
	public int getMaxNum()
	{
		return boardDao.getMaxNum();
	}
	
	public void updateRestep(int regroup, int restep)
	{
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("regroup", regroup);
		map.put("restep", restep);
		
		boardDao.updateRestep(map);;
	}
	
	public void insertBoard(BoardDto dto)
	{
		int num = dto.getNum(); // �� ���� ��� 0, ����� ��� 1 �̻�
		int regroup = dto.getRegroup(); // ����� �޷��� �ϴ� ���� regroup
		int restep = dto.getRestep(); // ����� �޷��� �ϴ� ���� restep
		int relevel = dto.getRelevel(); // ����� �޷��� �ϴ� ���� relevel
		
		if (num == 0) {
			// �� ���� ���
			regroup = boardDao.getMaxNum() + 1;
			restep = 0;
			relevel = 0;
			
		} else {
			// ����� ���
			// (�׷��� �״�� ����ϹǷ�, regroup�� ���� ������ ����)
			
			// 1. ���� �׷� �� ���޹��� restep���� ū restep�� ���� �۵��� restep + 1
			this.updateRestep(regroup, restep); 
			// 2. �� ���� 1 �����ֱ�
			restep = restep + 1;
			relevel = relevel + 1;
		}
		
		// ���� ���� ���� ������ �ٽ� dto�� ��´�
		dto.setRegroup(regroup);
		dto.setRestep(restep);
		dto.setRelevel(relevel);
		
		// db insert
		boardDao.insertBoard(dto);
	}
	
	public void updateReadCount(int num)
	{
		boardDao.updateReadCount(num);
	}
	
	public BoardDto getData(int num)
	{
		return boardDao.getData(num);
	}
	
	/* 20231124 */
	
	public void updateBoard(BoardDto dto)
	{
		boardDao.updateBoard(dto);
	}
	
	public void deleteBoard(int num)
	{
		boardDao.deleteBoard(num);
	}
}
