package com.mobiquityinc.constant;


import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Testing class for Constant
 */
public class ConstantTest {


    /**
     * Scenario:
     * Test the constant values of the class
     * Expected:
     * true over all the values tested
     */
    @Test
    public void testingConstantValues() {

        assertThat(Constant.MAX_PACKAGE_WEIGHT_CAN_TAKE, is(100));
        assertThat(Constant.MAX_THING_COST, is(100));
        assertThat(Constant.MAX_THING_WEIGHT, is(100));
        assertThat(Constant.MAX_THINGS_TO_CHOOSE, is(15));
    }
}
