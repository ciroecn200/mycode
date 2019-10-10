package com.mobiquityinc.exception;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Testing class for Packer
 */
public class APIExceptionTest {


    private static final String AN_EXCEPTION = "an exception";
    private APIException apiException;

    /**
     * Scenario:
     * Executes {@link APIException#APIException(String)} with a not null parameter
     * Expected:
     * {@link APIException#getMessage()} should returns 'an exception'
     */
    @Test
    public void testingConstructorWithOneParameter() {
        apiException = new APIException(AN_EXCEPTION);
        assertThat(apiException.getMessage(), is(AN_EXCEPTION));
    }

    /**
     * Scenario:
     * Executes {@link APIException#APIException(String)} with a null parameter
     * Expected:
     * {@link APIException#getMessage()} should returns null
     */
    @Test
    public void testingConstructorWithOneNullParameter() {
        apiException = new APIException(null);
        assertThat(apiException.getMessage(), is(nullValue()));
    }

    /**
     * Scenario:
     * Executes {@link APIException#APIException(String, Exception)} with not null parameters
     * Expected:
     * {@link APIException#getMessage()} should returns 'an exception'
     * {@link APIException#getCause()} should returns an instance of NullPointerException
     */
    @Test
    public void testingConstructorWithTwoParameters() {
        apiException = new APIException(AN_EXCEPTION, new NullPointerException());
        assertThat(apiException.getMessage(), is(AN_EXCEPTION));
        assertThat(apiException.getCause(), instanceOf(NullPointerException.class));
    }

    /**
     * Scenario:
     * Executes {@link APIException#APIException(String, Exception)} with null parameters
     * Expected:
     * {@link APIException#getMessage()} should returns null
     * {@link APIException#getCause()} should returns null
     */
    @Test
    public void testingConstructorWithTwoNullParameters() {
        apiException = new APIException(null, null);
        assertThat(apiException.getMessage(), is(nullValue()));
        assertThat(apiException.getCause(), is(nullValue()));
    }


}
