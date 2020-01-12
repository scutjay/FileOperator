package com.jaywu;

import java.io.File;

public class MyFile extends File {
    public MyFile(String pathname) {
        super(pathname);
    }

    public String getFileType() throws Exception {
        int lastDotIdx = getName().lastIndexOf('.');
        if (lastDotIdx <= 0 || lastDotIdx == getName().length() - 1)
            throw new Exception("No file type found");
        return getName().substring(lastDotIdx+1);
    }
}
