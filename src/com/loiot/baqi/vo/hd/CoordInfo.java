package com.loiot.baqi.vo.hd;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class CoordInfo {
	
	private int hdPositionId;//职位id
	
	private String hdLocation;//工作地址
	
	private String areaName; //行政区名称
	
	private String coordX;
	
	private String coordY;


}
