package com.bill.task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bill.task.service.AsyncService;

@RestController
public class AsyncController {

	@Autowired
	AsyncService asyncService;
	
	@GetMapping("/hello")
	public String hello() {
		asyncService.hello();
		return "success";
	}
}
