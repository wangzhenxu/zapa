package com.loiot.baqi.vo.hd;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@EqualsAndHashCode(callSuper = false)
public class Root implements java.io.Serializable{
	
	@Getter @Setter
	private Data data;
	
	@Getter @Setter
	private String errCode;
	
	@Getter @Setter
	private String message;
	
	@Getter @Setter
	private boolean success;

}
