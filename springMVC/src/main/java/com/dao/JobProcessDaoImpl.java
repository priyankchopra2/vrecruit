package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.entities.JobApplication;
import com.entities.JobProcessDetails;
import com.entities.User;
//import com.project.recruitmentoperation.entity.JobApplication;
//import com.project.recruitmentoperation.entity.JobProcessDetails;
//import com.project.recruitmentoperation.entity.User;

@Repository
@Transactional
public class JobProcessDaoImpl implements JobProcessDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	HibernateTemplate hibernateTemplate;

	public JobProcessDaoImpl() {
	}

	public JobProcessDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void save(JobProcessDetails uploadFile) {

		sessionFactory.getCurrentSession().save(uploadFile);

	}

	@Override
	public boolean validate(User user) {
		JobProcessDetails users = null;
		try (Session session = sessionFactory.openSession()) {
			users = (JobProcessDetails) session.createQuery("FROM JobProcessDetails U WHERE U.user = :user ")
					.setParameter("user", user).uniqueResult();

		}
		if (users == null)
			return true;
		else
			return false;
	}

	@Override
	public JobApplication getJob(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		JobApplication jobApplication = (JobApplication) currentSession.get(JobApplication.class, id);
		return jobApplication;

	}

	@Override
	public List<JobProcessDetails> getCandidatesJobProcess(int id) {
		try (Session session = sessionFactory.openSession()) {
			List<JobProcessDetails> jobProcessList = (List<JobProcessDetails>) session
					.createQuery("FROM JobProcessDetails U WHERE U.jobApplication.id = " + id).list();
			return jobProcessList;
		}
	}

	@Transactional
	@Override
	public List<JobProcessDetails> update(JobProcessDetails obj) {
//			List<JobProcessDetails> jobProcessList=null;
//			try (Session session = sessionFactory.openSession()) {
//			sessionFactory.getCurrentSession().update(obj);
//			jobProcessList= (List<JobProcessDetails>) session.createQuery("FROM JobProcessDetails").list();
//			return jobProcessList;
//			}
//			catch(Exception e) {e.printStackTrace();}
//			return jobProcessList;
		this.hibernateTemplate.saveOrUpdate(obj);
		List<JobProcessDetails> jobApp = this.hibernateTemplate.loadAll(JobProcessDetails.class);
		return jobApp;

	}

	@Override
	public JobProcessDetails findById(int id) {
		try (Session session = sessionFactory.openSession()) {
		return  
				(JobProcessDetails) session.createQuery("FROM JobProcessDetails U WHERE U.jobid = :id ")
				.setParameter("id", id).uniqueResult();
		}
	}

}
