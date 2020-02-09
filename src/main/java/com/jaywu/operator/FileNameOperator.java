package com.jaywu.operator;

import com.jaywu.enums.AudioFileType;
import com.jaywu.enums.DefinitionType;
import com.jaywu.enums.WebsiteURLType;
import com.jaywu.utils.StringUtils;
import com.jaywu.utils.StringUtilsException;

import java.io.File;
import java.util.Objects;

public class FileNameOperator {
    private FileNameOperator() {
    }

    public static String filterURL(String fileName) throws StringUtilsException {
        String rtn = fileName;
        for (WebsiteURLType item : WebsiteURLType.values()) {
            rtn = StringUtils.removeTargetString(rtn, item.getValue());
        }
        return rtn;
    }

    public static String filterDefinition(String fileName) throws StringUtilsException {
        String rtn = fileName;
        for (DefinitionType item : DefinitionType.values()) {
            rtn = StringUtils.removeTargetString(rtn, item.getValue());
        }
        return rtn;
    }

    public static boolean isAudioFile(String fileName) {
        for (AudioFileType item : AudioFileType.values()) {
            if (fileName.toUpperCase().endsWith(item.getValue().toUpperCase()))
                return true;
        }
        return false;
    }

    public static boolean renameFile(File file, boolean needReplaceWebsiteURL, boolean needReplaceDefinition) throws StringUtilsException {
        String fileName = file.getName();
        if (needReplaceWebsiteURL)
            fileName = filterURL(fileName);
        if (needReplaceDefinition)
            fileName = filterDefinition(fileName);
//        fileName = removeExtraDot(fileName);
        File newFile = new File(file.getParentFile().getAbsolutePath() + "\\" + fileName);
        System.out.println(newFile.getAbsolutePath());
        return file.renameTo(newFile);
    }

    public static String removeExtraDot(String fileName) {
        return fileName.substring(0, fileName.lastIndexOf('.')).replaceAll("\\.", "")
                + fileName.substring(fileName.lastIndexOf('.'));
    }

    public static void renameAll(File rootDir, boolean includeAll, boolean needReplaceWebsiteURL, boolean needReplaceDefinition) throws StringUtilsException {
        if (!rootDir.exists() || !rootDir.isDirectory())
            return;
        for (File item : Objects.requireNonNull(rootDir.listFiles())) {
            if (item.isDirectory() && includeAll)
                renameAll(item, true, needReplaceWebsiteURL, needReplaceDefinition);
            else if (item.isFile())
                renameFile(item, needReplaceWebsiteURL, needReplaceDefinition);
        }
    }
}
