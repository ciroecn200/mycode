package com.mobiquityinc;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

/**
 * Class for being used as utility for testing
 */
public final class Utility {

    private static final String ABSOLUTE_PATH = Utility.getAbsolutePathForAFile();
    private static final String PATH_FORMAT = "%s%s";
    public static final String INPUT = String.format(PATH_FORMAT, ABSOLUTE_PATH, "input");
    public static final String EMPTY_INPUT = String.format(PATH_FORMAT, ABSOLUTE_PATH, "emptyInput");
    public static final String FILE_PATH_CANNOT_BE_NULL_OR_EMPTY = "FilePath cannot be null or empty";
    public static final String THE_FILE_MUST_CONTAIN_AT_LEAST_ONE_ELEMENT = "The file must contain at least one element";
    public static final String DUMMY_PATH_NO_SUCH_FILE_OR_DIRECTORY = "/dummy/path (No such file or directory)";
    public static final String DUMMY_PATH = "/dummy/path";

    /**
     * private constructor to avoid a new instance
     */
    private Utility() {

    }

    /**
     * Get Absolute Path of /resources folder for the test
     *
     * @return absolute Path
     */
    public static String getAbsolutePathForAFile() {
        ClassLoader classLoader = Utility.class.getClassLoader();
        return Objects.requireNonNull(classLoader.getResource(StringUtils.EMPTY)).getPath();
    }


}
