package com.pru.offboarding.task.service;

import java.util.List;

import com.pru.offboarding.task.entity.Summary;

public interface SummaryService {
	
	public Summary saveSummary(Summary summary);
	
	public List<Summary> saveAllSummary(List<Summary> summaries);
	
	public Summary getSummaryById(Long Id);
	
	public List<Summary> getAllSummary();
	
	public void deleteSummary(Long summaryId);
}
