package com.mobiquityinc.extractor;

import com.mobiquityinc.constant.Constant;
import com.mobiquityinc.packer.Box;
import com.mobiquityinc.packer.Thing;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class that handler the implementation of Extractor
 */
public class ExtractorImpl implements Extractor {

    private static final String LINE_REGEX = "^(\\d+) : (.*)";
    private static final String THING_REGEX = "^\\((\\d+),(\\d+\\.*\\d*),€(\\d+\\.*\\d*)\\)";
    private static final String SEPARATOR_REGEX = "\\s";

    @Override
    public List<Box> extract(final List<String> lines) {

        List<Box> bags = new LinkedList<>();
        if (lines != null) {
            Pattern linePattern = Pattern.compile(LINE_REGEX);
            Pattern thingPattern = Pattern.compile(THING_REGEX);
            lines.forEach(line -> {
                Matcher lineMatcher = linePattern.matcher(line);
                if (lineMatcher.matches() && lineMatcher.groupCount() == 2) {
                    Box bag = new Box();
                    bag.setWeight(Double.parseDouble(lineMatcher.group(1)));
                    if (bag.getWeight() <= Constant.MAX_PACKAGE_WEIGHT) {
                        List<Thing> things = new ArrayList<>();
                        List<String> thingLines = Arrays.asList(lineMatcher.group(2).split(SEPARATOR_REGEX));
                        thingLines.forEach(thingLine -> {
                            Matcher thingMatcher = thingPattern.matcher(thingLine);
                            if (thingMatcher.matches() && thingMatcher.groupCount() == 3) {
                                Thing thing = new Thing();
                                thing.setIndex(Long.parseLong(thingMatcher.group(1)));
                                thing.setWeight(Double.parseDouble(thingMatcher.group(2)));
                                thing.setCost(Double.parseDouble(thingMatcher.group(3)));
                                if (thing.getWeight() <= bag.getWeight() &&
                                        thing.getWeight() <= Constant.MAX_THING_WEIGHT &&
                                        thing.getCost() <= Constant.MAX_THING_COST &&
                                        thing.getIndex() <= Constant.MAX_THINGS_ALLOWED_TO_CHOOSE) {
                                    things.add(thing);
                                }
                            }
                        });
                        things.sort(Comparator.comparing(Thing::getIndex));
                        bag.setThings(things);
                        bags.add(bag);
                    }
                }
            });
        }
        return bags;
    }
}
