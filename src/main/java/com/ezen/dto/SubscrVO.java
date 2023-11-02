package com.ezen.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class SubscrVO {
	
	  private int subscrid;
	  private String subscrname;
	  private int price;
	  private String salefromdate;
	  private String saletodate;
	  private int subscrperiod;      // 30일, 90일, 180일, 365일
	  private String memberid;
	  private String registereddate;
	  private int allowedbookcnt;

}
