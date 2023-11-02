package com.ezen.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class RatingsVO {

	private int ratingsid;
	private String isbn;
	private String memberid;
	private String writedate;
	private String content;
	private int score;

}
