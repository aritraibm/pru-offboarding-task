package com.pru.offboarding.task.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pru.offboarding.task.entity.Recording;
import com.pru.offboarding.task.service.RecordingService;

@CrossOrigin
@RestController
@RequestMapping("/recording")
public class RecordingsController {
	
	@Autowired
	private RecordingService recordingService;
	
	@PreAuthorize("hasAnyRole({'ROLE_ASSOCIATE','ROLE_OFFBOARDING_REVIEWER','ROLE_OFFBOARDING_MANAGER'})")
	@GetMapping("/get-all-recordings")
	public List<Recording> getAllRecording(){
		List<Recording> recording= recordingService.getAllRecording();
		return recording;
	}
	
	@PreAuthorize("hasAnyRole({'ROLE_OFFBOARDING_REVIEWER','ROLE_OFFBOARDING_MANAGER'})")
	@PostMapping("/add-recording")
	public Recording saveRecording(@RequestBody Recording newRecording){
		Recording recording= recordingService.insertRecording(newRecording);
		return recording;
	}
	
	@PreAuthorize("hasAnyRole({'ROLE_OFFBOARDING_REVIEWER','ROLE_OFFBOARDING_MANAGER'})")
	@DeleteMapping("/{id}")
	public Boolean deleteRecordByID(@PathVariable("id")String id){
		return recordingService.deleteRecord(id);
	}
	
	@PreAuthorize("hasAnyRole({'ROLE_OFFBOARDING_REVIEWER','ROLE_OFFBOARDING_MANAGER'})")
	@PutMapping("/{id}")
	public Recording updateRecordByID(@PathVariable("id")String id,@RequestBody Recording recording){
		Optional<Recording> rec= recordingService.findRecord(id);
		if(rec.isPresent()) {
			Recording dbr=rec.get();
			dbr.setRecordDesc(recording.getRecordDesc());
			dbr.setRecordLink(recording.getRecordLink());
			dbr.setRecordLinkPassword(recording.getRecordLinkPassword());
			saveRecording(dbr);
			return dbr;
		}
		return null;
	}

}
