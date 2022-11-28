package com.pru.offboarding.task.exception;

import lombok.Data;

@Data
public class TaskNotFoudException extends Exception {

	private String msg;

	public TaskNotFoudException(String msg) {
		super(msg);
		this.msg = msg;
	}

}
