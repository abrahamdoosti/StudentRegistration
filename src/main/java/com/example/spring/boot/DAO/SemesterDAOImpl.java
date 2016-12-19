package com.example.spring.boot.DAO;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.spring.boot.model.Semester;

@Repository
public class SemesterDAOImpl implements SemesterDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public SemesterDAOImpl() {

	}

	@Override
	public Semester getSemester(int semesterID) {

		return getSession().get(Semester.class, semesterID);
	}

	@Override
	public Semester addSemester(Semester semester) {

		int id = (int) getSession().save(semester);
		return getSession().get(Semester.class, id);
	}

	@Override
	public Semester updateSemester(Semester semester) {

		int id = semester.getSemesterId();
		getSession().saveOrUpdate(semester);
		return getSession().get(Semester.class, id);
	}

	@Override
	public void deleteSemester(int semesterID) {
		Semester semester = getSession().get(Semester.class, semesterID);
		getSession().delete(semester);
	}

	@Override
	public List<Semester> getAllSemesters() {
		return getSession().createCriteria(Semester.class).list();
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

}
