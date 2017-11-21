package com.cyh.model;

/**
 * 号码机器类
 * 可以生成不同的客户
 * @author CYH
 * @version 1.0
 */
public class NumberMachine {
	
	private NumberManager commonCustomer = new NumberManager(); //普通客户
	private NumberManager fastCustomer = new NumberManager(); //快速客户
	private NumberManager vipCustomer = new NumberManager(); //vip客户
	
	/*以下为定义单例模型（饿汉式）*/
	private static NumberMachine instance = new NumberMachine(); //私有静态的NumberMachine类对象
	
	/**
	 * 私有的无参构造方法
	 */
	private NumberMachine() {}
	
	/**
	 * 获取对象
	 * @return NumberMachine类的对象
	 */
	public static NumberMachine getInstance() {
		return instance;
	}
	
	/**
	 * 获取普通客户
	 * @return 普通客户对象(NumberManager)
	 */
	public NumberManager getCommonCustomer() {
		return commonCustomer;
	}
	
	/**
	 * 获取快速客户
	 * @return 快速客户对象(NumberManager)
	 */
	public NumberManager getFastCustomer() {
		return fastCustomer;
	}
	
	/**
	 * 获取vip客户
	 * @return vip客户对象(NumberManager)
	 */
	public NumberManager getVipCustomer() {
		return vipCustomer;
	}

}
