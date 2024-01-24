package data.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import data.dto.MemberDto;

@Mapper
public interface MemberMapper {
	@Select("select count(*) from memberdb")
	public int getTotalCount();
	
	@Select("select * from memberdb order by num desc")
	public List<MemberDto> getAllMembers();
	
	// @Insert로 쿼리문을 여기서 직접 써도 되지만, xml에서 해보자.
	public void insertMember(MemberDto dto);
	
	/* 20240124 */
	// 해당 아이디가 있는지 count을 이용하여 확인
	@Select("select count(*) from memberdb where myid = #{myid}")
	public int getIdCheck(String myid);
	
	@Delete("delete from memberdb where num = #{num}")
	public void deleteMember(int num);
	
	@Select("select * from memberdb where num = #{num}")
	public MemberDto getMember(int num);
	
	// 일단은 아이디만 맞으면 반환하자. 단, 아이디가 없으면 null로 들어갈 거임
	@Select("select * from memberdb where myid = #{myid}")
	public MemberDto getLogin(String myid);
}
