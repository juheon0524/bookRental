package com.ezen.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class WishlistsVO {
	private int	wishlistid;
	private String isbn;
	private String createdate;
	private String memberid;
	private String bookimgurl;
	private String author;
	private String publisher;
	private String publisheddate;
	private int cumrentalcnt;
	private int curbookcnt;
	private int score;
	private String title;
	
	
}
