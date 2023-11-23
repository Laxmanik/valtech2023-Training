package com.valtech.training.mobile.rating.ui;

import java.util.List;

import com.valtech.training.mobile.ranking.MobileRankingService;
import com.valtech.training.mobile.ranking.MobileRankingServiceImpl;

public class RatingHelper {

	private MobileRankingService mobileRankingService = new MobileRankingServiceImpl();

	public List<String> getRanking(List<String> phoneNumbers) {

		if (phoneNumbers == null || phoneNumbers.isEmpty()) {
			System.err.println("Phone Number List Cannot be null");
		}

		for (String phoneNumber : phoneNumbers) {
			if (phoneNumber == null || !isValidPhoneNumber(phoneNumber)) {
				System.err.println("Not a valid Phone Number: " + phoneNumber);
			}
		}

		return mobileRankingService.rankMobile(phoneNumbers);
	}

	private boolean isValidPhoneNumber(String phoneNumber) {
		return phoneNumber != null && phoneNumber.matches("[6789]\\d{9}");
	}
	
	
}
