package strings;

public class NumberofVowelsandConsonants {

	public static void main(String[] args) {
		String alpha = "Abcdefghijklmnopqrstuvwxyz";
		int vowels = 0, consonants = 0;
		
		for(int i=0; i<alpha.length(); i++) {
			alpha = alpha.toLowerCase();
			char currentChar = alpha.charAt(i);
			if(currentChar == 'a' || currentChar == 'e' || currentChar == 'i' || currentChar == 'o' || currentChar == 'u') {
				vowels++;
			}else {
				consonants++;
			}
		}
		System.out.println("Vowels = "+vowels+", Consonants = "+consonants);
	}
}