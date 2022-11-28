package com.pru.offboarding.task.service;

import java.util.List;
import java.util.Optional;

import com.pru.offboarding.task.entity.Recording;

public interface RecordingService {
	
	public List<Recording> getAllRecording();
	
	public Recording insertRecording(Recording recording);
	
	public boolean deleteRecord(String id);
	
	public Optional<Recording> findRecord(String id);

}
