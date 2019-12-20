package cn.cement.ysh.coderecord.CommonTest;

import cn.hutool.core.io.FileUtil;

import java.io.*;
import java.math.BigDecimal;

public class CommonTest33 {

    public static String getFilePath(BigDecimal bigDecimal){
        return "E:\\Test\\DataBridge\\Watch\\YSH-T_STUDENT-"+bigDecimal+".dat";
    }
    public static void main(String[] args) {
        String json =
                "[" +
                        "{\"idCard\":\"430100010001000198\",\"name\":\"李四002\",\"age\":12,\",gender\":\"男\",\"departMent\":\"英文系\",\"CLASS\":\"英文一班\",\"createTime\":\"2019-8-15 08:35:23\",\"SEX\":true}," +
                        "{\"idCard\":\"430100010001000200\",\"name\":\"李四003\",\"age\":10,\",gender\":\"男\",\"departMent\":\"英文系\",\"CLASS\":\"英文一班\",\"createTime\":\"2019-8-15 08:35:40\",\"SEX\":true}," +
                        "{\"idCard\":\"430100010001000201\",\"name\":\"李四004\",\"age\":10,\"gender\":\"男\",\"departMent\":\"英文系\",\"CLASS\":\"英文一班\",\"createTime\":\"2019-8-15 08:35:41\",\"SEX\":true}," +
                        "{\"idCard\":\"430100010001000202\",\"name\":\"李四005\",\"age\":16,\"gender\":\"男\",\"departMent\":\"英文系\",\"CLASS\":\"英文一班\",\"createTime\":\"2019-8-15 08:35:31\",\"SEX\":true}," +
                        "{\"idCard\":\"430100010001000203\",\"name\":\"李四006\",\"age\":10,\"gender\":\"男\",\"departMent\":\"英文系\",\"CLASS\":\"英文一班\",\"createTime\":\"2019-8-15 08:35:24\",\"SEX\":true}," +
                        "{\"idCard\":\"430100010001000204\",\"name\":\"李四007\",\"age\":18,\"gender\":\"男\",\"departMent\":\"英文系\",\"CLASS\":\"英文一班\",\"createTime\":\"2019-8-15 08:35:25\",\"SEX\":true}," +
                        "{\"idCard\":\"430100010001000214\",\"name\":\"李四007\",\"age\":10,\"gender\":\"男\",\"departMent\":\"英文系\",\"CLASS\":\"英文一班\",\"createTime\":\"2019-8-15 08:35:25\",\"SEX\":true}," +
                        "{\"idCard\":\"430100010001000224\",\"name\":\"李四007\",\"age\":19,\"gender\":\"男\",\"departMent\":\"英文系\",\"CLASS\":\"英文一班\",\"createTime\":\"2019-8-15 08:35:25\",\"SEX\":true}," +
                        "{\"idCard\":\"430100010001000234\",\"name\":\"李四007\",\"age\":11,\"gender\":\"男\",\"departMent\":\"英文系\",\"CLASS\":\"英文一班\",\"createTime\":\"2019-8-15 08:35:25\",\"SEX\":true}," +
                        "{\"idCard\":\"430100010001000244\",\"name\":\"李四007\",\"age\":10,\"gender\":\"男\",\"departMent\":\"英文系\",\"CLASS\":\"英文一班\",\"createTime\":\"2019-8-15 08:35:25\",\"SEX\":true}," +
                        "{\"idCard\":\"430100010001000245\",\"name\":\"李四007\",\"age\":10,\"gender\":\"男\",\"departMent\":\"英文系\",\"CLASS\":\"英文一班\",\"createTime\":\"2019-8-15 08:35:25\",\"SEX\":true}" +
                        "]";

        BigDecimal bigDecimal = new BigDecimal("20191015121012105711");
//        String jsonStr =  "{\"idCard\":\"430100010001000198\",\"name\":\"李四002\",\"age\":12,\",gender\":\"男\",\"departMent\":\"英文系\",\"CLASS\":\"英文一班\",\"createTime\":\"2019-8-15 08:35:23\",\"SEX\":true}";
//        File file = FileUtil.writeString(json, "E:\\Test\\DataBridge\\Watch\\YSH-T_STUDENT-20190909121012105701.dat", "utf-8");
//     File file = FileUtil.writeString(json, fileName, "utf-8");


        for (int i = 0; i < 100; i++) {
            bigDecimal = bigDecimal.add(BigDecimal.valueOf(i));

            PrintWriter out = null;
            try {
                out = new PrintWriter(new FileWriter(getFilePath(bigDecimal)));
                out.print(json);

                Thread.sleep(1000);
                out.flush();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                out.close();
            }
        }

    }




}
