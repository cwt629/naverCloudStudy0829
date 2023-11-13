package study.spring.day1113;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DataReadController {
	
//	@GetMapping("/process1")
//	public String process1(HttpServletRequest request, Model model)
//	{
//		// jsp처럼 읽어보자(스프링에서는 이렇게 읽지는 않음)
//		String name = request.getParameter("name");
//		String addr = request.getParameter("addr");
//		int age = Integer.parseInt(request.getParameter("age"));
//		
//		model.addAttribute("name", name);
//		model.addAttribute("addr", addr);
//		model.addAttribute("age", age + "세는 " + (age >= 20? "성인" : "미성년자") + "입니다");
//		
//		return "result1";
//	}
	
	@GetMapping("/process1")
	// @RequestParam("폼태그의 name") String 변수명 : 폼태그의 name과 변수명이 같으면, name은 생략 가능
	// @RequestParam 자체가 사실 생략 가능함(하지만 다른 어노테이션으로 잘못 인식하는 경우를 방지하기 위해 생략안하는걸 권고)
	public String process1(Model model, @RequestParam("name") String irum, @RequestParam String addr, @RequestParam int age)
	{
		model.addAttribute("name", irum);
		model.addAttribute("addr", addr);
		model.addAttribute("age", age + " 세는 " + (age >= 20? "성인" : "미성년자") + "입니다");
		return "result1";
	}
	
	@PostMapping("/process2")
	public String process2(Model model, @RequestParam String message, @RequestParam String animal
			, @RequestParam(defaultValue = "다니엘", required = false) String name)
	{
		System.out.println(name); // 넘어오는 name이 없으면 null 나옴(defaultValue 있으면 그값 나옴)
		// form에 없는 데이터면? Required String parameter 'name' is not present(에러코드 400)
		model.addAttribute("name", name); // required = false를 넣어주면, 안넘어와도 오류가 나오지 않음
		model.addAttribute("message", message);
		model.addAttribute("animal", animal);
		
		return "result2";
	}
	
	// @ModelAttribute : dto와 같은 이름의 폼태그를 읽어 모델에 저장
	// (이 역시 생략은 가능하지만 권장하진 않음)
	@PostMapping("/process3")
	// dto에 없는 데이터는 RequestParam으로 읽어와준다
	public String process3(@ModelAttribute ShopDto dto, @RequestParam String today, Model model) // model에 shopDto라는 이름으로 저장
	// public String process3(@ModelAttribute("dto") ShopDto dto) // model에 dto라는 이름으로 저장
	{
		model.addAttribute("today", today);
		return "result3";
	}
	
	@PostMapping("/process4")
	public String process4(Model model, @RequestParam Map<String, String> map) // 폼태그의 name이 key, 입력값이 value로 저장
	{
		model.addAttribute("sang", map.get("sang"));
		model.addAttribute("su", map.get("su"));
		model.addAttribute("dan", map.get("dan"));
		model.addAttribute("color", map.get("color"));
		model.addAttribute("photo", map.get("photo"));
		model.addAttribute("today", map.get("today"));
		
		return "result4";
	}
}
