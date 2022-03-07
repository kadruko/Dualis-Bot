package com.schewe.dualisbot.abstraction.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;

public class FileUtils {

    public static void copyAllFilesFromDirectory(File srcDir, File destDir) throws IOException{
        for (File srcFile : srcDir.listFiles()){
            FileChannel src = new FileInputStream(srcFile).getChannel();
            File destFile = new File(destDir.getPath() + "/" + srcFile.getName());
            FileChannel dest = new FileOutputStream(destFile).getChannel();
            dest.transferFrom(src, 0, src.size());
            src.close();
            dest.close();
        }
    }

    public static void deleteAllFilesFromDirectory(File dir) throws IOException {
        if (dir.isDirectory()) {
            for (File c : dir.listFiles())
                c.delete();
        }
    }

    public static String join(String path1, String path2){
        return Paths.get(path1, path2).toString();
    }

}
