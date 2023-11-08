package day1108.test1;

import lombok.AllArgsConstructor; 
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
// annotation 활용해서 setter, getter 만들 수 있음(lombok 활용)
//@Setter
//@Getter
//@ToString

// 위 3개의 annotation을 하나의 어노테이션으로 표현 가능
@Data

@NoArgsConstructor // default 생성자
@AllArgsConstructor // 모든 멤버를 인자로 갖는 생성자
@RequiredArgsConstructor // 필요한 인자만 생성자로 주입(Injection) - @NonNull 인자만 주입
public class TestDto {
	@NonNull // 이 경우 name만 NonNull로 받음
	private String name;
	private String addr;
	private int age;
}
