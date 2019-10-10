package com.mobiquityinc.extractor;

import com.mobiquityinc.packer.Bag;

import java.util.List;

public interface Extractor {

    List<Bag> extract(List<String> lines);
}
