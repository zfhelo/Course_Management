package org.gdpi.course.utils;

import java.io.File;

public class DeleteFiles {
    /**
     * 删除文件
     * @param files
     */
    public static void deleteFiles(File...files) {
        for (File f:files) {
            File[] ff = f.listFiles();
            // 是文件 或 空目录 直接删除
            if (f.isFile() || ff == null) {
                boolean delete = f.delete();
                continue;
            }
            // 删除子目录
            deleteFiles(ff);
            f.delete();
        }
    }
}
