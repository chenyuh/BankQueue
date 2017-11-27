package com.cyh.model;

import java.util.Random;
import java.util.concurrent.Executors;

public class ServiceWindow {

	private CustomerType type = CustomerType.COMMON;
	private int windowId = 1;
	
	/**
	 * type的setter方法 
	 * @param type 客户类型
	 */
	public void setType(CustomerType type) {
		this.type = type;
	}
	
	/**
	 * windowId的setter的方法
	 * @param windowId 窗口号
	 */
	public void setWindowId(int windowId) {
		this.windowId = windowId;
	}

	/**
	 * 无参构造方法
	 */
	public ServiceWindow() {
	}

	/**
	 * 开始方法
	 */
	public void start() {
		Executors.newSingleThreadExecutor().execute(new Runnable() {

			@Override
			public void run() {
				while (true) {
					switch (type) {
					case COMMON:
						doCommonService();
						break;
					case FAST:
						doFastService();
						break;
					case VIP:
						doVipService();
						break;

					default:
						break;
					}
				}
			}
		});
	}

	/**
	 * 普通窗口服务方法
	 */
	public void doCommonService() {
		String windowName = "第" + windowId + "号" + type + "窗口";
		System.out.println(windowName + "开始获取普通任务!");
		Integer number = NumberMachine.getInstance().getCommonCustomer().fetchNumber(); // 获取服务号
		if (number != null) {
			System.out.println(windowName + "开始为第" + number + "号普通客户服务");
			long serviceTime = new Random().nextInt(Constants.MAX_SERVICE_TIME - Constants.MIN_SERVICE_TIME) + 1
					+ Constants.MIN_SERVICE_TIME;
			try {
				Thread.sleep(serviceTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(windowName + "为第" + number + "号普通客户服务时长：" + (serviceTime / 1000) + "秒");
		} else {
			System.out.println("暂时没有普通客户，休息1秒钟~~~");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 快速窗口服务方法
	 */
	public void doFastService() {
		String windowName = "第" + windowId + "号" + type + "窗口";
		System.out.println(windowName + "开始获取快速任务!");
		Integer number = NumberMachine.getInstance().getFastCustomer().fetchNumber(); // 获取服务号
		if (number != null) {
			System.out.println(windowName + "开始为第" + number + "号快速客户服务");
			try {
				Thread.sleep(Constants.MIN_SERVICE_TIME);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(windowName + "为第" + number + "号快速客户服务时长：" + (Constants.MIN_SERVICE_TIME / 1000) + "秒");
		} else {
			System.out.println("暂时没有快速客户，休息1秒钟~~~");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			doCommonService();
		}

	}
	
	/**
	 * vip窗口服务方法
	 */
	public void doVipService() {
		String windowName = "第" + windowId + "号" + type + "窗口";
		System.out.println(windowName + "开始获取VIP任务!");
		Integer number = NumberMachine.getInstance().getVipCustomer().fetchNumber(); // 获取服务号
		if (number != null) {
			System.out.println(windowName + "开始为第" + number + "号VIP客户服务");
			long serviceTime = new Random().nextInt(Constants.MAX_SERVICE_TIME - Constants.MIN_SERVICE_TIME) + 1
					+ Constants.MIN_SERVICE_TIME;
			try {
				Thread.sleep(serviceTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(windowName + "为第" + number + "号VIP客户服务时长：" + (serviceTime / 1000) + "秒");
		} else {
			System.out.println("暂时没有VIP客户，休息1秒钟~~~");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			doCommonService();
		}
	}

}
