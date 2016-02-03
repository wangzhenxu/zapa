package com.loiot.baqi.vo.hd;
import lombok.Data;
import lombok.EqualsAndHashCode;

import com.loiot.baqi.vo.JlAuditPersonList;

import net.sf.json.JSONObject;
import net.sf.json.JSONArray;
@Data
@EqualsAndHashCode(callSuper = false)

public class Position implements java.io.Serializable{
	
	private double annualSalary;

	private int cityId;   //30101 北京

	private String cityName;

	private int countryId;

	private int customReward;

	private int degreeRequired;  //学历要求 （2  本科及以上）

	private int enterpriseId;

	private String enterpriseName; //企业名称

	private double fixedRewardAmount; //固定赏金金额

	private int functionId;

	private int guaranteeTime;  //保证期

	private int headCount;  //招聘人数

	private int headHunterCount;

	private double hrFeedbackTime;  //HR 反馈时间

	private int hrPriority;  

	private int industryId;  //所属行业

	private boolean isContract;

	private boolean isPrivate;

	private boolean isPublic;

	private double maxBaseAnnualSalary;

	private double maxReward;

	private double maxShowAnnualSalary;

	private double minShowAnnualSalary;

	private double modifyTime;

	private int newMessage;

	private double percentageNumbric; //返利比例

	private int positionAssignId;

	private int positionId;//职位id （48146  职位的id  ）

	private String positionTitle;  // 职位名称 xxx工程师

	private int positionType;

	private int priority;  //是否是急招 2急招  0非急招

	private int provinceId;

	private String provinceName;

	private double publishTime;  //发布时间

	private int rewardType;

	private int status;

	private String tags;

	private int urgency;

	private int workExpRequired; //工作年限要求
	
	private String reportTo;//汇报对象
	
	private String subordinate;//下属团队
	
	private String jobDescription;//职位描述
	
	private String jobRequirement;//任职要求
	
	private int genderRequired; //性别

	private String languageRequired;//语言要求
	
	private String location;//工作地址
	

	

}