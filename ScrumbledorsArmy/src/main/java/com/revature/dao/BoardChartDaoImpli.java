package com.revature.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.revature.pojo.BoardChart;
import com.revature.pojo.Story;
@Repository
@Component
public class BoardChartDaoImpli implements Dao<BoardChart> {
	
	@Autowired
	 private SessionFactory sessionFactory;

	
	@Override
	public void insert(BoardChart obj) {
		System.out.println("inserting a Burndown Chard");
        Session session = sessionFactory.getCurrentSession();
        session.save(obj);
		
	}

	@Override
	public BoardChart getPojoById(BoardChart obj) {
		System.out.println("Pulling a Story by ID");
        Session session = sessionFactory.getCurrentSession();
		return (BoardChart)session.get(BoardChart.class,obj.getId());
	}

	@Override
	public void update(BoardChart obj) {
		System.out.println("Updating a Board Chart");
        Session session = sessionFactory.getCurrentSession();
        session.update(obj);
		
	}

	@Override
	public void delete(BoardChart obj) {
		System.out.println("Deleting a Board Chart");
        Session session = sessionFactory.getCurrentSession();
        session.delete(obj);
		
	}

	@Override
	public List<BoardChart> getAllPojos() {
		System.out.println("Getting all Board Charts");
        Session session= sessionFactory.getCurrentSession();
        Criteria crit=session.createCriteria(BoardChart.class);
        List<BoardChart> BC=crit.list();
		return BC ;
	}

	@Override
	public List<BoardChart> getAllPojos(List<Criterion> restrictions) {
		System.out.println("Getting all Burndown Charts with Criteria");
        Session session= sessionFactory.getCurrentSession();
        Criteria crit=session.createCriteria(BoardChart.class);
        for(Criterion a:restrictions){
            
            crit.add(a);
            
        }
        List<BoardChart> BC=crit.list();
		return BC;
	}

}
