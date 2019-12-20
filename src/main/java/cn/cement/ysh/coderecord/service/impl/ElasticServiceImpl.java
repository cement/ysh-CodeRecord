package cn.cement.ysh.coderecord.service.impl;

import cn.cement.ysh.coderecord.dao.IElasticDao;
import cn.cement.ysh.coderecord.service.IElasticService;
import com.alibaba.fastjson.JSONObject;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;


@Service
public class ElasticServiceImpl implements IElasticService {


    @Autowired
    private IElasticDao elasticDao;
    @Override
    public List<String> test(JSONObject json){
        return elasticDao.test(json);
    }

    @Override
    public IndexResponse index(IndexRequest indexRequest) throws IOException {
        return elasticDao.index(indexRequest);
    }

    @Override
    public GetResponse get(GetRequest getRequest) throws IOException {
        return elasticDao.get(getRequest);
    }
}
