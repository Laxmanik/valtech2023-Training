package strings;

public class AlternateStrings {
	
	public static void main(String[] args) {
		String  s1 = "abcd";
		String s2 = "1234";
		StringBuilder str = new StringBuilder();
		for(int i=0; i<s1.length(); i++) {
			str.append(s1.charAt(i));
			str.append(s2.charAt(i));
		}
		System.out.println(str);
		
		
//		String s1 = "abc";
//		String s2 = "abc";
//		System.out.println(s1==s2);
//		System.out.println(s1.hashCode());
//		System.out.println(s2.hashCode());
//		System.out.println(s1.equals(s2));
	}

}