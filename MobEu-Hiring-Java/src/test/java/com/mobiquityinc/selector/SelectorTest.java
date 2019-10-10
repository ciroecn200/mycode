package com.mobiquityinc.selector;

import com.mobiquityinc.packer.Box;
import com.mobiquityinc.packer.Thing;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Testing class for Selector
 */
public class SelectorTest {

    private Selector selector;

    /**
     * Setting a new instance of the class to test
     */
    @Before
    public void setup() {
        selector = new SelectorImpl();
    }

    /**
     * Scenario:
     * Executes {@link Selector#select(List)}  with null
     * Expected:
     * Should return an empty list
     */
    @Test
    public void testingSelectorWithNull() {
        List<String> itemsSelected = selector.select(null);
        assertThat(itemsSelected.size(), is(0));

    }

    /**
     * Scenario:
     * Executes {@link Selector#select(List)}  with empty list
     * Expected:
     * Should return an empty list
     */
    @Test
    public void testingSelectorWithEmpty() {
        List<String> itemsSelected = selector.select(Collections.emptyList());
        assertThat(itemsSelected.size(), is(0));
    }

    /**
     * Scenario:
     * Executes {@link Selector#select(List)} with one Box and four things
     * Box weight 5
     * i1 w2 c3
     * i2 w3 c4
     * i3 w4 c5
     * i4 w5 c6
     * Expected:
     * Should return a list with i1 and i2 because they maximize the costs
     */
    @Test
    public void testingSelectorWithGoodValues() {
        List<Box> boxes = new ArrayList<>();
        Box box = new Box();
        box.setWeight(5.0);
        box.setThings(new ArrayList<>());
        Thing thing1 = new Thing(1L, 3.0, 2.0);
        Thing thing2 = new Thing(2L, 4.0, 3.0);
        Thing thing3 = new Thing(3L, 5.0, 4.0);
        Thing thing4 = new Thing(4L, 6.0, 5.0);
        box.getThings().add(thing1);
        box.getThings().add(thing2);
        box.getThings().add(thing3);
        box.getThings().add(thing4);
        boxes.add(box);

        List<String> itemsSelected = selector.select(boxes);
        assertThat(itemsSelected.size(), is(1));
        assertThat(itemsSelected.contains("1,2"), is(true));

    }


}
