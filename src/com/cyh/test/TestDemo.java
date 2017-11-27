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
		
		/*����4����ͨ����*/
		createWindow(4, 0, CustomerType.COMMON);
		
		/*�������ٴ���*/
		createWindow(1, 5, CustomerType.FAST);
		
		/*����vip����*/
		createWindow(1, 6, CustomerType.VIP);
		
		/*��ʱ������ͨ�ͻ�*/
		generateCustomer(NumberMachine.getInstance().getCommonCustomer(), Constants.COMMON_SERVICE_TIME);

		/*��ʱ����vip�ͻ�*/
		generateCustomer(NumberMachine.getInstance().getVipCustomer(), Constants.COMMON_SERVICE_TIME * 6);
		
		/*��ʱ���ɿ��ٿͻ�*/
		generateCustomer(NumberMachine.getInstance().getFastCustomer(), Constants.COMMON_SERVICE_TIME * 2);
	}
	
	/**
	 * ��������
	 * @param num ��������
	 * @param id ����id��
	 * @param type ��������
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
	 * ���ɷ����
	 * @param numberManager ������Ϣ�����
	 * @param time ��ʱʱ��
	 */
	public static void generateCustomer(NumberManager numberManager, long time) {
		Executors.newScheduledThreadPool(1).scheduleAtFixedRate(new Runnable() {
			@Override
			public void run() {
				Integer number = numberManager.generateNumber();
				System.out.println(numberManager.getType().toString() + "�ͻ�:" + number + "��");
			}
		}, 0, time, TimeUnit.SECONDS);
	}

}
