package com.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.MappingException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.entities.JobProcessDetails;
import com.entities.User;
//import com.project.recruitmentoperation.entity.JobProcessDetails;
//import com.project.recruitmentoperation.entity.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override

	public void saveUser(User user) {
		Session currentSession = sessionFactory.getCurrentSession();
		// checkuser(user.getEmail());
		currentSession.saveOrUpdate(user);
	}

	@Override
	public List<User> getUsers() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<User> cq = cb.createQuery(User.class);
		Root<User> root = cq.from(User.class);
		cq.select(root);
		Query query = session.createQuery(cq);
		return query.getResultList();

	}

	@Override
	public User checkuser(String email) {
		User user = null;

		try (Session session = sessionFactory.openSession()) {
			user = (User) session.createQuery("FROM User U WHERE U.email = :email").setParameter("email", email)
					.uniqueResult();

		}

		return user;
	}

	@Override
	public User validate(String email, String password) {

		User user = null;
		try (Session session = sessionFactory.openSession()) {
			user = (User) session.createQuery("FROM User U WHERE U.email = :email ").setParameter("email", email)
					.uniqueResult();

			if (user != null && user.getPassword().equals(password)) {
				return user;

			}

		}
		return null;
	}

	@Override
	public User viewprofile(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		User user = (User) currentSession.get(User.class, id);
		return user;
	}

}
