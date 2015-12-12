package com.loiot.baqi.status;

/*
 * Timeloit.com Inc.
 * Copyright (c) 2012 时代凌宇物联网数据平台. All Rights Reserved
 */

/**
 * 简历审核状态
 * 
 * @author wangzx
 * 
 */
public enum JlAuditType {

	NO_SELECT_AUDIT_PERSON(9, "未选评审"),
	WAIT_AUDIT(1, "等待评审"),
	AUDIT_OK(2, "通过"),
	AUDIT_NO_PASS(3, "未通过");
	
	
	
	
	
	
	
	
	/**
	 * 状态码
	 */
	private int code;
	/**
	 * 标题
	 */
	private String title;

	/**
	 * 构造一个类型
	 * 
	 * @param code
	 *            状态码
	 * @param title
	 *            标题
	 */
	JlAuditType(int code, String title) {
		this.code = code;
		this.title = title;
	}

	/**
	 * 获得此枚举的标题。
	 * 
	 * @return 标题
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * 获得此枚举的状态码。
	 * 
	 * @return 状态码
	 */
	public short getCode() {
		return (short) code;
	}

	/**
	 * 根据状态码获得枚举。
	 * 
	 * @param code
	 *            状态码
	 * @return 状态码对应的枚举，如果找不到则返回null。
	 */
	public static JlAuditType get(int code) {
		for (JlAuditType type : values()) {
			if (type.getCode() == code) {
				return type;
			}
		}
		return null;
	}
}
