package com.valtech.training.pattern.checker;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PatternCheckerServiceImpl implements PatternCheckerService {
	
	

	public PatternCheckerServiceImpl() {
	}

	@Override
	public Map<String, Integer> checkPatterns(List<String> phoneNumbers) {
		Map<String, Integer> phoneNumberScores = new HashMap<String, Integer>();

		for (String phoneNumber : phoneNumbers) {
			int score = 0;
			if (hasConsecutiveOrder(phoneNumber)) {
				score += 1;
			}
			if (hasDescendingOrder(phoneNumber)) {
				score += 2;
			}
			if (hasAscendingOrder(phoneNumber)) {
				score += 3;
			}
			if (hasRepeatedDigit(phoneNumber)) {
				score += 4;
			}
			if (isPalindrome(phoneNumber)) {
				score += 5;
			}
			if (isAllDigitsSame(phoneNumber)) {
				score += 6;
			}
			phoneNumberScores.put(phoneNumber, score);
		}

		return phoneNumberScores;
	}

	private boolean hasConsecutiveOrder(String phoneNumber) {
		for (int i = 0; i < phoneNumber.length() - 1; i++) {
			int currentDigit = Character.getNumericValue(phoneNumber.charAt(i));
			int nextDigit = Character.getNumericValue(phoneNumber.charAt(i + 1));
			// checks for ascending consecutive order
			if (nextDigit == (currentDigit + 1)) {
				return true;
			}
			// checks for descending consecutive order
			if (nextDigit == (currentDigit - 1)) {
				return true;
			}
		}
		return false;
	}

	private boolean hasDescendingOrder(String phoneNumber) {
		for (int i = 0; i < phoneNumber.length() - 1; i++) {
			int currentDigit = Character.getNumericValue(phoneNumber.charAt(i));
			int nextDigit = Character.getNumericValue(phoneNumber.charAt(i + 1));
			// In descending order currentdigit shouldnot be less than or equal to nextdigit
			if (currentDigit <= nextDigit) {
				return false;
			}
		}
		return true;
	}

	private boolean hasAscendingOrder(String phoneNumber) {
		for (int i = 0; i < phoneNumber.length() - 1; i++) {
			int currentDigit = Character.getNumericValue(phoneNumber.charAt(i));
			int nextDigit = Character.getNumericValue(phoneNumber.charAt(i + 1));

			if (currentDigit >= nextDigit) {
				return false;
			}
		}
		return true;
	}

	private boolean hasRepeatedDigit(String phoneNumber) {
		for (int i = 0; i < phoneNumber.length() - 1; i++) {
			char currentDigit = phoneNumber.charAt(i);
			char nextDigit = phoneNumber.charAt(i + 1);

			if (currentDigit == nextDigit) {
				return true;
			}
		}
		return false;
	}

	private boolean isPalindrome(String phoneNumber) {
		for (int i = 0; i < phoneNumber.length() / 2; i++) {
			char firstDigit = phoneNumber.charAt(i);
			char lastDigit = phoneNumber.charAt(i + 1);

			if (firstDigit != lastDigit) {
				return false;
			}
		}
		return true;
	}

	private boolean isAllDigitsSame(String phoneNumber) {
		char firstDigit = phoneNumber.charAt(0);

		for (int i = 1; i < phoneNumber.length(); i++) {
			char currentDigit = phoneNumber.charAt(i);
			
			if(currentDigit != firstDigit) {
				return false;
			}
		}

		return true;
	}
	
//	public static void main(String[] args) {
//		PatternCheckerService pc = new PatternCheckerServiceImpl();
//		List<String> phoneNumbers = Arrays.asList("9945711296", "9739220033", "8151803366", "8970565176", "9900135729","9916878237","9999999999");
//		System.out.println(pc.checkPatterns(phoneNumbers));
//	}

}
