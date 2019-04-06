package com.markbrown.connectivity.quiz;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.io.File;
import java.sql.Timestamp;

import org.junit.Test;

public class SocialNetworkTimestampAlgorithmTest {

    private SocialNetworkTimestampAlgorithm algorithm;

    @Test
    public void testThatCorrectTimestampCanBeObtainedOne() throws Exception {

        // Setup
        String filePath = new File(".").getCanonicalPath() + "\\weekone\\dynamic-connectivity\\src\\test\\resources\\test.csv";
        algorithm = new SocialNetworkTimestampAlgorithm(4, filePath);

        // Test
        Timestamp allConnected = algorithm.getEarliestConnectionDate();
        assertEquals(Timestamp.valueOf("2019-01-03 12:00:00"), allConnected);

    }

    @Test
    public void testThatCorrectTimestampCanBeObtainedTwo() throws Exception {

        // Setup
        String filePath = new File(".").getCanonicalPath()
                + "\\weekone\\dynamic-connectivity\\src\\test\\resources\\test2.csv";
        algorithm = new SocialNetworkTimestampAlgorithm(10, filePath);

        // Test
        Timestamp allConnected = algorithm.getEarliestConnectionDate();
        assertEquals(Timestamp.valueOf("2019-01-10 12:00:00"), allConnected);

    }

    @Test
    public void testThatCorrectTimestampCanBeObtainedThree() throws Exception {

        // Setup
        String filePath = new File(".").getCanonicalPath()
                + "\\weekone\\dynamic-connectivity\\src\\test\\resources\\test3.csv";
        algorithm = new SocialNetworkTimestampAlgorithm(10, filePath);

        // Test
        Timestamp allConnected = algorithm.getEarliestConnectionDate();
        assertEquals(Timestamp.valueOf("2019-01-10 12:00:00"), allConnected);

    }
    
    @Test
    public void testThatNullIsReturnedIfNoTimestampExistsSuchThatEveryoneIsConnected() throws Exception {

        // Setup
        String filePath = new File(".").getCanonicalPath()
                + "\\weekone\\dynamic-connectivity\\src\\test\\resources\\test4.csv";
        algorithm = new SocialNetworkTimestampAlgorithm(10, filePath);

        // Test
        Timestamp allConnected = algorithm.getEarliestConnectionDate();
        assertNull(allConnected);

    }

}