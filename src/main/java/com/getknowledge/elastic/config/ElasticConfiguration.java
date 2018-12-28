package com.getknowledge.elastic.config;

import java.io.File;
import java.io.IOException;

import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.node.NodeBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages = "com.getknowledge.elastic.repository")
public class ElasticConfiguration {


    @Bean
    public NodeBuilder nodeBuilder() {
        return new NodeBuilder();
    }
    
    @Bean
    ElasticsearchOperations elasticsearchOperations(){
    	File tempFileDir = null;
    	
    	try {
    		tempFileDir = File.createTempFile("temp-elastic-file", Long.toString(System.nanoTime()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 Settings.Builder elasticsearchSettings =
                 Settings.settingsBuilder()
                         .put("http.enabled", "true") // 1
                         .put("index.number_of_shards", "1")
                         .put("path.data", new File(tempFileDir, "data").getAbsolutePath()) // 2
                         .put("path.logs", new File(tempFileDir, "logs").getAbsolutePath()) // 2
                         .put("path.work", new File(tempFileDir, "work").getAbsolutePath()) // 2
                         .put("path.home", tempFileDir); // 3



         return new ElasticsearchTemplate(nodeBuilder()
                 .local(true)
                 .settings(elasticsearchSettings.build())
                 .node()
                 .client());
    }
	
}
