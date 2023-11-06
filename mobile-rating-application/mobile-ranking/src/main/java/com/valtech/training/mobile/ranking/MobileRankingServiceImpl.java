package com.valtech.training.mobile.ranking;

import java.util.List;

import com.valtech.training.pattern.checker.PatternCheckerService;

public class MobileRankingServiceImpl implements MobileRankingService {
	
	private PatternCheckerService patternCheckerService;

	
	public int  rankMobile(String mobile) {
		List<String> patterns=patternCheckerService.listPatterns(mobile);
		//Rating logic here
		return 0;
	}

}
