package com.loiot.baqi.vo;

import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;

import com.loiot.baqi.pojo.AccountExpandInfo;
@Data
@EqualsAndHashCode(callSuper = false)
public class MatchInfo {
	
	//是否匹配
	private int status;
	//列名称
	private String cloumnName;
	//公司列要求名称
	private String companyRequireName;
	//求职者列信息
	private String jobSeekerInfo;
	
	
}
