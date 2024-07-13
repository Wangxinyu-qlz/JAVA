package com.sky.test;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.client.RestTemplateAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * @program: sky-take-out
 * @author: Qiaolezi
 * @create: 2024-07-13 12:07
 * @description:
 **/
@SpringBootTest
public class HttpClientTest {
	@Autowired
	private RestTemplateAutoConfiguration restTemplateAutoConfiguration;

	/**
	 * 通过httpClient发送GET请求
	 */
	@Test
	public void testGET() throws IOException {
		//创建httpClient对象
		CloseableHttpClient httpClient = HttpClients.createDefault();

		//创建请求对象
		HttpGet httpGet = new HttpGet("http://localhost:8080/user/shop/status");

		//发送请求
		CloseableHttpResponse response = httpClient.execute(httpGet);

		//获取服务端返回的状态码
		int statusCode = response.getStatusLine().getStatusCode();
		System.out.println(statusCode);//200

		HttpEntity entity = response.getEntity();
		String body = EntityUtils.toString(entity);
		System.out.println("返回的数据为：" + body);//返回的数据为：{"code":1,"msg":null,"data":1}

		//关闭资源
		response.close();
		httpClient.close();
	}

	/**
	 * 通过httpClient发送POST请求
	 */
	@Test
	public void testPOST() throws IOException {
		//创建httpClient对象
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost("http://localhost:8080/admin/employee/login");

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("username", "admin");
		jsonObject.put("password", "123456");

		StringEntity entity = new StringEntity(jsonObject.toString());
		//指定请求的编码方式
		entity.setContentEncoding("utf-8");
		//数据格式
		entity.setContentType("application/json");
		httpPost.setEntity(entity);

		//发送请求
		CloseableHttpResponse response = httpClient.execute(httpPost);

		int statusCode = response.getStatusLine().getStatusCode();
		System.out.println("响应码为：" + statusCode);

		HttpEntity entity1 = response.getEntity();
		String body = EntityUtils.toString(entity1);
		System.out.println("返回的数据为：" + body);

		//关闭资源
		response.close();
		httpClient.close();
	}
}
