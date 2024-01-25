package data.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import data.dto.BoardDto;

@Mapper
public interface BoardMapper {

	public int getTotalCount(String search);
	public List<BoardDto> getAllData(HashMap<String, Object> map);
	public void insertBoard(BoardDto dto);
	public BoardDto getDataByNum(int num);
	public void incrementReadcount(int num);
}
