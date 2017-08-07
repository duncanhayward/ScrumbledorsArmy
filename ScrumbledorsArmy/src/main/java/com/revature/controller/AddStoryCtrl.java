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
import com.revature.pojo.SwimLane;
import com.revature.service.AppService;

@RestController
public class AddStoryCtrl {
	
	@Autowired
	AppService app;
	
	@RequestMapping(value="/addStory", method=RequestMethod.POST)
		public ResponseEntity<Integer> addStory(@RequestBody StoryPost story){
			System.out.println("Adding new story to swimlane");
			
			System.out.println(story);
			
			Story addStory = story.getStoryPost();
			addStory.setSwimLane(new SwimLane());
			addStory.getSwimLane().setId(story.getLaneId());
			
			Integer storyID = app.insertStory(addStory);
			
			if(storyID != null){
				return new ResponseEntity<Integer>(storyID, HttpStatus.OK);
			}else{
				return new ResponseEntity<Integer>(HttpStatus.NOT_ACCEPTABLE);
			}
	}

}

class StoryPost implements Serializable{
	private Story storyPost;
	private int laneId;
	
	public StoryPost(){}
	
	public Story getStoryPost() {
		return storyPost;
	}
	public void setStoryPost(Story storyPost) {
		this.storyPost = storyPost;
	}
	public int getLaneId() {
		return laneId;
	}
	public void setLaneId(int laneId) {
		this.laneId = laneId;
	}
	
	@Override
	public String toString() {
		return "StoryPost [storyPost=" + storyPost + ", laneId=" + laneId + "]";
	}
	
}
