package com.mobiquityinc.packer;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNot.not;

/**
 * Testing class for Thing
 */
public class ThingTest {

    private Thing thing;

    /**
     * Scenario:
     * Executes Thing getter and setter
     * Expected:
     * returns expected set values
     */
    @Test
    public void testingConstructorGetterAndSetter() {

        assertThat(thing, is(nullValue()));
        thing = new Thing();
        assertThat(thing, is(not(nullValue())));
        assertThat(thing.getCost(), is(nullValue()));
        thing.setCost(33.3);
        assertThat(thing.getCost(), is(not(nullValue())));
        assertThat(thing.getWeight(), is(nullValue()));
        thing.setWeight(5.0);
        assertThat(thing.getWeight(), is(not(nullValue())));
        assertThat(thing.getIndex(), is(nullValue()));
        thing.setIndex(1l);
        assertThat(thing.getIndex(), is(not(nullValue())));
    }
}
