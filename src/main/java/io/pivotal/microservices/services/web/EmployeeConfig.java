package io.pivotal.microservices.services.web;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class EmployeeConfig {
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@RequestMapping("/hello")
	public String hello() {
		return "Hello world from 19th floor!";
	}
	
	@RequestMapping(value = "/hello2", produces = "application/json")
	public Employee hello2() {
		return new Employee();
	}
	
    @RequestMapping("/create2")
    public String create2() throws IOException {
    	RestHighLevelClient client = Config.client();
    	String id = UUID.randomUUID().toString();
    	
    	List<String> addresses = new ArrayList<>();
    	addresses.add("ValKot Address 1");
		addresses.add("ValKot Address 22");
		addresses.add("ValKot Address 333");
		
		IndexRequest request = new IndexRequest("employees", "", id)
				.source(jsonBuilder()
                    .startObject()
                    .field("id", "111111111")
                    .field("egn", "3333333333333333")
                    .field("firstName", "Valeri333")
                    .field("lastName", "Kotsev333")
                    .field("addresses", addresses)
                    .endObject());
        IndexResponse response = client.index(request, RequestOptions.DEFAULT);
        
        return response.getResult().toString();
    }
    
    @PostMapping("/create")
    public String create(@RequestBody Employee employee) throws IOException {
    	RestHighLevelClient client = Config.client();
    	String id = UUID.randomUUID().toString();
		
		Map<String, Object> employeeMapper = objectMapper.convertValue(employee, Map.class);
		
		IndexRequest request = new IndexRequest("employees", "NT", id).source(employeeMapper);
        IndexResponse response = client.index(request, RequestOptions.DEFAULT);
        
        return response.getResult().toString();
    }
    
    @GetMapping("/read/{id}")
    public Employee readById(@PathVariable String id) throws IOException {
    	RestHighLevelClient client = Config.client();
    	
    	GetRequest getRequest = new GetRequest("employees", "NT", id);
    	GetResponse getResponse = client.get(getRequest, RequestOptions.DEFAULT);
    	
        Map<String, Object> employeeMap = getResponse.getSource();
        
        return objectMapper.convertValue(employeeMap, Employee.class);
    }
    
    @PutMapping("/update/{id}")
    public String update(@PathVariable String id, @RequestBody Employee employee) throws IOException {
    	RestHighLevelClient client = Config.client();
    	Employee resultEmployee = readById(id);
    	
    	UpdateRequest updateRequest = new UpdateRequest("employees", "NT", id);
    	Map<String, Object> employeeMapper =  objectMapper.convertValue(employee, Map.class);
    	updateRequest.doc(employeeMapper);
    	UpdateResponse updateResponse = client.update(updateRequest, RequestOptions.DEFAULT);
    	
    	return updateResponse.getResult().toString();
    }
    
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable String id) throws IOException {
    	RestHighLevelClient client = Config.client();
    	
    	DeleteRequest deleteRequest = new DeleteRequest("employees", "NT", id);
        DeleteResponse response = client.delete(deleteRequest, RequestOptions.DEFAULT);

        return response.getResult().toString();
    }
	
}