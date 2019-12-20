package cn.cement.ysh.coderecord.CommonTest;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.spi.FileSystemProvider;

public class CommonTest11 {

    public static void main(String[] args) throws IOException {
        Path source = Paths.get("E:\\Test\\DataBridge\\test\\test.dat");
        Path target = Paths.get("E:\\Test\\DataBridge\\test\\test.data");
//        Path path = Files.move(srcPath, targetPath);

        FileSystemProvider provider = source.getFileSystem().provider();
//        provider.checkAccess(source,);
//        provider.checkAccess(target);

        provider.move(source, target);

//        srcPath.toFile().renameTo(targetPath.toFile());
//
//        File file = new File("E:\\Test\\DataBridge\\test\\test.dat");
//        File file2 = new File("E:\\Test\\DataBridge\\test\\test.dat");
//
//        boolean b = file.renameTo(file2);
//        System.out.println(b);


//        SecurityManager security = System.getSecurityManager();
//        if (security != null) {
//            security.checkWrite(srcPath.toString());
//            security.checkWrite(targetPath.toString());
//        }
    }




}
