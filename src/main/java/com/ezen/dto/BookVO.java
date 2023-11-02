package com.ezen.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class BookVO {

	private String isbn;
	private String title;
	private String genrecode;
	private String author;
	private String publisher;
	private String publisheddate;
	private int totbookcnt;
	private int rentedbookcnt;
	private int curbookcnt;
	private int price;
	private int cumrentalcnt;
	private String registereddate;
	private String memberid;
	private String bookimgurl;
	private String bookcontent;
	private double score;   // ratings(100자평)의 group by score
	

}
