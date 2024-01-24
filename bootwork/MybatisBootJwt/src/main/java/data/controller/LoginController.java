package data.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import data.dto.MemberDto;
import data.service.MemberService;
import lombok.RequiredArgsConstructor;
import security.setting.JwtTokenProvider;
import security.setting.UserAuthentication;

@RestController
@RequiredArgsConstructor
@CrossOrigin
public class LoginController {

	private final MemberService memberService;
	private final PasswordEncoder passwordEncoder;
	
	@PostMapping("/login/auth")
	public Map<String, Object> login(@RequestBody MemberDto dto)
	{
		Map<String, Object> map = new HashMap<>();
		// 해당 아이디에 대한 멤버가 있는지 가져오기
		MemberDto dto2 = memberService.getLogin(dto.getMyid());
		// 해당 아이디가 없는 경우
		if (dto2 == null) {
			map.put("result", "noid");
		} 
		// 해당 아이디가 있는 경우
		else {
			// 비번 얻어서 비교
			String dbPass = dto2.getPass();
			// 입력한 비번과 DB의 암호화된 비번이 맞을 경우 - 토큰 얻어서 보내기
			// result : success
			String pass = dto.getPass(); // 로그인 시 입력한 비번
			String myid = dto.getMyid(); // 로그인 시 입력한 아이디
			boolean matchesPass = passwordEncoder.matches(pass, dbPass);
			if (matchesPass)
			{
				// 비번이 맞는 경우
				map.put("result", "success");
				// 토큰 얻기
				Authentication auth = new UserAuthentication(myid, null, null);
				String token = JwtTokenProvider.generateToken(auth, myid);
				System.out.println("token = " + token);
				
				map.put("token", token);
			} else {
				// 비번이 맞지 않는 경우 - result : nopass
				map.put("result", "nopass");
			}
			
		}
		
		return map;
	}
}
