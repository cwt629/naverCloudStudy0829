package mycar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;
import mycar.data.MyCarDto;

// JpaRepository 상속 & <T, ID>는 각각 dto타입, id 컬럼 타입을 넣어줌
public interface MyCarDaoInter extends JpaRepository<MyCarDto, Long>{

	// 직접 쿼리문을 이용해서 수정하는 메소드를 추가해보자
	// 자동차명, 가격, 색상만 수정하는 메소드를 만들어보자
	
	/* @Query : repository에 원하는 쿼리를 작성하게 해주는 어노테이션
	 * value 속성: 쿼리 작성부 - 변수 앞에 :을 붙여준다
	 * nativeQuery: JPA에서 지정한 규칙을 모두 무시할 수 있는 속성
	 */
	@Query(value = 
			"""
			update mycar set car_name=:carname, carprice=:carprice, carcolor=:carcolor
			where num=:num
			""", nativeQuery = true)
	/*
	 * update와 delete는 아래 두가지 어노테이션을 추가로 붙여줘야 한다.
	 * Modifying은 insert, update, delete 뿐만 아니라 DDL 구문을 사용할 때도 표기를 해줘야 한다.
	 * Transactional은 update, delete를 할 때 표기해줘야 정상 실행이 된다.
	 */
	@Modifying
	@Transactional
	public void updateMycarNoPhoto(@Param("num") Long num, @Param("carname") String carname,
			@Param("carprice") int carprice, @Param("carcolor") String carcolor);
	
	@Query(value = "select count(*) from mycar", nativeQuery = true)
	public Long getTotalMyCount();
	
	// TODO: DTO로 받기
	@Query(value = 
			"""
			update mycar set car_name=:#{#dto.carname}, carprice=:#{#dto.carprice}, carcolor=:#{#dto.carcolor},
			carguip=:#{#dto.carguip}
			where num=:#{#dto.num}
			""", nativeQuery = true)
	@Modifying
	@Transactional
	public void updateMycarDTONoPhoto(@Param("dto") MyCarDto dto);
}
