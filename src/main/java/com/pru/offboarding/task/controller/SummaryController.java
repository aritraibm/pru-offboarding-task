package com.pru.offboarding.task.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pru.offboarding.task.entity.Summary;
import com.pru.offboarding.task.service.SummaryService;


@RestController
@RequestMapping("/summary")
public class SummaryController {

	@Autowired
	private SummaryService service;

	@PostMapping("/add-Summary")
	public Summary addSummary(@RequestBody Summary summary) {
		Summary tsk = service.saveSummary(summary);
		return tsk;
	}
	
	@PostMapping("/add-all-Summary")
	public List<Summary> addAllSummary(@RequestBody List<Summary> Summarys){
		return service.saveAllSummary(Summarys);
	}
	
	@GetMapping("/get-all-Summary")
	public List<Summary> getAllSummarys(){
		List<Summary> Summarys = service.getAllSummary();
		return Summarys;
	}
	
	@GetMapping("/{id}")
	public Summary getSummaryById(@PathVariable(name = "id") Long SummaryId) {
		Summary Summary=null;
		Summary=service.getSummaryById(SummaryId);	
		return Summary;
	}
	
	@DeleteMapping("/{id}")
	public String deleteSummary(@PathVariable(name = "id") Long SummaryId) {
		service.deleteSummary(SummaryId);
		return "Summary "+SummaryId+" has been deleted.";
	}

}
