package com.mobiquityinc.exception;

/**
 * Class that handler the exception in the packer functionality
 */
public class APIException extends Exception {

    /**
     * Initialize an instance of APIException
     *
     * @param message of the exception
     * @param e       Exception that rise an APIException
     */
    public APIException(final String message, final Exception e) {
        super(message, e);
    }

    /**
     * Initialize an instance of APIException
     *
     * @param message of the exception
     */
    public APIException(String message) {
        super(message);
    }
}
