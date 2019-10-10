package com.mobiquityinc.extractor;

import com.mobiquityinc.packer.Box;

import java.util.List;

/**
 * Class that handler the extraction from a collection of lines
 * I use an interface because in this way is easy to change in the future to a better implementation
 * without affecting the rest of the code
 */
public interface Extractor {

    /**
     * generate a collection of  Boxes with things
     *
     * @param lines a collection of lines where we will extract the info to generate a Box
     * @return List of Boxes
     */
    List<Box> extract(List<String> lines);
}
