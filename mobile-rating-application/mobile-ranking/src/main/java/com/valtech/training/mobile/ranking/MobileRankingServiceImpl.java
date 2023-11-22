package com.valtech.training.mobile.ranking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.valtech.training.pattern.checker.PatternCheckerService;
import com.valtech.training.pattern.checker.PatternCheckerServiceImpl;

public class MobileRankingServiceImpl implements MobileRankingService {

	private PatternCheckerService patternCheckerService = new PatternCheckerServiceImpl();

	public MobileRankingServiceImpl() {
	}

	public MobileRankingServiceImpl(PatternCheckerService patternCheckerService) {
		this.patternCheckerService = patternCheckerService;
	}

	

	public void setPatternCheckerService(PatternCheckerService patternCheckerService) {
		this.patternCheckerService = patternCheckerService;
	}

	@Override
	public List<String> rankMobile(List<String> phoneNumbers) {
		Map<String, Integer> phoneNumberScores = patternCheckerService.checkPatterns(phoneNumbers);

		List<Map.Entry<String, Integer>> phoneNumberScoresEntries = new ArrayList<Map.Entry<String, Integer>>(
				phoneNumberScores.entrySet());

		// sorts phoneNumbers Based on scores from highest to lowest
		Collections.sort(phoneNumberScoresEntries, new Comparator<Entry<String, Integer>>() {

			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				return o2.getValue().compareTo(o1.getValue());
			}
		});

		List<String> sortedPhoneNumbers = new ArrayList<String>();

		for (Map.Entry<String, Integer> entry : phoneNumberScoresEntries) {
			sortedPhoneNumbers.add(entry.getKey());
		}

		return sortedPhoneNumbers;
	}
	
//	public static void main(String[] args) {
//		MobileRankingService mr = new MobileRankingServiceImpl();
//    	List<String> phoneNumbers = Arrays.asList("9945711296", "9739220033", "8151803366", "8970565176", "9900135729","9916878237","9999999999");
//    	System.out.println(mr.rankMobile(phoneNumbers));
//	}

}
