package com.pru.offboarding.task.service;

import java.util.List;

import com.pru.offboarding.task.entity.Task;
import com.pru.offboarding.task.exception.TaskNotFoudException;

public interface TaskService {
	
	public Task saveTask(Task task);
	
	public List<Task> saveAllTask(List<Task> tasks);
	
	public Task getTaskById(Long Id) throws TaskNotFoudException;
	
	public List<Task> getAllTasks();
	
	public void delete(Long taskId);

}
