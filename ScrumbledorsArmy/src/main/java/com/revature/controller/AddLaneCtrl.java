package com.revature.controller;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.pojo.Board;
import com.revature.pojo.SwimLane;
import com.revature.service.AppService;

@RestController
public class AddLaneCtrl {
	
	@Autowired
	AppService app;
	
	@RequestMapping(value="/addLane", method=RequestMethod.POST)
	public ResponseEntity<Integer> addLane(@RequestBody SwimLanePost lane ){
		System.out.println("Inserting Lane into DB");
		
		System.out.println(lane);
		
		SwimLane swimLane = lane.getLane();
		swimLane.setBoard(new Board());
		swimLane.getBoard().setId(lane.getB_id());
		
		Integer laneID = app.insertSwimLane(swimLane);
		
		System.out.println(laneID);
		
		if (laneID != null) {
			return new ResponseEntity<Integer>(laneID, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Integer>(HttpStatus.NOT_ACCEPTABLE);
		}
	}
}

class SwimLanePost implements Serializable{
	private SwimLane lane;
	private int b_id;
	
	public SwimLanePost(){ }

	public SwimLane getLane() {
		return lane;
	}

	public void setLane(SwimLane lane) {
		this.lane = lane;
	}

	public int getB_id() {
		return b_id;
	}

	public void setB_id(int b_id) {
		this.b_id = b_id;
	}

	@Override
	public String toString() {
		return "SwimLanePost [lane=" + lane + ", b_id=" + b_id + "]";
	}
}
