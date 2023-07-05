package com.pru.offboarding.task.serviceimpl;

import java.util.List;
import java.util.Random;

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
		

		String reqMsgId= comment.getMsgId();
		String versionNo= comment.getVersionNo();

		String finalMsgId= "";
		String finalVersionNo= "";
		int tempVersionNo= 0;
		
		if(reqMsgId == null) {
			finalMsgId= generateMsgId(comment.getWho());
			finalVersionNo= "1";
		}else {
			finalMsgId= reqMsgId;
			tempVersionNo= Integer.parseInt(versionNo)+ 1;
			finalVersionNo= String.valueOf(tempVersionNo);
		}
		


		System.out.println("FINAL is :::: >>>"+finalMsgId+" :: "+finalVersionNo);
		
		comment.setMsgId(finalMsgId);
		comment.setVersionNo(finalVersionNo);
		
		
		return commentRepo.save(comment);
	}

	@Override
	public List<Comment> getCommentByEmpId(String empId) {
		return commentRepo.findByEmpIdOrderByDateDesc(empId);
	}
	
	private String generateMsgId(String empId) {
		
		String generateMsgId="";
		
	    String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	    StringBuilder sb = new StringBuilder();

	    Random random = new Random();

	    int length = 7;

	    for(int i = 0; i < length; i++) {

	      int index = random.nextInt(alphabet.length());

	      char randomChar = alphabet.charAt(index);

	      sb.append(randomChar);
	    }

	    String randomString = sb.toString();
	    generateMsgId= randomString;
	    System.out.println("Random String is: " + generateMsgId);
	    
		return generateMsgId;
		
	}

}
