package cn.cement.ysh.coderecord.Controller;


import cn.cement.ysh.coderecord.service.IElasticService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetRequestBuilder;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.*;

@Slf4j
@Api(value = "ElasticSearch测试接口", tags = {"ElasticSearch测试接口"})
@RestController
@RequestMapping(value = "/elastic",method = {RequestMethod.GET,RequestMethod.POST})
public class ElasticCtrl {


    @Autowired
    private IElasticService elasticService;

    @RequestMapping(value = "/testRequestBody")
    public ResponseEntity<List<String>> testRequestBody(@RequestBody JSONObject jsonObject){

        List<String> resultList = elasticService.test(jsonObject);
        return ResponseEntity.ok(resultList);
    }


    @ApiImplicitParams({

    @ApiImplicitParam(name = "aaa",  value = "字段1", required = true, dataType="string",paramType="query"),
    @ApiImplicitParam(name = "bbb", value = "字段2", required = true, dataType="string",paramType="query"),
    @ApiImplicitParam(name = "O.a", value = "字段O.a", required = true, dataType="string",paramType="query"),
    @ApiImplicitParam(name = "O.b", value = "字段O.b", required = true, dataType="string",paramType="query")
    })
    @RequestMapping(value = "/testRequestParam")
    public ResponseEntity<String> testRequestParam(@RequestParam Map paramMap,@RequestBody(required = false) JSONObject bodyJson){
        log.info("======  {}",paramMap);
        return ResponseEntity.ok(JSON.toJSONString(paramMap));
    }

    @RequestMapping(value = "/testMatrixVariable/{ownerId}/pets/{petId}")
    public ResponseEntity<String> testMatrixVariable(@PathVariable("ownerId") String ownerId,@MatrixVariable(pathVar = "ownerId") Map<String, String> matrixVars,
                                                     @MatrixVariable(pathVar = "petId") Map<String, String> petMatrixVars){

        System.out.println(matrixVars+":matrixVars");
        System.out.println(petMatrixVars+":petMatrixVars");
        return null;
    }

    @RequestMapping(value = "/index")
    public ResponseEntity<IndexResponse> index(@RequestParam Map<String,String> paramsMap,@RequestBody JSONObject bodyJson) throws IOException {
        IndexRequest indexRequest = new IndexRequest("index", "type", "1").source(bodyJson);
        IndexResponse indexResponse = elasticService.index(indexRequest);
        return ResponseEntity.ok(indexResponse);
    }

    @RequestMapping(value = "/get")
    @ApiImplicitParam(name = "getRequest", value = "get请求实体类", required = true, dataType="org.elasticsearch.action.get.GetRequest",paramType="query")
    public ResponseEntity<GetResponse> get(@RequestParam("getRequest") GetRequest getRequest) throws IOException {
        GetResponse getResponse = elasticService.get(getRequest);
        return ResponseEntity.ok(getResponse);

    }




}
