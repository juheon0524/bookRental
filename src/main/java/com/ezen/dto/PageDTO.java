package com.ezen.dto;

import lombok.Getter;

@Getter
public class PageDTO {
	private int page;			//현재 페이지 값을 나타내는 필드
	private int startNum;		//현재 페이지의 조회 시작 넘버
	private int endNum;			//현재 페이지의 조회 종료 넘버
	private int startPage;		//리스트 목록 출력시 하단부의 시작 페이지 수
	private int endPage;		//리스트 목록 출력시 하단부의 종료 페이지 수
	private int maxPage;		//전체 페이지의 수
	private int limitList = 10;	//한 페이지에 나타낼 수 있는 게시글 수
		
	public void calcu(int page, int limit , int bookCount) {
		this.page = page;
		this.limitList = limit;
		this.startNum = (page - 1) * limit + 1 ;
		this.endNum = (page * limit) > bookCount ? bookCount : page * limit ;
		this.maxPage = (int) Math.ceil(bookCount* 1.0/ limit);
		this.startPage = (page / 10) * 10 + 1 ;
		this.endPage = startPage + 9 > maxPage ? maxPage : startPage + 9;
	}
}
