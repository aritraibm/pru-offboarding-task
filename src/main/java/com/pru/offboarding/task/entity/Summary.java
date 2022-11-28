package com.pru.offboarding.task.entity;

import java.util.Date;

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
@Document(collection = "summarydetails")
public class Summary {
	@NotNull
	@Id
	private Long summaryId;
	private Float version;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date versionDate;
	private String author;
	private String natureOfChange;
}
