package com.mobiquityinc.file;

import com.mobiquityinc.exception.APIException;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.Validate;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class that handler the implementation of File
 */
public class FileImpl implements File {
    private final static Logger LOGGER = Logger.getLogger(FileImpl.class.getName());

    private static final String WRONG_FILE_PATH = "FilePath cannot be null or empty";
    private static final String WRONG_FILE_CONTENT = "The file must contain at least one element";

    @Override
    public List<String> get(final String filePath) throws APIException {
        try {
            LOGGER.log(Level.INFO, "Getting file from {0}", filePath);
            Validate.notEmpty(filePath, WRONG_FILE_PATH);
            FileInputStream fileInputStream = new FileInputStream(filePath);
            List<String> data = IOUtils.readLines(fileInputStream, StandardCharsets.UTF_8);
            Validate.notEmpty(data, WRONG_FILE_CONTENT);
            LOGGER.log(Level.INFO, "Ending getting file from {0}", filePath);
            return data;

        } catch (IOException | IllegalArgumentException | NullPointerException e) {
            LOGGER.log(Level.SEVERE, "An Error has occurred while was trying to get the file", e);
            throw new APIException(e.getMessage());
        }

    }

}
