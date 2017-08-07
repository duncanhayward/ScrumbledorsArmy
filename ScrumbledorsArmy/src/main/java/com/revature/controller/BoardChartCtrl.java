package com.revature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.pojo.BoardChart;
import com.revature.service.AppService;

@RestController
public class BoardChartCtrl {
	@Autowired
	AppService app;
	
	@RequestMapping(value="/bdchart/{id}",method=RequestMethod.GET)
	public BoardChart pullBoardChart(@PathVariable int id ){
		BoardChart bdChart=new BoardChart();
		bdChart.setId(id);
		return app.getBdChart(bdChart);
		
	}
	
	
	

}
