
package com.stephanietech.learn_spring_framework.enterprise.example.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stephanietech.learn_spring_framework.enterprise.example.data.DataService;

@Component
public class BusinessService {
	
	@Autowired
	private DataService service;
	
	public BusinessService(DataService service) {
		super();
		System.out.println("Constructor injection");
		this.service = service;
	}

//	
//	public DataService getService() {
//		return service;
//	}
//

//	@Autowired
//	public void setService(DataService service) {
//		System.out.println("Setter injection");
//		this.service = service;
//	}

	public long calculateSum() {
		List<Integer> data = service.getData();
		return data.stream().reduce(Integer::sum).get();
	}
}

