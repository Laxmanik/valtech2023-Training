package com.valtech.training.mobile.rating.ui;

import junit.framework.Assert;
import junit.framework.TestCase;

public class RatingHelperTest extends TestCase {

	public void testGetRanking() {
		RatingHelper helper = new RatingHelper();
		Assert.assertEquals(0, helper.getRanking("9898989898"));
	}
}
