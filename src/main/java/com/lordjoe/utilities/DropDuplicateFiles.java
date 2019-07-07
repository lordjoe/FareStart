package com.lordjoe.utilities;

import java.io.File;

/**
 * com.lordjoe.utilities.DropDuplicateFiles
 * User: Steve
 * Date: 3/6/2019
 */
public class DropDuplicateFiles {
    public static final DropDuplicateFiles[] EMPTY_ARRAY = {};

    public static void main(String[] args) {
        File f = new File(args[0]);
        dropDuplicates(f);
    }

    private static void dropDuplicates(File f) {
        File[] files = f.listFiles();
        if (files == null)
            return;
        for (int i = 0; i < files.length; i++) {
            File file = files[i];
            if (isDuplicateFile(file)) {
                dropFile(file);
            } else {
                if (file.isDirectory()) {
                    dropDuplicates(file);
                }
            }
        }
    }

    private static boolean isDuplicateFile(File file) {
        String name = file.getName();
        if (name.contains("(")) return testPossibleDuplicate(file);
        return false;
    }

    private static boolean testPossibleDuplicate(File file) {
        String name = file.getName();
        int index1 = name.indexOf("(");
        int index2 = name.indexOf(")", index1);
        if (index2 == -1)
            return false;
        String test = name.substring(index1 + 1, index2 );
        if (test.length() == 0)
            return false;
        for (int i = 0; i < test.length(); i++) {
            if (!Character.isDigit(test.charAt(i)))
                return false;
        }
        return true;
    }

    private static void dropFile(File file) {

        System.out.println(file);
        if (file.isDirectory()) {
            FileUtilities.expungeDirectory(file);
        } else {
            file.delete();
        }
    }


}
