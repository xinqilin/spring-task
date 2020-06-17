package com.bill.task.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {

	@Scheduled(cron="* * * * * MON-FRI")
	public void hello() {
		System.out.println("Schedule作用中!!!");
	}
}
