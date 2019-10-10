package com.mobiquityinc.extractor;

import com.mobiquityinc.packer.Box;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Testing class for Extractor
 */
public class ExtractorTest {

    private Extractor extractor;

    /**
     * Setting a new instance of the class to test
     */
    @Before
    public void setup() {
        extractor = new ExtractorImpl();
    }

    /**
     * Scenario:
     * Executes {@link Extractor#extract(List)}  with empty list
     * Expected:
     * Should return an empty list
     */
    @Test
    public void testingExtractorWithAnEmptyListOfLines() {
        List<Box> boxes = extractor.extract(Collections.emptyList());
        assertThat(boxes.size(), is(0));
    }

    /**
     * Scenario:
     * Executes {@link Extractor#extract(List)}  with null list
     * Expected:
     * Should return an empty list
     */
    @Test
    public void testingExtractorWithANullListOfLines() {
        List<Box> boxes = extractor.extract(null);
        assertThat(boxes.size(), is(0));
    }

    /**
     * Scenario:
     * Executes {@link Extractor#extract(List)}  with one incorrect element
     * Expected:
     * Should return an empty list
     */
    @Test
    public void testingExtractorWithOneIncorrectElement() {
        List<Box> boxes = extractor.extract(Arrays.asList("3k3id2"));
        assertThat(boxes.size(), is(0));
    }

    /**
     * Scenario:
     * Executes {@link Extractor#extract(List)}  with one element that has only the weight of the package good the other values are incorrect
     * 22 : ()()()
     * Expected:
     * Should return one Box with the weight defined and  without things because they  were not defined
     */
    @Test
    public void testingExtractorWithOneElementWithHalfOfLineIncorrect() {
        List<Box> boxes = extractor.extract(Arrays.asList("22 : ()()()"));
        assertThat(boxes.size(), is(1));
        assertThat(boxes.get(0).getWeight().intValue(), is(22));
    }

    /**
     * Scenario:
     * Executes {@link Extractor#extract(List)}  with one element with correct values
     * 8 : (2,3,€10)
     * Expected:
     * Should return one Box with all values defined above
     */
    @Test
    public void testingExtractorWithOneElementWithCorrectValues() {
        List<Box> boxes = extractor.extract(Arrays.asList("8 : (2,3,€10)"));
        assertThat(boxes.size(), is(1));
        assertThat(boxes.get(0).getWeight().intValue(), is(8));
        assertThat(boxes.get(0).getThings().size(), is(1));
        assertThat(boxes.get(0).getThings().get(0).getIndex(), is(2L));
        assertThat(boxes.get(0).getThings().get(0).getCost(), is(10.0));
        assertThat(boxes.get(0).getThings().get(0).getWeight(), is(3.0));
    }

    /**
     * Scenario:
     * Executes {@link Extractor#extract(List)}  with  one element with two things with correct values
     * 90 : (2,3,€10) (1,10,€1.03)
     * Expected:
     * Should return one Box with all values defined above
     */
    @Test
    public void testingExtractorWithOneElementAndTwoThingsWithCorrectValues() {
        List<Box> boxes = extractor.extract(Arrays.asList("90 : (1,85.31,€29) (2,14.55,€74)"));
        assertThat(boxes.size(), is(1));
        assertThat(boxes.get(0).getWeight().intValue(), is(90));
        assertThat(boxes.get(0).getThings().size(), is(2));
        assertThat(boxes.get(0).getThings().get(0).getIndex(), is(1L));
        assertThat(boxes.get(0).getThings().get(0).getCost(), is(29.0));
        assertThat(boxes.get(0).getThings().get(0).getWeight(), is(85.31));
        assertThat(boxes.get(0).getThings().get(1).getIndex(), is(2L));
        assertThat(boxes.get(0).getThings().get(1).getCost(), is(74.0));
        assertThat(boxes.get(0).getThings().get(1).getWeight(), is(14.55));
    }
}
