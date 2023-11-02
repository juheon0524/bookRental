package com.ezen.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class MemberVO {

	private String memberid;
	private String membername;
	private String postalcode;
	private String postaladdress;
	private String detailaddress;
	private String mphone;
	private String birthdate;
	private String passcode;
	private String joindate;
	private String memberflag;  // 00: 사용자, 01: 고객
	private String email;
	private String penaltysdate; 
	private String penaltyedate;
	private int    penaltyrentalid;
	private String statuscode;  // active, inactive, closed : 회원가입 시 "active", 탈회 시 "closed"
	private String lastlogindate; 
}
