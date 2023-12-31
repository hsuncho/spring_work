package com.spring.myweb.snsboard.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class SnsBoardRequestDTO {
	
	private String content;
	private String writer;
	private MultipartFile file;
}
