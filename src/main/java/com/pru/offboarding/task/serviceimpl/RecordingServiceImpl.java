package com.pru.offboarding.task.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pru.offboarding.task.entity.Recording;
import com.pru.offboarding.task.repo.RecordingRepo;
import com.pru.offboarding.task.service.RecordingService;

@Service
public class RecordingServiceImpl implements RecordingService {

	@Autowired
	private RecordingRepo recordingRepo;

	@Override
	public List<Recording> getAllRecording() {
		return recordingRepo.findAll();
	}

	@Override
	public Recording insertRecording(Recording recording) {
		return recordingRepo.save(recording);
	}

	@Override
	public boolean deleteRecord(String id) {
		recordingRepo.deleteById(id);
		return true;
	}

	@Override
	public Optional<Recording> findRecord(String id) {
		return recordingRepo.findById(id);
	}

}
