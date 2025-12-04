package com.hmall.item.es;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;


public class IndexTest {

    private RestHighLevelClient client;

    @BeforeEach
    void setUp() {
        this.client = new RestHighLevelClient(RestClient.builder(
                HttpHost.create("http://110.41.61.31:9200")
        ));
    }

    @Test
    void testConnect() {
        try {
            // 测试连接是否有效
            boolean ping = client.ping(RequestOptions.DEFAULT);
            System.out.println("Elasticsearch connection successful: " + ping);
            System.out.println("Client info: " + client);
        } catch (IOException e) {
            System.err.println("Failed to connect to Elasticsearch:");
            e.printStackTrace();
        }
    }

    @AfterEach
    void tearDown() throws IOException {
        if (this.client != null) {
            this.client.close();
        }
    }
}
