package mycar.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import lombok.AllArgsConstructor;
import mycar.data.MyCarDto;

@Repository
@AllArgsConstructor
public class MyCarDao {

	// JpaRepository를 상속받을 경우, 기본적인 SQL을 실행해주는 각종 메소드 호출 가능
	MyCarDaoInter daoInter;
	
	// 전체 개수 구하기
	public long getTotalCount()
	{
		//return daoInter.count(); // jpa에서 제공하는 메소드
		return daoInter.getTotalMyCount(); // 내가 만든 메소드
	}
	
	// db 저장
	public void insertMyCar(MyCarDto dto)
	{
		daoInter.save(dto); // save는 dto에 num값이 포함되어 있으면 update, 없으면 insert를 실행함
	}
	
	// 전체 출력
	public List<MyCarDto> getAllCars()
	{
		return daoInter.findAll(); // 전체 데이터 반환
		
		// 아래는 order by 적용한 예시
		
		//return daoInter.findAll(Sort.by(Sort.Direction.DESC, "carprice")); // 가격에 대해 desc로 출력(비싼 것부터)
		//return daoInter.findAll(Sort.by(Sort.Direction.ASC, "carprice")); // 가격에 대해 asc로 출력(싼 것부터)
		
	}
	
	// 페이지 출력
	public Page<MyCarDto> getAllCars(Pageable pageable)
	{
		return daoInter.findAll(pageable); // 페이지에 필요한 만큼 데이터 반환
	}
	
	// num에 해당하는 dto 반환
	public MyCarDto getData(Long num)
	{
		return daoInter.getReferenceById(num);
		// 참고: 같은 역할을 하는 getById, getOne도 있지만, 이 둘은 deprecated됨
	}
	
	// delete(스스로 해봄)
	public void deleteMyCar(Long num)
	{
		daoInter.deleteById(num);
	}
	
	// update
	public void updateMyCar(MyCarDto dto)
	{
		daoInter.save(dto); // dto에 num이 포함되어 있으므로 수정된다
	}
	
	// update - 사진 수정 안하고 자동차명, 가격, 색상만 변경
	public void updateMycarNoPhoto(MyCarDto dto)
	{
		// 기존 방식
		//Long num = dto.getNum();
		//String carname = dto.getCarname();
		//String carcolor = dto.getCarcolor();
		//int carprice = dto.getCarprice();
		
		//daoInter.updateMycarNoPhoto(num, carname, carprice, carcolor);
		
		// TODO : 검색을 통해, dto로 직접 파라미터 넘기는 경우로 테스트해보기
		daoInter.updateMycarDTONoPhoto(dto);
	}
}
