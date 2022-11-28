package com.pru.offboarding.task.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pru.offboarding.task.entity.OffBoardingChecklist;
import com.pru.offboarding.task.repo.OnBoardingChecklistRepo;
import com.pru.offboarding.task.service.OffBoardingChecklistService;

@Service
public class OffBoardingChecklistServiceImpl implements OffBoardingChecklistService {
	
	@Autowired
	private OnBoardingChecklistRepo checklistRepo;

	@Override
	public OffBoardingChecklist saveOffBoardingChecklist(OffBoardingChecklist boardingChecklist) {
		return checklistRepo.save(boardingChecklist);
	}

	@Override
	public List<OffBoardingChecklist> saveAllOffBoardingChecklist(List<OffBoardingChecklist> boardingChecklists) {
		return checklistRepo.saveAll(boardingChecklists);
	}

	@Override
	public OffBoardingChecklist getOffBoardingChecklistById(String Id) {
		Optional<OffBoardingChecklist> on=checklistRepo.findById(Id);
		return on.get();
	}

	@Override
	public List<OffBoardingChecklist> getAllOffBoardingChecklist() {
		return checklistRepo.findAll();
	}

	@Override
	public void deleteOffBoardingChecklist(String offBoardingChecklistId) {
		checklistRepo.deleteById(offBoardingChecklistId);
	}

}
