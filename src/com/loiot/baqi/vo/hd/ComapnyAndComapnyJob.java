package com.loiot.baqi.vo.hd;

import lombok.Data;
import lombok.EqualsAndHashCode;

import com.loiot.baqi.pojo.ZpCompanyInfo;
import com.loiot.baqi.pojo.ZpCompanyJobInfo;
@Data
@EqualsAndHashCode(callSuper = false)
public class ComapnyAndComapnyJob {

	ZpCompanyJobInfo companyJob;
	
	ZpCompanyInfo company;

}
