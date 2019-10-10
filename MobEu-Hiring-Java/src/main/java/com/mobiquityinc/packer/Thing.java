package com.mobiquityinc.packer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Class that represent a thing to be packed
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Thing {
    private Long index;
    private Double cost;
    private Double weight;
}
