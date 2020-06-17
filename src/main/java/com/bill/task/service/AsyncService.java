package com.bill.task.service;

import org.springframework.stereotype.Service;

@Service
public class AsyncService {
	
	
	public void hello() {
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("任務處理中...");
	}
}
