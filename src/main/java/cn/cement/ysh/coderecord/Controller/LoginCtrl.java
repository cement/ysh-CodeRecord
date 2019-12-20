package cn.cement.ysh.coderecord.Controller;

import cn.cement.ysh.coderecord.entity.RLoginResult;
import cn.cement.ysh.coderecord.entity.RResult;
import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Slf4j
@Api(value = "文件下载测试接口", tags = {"Redis模板示例测试"})
@CrossOrigin
@RestController
@RequestMapping("/android")

public class LoginCtrl {

    @RequestMapping("/login")
    public ResponseEntity<RResult> login(String userName, String password){
        RLoginResult loginResult = RLoginResult.builder().id(123465).userName(userName).userLevel(1).waitPayCount(12).build();
        RResult result = RResult.builder().success(true).errorMsg("").result(JSON.toJSONString(loginResult)).build();
        return ResponseEntity.ok(result);

    }
    @RequestMapping("/loginTest")
    public ResponseEntity<RResult> loginTest(@RequestParam Map paramMap){
        RLoginResult loginResult = RLoginResult.builder().id(1234567).userName(String.valueOf(paramMap.get("userName"))).userLevel(1).waitPayCount(12).build();
        RResult result = RResult.builder().success(true).errorMsg("").result(JSON.toJSONString(loginResult)).build();
        return ResponseEntity.ok(result);

    }
}
