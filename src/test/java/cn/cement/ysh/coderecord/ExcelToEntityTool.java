package cn.cement.ysh.coderecord;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.lang.Console;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.sax.handler.RowHandler;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;


/**
 *
 */
public class ExcelToEntityTool {
    private static String excelPath = "E:\\工程资料\\邵阳特色系统(YY-last).xlsx";
    private static String packageName ="com.enqd.sywan.common.entity" ;
    private static String CRLF = "\n";
    private static String TAB = "\t";
    private static String SPACE = " ";
//    private static String  PATH ="E:/YSH/JAVA文件生成/安检通知及布控/";
    private static String  PATH ="E:\\WorkSpace\\LocalSpace\\sywan\\common\\src\\main\\java\\com\\enqd\\sywan\\common\\entity\\";
    private static  File javaFile;
    public static void main(String[] args) {
//        ExcelUtil.read07BySax(ExcelPath,0, rowHandler());
//        ExcelUtil.read07BySax(ExcelPath,5, rowHandler());
//        ExcelUtil.read07BySax(ExcelPath,2, rowHandler());
        ExcelUtil.read07BySax(excelPath,6, rowHandler());
    }

    private static RowHandler rowHandler() {
        return new RowHandler() {
            @Override
            public void handle(int sheetIndex, int rowIndex, List<Object> rowlist) {
                Console.log("{} {} {}", sheetIndex, rowIndex, rowlist);
                if (rowlist.size()==2){
                     if (ObjectUtil.isNotNull(javaFile)) {
                         FileUtil.writeLines(Arrays.asList("}"),javaFile,"utf-8",true);
                     }
                    javaFile = FileUtil.file(PATH+StrUtil.upperFirst(String.valueOf(rowlist.get(1)))+".java");
                    ArrayList<String> lineList = new ArrayList<>();
                    lineList.add("package"+SPACE+packageName+";");
                    lineList.add("");
                    lineList.add("import lombok.Data;");
                    lineList.add("");
                    lineList.add("/**");
                    lineList.add("*@author:YSH "+ LocalDate.now());
                    lineList.add("*/");
                    lineList.add("//"+rowlist.get(0));
                    lineList.add("@Data");
                    lineList.add("public class"+SPACE+StrUtil.upperFirst(String.valueOf(rowlist.get(1)))+"{");

                    FileUtil.writeLines(lineList,javaFile,"utf-8",true);


                }else{
                    boolean matches = Pattern.matches("[\\u4e00-\\u9fa5]+", String.valueOf(rowlist.get(0)));
                    if (!matches){
                        ArrayList<String> lineList = new ArrayList<>();
                        String javeType = getJaveType(String.valueOf(rowlist.get(1)));
                        String comment = "    //"+"["+rowlist.get(2)+"]"+rowlist.get(6);
                        if (rowlist.size()>7&&!ObjectUtil.isEmpty(rowlist.get(7))){
                            comment +="-->"+rowlist.get(7);
                        }
                        lineList.add("    private"+SPACE+javeType+SPACE+rowlist.get(0)+";"+comment);

                        FileUtil.writeLines(lineList,javaFile,"utf-8",true);

                    }
                }
            }
        };
    }

    private static String getJaveType(String dbtype){
        if (StrUtil.equalsIgnoreCase(dbtype,"DATE")){
              return "java.util.Date";
        }
        if (StrUtil.equalsIgnoreCase(dbtype,"LONG")){
              return "String";
        }
        if (StrUtil.equalsIgnoreCase(dbtype,"TIMESTAMP")){
              return "java.sql.Timestamp";
        }
        if (StrUtil.equalsIgnoreCase(dbtype,"NUMBER")){
            return "int";
        }
        if (StrUtil.equalsIgnoreCase(dbtype,"BLOB")){
            return "java.sql.Blob";
        }
        if (StrUtil.equalsIgnoreCase(dbtype,"CLOB")){
            return "java.sql.Clob";
        }
        if (StrUtil.containsAnyIgnoreCase(dbtype,"VARCHAR")){
            return "String";
        }
        return "String";
    }




}
