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

		System.out.println("REQUESt is :::: >>>"+reqMsgId+" :: "+versionNo);
		System.out.println("REQUES BODY is :::: >>>"+comment.toString());
		String finalMsgId= "";
		String finalVersionNo= "";
		int tempVersionNo= 0;
		// L1: OBJ query the count, based on msgid (number of msgs) / get the version number based on msg

		// if L1 === 0 :: generate one msgId "MSG-132213ffdgr3w3422"
		if(reqMsgId == null) {
//			System.out.println("11111111111111");
			finalMsgId= generateMsgId(comment.getWho());
			finalVersionNo= "1";
		}else {
//			System.out.println("222222222222");
			finalMsgId= reqMsgId;
			tempVersionNo= Integer.parseInt(versionNo)+ 1;
			finalVersionNo= String.valueOf(tempVersionNo);
		}
		

		// if L1 > 0 :: copy the msgid from L1 and use it
		// set version id= count(L1) + 1;
		System.out.println("FINAL is :::: >>>"+finalMsgId+" :: "+finalVersionNo);
		
		//update the setter
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
		// create a string of all characters
	    String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	    // create random string builder
	    StringBuilder sb = new StringBuilder();

	    // create an object of Random class
	    Random random = new Random();

	    // specify length of random string
	    int length = 7;

	    for(int i = 0; i < length; i++) {

	      // generate random index number
	      int index = random.nextInt(alphabet.length());

	      // get character specified by index
	      // from the string
	      char randomChar = alphabet.charAt(index);

	      // append the character to string builder
	      sb.append(randomChar);
	    }

	    String randomString = sb.toString();
	    //generateMsgId= "MSG-"+empId+randomString;
	    generateMsgId= randomString;
	    System.out.println("Random String is: " + generateMsgId);
	    
		return generateMsgId;
		
	}

}
