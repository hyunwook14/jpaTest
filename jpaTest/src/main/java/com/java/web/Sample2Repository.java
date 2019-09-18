package com.java.web;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


public interface Sample2Repository extends JpaRepository<Meeting, Long> {
	
	// JPA Optional 단일 유니크한 하나의 행만 가져올때 null 체크 isPrecent
	// List<Object> 여러 행을 가져올때 -> null 체크는 size
	
	List<Meeting> findByTitleIsLike(String title);
	
}
