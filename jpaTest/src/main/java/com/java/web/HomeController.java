package com.java.web;


import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	@Autowired
	Sample2Repository repository;
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home() {
		
		return "home";
	}
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test() {
		Meeting mt = new Meeting();
		mt.setId((long) 1);
		mt.setTitle("aasaa");
		mt.setContent("test");
		
		repository.save(mt);
		
		mt = new Meeting();
		mt.setId((long) 2);
		mt.setTitle("acsaa");
		mt.setContent("test");
		
		repository.save(mt);
		
//		Optional<Meeting> result = repository.findByTitleIsLike("%a%");
//		System.out.println(result.isPresent());
//		System.out.println(result.get().getTitle());
		List<Meeting> result = repository.findByTitleIsLike("%a%");
		System.out.println(result.size());
		
		return "home";
	}
	
	
	public void logic(EntityManager em) {
		String id = "galid1";
		
		MemberEntity member = new MemberEntity();
		member.setId(id);
		member.setUserName("jjj");
		member.setAge(21);
		
		em.persist(member);
		
		MemberEntity findMember = em.find(MemberEntity.class, id);
		System.out.println("findMember = "+ findMember.getUserName()+ " "+
		findMember.getAge());
	}
	
	@RequestMapping("/")
	public String saveMember() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
		EntityManager em =  emf.createEntityManager(); 
		EntityTransaction tx = em.getTransaction();
		
		try {
			tx.begin();
			logic(em);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			em.close();
		}
		emf.close();
		
		return "home";
	}
	
	@RequestMapping("/board")
	public String board() {
		return "board";
	}
}
