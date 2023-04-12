package com.pru.offboarding.task.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pru.offboarding.task.entity.OffBoardingChecklist;
import com.pru.offboarding.task.service.OffBoardingChecklistService;


@RestController
@RequestMapping("/offboarding_checklist")
public class OnBoardingChecklistController {
	@Autowired
	private OffBoardingChecklistService service;
	
	
	@PreAuthorize("hasAnyRole({'ROLE_OFFBOARDING_REVIEWER','ROLE_OFFBOARDING_MANAGER'})")
	@PostMapping(path = "/add-offboarding-checklist",consumes = "application/json")
	public OffBoardingChecklist addOnBoarding(@RequestBody OffBoardingChecklist checklist) {
		System.out.println("checklist single >>>>"+checklist);
		OffBoardingChecklist boardingChecklist  = service.saveOffBoardingChecklist(checklist);
		return boardingChecklist;
	}
	
	@PostMapping("/add-all-offboarding-checklist")
	@PreAuthorize("hasAnyRole({'ROLE_OFFBOARDING_REVIEWER','ROLE_OFFBOARDING_MANAGER'})")
	public List<OffBoardingChecklist> addAllOffBoarding(@RequestBody List<OffBoardingChecklist> checklists){
		System.out.println("checklists >>>>"+checklists);
		return service.saveAllOffBoardingChecklist(checklists);
	}
		
	@PreAuthorize("hasAnyRole({'ROLE_ASSOCIATE','ROLE_OFFBOARDING_REVIEWER','ROLE_OFFBOARDING_MANAGER'})")
	@GetMapping("/get-all-offboarding-checklist")
	public List<OffBoardingChecklist> getAllOffBoarding(){
		List<OffBoardingChecklist> boardingChecklists= service.getAllOffBoardingChecklist();
		return boardingChecklists;
	}
	
	
	@PreAuthorize("hasAnyRole({'ROLE_OFFBOARDING_REVIEWER','ROLE_OFFBOARDING_MANAGER'})")
	@GetMapping("/{id}")
	public OffBoardingChecklist getOffBoardingById(@PathVariable(name = "id") String id) {
		OffBoardingChecklist boardingChecklist=null;
		boardingChecklist=service.getOffBoardingChecklistById(id);
		return boardingChecklist;
	}
	
	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('ROLE_OFFBOARDING_MANAGER')")
	public String deleteOffBoarding(@PathVariable(name = "id") String id) {
		service.deleteOffBoardingChecklist(id);
		return "Task "+id+" has been deleted.";
	}
}
