package org.talamona.mockup.tipicalCases.mockingNew;

import java.io.File;

public class Directory {
    public boolean createDirectoryStructure(String directoryPath) {

        // HOW TO INTERCEPT THIS OBJECT, CREATED IN A METHOD? (NOT A MEMBER VARIABLE)
        File directory = new File(directoryPath);
        if (directory.exists()) {
            throw new IllegalArgumentException("" +
                    directoryPath + " already exists.");
        }
        return directory.mkdirs();
    }
}