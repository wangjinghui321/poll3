package com.briup.apps.poll.service;

import java.util.List;

import com.briup.apps.poll.bean.Grade;

public interface IGradeService {
	List<Grade> findAllGrade() throws Exception;
	Grade findById(long id) throws Exception;
	List<Grade> query(String keywords) throws Exception;
	void saveOrupdate(Grade grade) throws Exception;
	void deleteById(long id) throws Exception;
	void batchDelete(List<Long> ids) throws Exception;
}
