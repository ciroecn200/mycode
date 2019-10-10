package com.mobiquityinc.selector;

import com.mobiquityinc.packer.Bag;

import java.util.List;

public interface Selector {

    List<String> select(List<Bag> bags);
}
