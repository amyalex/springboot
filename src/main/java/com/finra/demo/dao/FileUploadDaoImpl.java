package com.finra.demo.dao;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.finra.demo.Entity.FileUpload;

@Repository
public class FileUploadDaoImpl implements IFileUploadDao {

	@Autowired
	private SessionFactory sessionFactory;

	public FileUploadDaoImpl() {
	}

	public FileUploadDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public void save(FileUpload uploadFile) {
		sessionFactory.getCurrentSession().save(uploadFile);
	}

}
