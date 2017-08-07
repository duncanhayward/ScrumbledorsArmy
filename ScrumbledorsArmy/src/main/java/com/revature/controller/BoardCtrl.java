package com.revature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.pojo.Board;
import com.revature.service.AppService;

@RestController
public class BoardCtrl {
	@Autowired
	AppService app;
	
	@RequestMapping(value="/board/{id}",method=RequestMethod.GET)
	public Board pullBoard(@PathVariable int id ){
		
		Board board=new Board();
		board.setId(id);
		return app.getBoardById(board);
		
		
		
	}
	
	
	

}
