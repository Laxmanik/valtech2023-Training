package com.valtech.training.mobile.ranking;

import java.util.Arrays;
import java.util.List;

import com.valtech.training.pattern.checker.PatternCheckerService;
import com.valtech.training.pattern.checker.PatternCheckerServiceImpl;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
    
    public void testMobileRanking() {
    	MobileRankingService mr = new MobileRankingServiceImpl();
    	List<String> phoneNumbers = Arrays.asList("9945711296", "9739220033", "8151803366", "8970565176", "9900135729","9916878237","9999999999");
    	System.out.println(mr.rankMobile(phoneNumbers));
    }
}
