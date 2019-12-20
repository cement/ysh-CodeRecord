package cn.cement.ysh.coderecord.CommonTest;

import cn.cement.ysh.coderecord.utils.FtpUtil;
import cn.hutool.core.lang.Console;
import cn.hutool.core.util.ReUtil;
import cn.hutool.http.HttpUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.sax.handler.RowHandler;
import cn.hutool.system.SystemUtil;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.function.Consumer;

@Slf4j
public class CommonTest {

    public static void main(String[] args) throws IOException, InterruptedException {

//
//        String decrypt = null;
//        try {
//            decrypt = DesUtil.decrypt("4FD5CCC08AD6D0CE203877970CA910266650FBE30EE39FD6");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.out.println(decrypt);

//
//        //匿名登录（无需帐号密码的FTP服务器）

//        System.out.println(ftp.getClient().getStatus());
//        //进入远程目录
//
////        ftp.cd("/opt/upload");
//       //上传本地文件
//        Ftp ftp = new Ftp("192.168.1.80", 21, "ysh", "ysh");
//        boolean upload = ftp.upload("YSH", FileUtil.file("E:\\YSH\\BaiduMap.jar"));
//        System.out.println(upload);
//        //下载远程文件
////        ftp.download("ddd.mp4", FileUtil.file("e:/YSH/"));
//
//       //关闭连接
//        ftp.close();

        FtpUtil ftpUtils = new FtpUtil();
        boolean b = ftpUtils.uploadFile("/YSH", "ddd.mp4", "E:\\YSH\\ddd.mp4");
        System.out.println(b);


//        ProcessBuilder pb = new ProcessBuilder("ipconfig");
//
//        Process process = pb.start();
//
//
//        process.waitFor();
//
//        PipedInputStream in = new PipedInputStream();
//        PipedOutputStream out = new PipedOutputStream(in);
//        System.setIn(in);
////        out.connect(in);
////          System.getProperties().putAll(System.getenv());
////         System.getProperties().list(new PrintStream(new FileOutputStream(new File("E:\\env.txt"))));
//         System.getProperties().list(System.out);
//
////        process.destroy();
//
//
//
//        Process process = Runtime.getRuntime().exec("ping 192.168.1.1");
//        consumer.accept(process.getInputStream());
//// 阻塞等待
//        process.waitFor();
//// 打印退出值
//        System.out.println(process.exitValue());

//        //请求列表页
//        String listContent = HttpUtil.get("https://www.oschina.net/action/ajax/get_more_news_list?newsType=&p=2");
////使用正则获取所有标题
//        List<String> titles = ReUtil.findAll("<span class=\"text-ellipsis\">(.*?)</span>", listContent, 1);
//        for (String title : titles) {
//            //打印标题
//            Console.log(title);
//        }

//        ExcelReader reader = ExcelUtil.getReader("E:\\工程资料\\邵阳特色系统(yy).xlsx");
//        List<List<Object>> readAll = reader.read();

//        ExcelUtil.read03BySax("E:\\工程资料\\邵阳特色系统(yy).xlsx", 0, rowHandler());

        String line="GET /test/test?a=aaa HTTP/1.1";

        String[]  firstLine= line.split(" ");
        System.out.println(Arrays.asList(firstLine));
//        System.setProperty("dcq","ddccqq");
        String dcq = System.getProperty("dcq");

        System.out.println(dcq);

//        System.load("");

        String property = System.getProperty("java.library.path");
        String path = System.getProperty("path");
        System.out.println("java.library.path: "+property);
        System.out.println("path: "+ path);

        System.out.println(System.getProperties());
        Properties properties = System.getProperties();

        System.getProperties().list(System.out);

        SystemUtil.getJvmSpecInfo();

        String iotmpdir = System.getProperty("java.io.tmpdir");
        System.out.println(iotmpdir);


    }


    private static final Consumer<InputStream> consumer = (InputStream inputStream) -> {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "gbk"));
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    };




}
