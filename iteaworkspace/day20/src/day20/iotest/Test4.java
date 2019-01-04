package day20.iotest;

import java.io.*;

/**
 * 4.复制文件夹d:/sxtjava下面所有文件和子文件夹内容到d:/sxtjava2。
 * 提示：涉及单个文件复制、目录的创建、递归的使用
 */
public class Test4 {
    // 复制单个文件
    public static void copyFile(File sourceFile, File targetFile) throws IOException {
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;

        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(sourceFile));
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(targetFile));

            byte[] bytes = new byte[1024];
            int length = 0;
            while ((length = bufferedInputStream.read()) != -1) {
                bufferedOutputStream.write(bytes, 0, length);
            }
            // 刷新此缓冲的输出流
            bufferedOutputStream.flush();
        } finally {
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
            if (bufferedOutputStream != null) {
                bufferedOutputStream.close();
            }
        }
    }

    // 复制目录
    public static void copyDirectory(String sourceDir, String targetDir) throws IOException {
        // 检查源目录
        File fileSourceDir = new File(sourceDir);
        // exists()---测试此抽象路径名表示的文件或目录是否存在。
        // isDirectory()---测试此抽象路径名表示的文件是否为目录。
        if (!fileSourceDir.exists() || !fileSourceDir.isDirectory()) {
            System.out.println("源文件不存在。");
            return;
        }

        // 检查目标目录，如果不存在就创建
        File fileTargetDir = new File(targetDir);
        if (!fileTargetDir.exists()) {
            // 创建由此抽象路径名命名的目录，包括任何必需但不存在的父目录。
            fileTargetDir.mkdirs();
        }

        // 遍历源目录下的文件或目录
        File[] files = fileSourceDir.listFiles();
        for (int i = 0; i < files.length; i++) {
            if (files[i].isFile()) {
                // 源文件
                File sourceFile = files[i];
                // 目标文件
                File targerFile = new File(fileTargetDir, files[i].getName());
                copyFile(sourceFile, targerFile);
            }
            // 递归复制子目录
            if(files[i].isDirectory()){
                // 准备复制的源文件夹
                // separator---与系统相关的默认名称 - 分隔符字符，以方便的方式表示为字符串。
                String subSourceFile = sourceDir + File.separator + files[i].getName();
                // 准备复制的目标文件夹
                String subTargerFile = targetDir + File.separator + files[i].getName();
                // 复制子目录
                copyDirectory(subSourceFile,subTargerFile);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        copyDirectory("F:\\test","F:\\test_1");
    }
}
