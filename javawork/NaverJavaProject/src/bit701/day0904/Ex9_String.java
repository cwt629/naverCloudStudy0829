package bit701.day0904;

public class Ex9_String {

	public static void main(String[] args) {
		String str1 = "apple";
		String str2 = "AppLe";
		String str3 = "Have a Good Day";
		String str4 = "   Happy   ";
		
		System.out.println(str3.length()); // str3의 총길이
		System.out.println(str2.toLowerCase()); // str2를 모두 소문자로 변환
		System.out.println(str2.toUpperCase()); // str2를 모두 대문자로 변환
		System.out.println(str3.substring(5)); // 인덱스 5부터 끝까지
		System.out.println(str3.substring(7, 11)); // 인덱스 7부터 11 이전까지
		System.out.println(str3.charAt(0)); // str3의 인덱스 0에 해당하는 character
		System.out.println(str3.charAt(7)); // str3의 인덱스 7에 해당하는 character
		System.out.println(str1.indexOf('a')); // str1에서 제일 처음 나오는 'a'의 인덱스값
		System.out.println(str3.lastIndexOf('a')); // str3에서 제일 마지막에 나오는 'a'의 인덱스값('Day'의 'a' 위치가 나옴)
		System.out.println(str4.length()); // 앞뒤 공백을 포함한 전체 길이
		System.out.println(str4.trim().length()); // 앞뒤 공백 제거 -> 그 후 길이
		System.out.println(str3.startsWith("Have")); // str3가 "Have"로 시작하면 true
		System.out.println(str3.endsWith("day")); // str3가 "day"로 끝나면 true
		System.out.println(str1.equals(str2)); // str1이 str2와 대소문자까지 같으면 true
		System.out.println(str1.equalsIgnoreCase(str2)); // 대소문자 상관없이 철자만 같으면 true
		// Self: compareTo는 앞에서부터 서로 다른 문자를 만날때까지 탐색하다가, 그 다른 문자간의 아스키코드 차이를 반환함!! 완전히 같으면 0
		System.out.println(str1.compareTo(str2)); // str1과 str2의 차이(양수값: str1이 더 큰값, 음수값: str2가 더 큰값)
		System.out.println(str1.compareTo("apple")); // 완전 같은 경우 0
	}

}
