package com.valtech.training.mobile.rating.ui;

import java.util.Arrays;
import java.util.List;

import junit.framework.Assert;
import junit.framework.TestCase;

public class RatingHelperTest extends TestCase {

	public void testGetRanking() {
		RatingHelper helper = new RatingHelper();
		List<String> phoneNumbers = Arrays.asList("9945711296", "9739220033", "8151803366", "8970565176", "9900135729","9916878237","9999999999");
		System.out.println(helper.getRanking(phoneNumbers));
	}
}
