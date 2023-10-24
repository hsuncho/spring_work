package com.spring.myweb.snsboard.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
	CREATE TABLE sns_like(
	    lno NUMBER PRIMARY KEY,
	    user_id VARCHAR2(50) NOT NULL,
	    bno NUMBER NOT NULL
	);
 */

@Getter @Setter @ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class SnsLike {
	
	private int lno;
	private String user_id;
	private int bno;
	
}
