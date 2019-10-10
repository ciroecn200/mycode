package com.mobiquityinc.packer;

import lombok.Data;

import java.util.List;

@Data
public class Bag {
    private Double weight;
    private List<Thing> things;
}
