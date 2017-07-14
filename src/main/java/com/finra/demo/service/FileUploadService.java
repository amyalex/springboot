package com.finra.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finra.demo.Entity.FileUpload;
import com.finra.demo.dao.IFileUploadDao;

@Service
public class FileUploadService implements IFIleUploadService {

	@Autowired
	IFileUploadDao fileUploadDao;

	@Override
	public void save(FileUpload fileUpload) {
		fileUploadDao.save(fileUpload);

	}

}
