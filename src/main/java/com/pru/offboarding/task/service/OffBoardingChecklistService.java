package com.pru.offboarding.task.service;

import java.util.List;

import com.pru.offboarding.task.entity.OffBoardingChecklist;

public interface OffBoardingChecklistService {
	
	public OffBoardingChecklist saveOffBoardingChecklist(OffBoardingChecklist boardingChecklist);
	
	public List<OffBoardingChecklist> saveAllOffBoardingChecklist(List<OffBoardingChecklist> boardingChecklists);
	
	public OffBoardingChecklist getOffBoardingChecklistById(String Id);
	
	public List<OffBoardingChecklist> getAllOffBoardingChecklist();
	
	public void deleteOffBoardingChecklist(String offBoardingChecklistId);

}
