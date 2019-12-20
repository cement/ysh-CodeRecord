package cn.cement.ysh.coderecord.Controller;

import cn.cement.ysh.coderecord.common.Component.RedisOperator;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Api(value = "Redis模板", tags = {"Redis模板示例测试"})
@RestController
@RequestMapping("/redis")
public class RedisCtrl {


    @Resource
    private RedisOperator redisOperator;
    private AtomicInteger atomicInteger = new AtomicInteger(30000);

    @RequestMapping(value = "/test", method = {RequestMethod.GET, RequestMethod.POST})
    public void demoTest() {
        int andIncr = atomicInteger.getAndIncrement();
        redisOperator.set(Integer.toString(andIncr), "value-" + Integer.toString(andIncr));
    }

    @RequestMapping(value = "/deleteAllKeys", method = {RequestMethod.GET, RequestMethod.POST})
    public void deleteAllKeys() {
        redisOperator.delete(redisOperator.keys("*"));
    }

    @ApiOperation(value = "@YSH 分组redis Key", notes = "分组redis Key")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pattern", value = "redis key", required = true, dataType = "String", paramType = "query"),
    })


    @RequestMapping(value = "/allkeysGroup", method = {RequestMethod.GET, RequestMethod.POST})
    public Map<Integer, List<String>> allkeys(@RequestParam("pattern") String pattern) {
        List<String> list = redisOperator.keys("*").stream().collect(Collectors.toList());
        Map<Integer, List<String>> map = list.stream().collect(Collectors.groupingBy(item -> list.indexOf(item) % 3));
        return map;
    }

}
