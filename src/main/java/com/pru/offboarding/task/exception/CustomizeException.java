package com.pru.offboarding.task.exception;

import java.util.Date;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomizeException extends ResponseEntityExceptionHandler {

	@ExceptionHandler(TaskNotFoudException.class)
	public ResponseEntity<ExceptionResponse> handleTaskNotFoudException(TaskNotFoudException ts,WebRequest request) {
		ExceptionResponse response=new ExceptionResponse(new Date(),ts.getMsg(),request.getDescription(false));
		return new ResponseEntity<ExceptionResponse>(response,HttpStatus.NOT_FOUND);
	}
	
}
