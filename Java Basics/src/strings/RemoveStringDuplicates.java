package strings;

public class RemoveStringDuplicates {

	public static void main(String[] args) {
		String s1 = "catchhhh";
		int n = s1.length()-1;
		StringBuilder str = new StringBuilder();
		while(n>0 && s1.charAt(n)==s1.charAt(n-1) ){
			n--;
		}
		
		System.out.println(str.append(s1.substring(0,n)));
	}
	
}