package myshop.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import myshop.data.MyShopDto;

@Mapper
public interface MyShopMapper {
	// 방법 1: sql을 직접 정의
	//@Select("select count(*) from myshop")
	//public int getTotalCount();
	
	// 방법 2: sql을 xml에서 정의
	// 주의: xml의 id와 메소드명이 정확히 일치해야 함
	public int getTotalCount();
	
	// 직접 insert 쿼리문 설정
	@Insert("""
			insert into myshop (sangpum, color, photo, price, writeday)
			values (#{sangpum}, #{color}, #{photo}, #{price}, now())
			""")
	public void insertShop(MyShopDto dto);
	
	// 전체 목록 출력(직접 sql문으로 설정)
	@Select("select * from myshop order by num desc")
	public List<MyShopDto> getSangpumList();
	
	// 이번엔 xml로 설정해보자
	public MyShopDto getData(int num);
	
	@Delete("delete from myshop where num = #{num}")
	public void deleteShop(int num);
}
