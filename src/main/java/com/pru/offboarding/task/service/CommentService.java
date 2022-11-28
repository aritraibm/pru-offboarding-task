package com.pru.offboarding.task.service;

import java.util.List;

import com.pru.offboarding.task.entity.Comment;

public interface CommentService {
	
	public List<Comment> getCommentByEmpId(String empId);
	
	public Comment insertComment(Comment comment);

}
