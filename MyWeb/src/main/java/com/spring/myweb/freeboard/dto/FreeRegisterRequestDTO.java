package com.spring.myweb.freeboard.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString @NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class FreeRegisterRequestDTO {

	private String title;
	private String content;
	private String writer;
	
}
