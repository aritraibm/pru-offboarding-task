package com.pru.offboarding.task.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pru.offboarding.task.entity.Comment;
import com.pru.offboarding.task.repo.CommentRepo;
import com.pru.offboarding.task.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	private CommentRepo commentRepo;

	@Override
	public Comment insertComment(Comment comment) {
		return commentRepo.save(comment);
	}

	@Override
	public List<Comment> getCommentByEmpId(String empId) {
		return commentRepo.findByEmpIdOrderByDateDesc(empId);
	}

}
