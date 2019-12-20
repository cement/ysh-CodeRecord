package cn.cement.ysh.coderecord.Controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IoUtil;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Slf4j
@Api(value = "文件下载测试接口", tags = {"Redis模板示例测试"})
@RestController
@RequestMapping("/media")
public class MediaCtrl {

    @Autowired
    public RestTemplate restTemplate;
    @RequestMapping("/upload")
    public void uploadMedia(@RequestParam("file") MultipartFile file) {

        long start = System.currentTimeMillis();
        String fileName = file.getOriginalFilename();
        Path targetPath = Paths.get( "E:\\Test\\advertfiles",fileName);
        if (Files.exists(targetPath)){
            log.info("文件上传 文件已经存在！：文件名：{}", fileName);
        }else{
            try {
                file.transferTo(targetPath);
                /*返回值*/
                long stop = System.currentTimeMillis();
                String log = "文件上传 成功！：文件名："+fileName+",文件大小/耗时："+file.getSize()+"/"+(stop-start);
            } catch (IOException e) {
                try {
                    Files.deleteIfExists(targetPath);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                long stop = System.currentTimeMillis();
//                String log = "文件上传 失败！：文件名："+fileName+",文件大小/耗时："+file.getSize()+"/"+(stop-start);
                log.info("文件上传 失败！：文件名：");
            }
        }

    }

   @RequestMapping("/download/{fileName:[A-Za-z0-9.]+}")
    public void downloadMedia(@PathVariable("fileName") String fileName, HttpServletResponse response) {
        long start = System.currentTimeMillis();
        Path srcPath = Paths.get("E:\\Test\\advertfiles", fileName);
        try (BufferedInputStream inputStream = FileUtil.getInputStream(srcPath);
             OutputStream outputStream = response.getOutputStream()){
            response.setContentType("application/octet-stream");
            response.setContentLengthLong(srcPath.toFile().length());
            response.setHeader("Content-Disposition", "attachment; filename=" + new String(fileName.getBytes("utf-8"), "iso-8859-1"));
            outputStream.flush();
            long length = IoUtil.copyByNIO(inputStream, outputStream, 1024 * 8, null);
            outputStream.flush();
            /*记录日志*/
            long stop = System.currentTimeMillis();
            log.info("设备端 下载完成  文件名称: {},文件大小:{},耗时 {}毫秒", fileName, length, (stop - start));
        } catch (IOException e) {
            /*记录日志*/
            long stop = System.currentTimeMillis();
            log.error("设备端 下载失败  文件名称: {},,耗时 {}毫秒", fileName,stop - start,e);
        }
    }



}
