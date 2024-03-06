package arrays;

import java.util.HashMap;

public class NumberOfOccuranceInArray {

	public static void main(String[] args) {
		int[] num = {1, 2, 4, 3, 4, 5, 2, 4};
		HashMap<Integer, Integer> numberOccurances = new HashMap<Integer, Integer>();
		
		for (int i = 0; i < num.length; i++) {
			if(numberOccurances.containsKey(num[i])) {
				numberOccurances.put(num[i], numberOccurances.get(num[i]) + 1);
			}else {
				numberOccurances.put(num[i], 1);
			}
		}
		
		for(int k: numberOccurances.keySet()) {
			System.out.println("Number of occurrence of " + k + " = " + numberOccurances.get(k));
		}
	}
}