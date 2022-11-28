package com.pru.offboarding.task.exception;

import lombok.Data;

@Data
public class TrainingNotFoundException extends Exception {

	private String msg;

	public TrainingNotFoundException(String msg) {
			super(msg);
			this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

}