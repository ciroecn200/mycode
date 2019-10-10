package com.mobiquityinc.extractor;

import com.mobiquityinc.packer.Bag;
import com.mobiquityinc.packer.Thing;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractorImpl implements Extractor {

    private static final String LINE_REGEX = "^(\\d+) : (.*)";
    private static final String THING_REGEX = "^\\((\\d+),(\\d+\\.*\\d*),€(\\d+\\.*\\d*)\\)";
    private static final String SEPARATOR_REGEX = "\\s";

    @Override
    public List<Bag> extract(final List<String> lines) {

        List<Bag> bags = new LinkedList<>();
        Pattern linePattern = Pattern.compile(LINE_REGEX);
        Pattern thingPattern = Pattern.compile(THING_REGEX);
        lines.forEach(line -> {
            Matcher lineMatcher = linePattern.matcher(line);
            if (lineMatcher.matches() && lineMatcher.groupCount() == 2) {
                Bag bag = new Bag();
                bag.setWeight(Double.parseDouble(lineMatcher.group(1)));
                List<Thing> things = new ArrayList<>();
                List<String> thingLines = Arrays.asList(lineMatcher.group(2).split(SEPARATOR_REGEX));
                thingLines.forEach(thingLine -> {
                    Matcher thingMatcher = thingPattern.matcher(thingLine);
                    if (thingMatcher.matches() && thingMatcher.groupCount() == 3) {
                        Thing thing = new Thing();
                        thing.setIndex(Long.parseLong(thingMatcher.group(1)));
                        thing.setWeight(Double.parseDouble(thingMatcher.group(2)));
                        thing.setCost(Double.parseDouble(thingMatcher.group(3)));
                        things.add(thing);
                    }
                });
                things.sort(Comparator.comparing(Thing::getIndex));
                bag.setThings(things);
                bags.add(bag);
            }
        });
        return bags;
    }
}
