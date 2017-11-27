package com.cyh.model;

/**
 * ���������
 * �������ɲ�ͬ�Ŀͻ�
 * @author CYH
 * @version 1.0
 */
public class NumberMachine {
	
	private NumberManager commonCustomer = new NumberManager(); //��ͨ�ͻ�
	private NumberManager fastCustomer = new NumberManager(); //���ٿͻ�
	private NumberManager vipCustomer = new NumberManager(); //vip�ͻ�
	
	/*����Ϊ���嵥��ģ�ͣ�����ʽ��*/
	private static NumberMachine instance = new NumberMachine(); //˽�о�̬��NumberMachine�����
	
	/**
	 * ˽�е��޲ι��췽��
	 */
	private NumberMachine() {}
	
	/**
	 * ��ȡ����
	 * @return NumberMachine��Ķ���
	 */
	public static NumberMachine getInstance() {
		return instance;
	}
	
	/**
	 * ��ȡ��ͨ�ͻ�
	 * @return ��ͨ�ͻ�����(NumberManager)
	 */
	public NumberManager getCommonCustomer() {
		commonCustomer.setType(CustomerType.COMMON);
		return commonCustomer;
	}
	
	/**
	 * ��ȡ���ٿͻ�
	 * @return ���ٿͻ�����(NumberManager)
	 */
	public NumberManager getFastCustomer() {
		fastCustomer.setType(CustomerType.FAST);
		return fastCustomer;
	}
	
	/**
	 * ��ȡvip�ͻ�
	 * @return vip�ͻ�����(NumberManager)
	 */
	public NumberManager getVipCustomer() {
		vipCustomer.setType(CustomerType.VIP);
		return vipCustomer;
	}

}
