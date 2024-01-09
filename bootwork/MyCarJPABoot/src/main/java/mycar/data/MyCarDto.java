package mycar.data;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "mycar")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MyCarDto {
	
	@Id // 각 entity를 구별할 수 있도록 식별 아이디를 가지도록 설계
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 기존의 auto-increment 역할
	private Long num;
	// 컬럼명은 변수명과 같으면 생략 가능
	@Column(name = "car_name", length = 30)
	private String carname;
	
	private int carprice;
	
	@Column(length = 20)
	private String carcolor;
	
	@Column(length = 30) // length 생략 시 255
	private String carguip;
	
	@Column(length = 100)
	private String carphoto;
	
	@Column(updatable = false) // 수정 시 컬럼 제외
	@CreationTimestamp
	private Timestamp writeday;
	
	@Transient // 테이블의 컬럼으로는 생성되지 않고, 객체에서만 사용 가능한 멤버 변수
	private int commentcount;
	
	@Transient
	private String message;
}
