package com.mobiquityinc.packer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Class that represent a thing to be packed inside a Box
 * Has and index a cost and a weight
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Thing {
    private Long index;
    private Double cost;
    private Double weight;
}
