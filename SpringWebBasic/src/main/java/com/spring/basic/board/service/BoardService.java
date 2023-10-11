package com.spring.basic.board.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.basic.board.dto.BoardListResponseDTO;
import com.spring.basic.board.dto.BoardModifyRequestDTO;
import com.spring.basic.board.entity.Board;
import com.spring.basic.board.entity.Board.BoardBuilder;
import com.spring.basic.board.repository.IBoardMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {
	
	private final IBoardMapper mapper; //의존성 관계를 맺어줘야해 

	public void insertArticle(String writer, String title, String content) {
		Board board = new Board();
		board.setWriter(writer);
		board.setTitle(title);
		board.setContent(content);
		mapper.insertArticle(board);
		//나머지 값들은 db에서 알아서 넣어주는 건가...?
	}

	public List<BoardListResponseDTO> getArticles() {
		List<BoardListResponseDTO> dtoList = new ArrayList<>();
		List<Board> boardList = mapper.getArticles();
		for(Board b: boardList) {
			BoardListResponseDTO dto = new BoardListResponseDTO(b);
			dtoList.add(dto);
		}
		return dtoList; //service는 controller에게 return 함
	}

	public Board retrieve(int boardNo) {
		return mapper.getArticle(boardNo);
	}

	public void modify(BoardModifyRequestDTO dto) {
//		Board board = Board.builder()
//						.boardNo(dto.getBoardNo())
//						.writer(dto.getWriter())
//						.title(dto.getTitle())
//						.content(dto.getContent())
//						.build(); //생성자 필요 무
//		mapper.updateArticle(board);
		Board board = Board.builder()
		.boardNo(dto.getBoardNo())
		.writer(dto.getWriter())
		.title(dto.getTitle())
		.content(dto.getContent())
		.build();
		System.out.println("board in Serviec: " + board);
		
		mapper.updateArticle(board);
	}

	public void delete(int boardNo) {
		mapper.deleteArticle(boardNo);
	}
	
	
	
}
