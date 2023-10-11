package com.spring.myweb.freeboard.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.spring.myweb.freeboard.entity.FreeBoard;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class FreeDetailResponseDTO {
	private int bno;
	private String title;
	private String writer;
	private String content;
	private String date;
	
	public FreeDetailResponseDTO(FreeBoard board) {
		super();
		this.bno = board.getBno();
		this.title = board.getTitle();
		this.writer = board.getWriter();
		this.content = board.getContent();
//		this.date = makePrettierDateString(
//				(board.getUpdateDate() == null)? board.getRegDate() : board.getUpdateDate()
//				);
		if(board.getUpdateDate() == null) {
			this.date = makePrettierDateString(board.getRegDate());
		} else {
			this.date = makePrettierDateString(board.getUpdateDate()) + " (수정됨)";
		}
		
		
	}
	
	private String makePrettierDateString(LocalDateTime regDate) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		return dtf.format(regDate);
	}
	
}
