package com.mobiquityinc.selector;

import com.mobiquityinc.packer.Box;

import java.util.List;

/**
 * Class that handler the selection of items to be packed in a particular Box
 */
public interface Selector {

    List<String> select(List<Box> bags);
}
