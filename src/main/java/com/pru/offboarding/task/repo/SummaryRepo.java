package com.pru.offboarding.task.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.pru.offboarding.task.entity.Summary;

@Repository
public interface SummaryRepo extends MongoRepository<Summary, Long> {

}
