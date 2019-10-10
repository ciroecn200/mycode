package com.mobiquityinc.selector;

import com.mobiquityinc.packer.Box;

import java.util.List;

/**
 * Class that handler the selection of items to be packed in a particular Box
 * I use an interface because in this way is easy to change in the future to a better implementation
 * without affecting the rest of the code
 */
public interface Selector {

    List<String> select(List<Box> bags);
}
