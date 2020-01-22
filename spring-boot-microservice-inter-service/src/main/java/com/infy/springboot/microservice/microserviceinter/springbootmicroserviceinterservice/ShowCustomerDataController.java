package com.infy.springboot.microservice.microserviceinter.springbootmicroserviceinterservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class ShowCustomerDataController {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ShowCustomerDetailsServiceProxy proxy;
	
	@GetMapping("/microservice-inter/customerdetails/all")
	public List<ShowCustomerDataBean> showCustomerData() {
		Map<String,String> uriVariable = new HashMap<String,String>();
		
		ResponseEntity<ShowCustomerDataBean> responseEntity = new RestTemplate().getForEntity("http://localhost:8000/microservice-crud/customerdetails/all", ShowCustomerDataBean.class, uriVariable);
		ShowCustomerDataBean response = responseEntity.getBody();
		List<ShowCustomerDataBean> responseList = new ArrayList<ShowCustomerDataBean>();
		responseList.add(response);
		
	return responseList;	
	}
	
	@GetMapping("/microservice-inter-feign/customerdetails/all")
	  public List<ShowCustomerDataBean> showDataFeign() {

		List<ShowCustomerDataBean> response = proxy.findAllCustomer();
		Map<String,String> accBalMap = new HashMap<String,String>();
		Map<String,String> totalBalMap = new HashMap<String,String>();
		Map<String,ShowCustomerDataBean> responseList = new HashMap<>();
		for(int i=0;i<response.size(); i++)
		{
			String accBal = response.get(i).getAccountBalance();
			if(accBalMap.containsKey(response.get(i).getPhone()))
			{
				String newAccountBal =  accBalMap.get(response.get(i).getPhone())+","+accBal;
				Integer totalAccBal = Integer.parseInt(accBalMap.get(response.get(i).getPhone()))+Integer.parseInt(accBal);
				accBalMap.put(response.get(i).getPhone(), newAccountBal);
				totalBalMap.put(response.get(i).getPhone(), totalAccBal.toString());
			}
			else {
				accBalMap.put(response.get(i).getPhone(), response.get(i).getAccountBalance());
				totalBalMap.put(response.get(i).getPhone(), response.get(i).getAccountBalance());
			}
			ShowCustomerDataBean sc= new ShowCustomerDataBean(response.get(i).getPhone(),response.get(i).getFirstName(),response.get(i).getLastName(),response.get(i).getEmail(),response.get(i).getAddressLine1()
					,response.get(i).getAddressLine2(),response.get(i).getAccountNumber(),accBalMap.get(response.get(i).getPhone()),totalBalMap.get(response.get(i).getPhone()));
			responseList.put(response.get(i).getPhone(),sc);
			
		}
		List<Integer> resultSortedKey = new ArrayList<>();
        List<ShowCustomerDataBean> sendRespList = responseList.entrySet().stream().sorted(Map.Entry.<String,ShowCustomerDataBean>comparingByKey().reversed())
                .map(x -> x.getValue()).collect(Collectors.toList());
		
	    log.info("{}", responseList);
	    return sendRespList;
	 }
	
	
}
