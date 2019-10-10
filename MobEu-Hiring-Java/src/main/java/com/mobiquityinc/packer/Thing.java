package com.mobiquityinc.packer;

import lombok.*;

/**
 * Class that represent a thing to be packed inside a Box
 * Has and index a cost and a weight
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Thing {
    private Long index;
    private Double cost;
    private Double weight;
}
