package person.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import person.data.PersonDao;
import person.data.PersonDto;

@CrossOrigin // 데이터 잘 못 가져오는 경우 추가해주자.
@RestController
@RequiredArgsConstructor
public class PersonController {

	private final PersonDao personDao;
	
	// 추가
	@PostMapping("/person/add")
	// 여기서는 json을 받으려면 ModelAttribute가 아니라 RequestBody로 받아야 함
	public void insert(@RequestBody PersonDto dto)
	{
		System.out.println("add >> " + dto);
		// db insert
		personDao.insertPerson(dto);
	}
	
	// 출력
	@GetMapping("/person/list")
	public List<PersonDto> list()
	{
		System.out.println("list >> 호출됨");
		return personDao.getAllPersons();
	}
	
	// 삭제
	@DeleteMapping("/person/delete")
	public void delete(@RequestParam("pnum") int num)
	{
		System.out.println("delete >> " + num);
		personDao.deletePerson(num);
	}
	
	// dto 반환
	@GetMapping("/person/select")
	public PersonDto select(@RequestParam("pnum") int pnum)
	{
		System.out.println("select >> " + pnum);
		return personDao.getSelectedData(pnum);
	}
	
	// 수정
	@PostMapping("/person/update")
	public void update(@RequestBody PersonDto dto)
	{
		System.out.println("update >> " + dto);
		personDao.updatePerson(dto);
	}
}
