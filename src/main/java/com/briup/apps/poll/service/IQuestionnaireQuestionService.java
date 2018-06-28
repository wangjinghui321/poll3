package com.briup.apps.poll.service;

import java.util.List;
import com.briup.apps.poll.bean.QuestionnaireQuestion;
import com.briup.apps.poll.bean.extend.QuestionnaireQuestionVM;


public interface IQuestionnaireQuestionService {

	List<QuestionnaireQuestion> findAll() throws Exception;
	
	List<QuestionnaireQuestionVM> findAllQuestionnaireQuestionVM() throws Exception;
	
	void saveOrUpdateQuestionnaireQuestion(QuestionnaireQuestion questionnaireQuestion) throws Exception;
	
	void deleteById(long id) throws Exception;
}
