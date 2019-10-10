package com.mobiquityinc.selector;

import com.mobiquityinc.packer.Box;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that handler the implementation of Selector
 * To resolve the selection in this method
 * I used the Dynamic programming that has O(n) execution time that has a better performance that if I use Brute force that has an execution time of O(2^n) *
 */
public class SelectorImpl implements Selector {

    private static final String EMPTY_SELECTED_ITEMS = "-";
    private static final String DELIMITER = ",";

    @Override
    public List<String> select(final List<Box> bags) {
        List<String> itemsSelectedForBags = new ArrayList<>();
        if (bags != null) {
            bags.forEach(bag -> {  // I repeat the process for each bag on bags
                int items = bag.getThings().size() + 1; // Calculates the # of items
                int weights = bag.getWeight().intValue() + 1; // Calculates the # of weight
                double cost[][] = new double[items][weights]; // Creates a matrix[][] of costs
                for (int i = 1; i < items; i++) {
                    for (int w = 1; w < weights; w++) {
                        if (bag.getThings().get(i - 1).getWeight() <= w) { // Asks if (i-1)Element weight is less or equals that if the bag had the current weight (w) this means that is a candidate to be packed
                            if (bag.getThings().get(i - 1).getCost() // Here we check if we got an increment in the cost
                                    + cost[i - 1][w - bag.getThings().get(i - 1).getWeight().intValue()]
                                    > cost[i - 1][w]) {

                                cost[i][w] = bag.getThings().get(i - 1).getCost() // we set the new increment
                                        + cost[i - 1][w - bag.getThings().get(i - 1).getWeight().intValue()];
                            } else {
                                cost[i][w] = cost[i - 1][w]; // we keep the same value of the cost as we have in the previous row
                            }

                        } else {
                            cost[i][w] = cost[i - 1][w]; // we keep the same value of the cost as we have in the previous row
                        }
                    }
                }
                // to this point we have the maximum cost that we can have but we need to look for the items that generates the maximum cost
                int i = bag.getThings().size();
                int w = bag.getWeight().intValue();
                List<String> selectedItemsForCurrentBag = new ArrayList<>();
                while (i > 0 && w > 0) {
                    if (cost[i][w] != cost[i - 1][w]) { // we look if a change happens
                        w = w - bag.getThings().get(i - 1).getWeight().intValue(); // we subtract from the Weight of the current box/bag the weight of the selected element
                        if (i < bag.getThings().size() && // here we check if the previous element has same cost to the selected one if so, we select the item that cost less
                                bag.getThings().get(i - 1).getCost().compareTo(bag.getThings().get(i).getCost()) == 0 &&
                                bag.getThings().get(i - 1).getWeight().compareTo(bag.getThings().get(i).getWeight()) > 0) {
                            selectedItemsForCurrentBag.add(bag.getThings().get(i).getIndex().toString());
                        } else {
                            selectedItemsForCurrentBag.add(bag.getThings().get(i - 1).getIndex().toString());
                        }
                    }
                    i--;
                }
                selectedItemsForCurrentBag.sort(String::compareTo);
                if (selectedItemsForCurrentBag.isEmpty()) { // if any items were selected we put a dash (-)
                    itemsSelectedForBags.add(EMPTY_SELECTED_ITEMS);
                } else { // Here we join all the selected elements by a (,)
                    itemsSelectedForBags.add(String.join(DELIMITER, selectedItemsForCurrentBag));
                }
            });
        }
        return itemsSelectedForBags;
    }
}
