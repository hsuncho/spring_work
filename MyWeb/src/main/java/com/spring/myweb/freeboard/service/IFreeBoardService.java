package com.spring.myweb.freeboard.service;

import java.util.List;

import com.spring.myweb.freeboard.dto.page.Page;
import com.spring.myweb.freeboard.dto.request.FreeModifyRequestDTO;
import com.spring.myweb.freeboard.dto.request.FreeRegisterRequestDTO;
import com.spring.myweb.freeboard.dto.response.FreeDetailResponseDTO;
import com.spring.myweb.freeboard.dto.response.FreeListResponseDTO;

public interface IFreeBoardService {
	
		void register(FreeRegisterRequestDTO dto);
		
		List<FreeListResponseDTO> getList(Page page);
		
		//총 게시물 개수
		int getTotal(Page page);
		
		FreeDetailResponseDTO getContent(int bno);
		
		void update(FreeModifyRequestDTO dto);
		
		void delete(int bno);
}
