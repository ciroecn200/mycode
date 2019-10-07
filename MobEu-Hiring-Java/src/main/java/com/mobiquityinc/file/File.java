package com.mobiquityinc.file;

import com.mobiquityinc.exception.APIException;

import java.util.List;

public interface File {

    List<String> get(String filePath) throws APIException;
}
