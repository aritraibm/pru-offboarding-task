package com.pru.offboarding.task.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pru.offboarding.task.entity.Task;
import com.pru.offboarding.task.repo.TaskRepo;
import com.pru.offboarding.task.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService {
	
	@Autowired
	private TaskRepo taskRepo;
	
	private Logger logger=LoggerFactory.getLogger(TaskServiceImpl.class);

	@Override
	public Task saveTask(Task task) {
		task = taskRepo.save(task);
		return task;
	}

	@Override
	public List<Task> saveAllTask(List<Task> tasks) {
		tasks = taskRepo.saveAll(tasks);
		return tasks;
	}

	@Override
	public Task getTaskById(Long Id) {
		Optional<Task> task = taskRepo.findById(Id);
		logger.info(""+task);
		return task.get();
	}

	@Override
	public List<Task> getAllTasks() {
		List<Task> tasks = taskRepo.findAll();
		return tasks;
	}

	@Override
	public void delete(Long taskId) {
		taskRepo.deleteById(taskId);
	}

}
