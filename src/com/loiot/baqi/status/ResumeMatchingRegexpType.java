package com.loiot.baqi.status;

/*
 * Timeloit.com Inc.
 * Copyright (c) 2012 时代凌宇物联网数据平台. All Rights Reserved
 */

/**
 * 简历
 * 
 * @author 
 * 
 */
public enum ResumeMatchingRegexpType {

	
	EMAIL_REGEXP(1, "EMAIL_REGEXP"),
	
	PHONE_REGEXP(2, "PHONE_REGEXP"),
	
	SEX_REGEXP(4, "SEX_REGEXP"),
	
	ID_CARD_REGEXP(5, "ID_CARD_REGEXP"),
	
	SCHOOLTAG_REGEXP(6, "SCHOOLTAG_REGEXP"),
	
	BIRTHDATE_REGEXP(7, "BIRTHDATE_REGEXP"),
	
	NAME_REGEXP(8, "NAME_REGEXP"),
	
	TOP_SCHOOLTAG_REGEXP(7, "TOP_SCHOOLTAG_REGEXP"),

	MARITAL_REGEXP(7, "MARITAL_REGEXP"),
	
	JOB_WORK_TERM_REGEXP(7, "JOB_WORK_TERM_REGEXP"),

	ENGLISH_LEVEL_REGEXP(7, "ENGLISH_LEVEL_REGEXP"),
	
	TOP_SPECIALTY_REGEXP(7, "TOP_SPECIALTY_REGEXP"),
	
	AGE_REGEXP(7, "AGE_REGEXP");

	
	
    

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
	ResumeMatchingRegexpType(int code, String title) {
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
	public static ResumeMatchingRegexpType get(int code) {
		for (ResumeMatchingRegexpType type : values()) {
			if (type.getCode() == code) {
				return type;
			}
		}
		return null;
	}
}
