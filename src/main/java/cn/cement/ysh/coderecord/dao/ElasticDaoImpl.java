package cn.cement.ysh.coderecord.dao;

import com.alibaba.fastjson.JSONObject;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class ElasticDaoImpl   implements IElasticDao  {

    @Autowired
    private RestHighLevelClient elasticClient;

//    @Autowired
//    public ElasticsearchTemplate elasticsearchTemplate;
//    @Override
//    public List<String> test(JSONObject jsonObject) {
//        SearchQuery searchQuery = new NativeSearchQueryBuilder()
//                .withQuery(QueryBuilders.queryStringQuery("菜鸟"))
//                .withPageable(PageRequest.of(0, 20))
//                .build();
//
//        List<String> resultList = elasticsearchTemplate.queryForIds(searchQuery);
//        return resultList;
//    }


    @Override
    public List<String> test(JSONObject jsonObject) {
        return null;
    }


    @Override
    public  IndexResponse index(IndexRequest indexRequest) throws IOException {
        IndexResponse indexResponse = elasticClient.index(indexRequest);
        return indexResponse;
    }

    @Override
    public GetResponse get(GetRequest getRequest) throws IOException {
//        GetRequest getRequest = new GetRequest("index","type","1");
        GetResponse getResponse = elasticClient.get(getRequest);
        return getResponse;
    }

}
