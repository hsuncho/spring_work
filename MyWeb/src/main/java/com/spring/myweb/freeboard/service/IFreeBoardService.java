package com.spring.myweb.freeboard.service;

import java.util.List;

import com.spring.myweb.freeboard.dto.FreeDetailResponseDTO;
import com.spring.myweb.freeboard.dto.FreeListResponseDTO;
import com.spring.myweb.freeboard.dto.FreeRegisterRequestDTO;
import com.spring.myweb.freeboard.entity.FreeBoard;

public interface IFreeBoardService {
	
		void register(FreeRegisterRequestDTO dto);
		
		List<FreeListResponseDTO> getList();
		
		FreeDetailResponseDTO getContent(int bno);
		
		void update(FreeBoard freeBoard);
		
		void delete(int bno);
}
