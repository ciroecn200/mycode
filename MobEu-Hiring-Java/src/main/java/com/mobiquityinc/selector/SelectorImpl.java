package com.mobiquityinc.selector;

import com.mobiquityinc.packer.Bag;

import java.util.ArrayList;
import java.util.List;

public class SelectorImpl implements Selector {

    public static final String EMPTY_SELECTED_ITEMS = "-";

    @Override
    public List<String> select(final List<Bag> bags) {
        List<String> itemsSelectedForBags = new ArrayList<>();
        bags.forEach(bag -> {
            int items = bag.getThings().size() + 1;
            int weights = bag.getWeight().intValue() + 1;
            double cost[][] = new double[items][weights];
            for (int i = 1; i < items; i++) {
                for (int w = 1; w < weights; w++) {
                    if (bag.getThings().get(i - 1).getWeight() <= w) {
                        if (bag.getThings().get(i - 1).getCost()
                                + cost[i - 1][w - bag.getThings().get(i - 1).getWeight().intValue()]
                                > cost[i - 1][w]) {

                            cost[i][w] = bag.getThings().get(i - 1).getCost()
                                    + cost[i - 1][w - bag.getThings().get(i - 1).getWeight().intValue()];
                        } else {
                            cost[i][w] = cost[i - 1][w];
                        }

                    } else {
                        cost[i][w] = cost[i - 1][w];
                    }
                }
            }
            int i = bag.getThings().size();
            int w = bag.getWeight().intValue();
            List<String> selectedItemsForCurrentBag = new ArrayList<>();
            while (i > 0 && w > 0) {
                if (cost[i][w] != cost[i - 1][w]) {
                    w = w - bag.getThings().get(i - 1).getWeight().intValue();
                    selectedItemsForCurrentBag.add(bag.getThings().get(i - 1).getIndex().toString());
                }
                i--;
            }
            selectedItemsForCurrentBag.sort(String::compareTo);
            if (selectedItemsForCurrentBag.isEmpty()) {
                itemsSelectedForBags.add(EMPTY_SELECTED_ITEMS);
            } else {
                itemsSelectedForBags.add(String.join(",", selectedItemsForCurrentBag));
            }
        });

        return itemsSelectedForBags;
    }
}