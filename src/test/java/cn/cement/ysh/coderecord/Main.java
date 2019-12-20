package cn.cement.ysh.coderecord;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.IdcardUtil;
import cn.hutool.core.util.StrUtil;
import io.swagger.models.auth.In;
import org.junit.platform.commons.util.StringUtils;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntFunction;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
//IdcardUtil.isvalidCard18()
        String idcard = "51343621001204993";
        boolean b = validateIdcard(idcard);
        System.out.println(b);
        System.out.println("=========================================");
        boolean b1 = IdcardUtil.isvalidCard18(idcard);
        System.out.println(b1);
    }

    private static final int[] factor = new int[]{7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
    private static final String[]  validate= new String[]{"1", "0","X","9","8","7","6","5","4","3","2"};
    public static boolean validateIdcard(String idcard){
        Assert.isTrue(!StringUtils.isBlank(idcard),"身份证号码不能为空或空字符");
        Assert.isTrue(idcard.matches("[0-9xX]{15}|[0-9xX]{18}"),"身份证号码位数必须是15位或18位,当前输入为"+idcard.length()+"位");

        String birthday = idcard.substring(6,14);
        LocalDate.parse(birthday, DateTimeFormatter.ofPattern("yyyyMMdd"));

        String idcard17 = idcard.substring(0, 17);
        char[] chars = idcard17.toCharArray();
        int sum = IntStream.range(0, factor.length).map(i -> (chars[i]-'0') * factor[i]).sum();
        int mod = Math.floorMod(sum,11);
        String idcard18 = idcard.substring(17);
        System.out.println(validate[mod]);
        boolean result = idcard18.equalsIgnoreCase(validate[mod]);
        return result;
    }
}
