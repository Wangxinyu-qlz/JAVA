package com.qlz.controller;

import com.qlz.entity.PayDTO;
import com.qlz.resp.ResultData;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @program: mscloud
 * @author: Qiaolezi
 * @create: 2024-06-12 15:42
 * @description: (url, requestMap, ResponseBean.class):
 *                REST请求地址、请求参数、HTTP响应转换被转换成的对象类型
 **/
@RestController
public class OrderController {
	//public static final String PaymentSrv_URL = "http://localhost:8001";//先写死，硬编码
	//服务注册中心上的微服务名称
	public static final String PaymentSrv_URL = "http://cloud-payment-service";
	@Resource
	private RestTemplate restTemplate;

	/**
	 * 一般情况下，通过浏览器的地址栏输入url，发送的只能是get请求
	 * 我们底层调用的是post方法，模拟消费者发送get请求，客户端消费者
	 * 参数可以不添加@RequestBody
	 *
	 * @param payDTO
	 * @return
	 */
	@GetMapping("/consumer/pay/add")
	public ResultData addOrder(@RequestBody PayDTO payDTO) {
		return restTemplate.postForObject(PaymentSrv_URL + "/pay/add", payDTO, ResultData.class);
	}

	@GetMapping("/consumer/pay/get/{id}")
	public ResultData getPayInfo(@PathVariable("id") Integer id) {
		return restTemplate.getForObject(PaymentSrv_URL + "/pay/get/" + id, ResultData.class, id);
	}

	@GetMapping("/consumer/pay/get")
	public ResultData getAllPayInfo() {
		return restTemplate.getForObject(PaymentSrv_URL + "/pay/get", ResultData.class);
	}

	@GetMapping("/consumer/pay/delete/{id}")
	public ResultData deleteOrder(@PathVariable("id") Integer id) {
		restTemplate.delete(PaymentSrv_URL + "/pay/del/" + id);
		return ResultData.success("成功删除");
	}

	@GetMapping("/consumer/pay/update")
	public ResultData updateOrder(@RequestBody PayDTO payDTO) {
		restTemplate.put(PaymentSrv_URL + "/pay/update",  payDTO);
		return ResultData.success("成功修改");
	}

}
