package com.java.web;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;


// Entity JPA 테이블 정의?
// @Id -> ID JPA 상속받는 <T, ID>
// @GeneratedValue 키설정?

// @column 컬럼명 다를때 명시적으로 정의
// @OnetoMany 1:N 단방향
// @ManytoOne N:1 단방향
// @OnetoMany <-> @ManytoOne 관계가 생기면 양방향
@Entity
public class Meeting {
	@Id @GeneratedValue
	private Long id;
	private String title;
	private String content;
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
}
