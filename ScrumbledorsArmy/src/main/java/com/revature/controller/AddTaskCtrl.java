package com.revature.controller;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.pojo.Story;
import com.revature.pojo.Task;
import com.revature.service.AppService;

@RestController
public class AddTaskCtrl {

	@Autowired
	AppService app;
	
	@RequestMapping(value="/addTask", method=RequestMethod.POST)
	public ResponseEntity<Integer> addTask(@RequestBody TaskPost task){
		System.out.println("adding a new task to the story");
		
		Task newTask = task.getTaskPost();
		newTask.setStory(new Story());
		newTask.getStory().setId(task.getStoryId());
		
		Integer taskId = app.insertTask(newTask);
		
		if(taskId != null){
			return new ResponseEntity<Integer>(taskId, HttpStatus.OK);
		}else{
			return new ResponseEntity<Integer>(HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
}

class TaskPost implements Serializable{
	private Task taskPost;
	private int storyId;
	
	public TaskPost(){}
	
	public Task getTaskPost() {
		return taskPost;
	}
	public void setTaskPost(Task taskPost) {
		this.taskPost = taskPost;
	}
	public int getStoryId() {
		return storyId;
	}
	public void setStoryId(int storyId) {
		this.storyId = storyId;
	}
	
	@Override
	public String toString() {
		return "TaskPost [taskPost=" + taskPost + ", storyId=" + storyId + "]";
	}
	
	
}
