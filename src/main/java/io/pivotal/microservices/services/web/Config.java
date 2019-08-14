package io.pivotal.microservices.services.web;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
	
	public static RestHighLevelClient client = null;

    public static String host = "10.0.10.138";
    public static int port = 9200;

    public String getHost() {
		return host;
	}

	public int getPort() {
		return port;
    }
    
    public static RestHighLevelClient client() {
    	if (client == null) {
    		client = new RestHighLevelClient(RestClient.builder(new HttpHost(host, port, "http")));
    	}
        return client;
    }
}