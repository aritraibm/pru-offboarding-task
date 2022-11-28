package com.pru.offboarding.task.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pru.offboarding.task.entity.Comment;
import com.pru.offboarding.task.service.CommentService;

@CrossOrigin
@RestController
@RequestMapping("/comment")
public class CommentController {
	
	@Autowired
	private CommentService service;
	
	@PreAuthorize("hasAnyRole({'ROLE_ASSOCIATE','ROLE_ONBOARDING_REVIEWER','ROLE_ONBOARDING_MANAGER'})")
	@GetMapping("/{id}")
	public List<Comment> getCommentByID(@PathVariable(name = "id") String id){
		List<Comment> comment= service.getCommentByEmpId(id);
		return comment;
	}
	
	@PreAuthorize("hasAnyRole({'ROLE_ASSOCIATE','ROLE_ONBOARDING_REVIEWER','ROLE_ONBOARDING_MANAGER'})")
	@PostMapping("/add-comment")
	public Comment saveOrUpdateCommentByID(@RequestBody Comment newComment){
		Comment comment= service.insertComment(newComment);
		return comment;
	}
}
