package strings;

import java.util.Comparator;

public class StringsComparator implements Comparator<String> {

	public static void main(String[] args) {
		StringsComparator strings = new StringsComparator();
		String s1 = "Aastha";
		String s2 = "Laxman";
		System.out.println(strings.compare(s1, s2));
	}

	@Override
	public int compare(String o1, String o2) {
		return o2.compareTo(o1);
	}
}