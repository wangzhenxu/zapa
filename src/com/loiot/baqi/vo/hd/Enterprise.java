package com.loiot.baqi.vo.hd;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Enterprise implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2239836830804825369L;

	private String address;  //企业地址

	private double approveTime; //批准时间

	private String bank; 

	private String bankAccount;

	private String bankAccountNo;

	private int bdPhase;

	private int candidateIntervalMonth;

	private int channel;

	private int cityId;

	private double createTime;

	private int createUserId;

	private int developStatus;  //发展状态  A轮 3  1

	private String displayName;

	private String highlights; //职位亮点（五险一金,带薪年假,期权激励,午餐补助,交通补贴）

	private int id;

	private int industryId;//公司性质

	private String industryIds;//所属行业

	private String introduce; //公司介绍

	private int investigateId;

	private String logo;

	private String memberName;

	private String name; //名称

	private int offerType;

	private boolean operated;

	private int otherIndustryId;

	private double pactionEndTime;

	private double pactionStartTime;

	private int positionNum;

	private int priority;

	private int provinceId;

	private int registerRelateAdmin;

	private String registrationNumber;

	private int salesAdmin;

	private int scale;    //规模   （1 50-99人） 

	private int serviceAdmin;

	private int servicePhase;

	private String shortName;

	private int status;

	private int style;

	private String tags;

	private String temptation;

	private int topCount;

	private int type;

	private double updateTime;

	private int updateUserId;

	private String website; //网站
}
