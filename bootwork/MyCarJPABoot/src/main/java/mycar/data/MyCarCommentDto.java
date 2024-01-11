package mycar.data;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * 은행 서비스에서 사용자(TABLE_USER)가 1개 이상의 계좌(TABLE_ACCOUNT)를 가질 수 있다고 가정하자.
 * 그럼 이를 TABLE_USER 입장에서 보면 OneToMany(1:n)이고,
 * TABLE_ACCOUNT 입장에서 보면 ManyToOne(n:1)이다.
 * 
 * 그래서 게시물과 댓글 입장에서 보면
 * 게시물(메인 테이블) 입장에선 1:n이고
 * 댓글(서브 테이블) 입장에선 n:1이다.
 * 하나의 게시물에 여러 개의 게시물을 달 수 있지만
 * 하나의 댓글을 여러 게시물에 대응시킬 순 없으니까 말이다.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity // 테이블로 연결
@Table(name = "mycar_comment")
public class MyCarCommentDto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idx;
	
	@ManyToOne // 하나의 등록글에 여러 개의 댓글을 달 수 있음
	@JoinColumn(name = "num")
	@OnDelete(action = OnDeleteAction.CASCADE) // on delete cascade
	private MyCarDto mycar; // join table
	
	private String comment; // @Column을 주지 않음. 기본 컬럼명 comment, 길이 255

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul") // 댓글은 출력 처리를 ajax로 할 예정
	@Column(updatable = false) // 수정 시, 수정되는 컬럼에서 제외
	@CreationTimestamp // 엔터티가 생성되는 시점의 시간이 자동 등록
	private Timestamp writeday;
	
	@Transient
	private int commentCount;
}
