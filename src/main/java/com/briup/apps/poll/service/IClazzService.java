package com.briup.apps.poll.service;

import java.util.List;

import com.briup.apps.poll.bean.Clazz;
import com.briup.apps.poll.bean.extend.ClazzVM;


public interface IClazzService {
	List<Clazz> findAllClazz() throws Exception;
	
	List<ClazzVM> findAll() throws Exception;
	
	void saveOrupdate(Clazz clazz) throws Exception;
	
	
	void deletes(Long[] ids) throws Exception;
	
	List<Clazz> query(String keywords) throws Exception;
	
	void deleteById(long id) throws Exception;
	
	ClazzVM selectById(long id) throws Exception;
}
