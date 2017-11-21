package com.cyh.model;

import java.util.ArrayList;
import java.util.List;
/**
 * 号码信息类
 * 管理号码的信息，提供上一个客户号码和等待服务的客户号码的队列集合，并且提供生成号码和获取号码的方法
 * @author CYH
 * @version 1.0
 */
public class NumberManager {

	private int lastNumber = 1; //上一个客户号码
	private List<Integer> queueNumber = new ArrayList<>(); //等待服务的客户号码集合
	
	/**
	 * 无参构造方法
	 */
	public NumberManager() {}
	
	/**
	 * 生成号码
	 * @return 返回生成的号码
	 */
	public int generateNumber() {
		lastNumber++;
		queueNumber.add(lastNumber);
		return lastNumber;
	}
	
	/**
	 * 获取马上要为之服务的号码（叫号）
	 * @return 号码
	 */
	public int fetchNumber() {
		int nowNumber = 0;
		if (queueNumber.size() > 0) {
			nowNumber = queueNumber.remove(0);
		}
		return nowNumber;
	}
}
