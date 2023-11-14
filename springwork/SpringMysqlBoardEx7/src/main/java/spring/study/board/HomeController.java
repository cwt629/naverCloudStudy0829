package spring.study.board;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HomeController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		// home으로 오더라도 /simple/list로 자동 리다이렉트
		return "redirect:./simple/list";
	}
	
}
