package com.mobiquityinc.packer;

import com.mobiquityinc.exception.APIException;
import com.mobiquityinc.extractor.Extractor;
import com.mobiquityinc.extractor.ExtractorImpl;
import com.mobiquityinc.file.File;
import com.mobiquityinc.file.FileImpl;
import com.mobiquityinc.selector.Selector;
import com.mobiquityinc.selector.SelectorImpl;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class that handler the packing of thing
 */
public class Packer {

    private final static Logger LOGGER = Logger.getLogger(Packer.class.getName());
    public static final String DELIMITER_FINAL_PACK = " ";

    /**
     * To avoid create an instance of the class
     */
    private Packer() {
    }

    /**
     * Generates a String items packed for each line of the file separated by a , and each line (TestCase) of the file separated by a space
     * E.G
     * Pw1 (i1,w1,c1) (i2,w2,c2)
     * Pw2 (i1,w1,c1)
     * Pw3 (i1,w1,c1) (i2,w2,c2) (i3,w3,c3)
     * <p>
     * 1,2 1 2,3
     *
     * @param filePath Absolute Path of the file that contains the items to pack
     * @return a String with items packed for each line of the file according to certain logic described in the above
     * @throws APIException
     */
    public static String pack(final String filePath) throws APIException {
        LOGGER.log(Level.INFO, "Packing things");
        String output = null;
        File file = new FileImpl();
        List<String> lines = file.get(filePath);
        Extractor extractor = new ExtractorImpl();
        List<Bag> bags = extractor.extract(lines);
        Selector selector = new SelectorImpl();
        List<String> selectedItems = selector.select(bags);
        String finalPack = String.join(DELIMITER_FINAL_PACK, selectedItems);
        LOGGER.log(Level.INFO, "Ending packing things");
        return finalPack;
    }
}
