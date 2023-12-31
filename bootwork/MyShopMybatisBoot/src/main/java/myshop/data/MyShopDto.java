package myshop.data;

import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Alias("MyShopDto") // spring에서 mini.~~.shopDto에 alias를 shopDto라고 준 느낌 
public class MyShopDto {
	private int num;
	private String sangpum;
	private String photo;
	private int price;
	private String color;
	private Timestamp writeday;
}
