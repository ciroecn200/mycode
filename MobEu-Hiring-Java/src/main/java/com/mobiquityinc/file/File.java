package com.mobiquityinc.file;

import com.mobiquityinc.exception.APIException;

import java.util.List;

/**
 * Class that handler the operations related to a File
 * I use an interface because in this way is easy to change in the future to a better implementation
 * without affecting the rest of the code
 */
public interface File {

    /**
     * Opens a File by given filePath an returns a List of String
     *
     * @param filePath Absolute path to the file to read
     * @return Each line that has the file will be returned as a element of a List of String
     * @throws APIException If the parameter filePath is invalid
     */
    List<String> get(String filePath) throws APIException;
}
