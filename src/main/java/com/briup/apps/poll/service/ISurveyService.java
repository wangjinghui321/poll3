package com.briup.apps.poll.service;

import java.util.List;

import com.briup.apps.poll.bean.Survey;

public interface ISurveyService {
	List<Survey> findAllSurvey() throws Exception;
	
	Survey findSurveyById(long id) throws Exception;
	
	List<Survey> querySurvey(String keywords) throws Exception;
	
	void saveOrupdate(Survey survey) throws Exception;
	
	void deleteSurveyById(long id) throws Exception;
	
	void batchSurveyDelete(List<Long> ids) throws Exception;

}
