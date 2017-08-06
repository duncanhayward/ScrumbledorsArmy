package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.revature.pojo.Board;
import com.revature.pojo.BoardRole;
import com.revature.pojo.Role;
import com.revature.pojo.User;

@Repository
public class BoardRoleDaoImpl implements Dao<BoardRole> {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Integer insert(BoardRole obj) {
		Session session = sessionFactory.getCurrentSession();
		session.save(obj);
		//already know the boardRoleId so returning a 0 to 
		//indicate the method executed without an exception
		return 0;
	}

	@Override
	public BoardRole getPojoById(BoardRole obj) {
		// TODO Auto-generated method stub
		return (BoardRole) sessionFactory.getCurrentSession().get(BoardRole.class, obj.getBrId());
	}

	@Override
	public List<BoardRole> getAllPojos() {
		Session session = sessionFactory.getCurrentSession();
		Criteria crit = session.createCriteria(BoardRole.class);
		return (List<BoardRole>) crit.list();
	}

	@Override
	public List<BoardRole> getAllPojos(List<Criterion> restrictions) {
		Session session = sessionFactory.getCurrentSession();
		Criteria crit = session.createCriteria(BoardRole.class);
		for (Criterion c : restrictions) {

			crit.add(c);

		}
		return (List<BoardRole>) crit.list();
	}

	@Override
	public void update(BoardRole obj) {
		Session session = sessionFactory.getCurrentSession();
		session.update(obj);
	}

	@Override
	public void delete(BoardRole obj) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(obj);
	}

//	@Override
//	public BoardRole getPojoByUserIdAndBoardId(User user, Board board) {
//		// TODO Auto-generated method stub
//
//		Session session = sessionFactory.getCurrentSession();
//		Criteria crit = session.createCriteria(BoardRole.class);
//		crit.add(Restrictions.and(Restrictions.ilike("u_id", user.getId()), Restrictions.ilike("b_id", board.getId())));
//
//		return null;
//	}
//
//	@Override
//	public ArrayList<BoardRole> getPojoByUserId(User obj) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public ArrayList<BoardRole> getPojoByBoardId(Board obj) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public ArrayList<BoardRole> getPojoByRoleId(Role obj) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
