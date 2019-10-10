package com.mobiquityinc.packer;

import com.mobiquityinc.exception.APIException;
import org.apache.commons.lang3.StringUtils;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Objects;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Testing class for Packer
 */
public class PackerTest {

    private static final String ABSOLUTE_PATH = getAbsolutePathForAFile();
    private static final String PATH_FORMAT = "%s%s";
    private static final String INPUT = String.format(PATH_FORMAT, ABSOLUTE_PATH, "input");
    private static final String EMPTY_INPUT = String.format(PATH_FORMAT, ABSOLUTE_PATH, "emptyInput");
    private static final String FILE_PATH_CANNOT_BE_NULL_OR_EMPTY = "FilePath cannot be null or empty";
    private static final String THE_FILE_MUST_CONTAIN_AT_LEAST_ONE_ELEMENT = "The file must contain at least one element";
    private static final String DUMMY_PATH_NO_SUCH_FILE_OR_DIRECTORY = "/dummy/path (No such file or directory)";
    private static final String DUMMY_PATH = "/dummy/path";
    private static final String EXPECTED_OUTPUT = "4 - 2,7 8,9";

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    /**
     * Scenario:
     * Executes {@link Packer#pack(String)} with null parameter
     * Expected:
     * Throws a APIException with "FilePath cannot be null or empty" message
     *
     * @throws APIException
     */
    @Test
    public void testingWithNullParameter() throws APIException {
        thrown.expect(APIException.class);
        thrown.expectMessage(FILE_PATH_CANNOT_BE_NULL_OR_EMPTY);
        Packer.pack(null);
    }

    /**
     * Scenario:
     * Executes {@link Packer#pack(String)} with null parameter
     * Expected:
     * Throws a APIException with "FilePath cannot be null or empty" message
     *
     * @throws APIException
     */
    @Test
    public void testingWithEmptyParameter() throws APIException {
        thrown.expect(APIException.class);
        thrown.expectMessage(FILE_PATH_CANNOT_BE_NULL_OR_EMPTY);
        Packer.pack(StringUtils.EMPTY);
    }

    /**
     * Scenario:
     * Executes {@link Packer#pack(String)} with dummy path
     * Expected:
     * Throws a APIException with "/dummy/path (No such file or directory)" message
     *
     * @throws APIException
     */
    @Test
    public void testingWithNoExitingFile() throws APIException {
        thrown.expect(APIException.class);
        thrown.expectMessage(DUMMY_PATH_NO_SUCH_FILE_OR_DIRECTORY);
        Packer.pack(DUMMY_PATH);
    }

    /**
     * Scenario:
     * Executes {@link Packer#pack(String)} with a empty file
     * Expected:
     * Throws a APIException with "The file must contain at least one element" message
     *
     * @throws APIException
     */
    @Test
    public void testingWithEmptyFile() throws APIException {
        thrown.expect(APIException.class);
        thrown.expectMessage(THE_FILE_MUST_CONTAIN_AT_LEAST_ONE_ELEMENT);
        Packer.pack(EMPTY_INPUT);
    }

    /**
     * Scenario:
     * Executes {@link Packer#pack(String)} with the file sent with the assigment
     * Expected:
     * Should return the String '4 - 2,7 8,9'
     *
     * @throws APIException
     */
    @Test
    public void testingWithAGoodFile() throws APIException {
        String output = Packer.pack(INPUT);
        assertThat(output, is(EXPECTED_OUTPUT));
    }

    /**
     * Get Absolute Path of /resources folder for the test
     *
     * @return absolute Path
     */
    private static String getAbsolutePathForAFile() {
        ClassLoader classLoader = PackerTest.class.getClassLoader();
        return Objects.requireNonNull(classLoader.getResource(StringUtils.EMPTY)).getPath();
    }
}
