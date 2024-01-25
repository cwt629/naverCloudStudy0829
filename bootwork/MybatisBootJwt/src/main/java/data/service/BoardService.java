package data.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import data.dto.BoardDto;
import data.mapper.BoardMapper;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BoardService {
	private BoardMapper boardMapper;
	
	public int getTotalCount(String search)
	{
		return boardMapper.getTotalCount(search);
	}
	
	public List<BoardDto> getAllData(String search, int start, int perpage)
	{
		HashMap<String, Object> map = new HashMap<>();
		map.put("search", search);
		map.put("start", start);
		map.put("perpage", perpage);
		
		return boardMapper.getAllData(map);
	}
	
	public void insertBoard(BoardDto dto)
	{
		boardMapper.insertBoard(dto);
	}
	
	public BoardDto getDataByNum(int num)
	{
		return boardMapper.getDataByNum(num);
	}
	
	public void incrementReadcount(int num)
	{
		boardMapper.incrementReadcount(num);
	}
}
