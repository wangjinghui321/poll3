package com.briup.apps.poll.service;

import java.util.List;

import com.briup.apps.poll.bean.Clazz;


public interface IClazzService {
	List<Clazz> findAllClazz() throws Exception;
	void saveOrupdate(Clazz clazz) throws Exception;
	void deletes(Long[] ids) throws Exception;
	List<Clazz> query(String keywords) throws Exception;
	void deleteById(long id) throws Exception;
}
