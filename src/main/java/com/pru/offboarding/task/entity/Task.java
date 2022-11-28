package com.pru.offboarding.task.entity;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document(collection = "taskdetails")
public class Task {

	@NotNull
	@Id
	private Long taskId;
	@NotBlank(message = "task name cant be empty")
	private String taskName;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date startDate;
	private String status;
	private String checkTask;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date endDate;
	private String employeeId;

}
