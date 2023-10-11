package com.spring.basic.board.dto;

import java.time.LocalDateTime;

import com.spring.basic.board.entity.Board;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter @ToString @EqualsAndHashCode
public class BoardListResponseDTO {
	
	//목록화면 응답용 dto
	private int boardNo;
	private String writer;
	private String title;
	private LocalDateTime regDate;
	
	public BoardListResponseDTO(Board board) {
		this.boardNo = board.getBoardNo();
		this.writer = board.getWriter();
		this.title = board.getTitle();
		this.regDate = board.getRegDate();
	}
	
}
