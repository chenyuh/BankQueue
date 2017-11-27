package com.cyh.test;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.cyh.model.Constants;
import com.cyh.model.CustomerType;
import com.cyh.model.NumberMachine;
import com.cyh.model.NumberManager;
import com.cyh.model.ServiceWindow;

public class TestDemo {

	public static void main(String[] args) {
		
		/*创建4个普通窗口*/
		createWindow(4, 0, CustomerType.COMMON);
		
		/*创建快速窗口*/
		createWindow(1, 5, CustomerType.FAST);
		
		/*创建vip窗口*/
		createWindow(1, 6, CustomerType.VIP);
		
		/*定时生成普通客户*/
		generateCustomer(NumberMachine.getInstance().getCommonCustomer(), Constants.COMMON_SERVICE_TIME);

		/*定时生成vip客户*/
		generateCustomer(NumberMachine.getInstance().getVipCustomer(), Constants.COMMON_SERVICE_TIME * 6);
		
		/*定时生成快速客户*/
		generateCustomer(NumberMachine.getInstance().getFastCustomer(), Constants.COMMON_SERVICE_TIME * 2);
	}
	
	/**
	 * 创建窗口
	 * @param num 窗口数量
	 * @param id 窗口id号
	 * @param type 窗口类型
	 */
	public static void createWindow(int num, int id, CustomerType type) {
		if (num == 1) {
			ServiceWindow window =  new ServiceWindow();
			window.setWindowId(id);
			window.setType(type);
			window.start();
		} else {
			for (int i = 0; i < num; i++) {
				ServiceWindow window =  new ServiceWindow();
				window.setWindowId(i + 1);
				window.setType(type);
				window.start();
			}
		}
	}
	
	/**
	 * 生成服务号
	 * @param numberManager 号码信息类对象
	 * @param time 定时时间
	 */
	public static void generateCustomer(NumberManager numberManager, long time) {
		Executors.newScheduledThreadPool(1).scheduleAtFixedRate(new Runnable() {
			@Override
			public void run() {
				Integer number = numberManager.generateNumber();
				System.out.println(numberManager.getType().toString() + "客户:" + number + "号");
			}
		}, 0, time, TimeUnit.SECONDS);
	}

}
