package com.pru.offboarding.task.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pru.offboarding.task.entity.Comment;

public interface CommentRepo extends MongoRepository<Comment, Long> {

	List<Comment> findByEmpIdOrderByDateDesc(String empId);

}
