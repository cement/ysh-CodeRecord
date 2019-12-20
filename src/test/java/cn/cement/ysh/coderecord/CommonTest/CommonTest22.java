package cn.cement.ysh.coderecord.CommonTest;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CommonTest22 {

    public static void main(String[] args) throws IOException, InterruptedException {
        Path srcPath = Paths.get("E:\\Test\\DataBridge\\test\\test.dat");
        Path targetPath = Paths.get("E:\\Test\\DataBridge\\test\\test.dat");
        Path path = Files.move(srcPath, targetPath);

        FileOutputStream fileOutputStream = new FileOutputStream(srcPath.toString(), true);
        for (int i = 0; i < 1000; i++) {
           fileOutputStream.write(97);
           Thread.sleep(1000);
        }
        fileOutputStream.flush();
        fileOutputStream.close();
    }




}
