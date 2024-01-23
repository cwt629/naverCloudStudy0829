package naver.storage;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.Data;

@Configuration
@Data
@PropertySource("classpath:/naver.properties")
// properties 파일에서 선언된 값 중, ncp.* 형식의 프로퍼티 값을 받을 필드 선언
@ConfigurationProperties(prefix = "ncp")
public class NaverConfig {
	private String endPoint;
	private String regionName;
	private String accessKey;
	private String secretKey;
}
