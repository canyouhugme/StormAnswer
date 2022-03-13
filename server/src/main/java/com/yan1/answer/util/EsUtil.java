package com.yan1.answer.util;


import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.SearchRequest;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import co.elastic.clients.elasticsearch.core.search.HitsMetadata;
import com.yan1.answer.entity.QuestionAndAnswer;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class EsUtil {

    @Autowired
    private ElasticsearchClient client;
//
//    // 创建索引
//    private static void createIndex() {
//        // 创建index
//        try {
//            CreateIndexRequest request = new CreateIndexRequest.Builder().index("question-answer").build();
//            CreateIndexResponse createIndexResponse = client.indices().create(request);
//            System.out.println(createIndexResponse);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    // 查询
    public List<QuestionAndAnswer> search(String searchKey, Integer pageNo, Integer pageSize) {
        SearchRequest.Builder builder = new SearchRequest.Builder().index("question-answer");
        // 设置分页参数
        builder.from((pageNo - 1) * pageSize).size(pageSize);

        // 设置检索内容
        if (StringUtils.isNotEmpty(searchKey)) {
            builder.query(_0 -> _0
                    .multiMatch(_1 -> _1
                            .query(searchKey)
                            .fields("question", "answer")
                    ));
        }
        SearchRequest searchRequest = builder.build();

        try {
            SearchResponse<QuestionAndAnswer> response = client.search(searchRequest, QuestionAndAnswer.class);
            HitsMetadata<QuestionAndAnswer> hits = response.hits();
            List<Hit<QuestionAndAnswer>> hits1 = hits.hits();
            return hits1.stream().map(hit -> hit.source()).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
//
//    // 添加数据
//    private static void addDocument() {
//        // 添加文档
//        QuestionAndAnswer questionAndAnswer = new QuestionAndAnswer("问题1", "答案1");
//
//        IndexRequest<QuestionAndAnswer> request = new IndexRequest.Builder<QuestionAndAnswer>().index("question-answer").document(questionAndAnswer).build();
//        try {
//            IndexResponse response = client.index(request);
//            System.out.println(response);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    // 分页列表查询


}
