package com.infy.springboot.microservice.microserviceinter.springbootmicroserviceinterservice;

import java.util.List;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
@FeignClient(name="microservice-crud")
@RibbonClient(name="microservice-crud")
public interface ShowCustomerDetailsServiceProxy {
	@GetMapping("/microservice-crud/customerdetails/all")
	  public List<ShowCustomerDataBean> findAllCustomer();
	
}
