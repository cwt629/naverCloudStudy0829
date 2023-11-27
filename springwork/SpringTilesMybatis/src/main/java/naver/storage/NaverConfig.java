package naver.storage;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

@Configuration // 설정 파일
@Setter
@Getter
public class NaverConfig {

	// endPoint : 고정
	@Value("https://kr.object.ncloudstorage.com")
	private String endPoint;
	
	// regionName : 고정
	@Value("kr-standard")
	private String regionName;
	
	// accessKey : 각자꺼 
	@Value("KBWbeoPeKDJhL2RLATtd")
	private String accessKey;
	
	// secretKey : 각자꺼 
	@Value("407hL347PDkJvmhw5olS0zH481ClFmArm2gKChPd")
	private String secretKey;
	
//	// 강사님의 keys
//	@Value("8yt6c0uo9is9HLAN1BZH")
//	private String accessKey;
//	
//	@Value("tmFGzatUiqw0C91hSR9Cx9jwPX5DWSzwLFRn3XC0")
//	private String secretKey;

}
