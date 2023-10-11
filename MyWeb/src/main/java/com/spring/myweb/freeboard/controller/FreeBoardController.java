package com.spring.myweb.freeboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.myweb.freeboard.dto.FreeRegisterRequestDTO;
import com.spring.myweb.freeboard.service.IFreeBoardService;

import lombok.RequiredArgsConstructor;


@Controller
@RequestMapping("/freeboard")
@RequiredArgsConstructor
public class FreeBoardController {

	private final IFreeBoardService service;
	
	//목록 화면
	@GetMapping("/freeList")
	public void freeList(Model model) {
		System.out.println("/freeboard/freeList: GET!");
		model.addAttribute("boardList", service.getList());
	}
	
	//글 등록 처리
	@PostMapping("/freeRegister")
	public String register(FreeRegisterRequestDTO dto) {
		service.register(dto);
		return "redirect:/freeboard/freeList";
	}
	
	@GetMapping("/content")
	public String getContent(int bno, Model model) {
		model.addAttribute("boardDetail",service.getContent(bno));
		return "freeDetail.jsp";
	}
	
}
