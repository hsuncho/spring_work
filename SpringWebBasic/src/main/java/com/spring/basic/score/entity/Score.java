package com.spring.basic.score.entity;

import com.spring.basic.score.dto.ScoreRequestDTO;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
 Entity class
 - 실제 데이터베이스에 저장된 테이블(값의 모음) 형태와 1:1로 매칭되는 클래스
 - DB 테이블 내에 존재하는 속성만을 필드로 가져야 합니다.
 - 상속이나 구현체여서는 안되고, 존재하지 않는 컬럼값을 가지는 것도 안됩니다. (가장 pure한 객체)
 - 절대로 요청이나 응답값을 전달하는 클래스(DTO의 역할)로 사용하지 않습니다. 
*/

@Setter @Getter @ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Score {
	
	private int stuNum; //student number
	private String stuName; //학생 이름
	private int kor, eng, math; // Korean/ English/ math score
	
	private int total;
	private double average;
	private Grade grade;
	
	//객체 생성할 때 DTO를 보내면 Name을 꺼내서 멤버 변수에 DTO에 있는 사용자가 입력한 name을 입력할게
	//changeScore에서는 dto를 전달받아서 초기화한 후 calcTotalAndAvg calcGrade 메서드를 부름
	public Score(ScoreRequestDTO dto) {
		this.stuName = dto.getName();
		changeScore(dto);
	} 
	
	 public void changeScore(ScoreRequestDTO dto) {
	        this.kor = dto.getKor();
	        this.eng = dto.getEng();
	        this.math = dto.getMath();
	        calcTotalAndAvg(); // 총점, 평균 계산
	        calcGrade(); // 학점 계산
	    }

    private void calcGrade() {
        if (average >= 90) {
            this.grade = Grade.A; //grade라는 변수에 enum에 선언된 상수 중 하나의 값을 매겨주고 있음
        } else if (average >= 80) {
            this.grade = Grade.B;
        } else if (average >= 70) {
            this.grade = Grade.C;
        } else if (average >= 60) {
            this.grade = Grade.D;
        } else {
            this.grade = Grade.F;
        }
    }

    private void calcTotalAndAvg() {
        this.total = this.kor + eng + math;
        this.average = total / 3.0;
    }
	
}
