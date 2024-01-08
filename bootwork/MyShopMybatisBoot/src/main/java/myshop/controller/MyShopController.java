package myshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;
import myshop.service.MyShopService;

@Controller
// final이나 @notnull 붙은 것만 생성자 주입
@RequiredArgsConstructor
public class MyShopController {
	private final MyShopService shopService;
	
	@GetMapping("/")
	public String list(Model model)
	{
		// 총 개수를 얻어온다
		int totalCount = shopService.getTotalCount();
		// model에 저장
		model.addAttribute("totalCount", totalCount);
		return "myshop/shoplist";
	}
}
