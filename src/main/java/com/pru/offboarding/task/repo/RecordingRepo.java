package com.pru.offboarding.task.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pru.offboarding.task.entity.Recording;

public interface RecordingRepo extends MongoRepository<Recording, String> {

}
