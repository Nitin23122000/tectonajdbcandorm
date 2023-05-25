package com.springORM.Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.springORM.Entity.Student;

public class StudentDao {

	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	//insert student
	@Transactional
	public int insert(Student s) {
		Integer i= (Integer) this.hibernateTemplate.save(s);
		return i;
	}
	
	//get single data 
	@Transactional
	public Student getsingledata(int id) {
		Student student = this.hibernateTemplate.get(Student.class, id);
		return student;
	}
	
	//get all data
	@Transactional
	public List<Student> getAllStudent(){
		List<Student> list = this.hibernateTemplate.loadAll(Student.class);
		return list;
	}
	
	//deleting the data
	@Transactional
	public void delete(int id) {
		Student student = this.hibernateTemplate.get(Student.class, id);
		this.hibernateTemplate.delete(student);
		
	}
	// updating data
	@Transactional
	public void update(Student s) {
		this.hibernateTemplate.update(s);
	}
	
	
}
