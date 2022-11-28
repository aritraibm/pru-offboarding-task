package com.pru.offboarding.task.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pru.offboarding.task.entity.Task;
import com.pru.offboarding.task.exception.TaskNotFoudException;
import com.pru.offboarding.task.service.TaskService;

@RestController
@RequestMapping("/task")
public class UserTaskController {
	
	@Autowired
	private TaskService service;
	
	private Logger logger = LoggerFactory.getLogger("UserTaskController");
	
	@PostMapping("/add-task")
	public Task addTask(@RequestBody Task task) {
		Task tsk = service.saveTask(task);
		logger.info("Task has been added  "+tsk);
		return tsk;
	}
	
	@PostMapping("/add-all-task")
	public List<Task> addAllTask(@RequestBody List<Task> tasks){
		return service.saveAllTask(tasks);
	}
	
	@GetMapping("/get-all-task")
	public List<Task> getAllTasks(){
		List<Task> tasks = service.getAllTasks();
		return tasks;
	}
	
	@GetMapping("/{id}")
	public Task getTaskById(@PathVariable(name = "id") Long taskId) throws TaskNotFoudException {		
		Task task=null;
		task=service.getTaskById(taskId);
		return task;
	}
	
	@DeleteMapping("/{id}")
	public String deleteTask(@PathVariable(name = "id") Long taskId) {
		service.delete(taskId);
		return "Task "+taskId+" has been deleted.";
	}	

}
