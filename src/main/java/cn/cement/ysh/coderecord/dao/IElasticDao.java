package cn.cement.ysh.coderecord.dao;

import com.alibaba.fastjson.JSONObject;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;

import java.io.IOException;
import java.util.List;

public interface IElasticDao {
    List<String> test(JSONObject jsonObject);

    IndexResponse index(IndexRequest indexRequest) throws IOException;

    GetResponse get(GetRequest getRequest) throws IOException;
}
