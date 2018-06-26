package com.briup.apps.poll.service;

import java.util.List;

import com.briup.apps.poll.bean.QuestionnaireQuestion;


public interface IQuestionnaireQuestionService {

	List<QuestionnaireQuestion> findAll() throws Exception;
	
	void deleteById(long id) throws Exception;
	
	void insert(QuestionnaireQuestion qq) throws Exception;
	
	void updateByPrimaryKey(QuestionnaireQuestion qq) throws Exception;
}
