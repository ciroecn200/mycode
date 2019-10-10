package com.mobiquityinc.file;

import com.mobiquityinc.exception.APIException;
import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.List;

import static com.mobiquityinc.Utility.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Testing class for File
 */
public class FileTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private File file;

    /**
     * Setting a new instance of the class to test
     */
    @Before
    public void setup() {
        file = new FileImpl();
    }

    /**
     * Scenario:
     * Executes {@link File#get(String)} with null filePath
     * Expected:
     * Should throw a APIException with 'FilePath cannot be null or empty' message
     *
     * @throws APIException
     */
    @Test
    public void testingFileWithNullParameter() throws APIException {
        thrown.expect(APIException.class);
        thrown.expectMessage(FILE_PATH_CANNOT_BE_NULL_OR_EMPTY);
        file.get(null);
    }

    /**
     * Scenario:
     * Executes {@link File#get(String)} with empty
     * Expected:
     * Should throw a APIException with 'FilePath cannot be null or empty' message
     *
     * @throws APIException
     */
    @Test
    public void testingFileWithEmptyParameter() throws APIException {
        thrown.expect(APIException.class);
        thrown.expectMessage(FILE_PATH_CANNOT_BE_NULL_OR_EMPTY);
        file.get(StringUtils.EMPTY);
    }

    /**
     * Scenario:
     * Executes {@link File#get(String)}  with dummy path
     * Expected:
     * Throws a APIException with "/dummy/path (No such file or directory)" message
     *
     * @throws APIException
     */
    @Test
    public void testingFileWithNoExitingFile() throws APIException {
        thrown.expect(APIException.class);
        thrown.expectMessage(DUMMY_PATH_NO_SUCH_FILE_OR_DIRECTORY);
        file.get(DUMMY_PATH);
    }

    /**
     * Scenario:
     * Executes {@link File#get(String)}  with the file sent with the assigment
     * Expected:
     * Should return the String '4 - 2,7 8,9'
     *
     * @throws APIException
     */
    @Test
    public void testingWithAGoodFile() throws APIException {
        List<String> lines = file.get(INPUT);
        assertThat(lines.size(), is(4));
        assertThat(lines.contains("81 : (1,53.38,€45) (2,88.62,€98) (3,78.48,€3) (4,72.30,€76) (5,30.18,€9) (6,46.34,€48)"), is(true));
        assertThat(lines.contains("8 : (1,15.3,€34)"), is(true));
        assertThat(lines.contains("75 : (1,85.31,€29) (2,14.55,€74) (3,3.98,€16) (4,26.24,€55) (5,63.69,€52) (6,76.25,€75) (7,60.02,€74) (8,93.18,€35) (9,89.95,€78)"), is(true));
        assertThat(lines.contains("56 : (1,90.72,€13) (2,33.80,€40) (3,43.15,€10) (4,37.97,€16) (5,46.81,€36) (6,48.77,€79) (7,81.80,€45) (8,19.36,€79) (9,6.76,€64)"), is(true));

    }

}
