package com.mobiquityinc.packer;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Class that represent the package to de fill with certain things
 * Has a maximum of weight that can handler and a Collection of things
 */
@Getter
@Setter
public class Box {
    private Double weight;
    private List<Thing> things;
}
