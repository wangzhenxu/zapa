package com.loiot.baqi.vo.hd;

import java.util.HashMap;
import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode(callSuper = false)
@Getter @Setter
public class Data implements java.io.Serializable{
	
	private int pageSize;
	private int start;
	private int total;
	List<Position> positions;
	HashMap<String,Enterprise> enterprises;
	Position position;


}
