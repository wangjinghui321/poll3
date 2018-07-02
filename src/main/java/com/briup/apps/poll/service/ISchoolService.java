package com.briup.apps.poll.service;

import java.util.List;

import com.briup.apps.poll.bean.School;

public interface ISchoolService {
	
	List<School> findAll() throws Exception;
	School findById(long id) throws Exception;
	List<School> query(String keywords) throws Exception;
	void insertOrupdate(School school) throws Exception;
	
	void deleteByPrimaryKey(long id) throws Exception;
	void batchDelete(List<Long> ids) throws Exception;
	

}
