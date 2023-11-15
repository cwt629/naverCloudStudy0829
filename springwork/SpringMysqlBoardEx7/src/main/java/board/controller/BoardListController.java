package board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import board.data.BoardDao;
import board.data.BoardDto;
import lombok.AllArgsConstructor;

@Controller
// @AllArgsConstructor // 어차피 하나밖에 없으므로 AllArgsConstructor로 주입해도 됨
public class BoardListController {
	@Autowired 
	private BoardDao boardDao;
	
	@GetMapping("/simple/list")
	public String list(Model model)
	{
		// 전체 갯수 가져오기
		int totalCount = boardDao.getTotalCount();
		// 전체 데이터 가져오기
		List<BoardDto> list = boardDao.getAllDatas();
		
		// model에 저장
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("list", list);
		
		return "list";
	}
}
