package com.mobiquityinc.packer;

import com.mobiquityinc.assemble.Assemble;
import com.mobiquityinc.exception.APIException;
import com.mobiquityinc.file.File;
import com.mobiquityinc.file.FileImpl;

import java.util.List;

public class Packer {

    private Packer() {
    }

    public static String pack(String filePath) throws APIException {

        String output = null;
        File file = new FileImpl();
        List<String> lines = file.get(filePath);
        //Assemble assemble = new Assemble();
        //assemble.process(lines);
        return output;
    }
}
