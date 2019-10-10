package com.mobiquityinc.packer;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNot.not;

/**
 * Testing class for Box
 */
public class BoxTest {

    private Box box;

    /**
     * Scenario:
     * Executes Box getter and setter
     * Expected:
     * returns expected set values
     */
    @Test
    public void testingConstructorGetterAndSetter() {

        assertThat(box, is(nullValue()));
        box = new Box();
        assertThat(box, is(not(nullValue())));
        assertThat(box.getThings(), is(nullValue()));
        box.setThings(new ArrayList<>());
        assertThat(box.getThings(), is(not(nullValue())));
        assertThat(box.getWeight(), is(nullValue()));
        box.setWeight(5.0);
        assertThat(box.getWeight(), is(not(nullValue())));
    }
}
