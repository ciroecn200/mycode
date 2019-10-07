package com.mobiquityinc.file;

import com.mobiquityinc.exception.APIException;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.Validate;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class FileImpl implements File {

    private static final String WRONG_FILE_PATH = "FilePath cannot be null or empty";
    private static final String WRONG_FILE_CONTENT = "The file must contain at least one element";

    @Override
    public List<String> get(final String filePath) throws APIException {
        try {
            Validate.notEmpty(filePath, WRONG_FILE_PATH);
            FileInputStream fileInputStream = new FileInputStream(filePath);
            List<String> data = IOUtils.readLines(fileInputStream, StandardCharsets.UTF_8);
            Validate.notEmpty(data, WRONG_FILE_CONTENT);
            return data;

        } catch (IOException | IllegalArgumentException | NullPointerException e) {
            throw new APIException(e.getMessage());
        }

    }

}
