package com.pru.offboarding.task.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document(collection = "recording")
public class Recording {

	@Id
	private String recordId;
	private String recordDesc;
	private String recordLink;
	private String recordLinkPassword;

}
