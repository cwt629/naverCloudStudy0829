package day1108.test1;

import lombok.AllArgsConstructor; 
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
// annotation Ȱ���ؼ� setter, getter ���� �� ����(lombok Ȱ��)
//@Setter
//@Getter
//@ToString

// �� 3���� annotation�� �ϳ��� ������̼����� ǥ�� ����
@Data

@NoArgsConstructor // default ������
@AllArgsConstructor // ��� ����� ���ڷ� ���� ������
@RequiredArgsConstructor // �ʿ��� ���ڸ� �����ڷ� ����(Injection) - @NonNull ���ڸ� ����
public class TestDto {
	@NonNull // �� ��� name�� NonNull�� ����
	private String name;
	private String addr;
	private int age;
}
