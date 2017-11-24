package com.cyh.model;

import java.util.Random;
import java.util.concurrent.Executors;

public class ServiceWindow {

	private CustomerType type = CustomerType.COMMON;
	private int windowId = 1;
	
	/* setter���� */
	public void setType(CustomerType type) {
		this.type = type;
	}

	public void setWindowId(int windowId) {
		this.windowId = windowId;
	}

	public ServiceWindow() {
	}

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

	public void doCommonService() {
		String windowName = "��" + windowId + "��" + type + "����";
		System.out.println(windowName + "��ʼ��ȡ��ͨ����!");
		Integer number = NumberMachine.getInstance().getCommonCustomer().fetchNumber(); // ��ȡ�����
		if (number != null) {
			System.out.println(windowName + "��ʼΪ��" + number + "����ͨ�ͻ�����");
			long serviceTime = new Random().nextInt(Constants.MAX_SERVICE_TIME - Constants.MIN_SERVICE_TIME) + 1
					+ Constants.MIN_SERVICE_TIME;
			try {
				Thread.sleep(serviceTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(windowName + "Ϊ��" + number + "����ͨ�ͻ�����ʱ����" + (serviceTime / 1000) + "��");
		} else {
			System.out.println("��ʱû����ͨ�ͻ�����Ϣ1����~~~");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	public void doVipService() {
		// TODO Auto-generated method stub

	}

	public void doFastService() {
		// TODO Auto-generated method stub

	}

}
