package com.cyh.model;

import java.util.ArrayList;
import java.util.List;
/**
 * ������Ϣ��
 * ����������Ϣ���ṩ��һ���ͻ�����͵ȴ�����Ŀͻ�����Ķ��м��ϣ������ṩ���ɺ���ͻ�ȡ����ķ���
 * @author CYH
 * @version 1.0
 */
public class NumberManager {

	private int lastNumber = 1; //��һ���ͻ�����
	private List<Integer> queueNumber = new ArrayList<>(); //�ȴ�����Ŀͻ����뼯��
	
	/**
	 * �޲ι��췽��
	 */
	public NumberManager() {}
	
	/**
	 * ���ɺ���
	 * @return �������ɵĺ���
	 */
	public int generateNumber() {
		lastNumber++;
		queueNumber.add(lastNumber);
		return lastNumber;
	}
	
	/**
	 * ��ȡ����ҪΪ֮����ĺ��루�кţ�
	 * @return ����
	 */
	public int fetchNumber() {
		int nowNumber = 0;
		if (queueNumber.size() > 0) {
			nowNumber = queueNumber.remove(0);
		}
		return nowNumber;
	}
}
