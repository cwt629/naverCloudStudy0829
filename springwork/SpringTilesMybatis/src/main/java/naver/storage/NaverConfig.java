package naver.storage;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

@Configuration // ���� ����
@Setter
@Getter
public class NaverConfig {

	// endPoint : ����
	@Value("https://kr.object.ncloudstorage.com")
	private String endPoint;
	
	// regionName : ����
	@Value("kr-standard")
	private String regionName;
	
	// accessKey : ���ڲ� 
	@Value("KBWbeoPeKDJhL2RLATtd")
	private String accessKey;
	
	// secretKey : ���ڲ� 
	@Value("407hL347PDkJvmhw5olS0zH481ClFmArm2gKChPd")
	private String secretKey;
	
//	// ������� keys
//	@Value("8yt6c0uo9is9HLAN1BZH")
//	private String accessKey;
//	
//	@Value("tmFGzatUiqw0C91hSR9Cx9jwPX5DWSzwLFRn3XC0")
//	private String secretKey;

}
