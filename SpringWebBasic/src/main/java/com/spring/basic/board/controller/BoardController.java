package com.spring.basic.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.basic.board.dto.BoardModifyRequestDTO;
import com.spring.basic.board.service.BoardService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
	
	private final BoardService service;
	
	//글 작성 화면을 열어주는 메서드
	@GetMapping("/write")
	public void write() {
		System.out.println("/board/write: GET");
	}
	
	//글 등록 요청 메서드
	@PostMapping("/write")
	public String write(String writer, String title, String content) {
		System.out.println("/board/write: POST");
		service.insertArticle(writer, title, content);
		//글 등록 완료 후 /board/list(글 목록) 요청이 다시 들어올 수 있게끔 redirect처리
		return "redirect:/board/list";
	}
	
	//글 목록 화면 요청
	@GetMapping("/list")
	public void list(Model model) {
		System.out.println("/board/list: GET");
		model.addAttribute("articles",service.getArticles()); //list.jsp로 전달해야 함
		//service.getArtickes()로 List<BoardListResponseDTO>가 왔고 이걸 list.jsp로 전달해야함
		//Model에 담아서 넘길 거야
		//왜냐면 Spring에서는 request를 쓸 필요가 없어
		//article이라는 이름으로 서비스가 리턴해준 리스트를 담겠다
		//list.jsp라는 곳을 만들어서 완성해야 html로 사용자에게 화면 응답을 보여줄 수 있음
		//반복문을 이용해서 list 안의 객체들을 하나씩 가져와
	}
	
	//글 내용 상세보기 요청 처리 메서드
	@GetMapping("/content")
	public void content(int boardNo, Model model) {
		System.out.println("/board/content?boardNo="+boardNo);
		retrieve(boardNo, model);
	}
	
	//글 수정하기 화면으로 이동 요청
	//메서드 이름은 modify(), url: /board/modify -> GET
	//수정하고자 하는 글 정보를 모두 받아와서 modify.jsp로 보내주세요.
	@GetMapping("/modify")
	public String modify(int boardNo, Model model) {
		System.out.println("/board/modify: GET");
		retrieve(boardNo, model);
		return "board/modify";
	}
	
	//modify.jsp를 생성해서, form태그에 사용자가 처음에 작성했던 내용이 드러나도록
	//배치해주시고 수정을 받아주세요.
	//수정 처리하는 메서드: modify(), 요청 url: /board/modify -> POST
	//수정 처리 완료 이후 방금 수정한 글의 상세보기 요청이 다시 들어올 수 있도록 작성하세요.
	@PostMapping("/modify")
	public String modify(BoardModifyRequestDTO dto) {
		System.out.println("/board/modify: POST");
		System.out.println("dto: " + dto);
		service.modify(dto);
		return "redirect:/board/content?boardNo="+ dto.getBoardNo();
	}
	
	//삭제는 알아서 작성해주세요. (삭제 클릭하면 해당 글이 삭제될 수 있도록)
	@GetMapping("/delete")
	public String delete(int boardNo) {
		System.out.println("/board/delete: GET, boardNo: "+boardNo);
		service.delete(boardNo);
		return "redirect:/board/list";
	}
	
	
	//상세보기, 수정 페이지 공통 로직을 메서드화
	private void retrieve(int boardNo, Model model) {
		model.addAttribute("article", service.retrieve(boardNo));
	}
	
	
	
	
	
	
	
	
	
	
	
}
